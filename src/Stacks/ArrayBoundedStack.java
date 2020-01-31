package ch02;

public class ArrayBoundedStack<T> implements StackInterface<T> {

    protected final int DEFAULT_CAPACITY = 100;
    protected T[] elements;
    protected int currentIndex = -1;

    public ArrayBoundedStack(){
        elements = (T[]) new Object[DEFAULT_CAPACITY]; //Binds the maximum capacity of the stack to 100

    }

    public ArrayBoundedStack(int maxSize){
        elements = (T[]) new Object[maxSize]; //Sets the user inputted maximum capacity of the stack to maxSize
    }

    //push element onto stack
    public void push(T element){
        if(isFull()){
            throw new StackOverflowException("You attempted to push an element onto a full stack."); // Throws exception if stack is full
        }
        else{
            currentIndex++; //Increments index by 1
            elements[currentIndex] = element; //Sets the top of the stack equal to element
        }
    }

    //Removes element at currentIndex
    public void pop(){
        if(isEmpty()){
            throw new StackUnderflowException("You attempted to pop a non-existent character"); //Throws exception if stack is empty
        }
        else{
            elements[currentIndex] = null; //Sets current index to null
            currentIndex--; // Points to previous index

        }
    }
    //Returns the last added element of the stack
    public T top(){
        if(isEmpty()){
            throw new StackUnderflowException("Empty, nothing to show."); //Throws exception if stack is empty
        }
        return elements[currentIndex]; //Returns element at the top of the stack
    }


    public boolean isFull() {
       return currentIndex == (elements.length -1); //Tests to see if the stack is full
    }

    public boolean isEmpty(){
        return currentIndex == -1; //Tests to see if stack is empty
    }
}
