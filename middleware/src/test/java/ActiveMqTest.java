import com.ldf.architect.middleware.App;
import com.ldf.architect.middleware.activeMq.Publisher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lidefu
 * @date 2019/9/4 16:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class ActiveMqTest {

    @Autowired
    private Publisher publisher;

    @Test
    public void publisherTest() throws InterruptedException {
        publisher.publish("topic.0904", "20190904");
        Thread.sleep(1000*10);
    }

}
