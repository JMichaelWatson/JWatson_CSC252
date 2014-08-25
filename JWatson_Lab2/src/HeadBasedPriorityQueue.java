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

    public HeadBasedPriorityQueue(int maxLenght) {
        this.maxLenght = maxLenght;
        tailIndex = 1;
        queue = (T[]) new Comparable[maxLenght];
    }

    //returns the head
    public T poll() {
        T temp = queue[1];
        queue[1] = queue[tailIndex - 1];
        queue[tailIndex - 1] = temp;
        tailIndex--;
        tHeapify();
        return temp;
    }
//    public T poll() {
//        if (tailIndex - 1 > 0) {
//            int temp = 1;
//            for (int index = 2; index < tailIndex - 1; index++) {
//                if (queue[temp].compareTo(queue[index]) > 0){
//                    temp = index;
//                }
//            }
//            //swap
//            T tempNode = queue[temp];
//            queue[temp] = queue[tailIndex - 1];
//            queue[tailIndex - 1] = tempNode;
//            tailIndex--;
//            //heapify
//            heapify();
//            return tempNode;
//        }
//        return null;
//    }

    public int size() {
        return tailIndex - 1;
    }

    public boolean offer(T data) {
        if (tailIndex == maxLenght) {
            maxLenght *= 2;
            T[] newQueue = (T[]) new Comparable[maxLenght];
            for (int count = 1; count < queue.length; count++) {
                newQueue[count] = queue[count];
            }
            queue = newQueue;
        }
        queue[tailIndex++] = data;
        heapify();
        return true;
    }

    public T peek() {
        return queue[1];
    }

    private void heapify() {
        //sort the last index to the right spot
        int parent = (tailIndex - 1) / 2;
        int count = 1;
        while (parent > 0) {
            if (queue[tailIndex - count].compareTo(queue[parent]) < 0) {
                T temp = queue[parent];
                queue[parent] = queue[tailIndex - count];
                queue[tailIndex - count] = temp;

            }
            parent = (tailIndex - ++count) / 2;
        }
    }

    private void tHeapify() {
        int parent = 1;
        while(parent<(tailIndex-1)/2){
            int left = parent*2;
            int right = parent*2+1;
            if(queue[left].compareTo(queue[right])<0){
                if(queue[parent].compareTo(queue[left])>0){
                    T temp = queue[parent];
                    queue[parent] = queue[left];
                    queue[left]= temp;
                }else  if(queue[parent].compareTo(queue[right])>0){
                    T temp = queue[parent];
                    queue[parent] = queue[right];
                    queue[right]= temp;
                }
            }else{
                if(queue[parent].compareTo(queue[right])>0){
                    T temp = queue[parent];
                    queue[parent] = queue[right];
                    queue[right]= temp;
                }else  if(queue[parent].compareTo(queue[left])>0){
                    T temp = queue[parent];
                    queue[parent] = queue[left];
                    queue[left]= temp;
                }
            }
            parent++;
        }
    }

    public String print() {
        String result = "";
        for (int index = 1; index < tailIndex; index++) {
            result += queue[index] + " ";
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

