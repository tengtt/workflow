package org.seckill.study.pattern.proxy.jdkProxy;


import org.apache.commons.io.FileUtils;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by teng on 2016/5/26.
 *
 *  * 实现步骤：
 * 1、创建一个实现接口InvocationHandler的类，他必须实现invoke方法。
 * 2、创建被代理的类以及接口
 * 3、调用Proxy的静态方法，创建一个代理类。
 */
class Proxy {
    public static Object newProxyInstance(Class infce,InvocationHandler h) throws Exception {
        String rt = "\r\n";
        String methodstr ="";
        for(Method m: infce.getMethods()){
            methodstr +=
            "@Override" + rt +
            "public void "+m.getName()+"() {" + rt +
            "   try{" + rt +
            "       Method m = "+infce.getName() +".class.getMethod(\""+m.getName()+"\");" + rt +
            "       h.invoke(this,m);" + rt +
            "   }catch(Exception e){" +rt +
            "   e.printStackTrace();" +rt +
            "   }"+ rt +
            " }";

        }
        String str =
            "package org.seckill.pattern.proxy.jdkProxy;" + rt +
            "import InvocationHandler;" + rt +
            "import java.lang.reflect.Method;" + rt +
            "public class $Proxy0 implements "+infce.getName()+" {" + rt +
            "private InvocationHandler h;" + rt +
            "    public $Proxy0(InvocationHandler h){" + rt +
            "       super();" + rt +
            "       this.h = h;" + rt +
            "" + rt +
            "    }" + rt +
            "" + rt +
                methodstr+ rt +
            " }" ;

        //D:\IDEAWorkspace\chentt\seckill
        String fileName = System.getProperty("user.dir") + "/bin/org/seckill/pattern/proxy/jdkProxy/$Proxy0.java";
        //String fileName = System.getProperty("user.dir") + "$Proxy0.java";
        System.out.println(fileName);

        File file = new File(fileName);
        FileUtils.writeStringToFile(file, str);
        //拿到编辑器
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        //文件管理者
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null,null,null);
        //获取文件
        Iterable units = fileManager.getJavaFileObjects(fileName);
        //编译任务
        JavaCompiler.CompilationTask t = compiler.getTask(null,fileManager,null,null,null,units);

        //进行编译
        t.call();
        fileManager.close();

        //load到内存中
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        Class c = cl.loadClass("org.seckill.pattern.proxy.jdkProxy.$Proxy0");
        System.out.println(c.getName());

        Constructor constructor = c.getConstructor(InvocationHandler.class);
        return constructor.newInstance(h);
    }
}
