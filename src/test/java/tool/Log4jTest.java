package tool;


import org.apache.log4j.Logger;

public class Log4jTest {

    private static Logger LOGGER = Logger.getLogger(Log4jTest.class);

    public static void main(String [] args) {

        LOGGER.info("This is log info1");
        LOGGER.info("This is log info2");
        LOGGER.info("This is log info3");
        LOGGER.info("This is log info4");
        LOGGER.info("This is log info5");
        LOGGER.info("This is log info6");


        LOGGER.debug("This is log debug1");
        LOGGER.debug("This is log debug2");
        LOGGER.debug("This is log debug3");
        LOGGER.debug("This is log debug4");

        LOGGER.error("This is log error1");
        LOGGER.error("This is log error2");
        LOGGER.error("This is log error3");
        LOGGER.error("This is log error4");
    }

}
