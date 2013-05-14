package DataStructures;

public class Link {

	public String bookName;
	public int millionsSold;
	
	public Link next;
	
	public Link (String bookName, int millionsSold) {
		
		this.bookName = bookName;
		this.millionsSold = millionsSold;
		
	}
	
	public void display () {
		
		System.out.println (bookName + ": " + millionsSold + ",000,000 Sold");
	
	}
	
	public String toString () {
		
		return bookName;
		
	}
	
	public static void main (String[] args) {
		
		LinkedList linkedlist = new LinkedList();
		
		linkedlist.insertFirstLink ("Don Quixote", 500);
		linkedlist.insertFirstLink ("A Tale of Two Cities", 200);
		linkedlist.insertFirstLink ("The Lord Of The Rings", 150);
		linkedlist.insertFirstLink ("Harry Potter and the Philosopher's stone", 100);
		
		linkedlist.display();
		
		System.out.println ("Value of first in LinkedList " + linkedlist.firstLink + "\n");
		
		linkedlist.removeFirst();
		
		linkedlist.display();
		
		linkedlist.removeLink ("A Tale of Two Cities");
		
		linkedlist.display();
	}
	
}
