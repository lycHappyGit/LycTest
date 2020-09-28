package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest2 {

    private static int num = 10000;

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        System.out.println("1处理完...");
        System.out.println("2处理完...");
        System.out.println("开始批量处理...");
        ThreadTest2 threadTest2 = new ThreadTest2();
        threadTest2.doBatch(threadTest2);
        System.out.println("结束批量处理...");
        System.out.println("3处理完...");
        long end = System.currentTimeMillis();
        System.out.println("总耗时 : " + (end-begin));
    }

    private void doBatch(ThreadTest2 threadTest2) {

        ExecutorService executorService = Executors.newFixedThreadPool(60);
        while(num > 0){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    threadTest2.doEach();
                }
            });
            num-=10;
            System.out.println("num = " + num);
        }
        executorService.shutdown();
        int i = 1;
        while(true){
            System.out.println("第"+i+"次查询");
            if(executorService.isTerminated()){
                break;
            }else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i++;
        }
    }

    private void doEach(){
        try {
            System.out.println("线程id:" + Thread.currentThread().getId() + "线程名称: " +Thread.currentThread().getName() + " 开始执行..");
            Thread.currentThread().sleep(10);
            System.out.println("线程id:" + Thread.currentThread().getId() + "线程名称: " +Thread.currentThread().getName() + " 完成..");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
