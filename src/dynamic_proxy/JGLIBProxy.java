package dynamic_proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xiejh
 * @Date 2020/5/5 0:47
 **/
public class JGLIBProxy {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Man.class);
        enhancer.setCallback((MethodInterceptor) (o, method, args1, methodProxy) -> {
            System.out.println("增强");
            return methodProxy.invokeSuper(o, args1);
        });

        Man man = (Man) enhancer.create();
        man.say();
    }
}
