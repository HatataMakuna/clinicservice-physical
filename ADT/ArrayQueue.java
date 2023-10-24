package adt;

import entity.*;
import java.util.Iterator;

/**
 *   ArrayQueue.java A class that implements the * ADT array by using an
 *   expandable linear array with a fixed front.
 * 
 * @author Tan Kang Hong, Har Chun Wai, Cheng Cai Jie, Nee Mei Yi
 */
public class ArrayQueue<T> implements QueueInterface<T> {

  private T[] array;
  private final static int frontIndex = 0;
  private int backIndex;
  private static final int DEFAULT_CAPACITY = 50; // default maximum capacity

  // constructors
  public ArrayQueue() {
    this(DEFAULT_CAPACITY);
  }

  public ArrayQueue(int initialCapacity) {
    array = (T[]) new Object[initialCapacity];
    backIndex = -1;
  }
  
  // add to queue
  public void enqueue(T newEntry) {
    if (!isArrayFull()) {
      backIndex++;
      array[backIndex] = newEntry;
    }
  }

  // get front value
  public T getFront() {
    T front = null;
    if (!isEmpty()) {
      front = array[frontIndex];
    }
    return front;
  }

  // remove from queue
  public T dequeue() {
    T front = null;
    if (!isEmpty()) {
      front = array[frontIndex];      // shift remaining array items forward one position      
      for (int i = frontIndex; i < backIndex; ++i) {
        array[i] = array[i + 1];
      }
      backIndex--;
    }
    return front;
  }

  // check is empty
  public boolean isEmpty() {
    return frontIndex > backIndex;
  }

  // clear queue
  public void clear() {
    if (!isEmpty()) { // deallocates only the used portion      
      for (int index = frontIndex; index <= backIndex; index++) {
        array[index] = null;
      }
      backIndex = -1;
    }
  }
  
  public int getFrontIndex() {
      return frontIndex;
  }
  
  public int getBackIndex() {
      return backIndex;
  }
  
  public void getAllEntries() {
      for (int i = frontIndex; i <= backIndex; i++) {
          System.out.println(array[i]);
      }
  }
  
  public T getEntry(int givenPosition) {
      T result = null;
      for (int i = frontIndex; i <= backIndex; i++) {
          if (i == givenPosition) {
              result = array[i];
          }
      }
      return result;
  }
  
  public T dequeue(int givenPosition) {
    T result = null;
    if (!isEmpty()) {
      result = array[frontIndex];
      for (int i = frontIndex; i <= backIndex; i++) {
        //array[i] = array[i + 1];
        if (givenPosition == i) {
            int removeIndex = givenPosition - 1;
            int lastIndex = backIndex;
            
            for (int newIndex = removeIndex; newIndex < lastIndex; newIndex++) {
                array[newIndex] = array[i + 1];
            }
        }
      }
      backIndex--;
    }
    return result;
  }

  private boolean isArrayFull() {
    return backIndex == array.length - 1;
  }
  
  public Iterator<T> getIterator() {
    return new ArrayQueueIterator();
  }
  
  
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void replace(int toModify, SickDetailSystem sickDetailSystem) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void replace() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public T queueDisplay() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  
  private class ArrayQueueIterator implements Iterator<T> {
    private int nextIndex;

    private ArrayQueueIterator() {
      nextIndex = 0;
    }

    @Override
    public boolean hasNext() {
      return nextIndex <= backIndex;
    }

    @Override
    public T next() {
      if (hasNext()) {
        T nextEntry = array[nextIndex];
        nextIndex++; // advance iterator
        return nextEntry;
      } else {
        return null;
      }
    }
  }
}
