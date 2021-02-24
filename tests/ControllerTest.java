import controller.Controller;
import javafx.stage.Stage;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import static org.testfx.api.FxAssert.verifyThat;

public class ControllerTest extends ApplicationTest {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Controller controller = new Controller();
        controller.start(primaryStage);
    }
    @Test
    public void testPlay() {
        clickOn("Play");
        verifyThat("We are in the second screen now!", NodeMatchers.isNotNull());
    }
}
