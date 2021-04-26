package thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest3 {

    public static final ThreadLocal<Map<String,Object>> ROLEID_PROJECTID_LOCAL = ThreadLocal.withInitial(HashMap::new);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0; i<10; i++){
            executorService.submit(new R());
        }
        executorService.shutdown();
    }
}

class R implements Runnable {

    @Override
    public void run() {

        Map<String, Object> map = ThreadTest3.ROLEID_PROJECTID_LOCAL.get();
        String threadNmae = Thread.currentThread().getName();
        System.out.println("----threadName: " + threadNmae + "的name为: " + map.get("name"));
        map.put("name", threadNmae);
        try {
            Thread.sleep(2*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("----threadName: " + threadNmae + "的name为: " + map.get("name"));
    }
}
