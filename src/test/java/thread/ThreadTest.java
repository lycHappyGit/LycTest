package thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import java.util.concurrent.CountDownLatch;

@Slf4j
public class ThreadTest {

    private Thread main;
    private Thread you;
    private Thread tiaoliao;
    private CountDownLatch countDownLatch;

    @Before
    public void init(){

        countDownLatch = new CountDownLatch(3);
        main = new Thread(new Main(countDownLatch));
        you = new Thread(new You(countDownLatch));
        tiaoliao = new Thread(new Tiaoliao(countDownLatch));
    }

    /**
     * 做饭
     * 买面-买油-买调料
     * 开始做
     */
    @Test
    public void test() throws InterruptedException {

        log.info("准备做饭...");

        main.start();
        main.join();
        you.start();
        you.join();
        tiaoliao.start();
        tiaoliao.join();

        log.info("材料购齐开始做饭...");
        Thread.sleep(3*1000);
        log.info("做饭完成");
    }

    @Test
    public void test2() throws InterruptedException {

        log.info("准备做饭...");

        main.start();
        you.start();
        tiaoliao.start();
        countDownLatch.await();

        log.info("材料购齐开始做饭...");
        Thread.sleep(3*1000);
        log.info("做饭完成");
    }

}

@Slf4j
class Main implements Runnable{

    private CountDownLatch countDownLatch;

    public Main(CountDownLatch countDownLatch){

        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5*1000);
            log.info("买面完成");
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

@Slf4j
class You implements Runnable{

    private CountDownLatch countDownLatch;

    public You(CountDownLatch countDownLatch){

        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5*1000);
            log.info("买油完成");
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

@Slf4j
class Tiaoliao implements Runnable{

    private CountDownLatch countDownLatch;

    public Tiaoliao(CountDownLatch countDownLatch){

        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5*1000);
            log.info("买调料完成");
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
