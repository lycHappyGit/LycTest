package socket;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sunpe on 2018/6/21.
 */
public class Client {


//    private static ReentrantLock lock = new ReentrantLock();
//    private static Condition condition =lock.newCondition();
//    private boolean socketIsFine = false;
    private Socket socket = null;
    private OutputStream os = null;
    private InputStream is = null;
    private String id;
    private String serverIp = "10.1.30.70";
    private int sec = 30;
    private String heartbeatStr;
    private String registerStr;


    public Client(String id) {
        this.id = id;
        Map<String,String> map = new HashMap<>();
        map.put("spotKey",id);
        this.heartbeatStr = MsgUtil.packMsg("01"+JSON.toJSONString(map));
        this.registerStr = MsgUtil.packMsg("02"+JSON.toJSONString(map));
    }

    public static void main(String[] args) {

        for(int i=0;i<1;i++){
            new Client("uuu9").new SocketThread().start();
        }

//        String heartbeat = "11001-heart:00001;";
//
//        int len = heartbeat.getBytes().length;
//
//        String heartbeatStr = len + heartbeat;
//
//
//        byte[] bb = heartbeatStr.getBytes();
//        byte[] gg = "18".getBytes();
//
//        System.out.println(bb);


    }

    /**
     * 发送心跳包
     */
    public void sendHeartbeat() {
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {

                        try {
//                            if(!socketIsFine){
//                                lock.lock();
//                                condition.await();//等待
//                            }

                            Thread.sleep(sec * 1000);// 10s发送一次心跳
                            os.write(heartbeatStr.getBytes());
                            os.flush();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }finally {
//                            if(!socketIsFine){
//                                lock.unlock();
//                            }
                        }
                    }
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class SocketThread extends Thread {

        @Override
        public void run() {
            long startTime = System.currentTimeMillis();
            sendHeartbeat();
            while (true) {
                try {
                    if (socket == null || socket.isClosed()) {
                        socket = new Socket(serverIp, 11211); // 连接socket
                        os = socket.getOutputStream();
                        os.write(registerStr.getBytes());
                        os.flush();
                    }
//                    Thread.sleep(100);
                    is = socket.getInputStream();
//                    int size = is.available();



                    byte[] bytelen = new byte[8] ;
                    is.read(bytelen);
                    String len = new String(bytelen) ;
                    Integer lenNum = MsgUtil.strToInt(len);
                    String response;
                    if(lenNum!=0){
                        byte[] bytes = new byte[lenNum] ;
                        is.read(bytes) ;
                        response = new String(bytes, "utf-8") ;
                    }else {
                        response = len;
                    }

                    System.out.println(response);

                    if(!"04".equals(response)){



//                        os.write(MsgUtil.back().getBytes());
//                        os.flush();
                    }else{
//                        socket.close();
//                        is.close();
//                        os.close();
                    }

                    long ds = System.currentTimeMillis() - startTime;
                    System.out.println("间隔时间："+ds);
                    startTime = System.currentTimeMillis();
                    if ((ds) > sec * 3 * 1000) { // 如果超过30秒没有收到服务器发回来的信息，说明socket连接可能已经被远程服务器关闭

                        System.out.println(id+",超过30秒没有收到服务器发回来的信息");
                        socket.close(); // 这时候可以关闭socket连接
                        continue;
                    }



//                    if (size <= 0) {
//                        long ds = System.currentTimeMillis() - startTime;
//                        System.out.println("间隔时间："+ds);
//                        if ((ds) > 3 * 10 * 1000) { // 如果超过30秒没有收到服务器发回来的信息，说明socket连接可能已经被远程服务器关闭
//
//                            System.out.println(id+",超过30秒没有收到服务器发回来的信息");
//                            socket.close(); // 这时候可以关闭socket连接
//                            startTime = System.currentTimeMillis();
//                        }
//                        continue;
//                    } else {
//                        startTime = System.currentTimeMillis();
//                    }


                } catch (Exception e) {
//                    socketIsFine = false;
                    e.printStackTrace();
                    try {
                        socket.close();
                        is.close();
                        os.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
    }

}
