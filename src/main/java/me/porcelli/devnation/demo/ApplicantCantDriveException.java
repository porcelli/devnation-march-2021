package me.porcelli.devnation.demo;

public class ApplicantCantDriveException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ApplicantCantDriveException() {
        super();
    }
    public ApplicantCantDriveException(String msg)   {
        super(msg);
    }

    public ApplicantCantDriveException(String msg, Exception e)  {
        super(msg, e);
    }
}