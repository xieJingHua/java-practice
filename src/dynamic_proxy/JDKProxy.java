package dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xiejh
 * @Date 2020/5/4 11:00
 **/
public class JDKProxy {

    static {
        System.out.println("init JDKProxy");
    }

    public static void main(String[] args) {

        Human human = (Human) Proxy.newProxyInstance(Human.class.getClassLoader(), new Class[]{Human.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("this is a human");
                         return null;
                    }
                });

        human.say();
    }
}
