package org.example;
import ch.qos.logback.classic.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;


/**
 * Unit test for simple App.
 */
public class AppTest
{
    private static Logger logger = (Logger)LoggerFactory.getLogger(AppTest.class);
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        logger.error("error++++++++++++++");
        logger.debug("debug++++++++++++++");
        Assertions.assertTrue(true);
    }

}
