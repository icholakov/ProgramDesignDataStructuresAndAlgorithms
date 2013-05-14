package DataStructures;

import java.util.ArrayList;

public class AVLTree {
	
	protected AVLNode root;
	
	public void insert (int k) {
		
		AVLNode node = new AVLNode (k);
		
		insertAVL (this.root, node);
		
	}
	
	public void insertAVL (AVLNode compared, AVLNode inserted) {
		
		if (compared == null) {
			
			this.root = inserted;
			
		} else {
			
			if (inserted.key < compared.key) {
				if (compared.left == null) {
					
					compared.left = inserted;
					inserted.parent = compared;
					
					recursiveBalance (compared);
					
				} else {
					
					insertAVL (compared.left, inserted);
					
				}
								
			} else if (inserted.key > compared.key) {
				
				if (compared.right == null) {
					
					compared.right = inserted;
					inserted.parent = compared;
					
					recursiveBalance (compared);
					
				} else {
					
					insertAVL (compared.right, inserted);
					
				}
				
			} else {
				
				System.out.println ("This node already exists");
								
			}
			
		}
		
	}
	
	public void recursiveBalance (AVLNode current) {
		
		setBalance (current);
		int balance = current.balance;
		
		if (balance == -2) {
			
			if (height(current.left.left) >= height(current.left.right)) {
				
				current = roateRight(current);
				
			} else {
				
				current = doubleRotateLeftRight(current);
				
			}
			
		}else if (balance == 2) {
			
			if (height(current.right.right) >= height(current.right.left)) {
				
				current = rotateLeft(current);
				
			} else {
				
				current = doubleRotateLeftRight(current);
				
			}
			
		}
		
		if (current.parent != null) {
			
			recursiveBalance (current.parent);
			
		} else {
			
			this.root = current;
			System.out.println ("--------Balancing Finished---------");
		}
		
	}
	
	public void remove (int k) {
		
		removeAVL (this.root, k);
		
	}
	
	public void removeAVL (AVLNode start, int keyremoved) {
		
		if (start == null) {
			
			return;
			
		} else {
			
			if (start.key > keyremoved) {
				
				removeAVL (start.left, keyremoved);
				
			} else if (start.key < keyremoved) {
				
				removeAVL (start.right, keyremoved);
				
			} else if (start.key == keyremoved) {
				
				removeFoundNode (start);
				
			}
			
		}
		
	}
	
	public void removeFoundNode (AVLNode node) {
		
		AVLNode r;
		
		if (node.left == null || node.right == null) {
			
			if (node.parent == null) {
				
				this.root = null;
				node = null;
				return;
				
			}
			r = node;
		} else {
			
			r = successor (node);
			node.key = r.key;
			
		}
		
		AVLNode p;
		if (r.left != null) {
			
			p = r.left;
			
		} else {
			
			p = r.right;
			
		}
		
		if (p != null) {
			
			p.parent = r.parent;
			
		}
		
		if (r.parent == null) {
			
			this.root = p;
			
		} else {
			
			if (r == r.parent.left) {
				
				r.parent.left = p;
				
			} else {
				
				r.parent.right = p;
				
			}
			
			recursiveBalance (r.parent);
			
		}
		r = null;
	}
	
	public AVLNode rotateLeft (AVLNode node) {
		
		AVLNode v = node.right;
		v.parent = node.parent;
		
		if (node.right != null) {
			
			node.right.parent = node;
			
		}
		
		v.left = node;
		node.parent = v;
		
		if (v.parent != null) {
			if (v.parent.right == node) {
				v.parent.right = v;
			} else if (v.parent.left == node) {
				v.parent.left = v;
			}
		}
		
		setBalance(node);
		setBalance(v);
		
		return v;
		
	}
	
	public AVLNode roateRight (AVLNode node) {
		
		AVLNode v = node.left;
		v.parent = node.parent;
		
		node.left = v.right;
		
		if (node.left != null) {
			node.left.parent = node;
		}
		
		v.right = node;
		node.parent = v;
		
		if (v.parent != null) {
			if (v.parent.right == node) {
				v.parent.right = v;
			} else if (v.parent.left == node) {
				v.parent.left = v;
			}
		}
		
		setBalance(node);
		setBalance(v);
		
		return v;
		
	}
	
	public AVLNode doubleRotateLeftRight (AVLNode node) {
		
		node.left = rotateLeft (node.left);
		return roateRight (node);
		
	}
	
	public AVLNode doubleRotateRightLeft (AVLNode node) {
		
		node.right = roateRight (node.right);
		return rotateLeft(node);
		
	}
	
	public AVLNode successor (AVLNode predecessor) {
		
		if (predecessor.right != null) {
			
			AVLNode r = predecessor.right;
			
			while (r.left != null) {
				
				r = r.left;
				
			}
			return r;
		} else {
			
			AVLNode p = predecessor.parent;
			
			while (p != null && predecessor == p.right) {
				
				predecessor = p;
				p = predecessor.parent;
				
			}
			return p;
		}
		
	}
	
	private int height (AVLNode current) {
		
		if (current == null) {
			
			return -1;
			
		}
		
		if (current.left == null && current.right == null) {
			return 0;
		} else if (current.left == null) {
			return 1+height(current.right);
		} else if (current.right == null) {
			return 1+height(current.left);
		} else {
			return 1+maximum(height(current.left), height(current.right));
		}
		
	}
	
	private int maximum (int a, int b) {
		
		if (a >= b) {
			return a;
		} else {
			return b;
		}
		
	}
	
	private void setBalance (AVLNode current) {
		
		current.balance = height(current.right) - height(current.left);
		
	}
	
	final protected ArrayList<AVLNode> inorder () {
		ArrayList<AVLNode> result = new ArrayList<AVLNode>();
		inorder (root, result);
		return result;
	}
	
	final protected void inorder (AVLNode node, ArrayList<AVLNode> io) {
		
		if (node == null) {
			return;
		}
		inorder (node.left, io);
		io.add(node);
		inorder (node.right, io);
		
	}
	
	public static void main (String[] args) {
		
		AVLTree avt = new AVLTree();
		avt.insert(15);
		avt.insert(12);
		avt.insert(20);
		avt.insert(120);
		ArrayList result = avt.inorder();
		System.out.println(result.toString());
		
	}
}
