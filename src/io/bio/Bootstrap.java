package io.bio;

/**
 * Author xiejh
 * Date   2019/4/9 13:31
 **/
public class Bootstrap {

    public static void main(String[] args) {
        //单线程阻塞server
//        BioServer server=new BioSingleThreadServer();
        //多线程阻塞server 可连接多个客户端
        BioServer server = new BioMultipleThreadServer();
        server.start();
    }
}
