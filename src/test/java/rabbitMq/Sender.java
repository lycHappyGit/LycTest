package rabbitMq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.Scanner;

/**
 * Created by Alan on 2018/7/23.
 */
public class Sender {
    public static String queueName = "lyctest";

    public static void main(String[] aa){
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("103.237.2.58");
            factory.setPort(5672);
            factory.setUsername("admin");
            factory.setPassword("admin");

            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(queueName,false,false,false,null);
            System.out.println("输入多条信息查看消费情况，输入消息后回车");
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()){
                String msg = scanner.nextLine();
                //退出
                if(msg != null && "exit".equals(msg)){
                    channel.close();
                    connection.close();
                    break;
                }//发送消息
                else{
                    channel.basicPublish("",queueName,null,msg.getBytes());
                    System.out.println("  >>>发送："+msg+"");
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
