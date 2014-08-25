/**
 * Created by JMichael on 8/18/2014.
 */
public class AVLTree<T extends Comparable<T>> {

    private AVLNode<T> root;

    public boolean insert(T value) {
        return insert(root, null, value);
    }

    public void print(){
        Printer printer = new Printer();
        printer.printNode(root);
    }
    public T peek() {
        return root.value();
    }

    public T poll() {
        return poll(root, null);

    }

    public int size() {
        return count(root);
    }

    public String inOrder() {
        return inOrder(root);
    }

    public String preOrder() {
        return preOrder(root);
    }

    public String postOrder() {
        return postOrder(root);
    }

    private T poll(AVLNode<T> current, AVLNode<T> parent) {
        if (current != null) {
            if (current.left() == null) {
                //rertrn current and replace with right
                AVLNode<T> temp = current;
                if (parent != null) {
                    if (parent.value().compareTo(current.value()) < 0) {

                        parent.right(current.right());

                    } else {
                        parent.left(current.right());
                    }
                } else {
                    root = current.right();
                }
                return temp.value();

            } else if (current.left().right() == null && current.left().left() == null) {
                return current.left().value();
            } else {
                return poll(current.left(), current);
            }
        }
        return null;
    }

    private int count(AVLNode<T> current){
        if(current != null){
            return count(current.left()) + count(current.right()) + 1;
        }
        return 0;
    }

    private boolean insert(AVLNode<T> currentAVLNode, AVLNode<T> parent, T value) {
        boolean isInserted = false;
        if (currentAVLNode == null && parent == null) {
            this.root = new AVLNode<T>(value);
        } else if (currentAVLNode == null) {
            currentAVLNode = new AVLNode<T>(value);
            if (parent.value().compareTo(currentAVLNode.value()) < 0) {
                if (parent.right() == null) {
                    parent.right(currentAVLNode);
                } else {
                    insert(parent.right(), parent, value);
                }
            } else if (parent.value().compareTo(currentAVLNode.value()) > 0) {
                if (parent.left() == null) {
                    parent.left(currentAVLNode);
                } else {
                    insert(parent.left(), parent, value);
                }
            }else{

                //dup
            }
        } else {
            if (value.compareTo(currentAVLNode.value()) < 0) {
                insert(currentAVLNode.left(), currentAVLNode, value);
            } else if(value.compareTo(currentAVLNode.value()) > 0){
                insert(currentAVLNode.right(), currentAVLNode, value);
            }
        }
        Balance(currentAVLNode, parent);
        return isInserted;
    }

    private String inOrder(AVLNode current) {
        String order = "";
        if (current != null) {
            order += inOrder(current.left());
            order += current.value() + " ";
            order += inOrder(current.right());
        }
        return order;

    }

    private String preOrder(AVLNode current) {
        String order = "";
        if (current != null) {
            order += current.value() + " ";
            order += preOrder(current.left());
            order += preOrder(current.right());
        }
        return order;

    }

    private String postOrder(AVLNode current) {
        String order = "";
        if (current != null) {
            order += postOrder(current.left());
            order += postOrder(current.right());
            order += current.value() + " ";
        }
        return order;

    }

    private void Balance(AVLNode<T> current, AVLNode<T> parent) {
        if (current != null) {
            int bf = getBalanceFactor(current);
            if (bf > 1) {
                //Right rotation
                //check left child bf
                int leftChildbf = getBalanceFactor(current.left());
                if (leftChildbf >= 0) {
                    rightRotation(current, parent);
                } else {
                    leftRotation(current.left(),current);
                    rightRotation(current, parent);
                }
            } else if (bf < -1) {
                //Left rotation
                //check right child bf
                int rightChildbf = getBalanceFactor(current.right());
                if (rightChildbf <= 0) {
                    //Left rotation
                    leftRotation(current,parent);
                } else {
                    //LR rotation
                    rightRotation(current.right(), current);
                    leftRotation(current,parent);
                }
            }
        }
    }

    private int getBalanceFactor(AVLNode<T> current) {
        return height(current.left()) - height(current.right());
    }

    private int height(AVLNode<T> current) {
        if (current != null) {
            return Math.max(height(current.left()), height(current.right())) + 1;
        }
        return 0;
    }

    private void rightRotation(AVLNode<T> current, AVLNode<T> parent) {
        if (parent != null) {
            AVLNode<T> temp = current;
            AVLNode<T> promoted = current.left();
            if (promoted.value().compareTo(parent.value()) > 0) {
                parent.right(promoted);
            } else {
                parent.left(promoted);
            }

            temp.left(promoted.right());
            promoted.right(temp);
        } else {
            AVLNode<T> temp = root;
            root = current.left();
            temp.left(root.right());
            root.right(temp);


        }
    }

    private void leftRotation(AVLNode<T> current, AVLNode<T> parent){
        if (parent != null) {
            AVLNode<T> temp = current;
            AVLNode<T> promoted = current.right();
            if (promoted.value().compareTo(parent.value()) > 0) {
                parent.right(promoted);
            } else {
                parent.left(promoted);
            }

            temp.right(promoted.left());
            promoted.left(temp);
        } else {
            AVLNode<T> temp = root;
            root = current.right();
            temp.right(root.left());
            root.left(temp);


        }
    }

}
