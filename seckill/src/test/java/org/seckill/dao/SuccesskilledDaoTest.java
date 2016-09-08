package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccesskilledDaoTest {

    @Resource
    SuccesskilledDao successkilledDao;

    @Test
    public void testInsertSuccessKilled() throws Exception {
        int insertCount = successkilledDao.insertSuccessKilled(1000L,13263473130L);

    }

    @Test
    public void testQueryByIdWithSeckill() throws Exception {
        SuccessKilled successKilled = successkilledDao.queryByIdWithSeckill(1004L,12345673433L);
        System.out.print(successKilled);
        System.out.print(successKilled.getSeckill().toString());
    }
}