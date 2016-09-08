package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * 站在使用者角度设计接口
 * 方法定义粒度，参数，返回类型（return 类型、异常）
 * Created by teng on 2016/5/17.
 */

@Service
public interface SeckillService {

    /*
    *
    * 查询所有秒杀记录
    * @return
    * */
    List<Seckill> getSeckillList();

    /*
    * 查询单个秒杀记录
    * @param seckillId
    * @return
    * */
    Seckill getById(long seckillId);

    /*
    * 输出秒杀接口地址，否则输出系统时间和秒杀时间
    * @param seckillId
    *
    * */
    Exposer exprotSeckillUrl(long seckillId);

    /*
    * 执行秒杀操作
    * @param seckillId
    * @param userPhone
    * @param md5
    * */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5);




 }
