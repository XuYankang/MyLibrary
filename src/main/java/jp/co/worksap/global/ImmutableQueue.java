package jp.co.worksap.global;

import java.util.NoSuchElementException;

/**
 * The Queue class represents an immutable first-in-first-out (FIFO) queue of objects. * @param <E>
 */
public class ImmutableQueue<E> {

    private static final long serialVersionUID = 1;
    /**
     * Shared empty array instance used for empty instances.
     */
    private static final Object[] EMPTY_QUEUE = {};

    private transient Object[] queue;

    /**
     * requires default constructor.
     */
    public ImmutableQueue() {
        // modify this constructor if necessary, but do not remove default constructor
        this.queue = EMPTY_QUEUE;
    }

    // add other constructors if necessary
    public ImmutableQueue(E[] queue) {
        this.queue = queue;
    }

    /**
     * Returns the queue that adds an item into the tail of this queue without modifying this queue.
     * <pre>
     * e.g.
     * When this queue represents the queue (2, 1, 2, 2, 6) and we enqueue the value 4 into this queue, * this method returns a new queue (2, 1, 2, 2, 6, 4)
     * and this object still represents the queue (2, 1, 2, 2, 6) .
     * </pre>
     * If the element e is null, throws IllegalArgumentException.
     *
     * @param e
     * @return
     * @throws IllegalArgumentException
     */
    public ImmutableQueue<E> enqueue(E e) {
        if (e == null) {
            throw new IllegalArgumentException("Element to be enqueue is null");
        }
        nullCheck();

        Object[] newQueue = new Object[queue.length + 1];
        System.arraycopy(queue, 0, newQueue, 0, queue.length);
        newQueue[queue.length] = e;
        return new ImmutableQueue<E>((E[]) newQueue);
    }

    public ImmutableQueue<E> append(E e) {
        if (e == null) {
            throw new IllegalArgumentException("Element to be enqueue is null");
        }
        Object[] newQueue = new Object[queue.length + 1];
        System.arraycopy(queue, 0, newQueue, 1, queue.length);
        newQueue[0] = e;
        return new ImmutableQueue<E>((E[]) newQueue);
    }

    /**
     * Returns the queue that removes the object at the head of this queue without modifying this queue. * <pre>
     * e.g.
     * When this queue represents the queue (7, 1, 3, 3, 5, 1) ,
     * this method returns a new queue (1, 3, 3, 5, 1)
     * and this object still represents the queue (7, 1, 3, 3, 5, 1) .
     * </pre>
     * If this queue is empty, throws java.util.NoSuchElementException.
     *
     * @return
     * @throws java.util.NoSuchElementException
     */
    public ImmutableQueue<E> dequeue() {
        nullCheck();
        emptyCheck();
        Object[] newQueue = new Object[queue.length - 1];
        System.arraycopy(queue, 1, newQueue, 0, queue.length - 1);
        return new ImmutableQueue<E>((E[]) newQueue);
    }


    /**
     * Looks at the object which is the head of this queue without removing it from the queue. * <pre>
     * e.g.
     * When this queue represents the queue (7, 1, 3, 3, 5, 1),
     * this method returns 7 and this object still represents the queue (7, 1, 3, 3, 5, 1)
     * </pre>
     * If the queue is empty, throws java.util.NoSuchElementException.
     *
     * @return
     * @throws java.util.NoSuchElementException
     */
    public E peek() {
        nullCheck();
        emptyCheck();
        return (E) queue[0];
    }

    /**
     * Throw NoSuchElementException if queue is empty.
     */
    private void emptyCheck() {
        if (queue.length == 0) {
            throw new NoSuchElementException("The queue is empty");
        }
    }

    /**
     * Throw NullPointerException if queue is not been initialized.
     */
    private void nullCheck() {
        if (queue == null) {
            throw new NullPointerException("The queue is not been initialized. ");
        }
    }

    /**
     * Returns the number of objects in this queue. * @return
     */
    public int size() {
        nullCheck();
        return queue.length;
    }
}