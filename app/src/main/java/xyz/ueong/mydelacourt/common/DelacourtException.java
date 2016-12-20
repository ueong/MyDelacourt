package xyz.ueong.mydelacourt.common;

public class DelacourtException extends RuntimeException {
    public DelacourtException() {
    }

    public DelacourtException(String detailMessage) {
        super(detailMessage);
    }

    public DelacourtException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public DelacourtException(Throwable throwable) {
        super(throwable);
    }
}
