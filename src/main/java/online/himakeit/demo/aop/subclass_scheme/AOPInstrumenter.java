package online.himakeit.demo.aop.subclass_scheme;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * author：LiXueLong
 * date：2019-03-12
 * mail1：skylarklxlong@outlook.com
 * mail2：li_xuelong@126.com
 * des:
 */
public class AOPInstrumenter implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();

    public Object getInstrumentedClass(Class clz) {
        enhancer.setSuperclass(clz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("调用日志方法" + method.getName());
        Object result = proxy.invokeSuper(o, args);
        return result;
    }
}