package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;

/**
 * Created by teng on 2016/5/17.
 */
public interface SeckillDao {

    /*
    * 减库存
    * @param seckillId
    * @param killTime
    * @Return 如果影响行数大于1，表示更新的记录行数
    * */
    int reduceNumber(@Param("seckillId")long seckillId,@Param("killTime") Date killTime);

    /*
    * 根据id查询秒杀对象
    * @param seckillId
    * @return
    * */
    Seckill queryById(long seckillId);

    /*
    * 根据偏移量查询秒杀商品列表
    * @param offet
    * @param limit
    * @return
    *
    * */
    List<Seckill> queryAll(@Param("offset") int offset,@Param("limit") int limit);
 }
