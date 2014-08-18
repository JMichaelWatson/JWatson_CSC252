/**
 * Created by JMichael on 8/18/2014.
 */
public class AVLTree <T extends Comparable>{

    private Node<T> root;

    public boolean insert(T value){
        return insert(root, root, value);
    }

    public Node<T> peek(){
        return root;
    }

    public String inOrder(){
        return inOrder(root);
    }

    public String preOrder(){
        return preOrder(root);
    }

    public String postOrder(){
        return postOrder(root);
    }

    private boolean insert(Node currentNode, Node parent, T value){
        boolean isInserted = false;
        if(root == null){
            if(parent == null){
                this.root = new Node(value);
            }
        }else if(currentNode == null){
            if(value.compareTo(parent.value()) < 0){
                parent.left(new Node(value));
            }else{
                parent.right(new Node(value));
            }
        }else{
            if(value.compareTo(parent.value()) < 0){
                insert(currentNode.left(), currentNode, value);
            }else{
                insert(currentNode.right(), currentNode, value);
            }
        }
        return isInserted;
    }

    private String inOrder(Node current){
        String order = "";
        if(current != null){
            order += inOrder(current.left());
            order += current.value() + " ";
            order += inOrder(current.right());
        }
        return order;

    }

    private String preOrder(Node current){
        String order = "";
        if(current != null){
            order += current.value() + " ";
            order += preOrder(current.left());
            order += preOrder(current.right());
        }
        return order;

    }

    private String postOrder(Node current){
        String order = "";
        if(current != null){
            order += postOrder(current.left());
            order += postOrder(current.right());
            order += current.value() + " ";
        }
        return order;

    }
}
