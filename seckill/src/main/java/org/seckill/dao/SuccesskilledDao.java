package org.seckill.dao;

import org.seckill.entity.SuccessKilled;
import org.apache.ibatis.annotations.Param;

/**
 * Created by teng on 2016/5/17.
 */
public interface SuccesskilledDao {

    /*
    * 插入购买明细，可过滤重复
    * @param seckillId
    * @param userPhone
    * @return
    *
    * */

    int insertSuccessKilled(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);

    /*
    * @param seckillId
    * @return
    * */

    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);
  }
