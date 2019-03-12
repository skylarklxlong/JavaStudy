package online.himakeit.demo.aop.interface_scheme;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.lang.reflect.Method;

/**
 * author：LiXueLong
 * date：2019-03-12
 * mail1：skylarklxlong@outlook.com
 * mail2：li_xuelong@126.com
 * des:处理拦截目的的类
 */
public class MyHandler implements InvocationHandler {
    private Object proxyObj;

    public Object bind(Object obj) {
        this.proxyObj = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
//请在这里插入代码，在方法前调用
            System.out.println("调用log日志方法" + method.getName());
            result = method.invoke(proxyObj, args); //原方法
//请在这里插入代码，方法后调用
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}