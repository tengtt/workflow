package org.seckill.study.pattern.factory;

import java.util.Map;

/**
 * Created by teng on 2016/5/27.
 *
 * 发型工厂,将产品和实现分离
 */
public class HairFactory {

    //这样做太麻烦
    public HairInterface getHair(String key){


        if("left".equals(key)){
            return new LeftHair();
        }else if("right".equals(key)){
            return new RightHair();
        }
        
        return null;
    }

    public HairInterface getHairByClass(String key){
        Map<String,String> properties = new PropertiesReader().getProperties();
        try {
            try {
                HairInterface hair = (HairInterface)Class.forName(properties.get(key)).newInstance();
                return hair;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  null;

    }
}
