package DataStructures;

public class BinaryTree {
	
	BinaryNode root;
	
	public void addNode (int key, String name) {
		
		BinaryNode newNode = new BinaryNode (key, name);
		
		if (root == null) {
			
			root = newNode;
			
		} else {
			
			BinaryNode focusNode = root;
			
			BinaryNode parent;
			
			while (true) {
				
				parent = focusNode;
				
				if (key < focusNode.key) {
					
					focusNode = focusNode.leftChild;
					
					if (focusNode == null) {
						
						parent.leftChild = newNode;
						return;
						
					}
					
				} else {
					
					focusNode = focusNode.rightChild;
					
					if (focusNode == null) {
						
						parent.rightChild = newNode;
						return;
						
					}
					
				}
				
			}
			
		}
		
	}
	
	public void inOrderTraverseTree (BinaryNode focusNode) {
		
		if (focusNode != null) {
			
			inOrderTraverseTree (focusNode.leftChild);
			
			System.out.println(focusNode);
			
			inOrderTraverseTree (focusNode.rightChild);
						
		}
		
	}
	
	public void preorderTraverseTree (BinaryNode focusNode) {
		
		if (focusNode != null) {
			
			System.out.println (focusNode);
			
			preorderTraverseTree (focusNode.leftChild);
			preorderTraverseTree (focusNode.rightChild);
			
		}
		
	}
	
	public void postOrderTraverseTree (BinaryNode focusNode) {
		
		if (focusNode != null) {
			
			postOrderTraverseTree (focusNode.leftChild);
			postOrderTraverseTree (focusNode.rightChild);
			
			System.out.println (focusNode);
			
		}
		
	}
	
	public BinaryNode findNode (int key) {
		
		BinaryNode focusNode = root;
		
		while (focusNode.key != key) {
			
			if (key < focusNode.key) {
				
				focusNode = focusNode.leftChild;
				
			} else {
				
				focusNode = focusNode.rightChild;
				
			}
			
			if (focusNode == null) return null;
			
		}
		
		return focusNode;
		
	}
	
	public static void main (String[] args) {
		
		BinaryTree tree = new BinaryTree();
		
		tree.addNode(50, "Boss");
		tree.addNode(46, "PR Manager");
		tree.addNode(23, "Chairman");
		tree.addNode(25, "CFO");
		tree.addNode(36, "CEO");
		tree.addNode(17, "Programmer");
		tree.addNode(24, "Salesman");
		
		System.out.println (tree.findNode(36));
		
	}
		
}
