package org.seckill.service.impl;

import org.seckill.dao.SeckillDao;
import org.seckill.dao.SuccesskilledDao;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStartEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by teng on 2016/5/17.
 */
@Service
public class SeckillServiceImpl implements SeckillService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillDao seckillDao;

    @Autowired
    private SuccesskilledDao successkilledDao;

    private final String slat = "ad$%&&*dddddd*ddddd%%%94293";

    @Override
    public List<Seckill> getSeckillList() {
        //return seckillDao.queryAll(0,4);
        return null;
    }

    @Override
    public Seckill getById(long seckillId) {
        //return seckillDao.queryById(seckillId);
        return null;
    }

    @Override
    public Exposer exprotSeckillUrl(long seckillId) {
        Seckill seckill = seckillDao.queryById(seckillId);
        if(seckill == null){
            return new Exposer(false,seckillId);
        }
        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
        Date nowTime = new Date();
        if(nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime()){
            return new Exposer(false,seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
        }
        //不可逆
        String md5 = getMD5(seckillId);
        return  new Exposer(true,md5,seckillId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ)
    /*
    * 使用注解控制事务方法的优点
    * 1、团队达成一致
    * 2、保证事务方法的执行时间尽可能短，不要穿插其他网络操作，rpc，http请求或者剥离到事务方法外部
    * 3、不是所有方法都需要事务，如：只有一个修改操作，只读操作不需要事务控制
    *
    * （1）throw Runtime异常才会回滚
    * （2）如果异常被catch住，则不会回滚
    * （3）如果catch中又throw，则会回滚
    *
    *
    * */
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
    throws SeckillException,RepeatKillException,SeckCloseException{
        if(md5 == null || !md5.equals(getMD5(seckillId))){
            throw new SeckillException("Seckill date rewrite");
        }
        //执行秒杀逻辑，减库存，增加秒杀记录
        Date nowTime = new Date();

        try {
            int updateCount = seckillDao.reduceNumber(seckillId, nowTime);
            if (updateCount <= 0) {
                //没有更新到记录
                throw new SeckCloseException("seckill is close");
            } else {
                //记录购买行为
                int insertCount = successkilledDao.insertSuccessKilled(seckillId, userPhone);
                if (insertCount <= 0) {
                    throw new RepeatKillException("Seckill is repeat");
                } else {
                    SuccessKilled successKilled = successkilledDao.queryByIdWithSeckill(seckillId, userPhone);
                    return new SeckillExecution(seckillId, SeckillStartEnum.SUCCESS, successKilled);
                }
            }
        }catch (SeckCloseException e1){
            throw e1;
        }catch (RepeatKillException e2){
            throw e2;
        }
        catch (Exception e){
            logger.error(e.getMessage(),e);
            //所有编译期异常转化为运行期异常
            throw new SeckillException("Seckill inner error:"+e.getMessage());
        }


    }

    private String getMD5(long seckillId){
        String base = seckillId + "/" + slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }
}
