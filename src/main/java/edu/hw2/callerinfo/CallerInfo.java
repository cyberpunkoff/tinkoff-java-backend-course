package edu.hw2.callerinfo;

public final class CallerInfo {
    private CallerInfo() {
    }

    public static CallingInfo getCallingInfo() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        StackTraceElement stackFrame = stackTrace[1];
        return new CallingInfo(stackFrame.getClassName(), stackFrame.getMethodName());
    }
}

