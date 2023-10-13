package edu.hw2.callerinfo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class CallerInfoTest {
    private final static Logger LOGGER = LogManager.getLogger();

    private CallerInfoTest() {
    }

    /*public static void main(String[] args) {
        var result = CallerInfo.callingInfo();

        LOGGER.info(result.className() + " " + result.methodName());
    }*/
}
