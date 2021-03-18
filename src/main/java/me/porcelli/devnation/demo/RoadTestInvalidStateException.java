package me.porcelli.devnation.demo;

public class RoadTestInvalidStateException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public RoadTestInvalidStateException() {
        super();
    }
    public RoadTestInvalidStateException(String msg)   {
        super(msg);
    }

    public RoadTestInvalidStateException(String msg, Exception e)  {
        super(msg, e);
    }

}
