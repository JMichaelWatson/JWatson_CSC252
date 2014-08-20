/**
 * Created by JMichael on 8/18/2014.
 */
public class AVLBasedPriorityQueue<T extends Comparable> {
    private AVLTree<T> tree = new AVLTree<T>();

    public boolean offer(T data){
        return tree.insert(data);
    }

    public Node<T> peek(){
        return tree.peek();
    }

    public void print(){
        Printer printer = new Printer();
        printer.printNode(peek());
    }
}
