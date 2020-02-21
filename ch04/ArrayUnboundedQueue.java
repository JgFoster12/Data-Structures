package ch04;

import ch02.StackUnderflowException;

public class ArrayUnboundedQueue<T> implements QueueInterface<T> {
    private final int DEFCAP = 100; //default capacity
    protected T[] elements; //array of elements
    int rear;
    int front = 0;
    int origCap = 0;
    int numElements = 0;

    public ArrayUnboundedQueue(){
        elements = (T[]) new Object[DEFCAP];
        rear = DEFCAP - 1;
        origCap = DEFCAP;
    }

    public ArrayUnboundedQueue(int origCap){
        elements = (T[]) new Object[origCap];
        rear = origCap - 1;
        this.origCap = origCap;
    }

    private void enlarge(){
        T[] larger = (T[]) new Object[elements.length + origCap];

        int currSmaller = front;
        for(int currLarger = 0; currLarger < numElements; currLarger++){
            larger[currLarger] = elements[currSmaller];
            currSmaller = (currSmaller + 1) % elements.length;
        }

        elements = larger;
        front = 0;
        rear = numElements - 1;
    }

    public void enqueue(T element){
        if(numElements == elements.length){
            enlarge();
        }

        rear = (rear + 1) % elements.length;
        elements[rear] = element;
        numElements = numElements + 1;
    }

    public T dequeue(){
        if(isEmpty()){
            throw new StackUnderflowException("Tried to dequeue an empty queue");
        }else{
            T toReturn = elements[front];
            elements[front] = null;
            numElements--;
            return toReturn;
        }
    }

    public boolean isEmpty(){
        return numElements == 0;
    }

    public boolean isFull(){
        return false;
    }

    @Override
    public int size() {
        return numElements;
    }
}
