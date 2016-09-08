package org.seckill.study.annotation;


import org.seckill.study.annotation.test.Filter;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by teng on 2016/5/18.
 */
public class TestTableAndColumn {

    public static void main(String[] args){
        Filter f1 = new Filter();
        f1.setId(1);

        Filter f2 = new Filter();
        f2.setNick_name("lucy");

        Filter f3 = new Filter();
        f3.setCity("北京");

        String sql1 = query(f1);
        String sql2 = query(f2);
        String sql3 = query(f3);

        System.out.println(sql1);
        System.out.println(sql2);
        System.out.println(sql3);
    }
    public static String query(Filter f){
        StringBuilder sb = new StringBuilder();

        //1、获取类
        Class c = f.getClass();
        //2、获取到table的名字
        boolean exists = c.isAnnotationPresent(Table.class);
        if(!exists){
            return null;
        }
        Table t = (Table)c.getAnnotation(Table.class);
        String tableName = t.value();

        sb.append("select * from").append(tableName).append(" where 1=1");

        //遍历所有的字段
        Field[] filedArray = c.getDeclaredFields();
        for(Field field: filedArray){
            //获取数据库中的字段
            boolean isExist = field.isAnnotationPresent(Column.class);
            if(!isExist){
                continue;
            }
            String filedName = field.getName();
            String getMethodName = "get" + filedName.substring(0, 1).toUpperCase() + filedName.substring(1);
            Object filedValue = null;
            try{
                Method method = c.getDeclaredMethod(getMethodName);
                filedValue = method.invoke(f);
            }catch (InvocationTargetException e){

            }catch (IllegalAccessException e){

            }catch (NoSuchMethodException e){

            }
            if (null == filedValue ||(filedValue instanceof Integer && (Integer)filedValue == 0)) {
                continue;
            }
            sb.append(" and ").append(filedName);
            if(filedValue instanceof String){
                sb.append(" = ").append("'").append(filedValue).append("'");
            }else{
                sb.append("=").append(filedValue);
            }
        }


        return sb.toString();

    }

}
