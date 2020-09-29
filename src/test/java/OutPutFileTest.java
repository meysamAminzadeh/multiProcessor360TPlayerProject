

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import testing.IOTest;
import testing.IOTestClass;
import testing.IOTestRule;

import static org.junit.Assert.*;

/**
 *  @author Meysam Aminzade on 8/2/2020.
 */
@IOTestClass(main= MainClass.class)
public class OutPutFileTest {

    @Rule
    public IOTestRule ioTestRule = new IOTestRule();

    @Test
    @IOTest(input="logs/output.log")
    /**
     *  check Last Line Of OutPutFile with our accept message
     */
    public void checkLastLineOfOutPutFile() {

        String lastOutput = ioTestRule.getLastLine();
        String accepteMessage = "bye 10";

        assertNotEquals(accepteMessage, lastOutput);
    }


}