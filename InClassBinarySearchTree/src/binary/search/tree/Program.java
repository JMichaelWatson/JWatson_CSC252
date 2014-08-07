package binary.search.tree;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree tree = new Tree();
		tree.insert(50);
		tree.insert(30);
		tree.insert(70);
		tree.insert(20);
		tree.insert(40);
		tree.insert(60);
		tree.insert(80);
		tree.insert(2);
		tree.insert(51);
		tree.insert(65);
		tree.insert(3);
		tree.insert(67);
		System.out.println(tree.inOrder());
		System.out.println(tree.preOrder());
		System.out.println(tree.postOrder());
		
	}	

}
