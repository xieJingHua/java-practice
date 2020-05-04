package dynamic_proxy;

import java.util.ArrayList;
import java.util.List;

/**
 * 男人
 *
 * @author xiejh
 * @Date 2020/5/4 10:58
 **/
public class Man implements Human {

    static {
        System.out.println("init Man");
    }

    public void say() {
        System.out.println("我是男人");
    }

}
