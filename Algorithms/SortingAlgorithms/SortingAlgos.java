package SortingAlgorithms;

public class SortingAlgos {
	
	private static int[] theArray;
	private int[] helperArray;
	
	private int arraySize;
	private int itemsInArray = 0;
	
	static long startTime;
	static long endTime;
	
	public SortingAlgos (int size) {
		
		arraySize = size;
		theArray = new int[size];
		generateRandomArray ();	
		helperArray = new int[theArray.length];
	}
	
	public void bubbleSort () {
		
		startTime = System.currentTimeMillis();
		
		for (int i = arraySize - 1; i > 1; i--) {
			for (int j = 0; j < i; j++) {
				if(theArray[j] > theArray[j + 1]) {
					swapValues (j, j + 1);
					printHorzArray (i, j);
				}
			}
		}
		
		endTime = System.currentTimeMillis();
		
		System.out.println("Bubble Sort took " + (endTime - startTime));
	}
	
	public void selectionSort () {
		startTime = System.currentTimeMillis();
		for (int x = 0; x < arraySize; x++) {
			int minimum = x;
			
			for (int y = x; y < arraySize; y++) {
				if (theArray[minimum] > theArray[y]) minimum = y;
				
			}
			
			swapValues(x, minimum);
			printHorzArray(x, -1);
		}
		endTime = System.currentTimeMillis();
		
		System.out.println("Selection sort took " + (endTime - startTime));
	}
	
	public void insertionSort () {
		startTime = System.currentTimeMillis();
		for (int i = 1; i < arraySize; i++) {
			int j = i;
			int toInsert = theArray[i];
			while ((j > 0) && (theArray[j - 1] > toInsert)) {
				theArray[j] = theArray[j - 1];
				j--;
				printHorzArray (i, j);
			}
			theArray[j] = toInsert;
			printHorzArray (i, j);
			
			System.out.println ("\nArray[i] = " + theArray[i] + " array[j] = " + theArray[j] + " toInsert = " + toInsert + "\n");
		}
		endTime = System.currentTimeMillis();
		
		System.out.println("Insertion sort took " + (endTime - startTime));
	}
	
	public void shellSort () {
		
		int inner, outer, temp;
		int interval = 1;
		
		while (interval <= arraySize /3) {
			
			interval = interval * 3 + 1;
			
		}
		startTime = System.currentTimeMillis();
		while (interval > 0) {
			
			for (outer = interval; outer < arraySize; outer++) {
				
				temp = theArray[outer];
				System.out.println("Copy " + theArray[outer] + " into temp");
				
				inner = outer;
				System.out.println("Checking if " + theArray[inner - interval] + " in index " + (inner - interval) + " is bigger than " + temp);
				
				while (inner > interval - 1 && theArray[inner - interval] >= temp) {
					
					System.out.println("in while checking if " + theArray[inner - interval] + " in index " + (inner - interval) + " is bigger than " + temp);
					
					printHorzArray (inner, outer, interval);
					
					theArray[inner] = theArray[inner - interval];
					
					 System.out.println(theArray[inner - interval]+ " moved to index " + inner);

					 inner -= interval;
					 
					 System.out.println("inner= " + inner);
					 printHorzArray(inner, outer, interval);

					 System.out.println("outer= " + outer);
					 System.out.println("temp= " + temp);
					 System.out.println("interval= " + interval);

				} 
				
				theArray[inner] = temp;
				
				System.out.println(temp + " moved to index " + inner);
				
				printHorzArray(inner, outer, interval);
			}
			
			interval = (interval - 1) / 3;

		}
		endTime = System.currentTimeMillis();
		
		System.out.println("Shell sort took " + (endTime - startTime));
		
	}
	
	//////////////////////////////////////////////////////////////////
	public void quickSort (int left, int right) {
		
		if (right - left <= 0) return;
		else {
			
			int pivot = theArray[right];			
			int pivotLocation = partitionArray (left, right, pivot);
			startTime = System.currentTimeMillis();
			quickSort (left, pivotLocation - 1);
			quickSort (pivotLocation + 1, right);
			
			endTime = System.currentTimeMillis();
			
			System.out.println("Quick sort took " + (endTime - startTime));
			
			printHorzArray (left, right);
		}
	}
	
	public int partitionArray (int left, int right, int pivot) {
		
		int leftPointer = left - 1;
		int rightPointer = right;
		
		while (true) {
			
			while (theArray[++leftPointer] < pivot) {
				
			}
			while (rightPointer > 0 && theArray[--rightPointer] > pivot) {
				
			}
			
			if (leftPointer >= rightPointer) break;
			else swapValues (leftPointer, rightPointer);
			
		}
		
		swapValues(leftPointer, right);
		
		return leftPointer;
	}
	//////////////////////////////////////////////////////////
	public void mergesort (int[] theArray) {
		startTime = System.currentTimeMillis();
		mergesort (0, arraySize - 1);
		endTime = System.currentTimeMillis();		
		System.out.println("Merge sort took " + (endTime - startTime));	
		printHorzArray(0, arraySize - 1);
		
	}
	
	private void mergesort (int low, int high) {
		
		if (low < high) {
			
			int middle = low + (high - low) /2;
			
			mergesort (low, middle);
			mergesort (middle + 1, high);
			
			merge (low, middle, high);
			
					
			
		}
	}
	
	private void merge (int low, int high, int middle) {
		
		for (int i = low; i <= high; i++) {
			helperArray[i] = theArray[i];
		}
		
		int i = low;
		int j = middle + 1;
		int k = low;
		
		while (i <= middle && j <= high) {
			
			if (helperArray[i] <= helperArray[j]) {
				
				theArray[k] = helperArray[i];
				i++;
				
			} else {
				
				theArray[k] = helperArray[j];
				j++;
				
			}
			
			k++;
			
						
		}
		
		while (i <= middle) {
			
			theArray[k] = helperArray[i];
			k++;
			i++;
						
		}		
		
	}
	
	public void addItemToArray (int newItem) {
		
		theArray[itemsInArray++] = newItem;
		
	}	
	
	public void generateRandomArray () {
		
		for (int i = 0; i < arraySize; i++) {
			theArray[i] = (int)(Math.random() * 1000) + 10;
		}
		
		itemsInArray = arraySize - 1;
	}
	
	public void swapValues (int indexOne, int indexTwo) {
		
		int temp = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo] = temp;
		
	}
	
	public void printHorzArray (int i, int j) {
		
		 for(int n = 0; n < 51; n++) System.out.print("-");
		 
		 System.out.println();
		
		 for(int n = 0; n < arraySize; n++){
		
			 System.out.print("| " + n + "  ");
		
		 }
	
		 System.out.println("|");
		     
		 for(int n = 0; n < 51; n++)System.out.print("-");
		
		 System.out.println();
		 
		 for(int n = 0; n < arraySize; n++){
		 
			 System.out.print("| " + theArray[n] + " ");
		 
		 }
		
		 System.out.println("|");
		
		 for(int n = 0; n < 51; n++)System.out.print("-");
		 
		 System.out.println();
		 
		 if(j != -1){
		 
			 for(int k = 0; k < ((j*5)+2); k++)System.out.print(" ");
		 
		     System.out.print(j);
		 
		 }
		 
		 if(i != -1){
		 		 
			 for(int l = 0; l < (5*(i - j)-1); l++)System.out.print(" ");		              
		 
		     System.out.print(i);	 
		 }	          
		 
		 System.out.println();

	}
	
	public void printHorzArray(int i, int j, int h) {
		
		 if (i == j) i = i - h;
		
		 for (int n = 0; n < 51; n++) System.out.print("-");
		
		 System.out.println();
		
		 for (int n = 0; n < arraySize; n++) {
		
			 System.out.print("| " + n + "  ");
		
	    }
		
		System.out.println("|");
		
		for (int n = 0; n < 51; n++) System.out.print("-");
		
		System.out.println();
		
		for (int n = 0; n < arraySize; n++) {
		
			System.out.print("| " + theArray[n] + " ");
		
		}
		
		System.out.println("|");
		
		for (int n = 0; n < 51; n++) System.out.print("-");
		
		System.out.println();

		if (i != -1) {
		
			int spacesBeforeFront = 5 * i + 1;
		    for (int k = 0; k < spacesBeforeFront; k++) System.out.print(" ");
		
		    System.out.print("I");
		
		    int spacesBeforeRear = (5 * j + 1 - 1) - spacesBeforeFront;
		
		    for (int l = 0; l < spacesBeforeRear; l++) System.out.print(" ");
		
		    System.out.print("O");
		
		    System.out.println("\n");
	
		}
		
	}
	
	public static void main (String[] args) {
		SortingAlgos algo = new SortingAlgos(11);
		//algo.mergesort(theArray);
	}

}
