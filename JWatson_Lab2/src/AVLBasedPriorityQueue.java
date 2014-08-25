/**
 * Created by JMichael on 8/18/2014.
 */
public class AVLBasedPriorityQueue<T extends Comparable<T>> {
    private AVLTree<T> tree = new AVLTree<T>();

    public boolean offer(T data){
        return tree.insert(data);
    }

    public int size(){
        return tree.size();
    }

    public T poll(){
        return tree.poll();
    }

    public T peek(){
        return tree.peek();
    }

    public void print(){
        tree.print();
    }
}
