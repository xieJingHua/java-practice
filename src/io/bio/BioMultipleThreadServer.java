package io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author xiejh
 * Date   2019/4/9 13:41
 **/
public class BioMultipleThreadServer extends BioServer {

    protected ExecutorService executorService = Executors.newFixedThreadPool(5);

    @Override
    protected void handleConnection(Socket socket) {
        executorService.execute(new Worker(socket));
    }

    class Worker implements Runnable {
        Socket socket;

        public Worker(Socket socket) {
            this.socket = socket;
        }

        private void communicate() {
            System.out.println(Thread.currentThread().getName());
            try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter pw = new PrintWriter(socket.getOutputStream())) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    pw.println("received info:" + line);
                    pw.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            communicate();
        }
    }
}
