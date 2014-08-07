package binary.search.tree;



public class Tree {

	private Node root;
	
	
	
	public boolean insert(int value){		
		return insert(root, root, value);
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
	
	private boolean insert(Node currentNode, Node parent, int value){
		boolean isInserted = false;
		if(root == null){
			if(parent == null){
			this.root = new Node(value);
			}
		}else if(currentNode == null){
			if(value < parent.value()){
				parent.left(new Node(value));
			}else{
				parent.right(new Node(value));
			}
		}else{
			if(value < parent.value()){
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
