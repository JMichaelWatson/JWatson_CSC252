import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMichael on 8/10/2014.
 */
public class Node implements Comparable{

    private List<Byte> key = new ArrayList<Byte>();
    private double value;
    private Node left;
    private Node right;
    private Boolean isLeaf;

    public Node (List<Byte> key, double value){
        this.key.addAll(key);
        this.value = value;
        this.isLeaf = false;
    }
    public Node(byte key, double value){
        this.key.add(key);
        this.value = value;
        this.isLeaf = false;
    }

    public void addKey(byte Key){
        this.key.add(Key);
    }
    public void addKey(List<Byte> key){
        this.key.addAll(key);
    }
    public List<Byte> getKey() {
        return key;
    }

    public double getValue() {
        return value;
    }

    public Node getLeftNode() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRightNode() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Boolean getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    public int compareTo(Object two) throws ClassCastException {
        Node tempNode = (Node)two;
        if(value < tempNode.getValue()){
            return -1;
        }else if(this.value == tempNode.getValue()){
            return 0;
        }else{
            return 1;
        }
    }
}
