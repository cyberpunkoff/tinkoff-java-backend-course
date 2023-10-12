package edu.hw2.callerinfo;

public final class CallerInfo {
    private CallerInfo() {
    }

    public static CallingInfo callingInfo() {
        var stackTrace = new Throwable().getStackTrace();
        var stackFrame = stackTrace[stackTrace.length - 1];
        var className = stackFrame.getClassName();

        return new CallingInfo(stackFrame.getClassName(), stackFrame.getMethodName());
    }
}

