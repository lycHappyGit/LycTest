import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConsoleLogTest {

    public static void main(String[] args) {
        for(int i=0;i<1000;i++){
            log.info("***************测试consoleLog" + i);
        }
    }
}
