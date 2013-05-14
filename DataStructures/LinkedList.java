package DataStructures;

public class LinkedList {
	
	public Link firstLink;
	
	public LinkedList () {
		
		firstLink = null;
		
	}
	
	public boolean isEmpty () {
		
		return (firstLink == null);
		
	}
	
	public void insertFirstLink (String bookName, int millionsSold) {
		
		Link newLink = new Link (bookName, millionsSold);
		
		newLink.next = firstLink;
		
		firstLink = newLink;
		
	}
	
	public Link removeFirst () {
		
		Link linkReference = firstLink;
		
		if (!isEmpty()) {
			
			firstLink = firstLink.next;
			
		} else {
			
			System.out.println ("Empty LinkedList");
			
		}
		
		return linkReference;
		
	}
	
	public void display () {
		
		Link link = firstLink;
		
		while (link != null) {
			
			link.display();
			
			System.out.println ("Next Link: " + link.next);
			
			link = link.next;
			
			System.out.println();
			
		}
		
	}
	
	public Link find (String bookName) {
		
		Link link = firstLink;
		
		if (!isEmpty()) {
			
			while (link.bookName != bookName) {
				
				if (link.next == null) {
					return null;
				} else {
					link = link.next;
				}
			}
		} else {
			
			System.out.println ("Empty LinkedList");
			
		}
		
		return link;
		
	}
	
	public Link removeLink (String bookName) {
		
		Link currentLink = firstLink;
		Link previousLink = firstLink;
		
		while (currentLink.bookName != bookName) {
			
			if (currentLink.next == null) {
				return null;
			} else {
				previousLink = currentLink;
				currentLink = currentLink.next;
				
			}
		}
		
		if (currentLink == firstLink) {
			
			firstLink = firstLink.next;
			
		} else {
			
			System.out.print("FOUND A MATCH");
			System.out.println("currentLink: " + currentLink);
			System.out.println("firstLink: " + firstLink);
			
			previousLink = currentLink.next;
			
		}
		
		return currentLink;
		
	}
	
}
