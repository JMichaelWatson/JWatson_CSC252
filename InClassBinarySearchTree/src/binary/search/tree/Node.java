package binary.search.tree;

public class Node {

	private Node leftNode;
	private Node rightNode;
	private int value;
	
	public Node(int value){
		this.value = value;
	}
	
	public Node left(){
		return leftNode;
	}
	
	public Node right(){
		return rightNode;
	}
	
	public void left(Node left){
		this.leftNode = left;
	}
	
	public void right(Node right){
		this.rightNode = right;
	}
	
	public int value(){
		return value;
	}
}
