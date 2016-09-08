package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/*
* 配置Spring和Junit依赖，junit启动时加载springIOC容器
* spring-test,junit
*
*
* 1、测试方法必须使用@Test进行修饰
* 2、测试方法必须使用public void进行修饰，不带任何参数
* 3、新建一个源代码目录来存放我们的测试代码
* 4、测试类的包应该和被测试类保持一致
* 5、测试单元中的每个方法必须可以独立测试，测试方法间不能有任何依赖
* 6、测试类使用Test作为类名的后缀(不是必须)
* 7、测试方法使用test作为方法名的前缀
*
*
* @Test将一个普通的方法修饰为一个测试方法
* @BeforeClass 他会在所有的方法运行前被执行，static修饰
* @AfterClass  它会在所有的方法运行结束后被执行，static修饰
* @Before      会在每个测试方法被运行前执行一次
* @After       会在每个测试方法运行后执行一次
* @Ignore      所修饰的测试方法会被测试运行器忽略
* @RunWith     可以更改测试运行器
* */

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    @Resource
    private SeckillDao seckillDao;

    @Test
    public void testReduceNumber() throws Exception {
        Date killTime = new Date();
        int updateCount = seckillDao.reduceNumber(100L,killTime);
        System.out.print(updateCount);
    }

    @Test
    public void testQueryById() throws Exception {
        long id = 1004;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());

    }

    @Test
    public void testQueryAll() throws Exception {
        //Parameter 'offset' not found. Available parameters are [1, 0, param1, param2]
        //错误原因：java没有报错形参，会把offset变成arg0
        int offset = 100, limit = 5;
        List<Seckill> list = seckillDao.queryAll(0,100);
        for(Seckill seckill: list){
            System.out.println(seckill.getName());
        }

    }

}