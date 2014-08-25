/**
 * Created by JMichael on 8/18/2014.
**/

public class AVLNode<T> {

    private AVLNode<T> leftAVLNode;
    private AVLNode<T> rightAVLNode;
    private T value;

    public AVLNode(T value){
        this.value = value;
    }

    public AVLNode<T> left(){
        return leftAVLNode;
    }

    public AVLNode<T> right(){
        return rightAVLNode;
    }

    public void left(AVLNode<T> left){
        this.leftAVLNode = left;
    }

    public void right(AVLNode<T> right){
        this.rightAVLNode = right;
    }

    public T value(){
        return value;
    }
}
