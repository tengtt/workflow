package org.seckill.study.mybatis.interfaceCode;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by teng on 2016/5/31.
 */
public class MapperProxy implements InvocationHandler {


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("通过接口与method获取对应的的配置文件中的信息");
        System.out.println("接口名称.方法名==namespace.id");
        System.out.println("通过配置文件中的信息获取SQL语句类型");
        System.out.println("根据SQL语句类型调用sqlSession对应的增删改查方法");
        System.out.println("当SQL语句类型是查询时：");
        System.out.println("根据返回值得类型是;List,Map，Object");
        System.out.println("分别调用SelectList,selectMap,selectOne");

        List<Object> list = new ArrayList<Object>();
        list.add(1);
        list.add(2);
        return list;
    }
}
