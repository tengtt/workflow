package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckCloseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
                      "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    //@Resource(name="seckillServiceProxy")
    private SeckillService seckillService;

    @Test
    public void testGetSeckillList() throws Exception {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list = {}",list);
    }

    @Test
    public void testGetById() throws Exception {
        Seckill seckill = seckillService.getById(100L);
        logger.info("seckill= {}",seckill);
    }
/*
    @Test
    public void testExprotSeckillUrl() throws Exception {
        long id = 1000;
        Exposer exposer = seckillService.exprotSeckillUrl(id);
        logger.info("exposer = {}",exposer);
    }*/

    @Test
    public void testExecuteSeckill() throws Exception {
        long id = 1004;
        Exposer exposer = seckillService.exprotSeckillUrl(id);
        long phone = 12345673433L;

        if(exposer.isExposed()) {
            String md5 = exposer.getMd5();

            try {
                SeckillExecution seckillExecution = seckillService.executeSeckill(id, phone, md5);
                logger.info("seckillExecution = {}", seckillExecution);
            } catch (RepeatKillException e) {
                logger.info(e.getMessage());
            } catch (SeckCloseException e) {
                logger.info(e.getMessage());
            }
        }else{
            //秒杀未开启
            logger.warn("exposer = {}",exposer);
        }

    }
}