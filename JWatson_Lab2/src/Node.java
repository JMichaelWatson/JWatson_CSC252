/**
 * Created by JMichael on 8/18/2014.
**/

public class Node<T extends Comparable> {

    private Node<T> leftNode;
    private Node<T> rightNode;
    private T value;

    public Node(T value){
        this.value = value;
    }

    public Node<T> left(){
        return leftNode;
    }

    public Node<T> right(){
        return rightNode;
    }

    public void left(Node<T> left){
        this.leftNode = left;
    }

    public void right(Node<T> right){
        this.rightNode = right;
    }

    public T value(){
        return value;
    }
}
