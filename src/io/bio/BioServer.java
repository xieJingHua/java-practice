package io.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author xiejh
 * Date   2019/4/9 11:38
 **/
public abstract class BioServer {

    protected  static  final  int PORT=8080;
    
    /**
     * 启动服务器
     */
    public void start() {
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(PORT);
            System.out.println("server已启动");
            while ((socket = server.accept()) != null) {
                System.out.println("有一个新的客户端连接");
                handleConnection(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 处理新客户端的连接请求
     * @param socket
     */
    protected void handleConnection(Socket socket){
        //字类必须重写，否则抛出异常
        throw new UnsupportedOperationException();
    }
}
