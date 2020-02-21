package ch04;

public class QueueUnderflowException extends RuntimeException {
    QueueUnderflowException(){super();}
    QueueUnderflowException(String message){super(message);}

}
