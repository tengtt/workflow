package org.seckill;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.seckill.dao.SeckillDaoTest;
import org.seckill.dao.SuccesskilledDaoTest;
import org.seckill.service.SeckillServiceTest;

/**
 * Created by teng on 2016/6/3.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({SeckillDaoTest.class, SuccesskilledDaoTest.class, SeckillServiceTest.class})
public class SuiteTest {

    /*
    * 测试套件，组织测试类一起运行
    * */
}
