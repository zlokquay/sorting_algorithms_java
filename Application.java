import java.util.Random;

public class Application {

	public static void main(String[] args) {
		int size = 100;
		int[] arr = initializeArray(size);
		int[] arr2 = arr.clone();
		
		System.out.println("Array Size = [" + size + "]");
		Sort.bubbleSort(arr);
		Sort.quickSort(arr2);
		
		size = 1000;
		arr = initializeArray(size);
		arr2 = arr.clone();
		System.out.println("\n\nArray Size = [" + size + "]");
		Sort.bubbleSort(arr);
		Sort.quickSort(arr2);
		
		size = 10000;
		arr = initializeArray(size);
		arr2 = arr.clone();
		System.out.println("\n\nArray Size = [" + size + "]");
		Sort.bubbleSort(arr);
		Sort.quickSort(arr2);
		
		size = 100000;
		arr = initializeArray(size);
		arr2 = arr.clone();
		System.out.println("\n\nArray Size = [" + size + "]");
		Sort.bubbleSort(arr);
		Sort.quickSort(arr2);
		
		size = 1000000;
		arr = initializeArray(size);
		arr2 = arr.clone();
		System.out.println("\n\nArray Size = [" + size + "]");
		Sort.bubbleSort(arr);
		Sort.quickSort(arr2);
		
		//If you want to sit through these, be my guest.
		//They take too long for me to care about 'em.
		size = 10000000;
		arr = initializeArray(size);
		arr2 = arr.clone();
		System.out.println("\n\nArray Size = [" + size + "]");
//		Sort.bubbleSort(arr);
		Sort.quickSort(arr2);
//		
		size = 100000000;
		arr = initializeArray(size);
		arr2 = arr.clone();
		System.out.println("\n\nArray Size = [" + size + "]");
//		Sort.bubbleSort(arr);
		Sort.quickSort(arr2);
	}
	
	/**
	 * @author rrkelley
	 * @param n
	 * 	Number of array elements to create array size;
	 * @return
	 * 	An array of size n filled with random integers from 1 to 1000
	 */
	public static int[] initializeArray(int n) {
		Random r = new Random();

		int arr[] = new int[n];

		for(int i=0;i<arr.length;i++)
			arr[i]=r.nextInt(100)+1;

		return arr;
	}//end initializeArray

}
