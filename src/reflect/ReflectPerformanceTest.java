package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 性能测试
 * 初步结果：感觉反射并不是很耗性能
 * @author: xiejh
 * created at: 2020/12/29 10:48 上午
 */
public class ReflectPerformanceTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
//        long start = System.currentTimeMillis();
//        ReflectPerformanceTest test = new ReflectPerformanceTest();
//        for(int i=0;i<1000000;i++){
//            test.test();
//        }
//        System.out.println("耗时："+(System.currentTimeMillis()-start));

        long start = System.currentTimeMillis();
        ReflectPerformanceTest test = ReflectPerformanceTest.class.newInstance();
        Method testMethod = ReflectPerformanceTest.class.getMethod("test");
        for(int i=0;i<1000000;i++){
            testMethod.invoke(test);
        }
        System.out.println("耗时："+(System.currentTimeMillis()-start));
    }

    public void test(){
      int i = 1+1;
        System.out.println("11");
    }

}
