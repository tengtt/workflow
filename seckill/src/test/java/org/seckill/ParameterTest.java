package org.seckill;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.test.context.ContextConfiguration;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by teng on 2016/6/3.
 *
 * 针对多个测试方法的参数类似。可以用这种方式
 *
 * 1、更改默认运行器为Parameterized
 * 2、声明变量来存放预期值和结果值
 * 3、声明一个放回值为Collection的公共静态方法，并用@Parameters进行修饰
 * 4、为测试类声明一个带有参数的公共构造函数，并在其中为其成名变量值
 *
 */

@RunWith(Parameterized.class)
public class ParameterTest {

    int expected = 0;
    int input1 = 0;
    int input2 = 0;

    @Parameterized.Parameters
    public static Collection<Object[]> t(){
        return Arrays.asList(new Object[][]{
                {2,4,2},
                {1,2,2}
        });
    }

    public ParameterTest(int expected, int input1, int input2){
        this.expected = expected;
        this.input1 = input1;
        this.input2 = input2;
    }

    //@Ignore
    @Test
    public void testDivide(){
       assertEquals(expected, new Calculate().divide(input1, input2));
    }



   /* public static void main(String[] args)
    {
        System.out.println("----start---");
        boolean isOpen = false;
        assert isOpen=true;             //如果开启了断言，会将isOpen的值改为true
        System.out.println("是否开启了断言"+isOpen);  //打印是否开启了断言
        if (isOpen)
        {
            int value=-1;
            assert 0 < value:"value="+value;
        }
        System.out.println("----end----");
    }*/
}
