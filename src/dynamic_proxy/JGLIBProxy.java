package dynamic_proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author xiejh
 * @Date 2020/5/5 0:47
 **/
public class JGLIBProxy {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Man.class);
        enhancer.setCallback(new MethodInterceptor(){
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("增强");
                return methodProxy.invokeSuper(o, args);
            }
        });

        Man man =(Man) enhancer.create();
        man.say();
    }
}
