package ch04;

public class QueueOverflowException extends RuntimeException {
    QueueOverflowException(){super();}
    QueueOverflowException(String message){super(message);}
}
