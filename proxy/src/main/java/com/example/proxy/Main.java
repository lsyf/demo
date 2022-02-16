package com.example.proxy;


import com.example.proxy.cglib.LogInterceptor;
import com.example.proxy.cglib.LogInterceptor2;
import com.example.proxy.java.LogHandler;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {


//        javaProxy();

        cglib();

    }

    private static void cglib() {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/lsyf/Code/github/demo/com/cglib");

        LogInterceptor logInterceptor = new LogInterceptor();
        LogInterceptor2 logInterceptor2 = new LogInterceptor2();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);  // 设置超类，cglib是通过继承来实现的
        enhancer.setCallback(logInterceptor);
//        enhancer.setCallbacks(new Callback[]{logInterceptor, logInterceptor2, NoOp.INSTANCE});
//        enhancer.setCallbackFilter(method -> {
//            if ("select".equals(method.getName())) {
//                return 0;   // Callback 列表第1个拦截器
//            }
//            return 1;   // Callback 列表第2个拦截器，return 2 则为第3个，以此类推
//        });

        UserServiceImpl dao = (UserServiceImpl) enhancer.create();   // 创建代理类
        dao.update();
        dao.select();
    }

    private static void javaProxy() {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        UserServiceImpl userServiceImpl = new UserServiceImpl();
        ClassLoader classLoader = userServiceImpl.getClass().getClassLoader();
        Class[] interfaces = userServiceImpl.getClass().getInterfaces();
        InvocationHandler logHandler = new LogHandler(userServiceImpl);
        UserService proxy = (UserService) Proxy.newProxyInstance(classLoader, interfaces, logHandler);
        // 调用代理的方法
        proxy.select();
        proxy.update();

        // 保存JDK动态代理生成的代理类，类名保存为 UserServiceProxy
        //环境变量 sun.misc.ProxyGenerator.saveGeneratedFiles=true
//        ProxyUtils.generateClassFile(userServiceImpl.getClass(), "UserServiceProxy");
    }
}
