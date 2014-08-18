import java.lang.reflect.Array;

/**
 * Created by JMichael on 8/18/2014.
 */
public class HeadBasedPriorityQueue<T extends Comparable> {

    private T[] queue;
    private int maxLenght = 10;
    private int tailIndex;

    public HeadBasedPriorityQueue() {
        //create queue
        queue = (T[]) new Object[maxLenght];
        tailIndex = 0;
    }

    public boolean offer(T data){
        if(queue.length == maxLenght){
            maxLenght *= 2;
            T[] newQueue = (T[]) new Object[maxLenght];
            for(int count = 0; count < queue.length; count++){
                newQueue[count] = queue[count];
            }
            queue = newQueue;
        }
        queue[tailIndex] = data;
        sort(tailIndex++);
        return true;
    }

    public T peek(){
        return queue[0];
    }

    private void sort(int index){
        //sort the last index to the right spot
        int parentIndex = (index -1 ) /2;
        boolean swap = false;
        while(index > 0 && !swap) {
            if (queue[parentIndex].compareTo(queue[index]) <= -1) {
                T temp = queue[parentIndex];
                queue[parentIndex] = queue[index];
                queue[index] = temp;
                swap = true;
            }
            index = parentIndex;
            parentIndex = (index-1)/2;
        }
    }


}
