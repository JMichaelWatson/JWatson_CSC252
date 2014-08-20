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
        if(currentNode == null && parent == null){
            this.root = new Node(value);
        }else if(currentNode == null){
            currentNode = new Node(value);
            if(parent.value().compareTo(currentNode.value())<0){
                if(parent.right() == null){
                    parent.right(currentNode);
                }else{
                    insert(parent.right(), parent, value);
                }
            }else if(parent.value().compareTo(currentNode.value())>0) {
                if (parent.left() == null) {
                    parent.left(currentNode);
                } else {
                    insert(parent.left(), parent, value);
                }
            }
        }else{
            if(value.compareTo(currentNode.value()) < 0){
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
