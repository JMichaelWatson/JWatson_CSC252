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
        queue = (T[]) new Comparable[maxLenght];
        tailIndex = 1;
    }

    public boolean offer(T data){
        if(queue.length == maxLenght){
            maxLenght *= 2;
            T[] newQueue = (T[]) new Comparable[maxLenght];
            for(int count = 1; count < queue.length; count++){
                newQueue[count] = queue[count];
            }
            queue = newQueue;
        }
        queue[tailIndex] = data;
        heapify();
        tailIndex++;
        return true;
    }

    public T peek(){
        return queue[1];
    }

    private void heapify(){
        //sort the last index to the right spot
        int parent = tailIndex / 2;
        while (parent != 0) {
            if (queue[tailIndex].compareTo(queue[parent]) > 0) {
                T temp = queue[parent];
                queue[parent] = queue[tailIndex];
                queue[tailIndex] = temp;
                parent = tailIndex / 2 - 1;
            }else{
                parent = 0;
            }

        }
    }

    public String print(){
        String result = "";
        for(T t : queue){
            if(t != null) {
                result += t + " ";
            }
        }
        return result;
    }


}



//for(int x =(tailIndex-1)/2 ; x > 0; x--) {
//        boolean isRight = false;
//        boolean isLeft = false;
//        int leftIndex = x * 2;
//        int rightIndex = x * 2 + 1;
//        if(queue[leftIndex].compareTo(queue[rightIndex]) > 0){
//        if(queue[x].compareTo(queue[leftIndex]) < 0){
//        isLeft = true;
//        }else if(queue[x].compareTo(queue[rightIndex]) > 0){
//        isRight = true;
//        }
//        }else{
//        if(queue[x].compareTo(queue[rightIndex]) > 0){
//        isRight = true;
//        }else if(queue[x].compareTo(queue[leftIndex]) > 0){
//        isLeft = true;
//        }
//        }
//        if(isRight){
//        T temp = queue[x];
//        queue[x] = queue[rightIndex];
//        queue[rightIndex] = temp;
//        while(rightIndex < tailIndex-1){
//        int leftTemp = rightIndex * 2;
//        int rightTemp = rightIndex * 2  + 1;
//        if(leftTemp < tailIndex-1 && rightTemp < tailIndex-1){
//        if(queue[rightIndex].compareTo(queue[leftTemp]) < 0){
//        T TempN = queue[rightIndex];
//        queue[rightIndex] = queue[leftTemp];
//        queue[leftTemp] = TempN;
//        rightIndex = leftTemp;
//        }else if(queue[rightIndex].compareTo(queue[rightTemp]) < 0){
//        T TempN = queue[rightIndex];
//        queue[rightIndex] = queue[rightTemp];
//        queue[rightTemp] = TempN;
//        rightIndex = rightTemp;
//        }else{
//        break;
//        }
//        }else if(leftTemp < tailIndex-1){
//        if(queue[rightIndex].compareTo(queue[leftTemp]) < 0){
//        T TempN = queue[rightIndex];
//        queue[rightIndex] = queue[leftTemp];
//        queue[leftTemp] = TempN;
//        rightIndex = leftTemp;
//        }else{
//        break;
//        }
//        }
//        }
//
//        }else if(isLeft){
//        T temp = queue[x];
//        queue[x] = queue[leftIndex];
//        queue[leftIndex] = temp;
//
//        while(leftIndex < tailIndex-1){
//        int leftTemp = leftIndex * 2;
//        int rightTemp = leftIndex * 2  + 1;
//        if(leftTemp < tailIndex-1 && rightTemp < tailIndex-1){
//        if(queue[leftIndex].compareTo(queue[leftTemp]) < 0){
//        T TempN = queue[leftIndex];
//        queue[leftIndex] = queue[leftTemp];
//        queue[leftTemp] = TempN;
//        leftIndex = leftTemp;
//        }else if(queue[leftIndex].compareTo(queue[rightTemp]) < 0){
//        T TempN = queue[leftIndex];
//        queue[leftIndex] = queue[rightTemp];
//        queue[rightTemp] = TempN;
//        leftIndex = rightTemp;
//        }else{
//        break;
//        }
//        }else if(leftTemp < tailIndex-1){
//        if(queue[leftIndex].compareTo(queue[leftTemp]) < 0){
//        T TempN = queue[leftIndex];
//        queue[leftIndex] = queue[leftTemp];
//        queue[leftTemp] = TempN;
//        leftIndex = leftTemp;
//        }else{
//        break;
//        }
//        }
//        }
//
//
//        }
//
//
//        }

