package rabbitMq;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by Alan on 2018/7/23.
 */
public class AckConsumer2 {

    private static Logger logger = LoggerFactory.getLogger(AckConsumer2.class);
    
    public static void main(String[] args) {
        String QUEUE_NAME= "lyctest";
        try{
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("103.237.2.58");
            factory.setPort(5672);
            factory.setUsername("admin");
            factory.setPassword("admin");

            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();


            // 消费者3
            logger.info("3号消费者开始" + "线程id: " + Thread.currentThread().getId());
            DefaultConsumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    logger.info("3号消费者 ===> " + message + "线程id: " + Thread.currentThread().getId());
                    try {
                        logger.info("3号消费者 ===> 处理中" + "线程id: " + Thread.currentThread().getId());
                        Thread.sleep(10000); // 延时ACK
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    getChannel().basicAck(envelope.getDeliveryTag(), false);
                    logger.info("3号消费者 ===> 处理完成" + "线程id: " + Thread.currentThread().getId());
                }
            };
            channel.basicConsume(QUEUE_NAME, false, consumer);


            // 消费者2
            logger.info("4号消费者开始" + "线程id: " + Thread.currentThread().getId());
            DefaultConsumer anotherConsumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    logger.info("4号消费者 ===> " + message + "线程id: " + Thread.currentThread().getId());
                    //一定要回ack 否则回再次被消费
                    try {
                        logger.info("4号消费者 ===> 处理中" + "线程id: " + Thread.currentThread().getId());
                        Thread.sleep(10000); // 延时ACK
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    getChannel().basicAck(envelope.getDeliveryTag(), false);
                    logger.info("4号消费者 ===> 处理完成" + "线程id: " + Thread.currentThread().getId());
                }
            };
            channel.basicConsume(QUEUE_NAME, false, anotherConsumer);


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
