package edu.hw2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("uncommentedmain")

public class Task4 {
    private Task4() {
    }

    private final static Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        LOGGER.info(callingInfo());
    }

    public static CallingInfo callingInfo() {
        String className;
        String methodName;
        StackTraceElement[] stack = new Throwable().getStackTrace();
        className = stack[1].getClassName();
        methodName = stack[1].getMethodName();
        return new CallingInfo(className, methodName);
    }

    public record CallingInfo(String className, String methodName) {
    }
}

