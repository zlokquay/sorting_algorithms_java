
public class Sort {
	
	private Sort() {
	}
	
	public static void bubbleSort(int[] a) {
		presortString(a);
		
		long startTime;
		long endTime;
		long totalTime;
		
		startTime = System.currentTimeMillis();
		for(int i = 0; i < a.length; i++) {
			for(int j = a.length - 1; j > i; j--) {
				if(a[j] < a[j-1]) {
					swap(a, j, j-1);
				}
			}
		}
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("\nBubble sort took: " + totalTime + " milliseconds.");
		postsortString(a);
	}
	
	  /**
     * Quicksort algorithm.
     * 
     * @author Weiss
     * 
     * @param a an array of integer items.
     */
	public static void quickSort(int[] a) {
		long startTime;
		long endTime;
		long totalTime;

		startTime = System.currentTimeMillis();
		quickSort(a, 0, a.length - 1);
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("\nQuick sort took: " + totalTime + " milliseconds.");

		postsortString(a);
	}

	private static final int CUTOFF = 10;

	/**
	 * Internal quicksort method that makes recursive calls. Uses median-of-three
	 * partitioning and a cutoff of 10.
	 * 
	 * @author Weiss
	 * 
	 * @param a
	 *            an array of integer items.
	 * @param low
	 *            the left-most index of the subarray.
	 * @param high
	 *            the right-most index of the subarray.
	 */
	private static void quickSort(int[] a, int low, int high) {
		if (low + CUTOFF > high)
			insertionSort(a, low, high);
		else {
			// Sort low, middle, high
			int middle = (low + high) / 2;
			if (a[middle] < (a[low]))
				swap(a, low, middle);
			if (a[high] < (a[low]))
				swap(a, low, high);
			if (a[high] < (a[middle]))
				swap(a, middle, high);

			// Place pivot at position high - 1
			swap(a, middle, high - 1);
			int pivot = a[high - 1];

			// Begin partitioning
			int i, j;
			for (i = low, j = high - 1;;) {
				while (a[++i] < (pivot))
					;
				while (pivot < (a[--j]))
					;
				if (i >= j)
					break;
				swap(a, i, j);
			}

			// Restore pivot
			swap(a, i, high - 1);

			quickSort(a, low, i - 1); // Sort small elements
			quickSort(a, i + 1, high); // Sort large elements
		}
	}

	/**
	 * Internal insertion sort routine for subarrays that is used by quicksort.
	 * 
	 * @author Weiss
	 * 
	 * @param a
	 *            an array of integer items.
	 * @param low
	 *            the left-most index of the subarray.
	 * @param n
	 *            the number of items to sort.
	 */
	private static void insertionSort(int[] a, int low, int high) {
		for (int p = low + 1; p <= high; p++) {
			int tmp = a[p];
			int j;

			for (j = p; j > low && tmp < (a[j - 1]); j--)
				a[j] = a[j - 1];
			a[j] = tmp;
		}
	}

	/**
	 * Quick selection algorithm. Places the kth smallest item in a[k-1].
	 * 
	 * @author Weiss
	 * 
	 * @param a
	 *            an array of integer items.
	 * @param k
	 *            the desired rank (1 is minimum) in the entire array.
	 */
	public static void quickSelect(int[] a, int k) {
		quickSelect(a, 0, a.length - 1, k);
	}

	/**
	 * Internal selection method that makes recursive calls. Uses median-of-three
	 * partitioning and a cutoff of 10. Places the kth smallest item in a[k-1].
	 * 
	 * @author Weiss
	 * 
	 * @param a
	 *            an array of integer items.
	 * @param low
	 *            the left-most index of the subarray.
	 * @param high
	 *            the right-most index of the subarray.
	 * @param k
	 *            the desired rank (1 is minimum) in the entire array.
	 */
	private static void quickSelect(int[] a, int low, int high, int k) {
		if (low + CUTOFF > high)
			insertionSort(a, low, high);
		else {
			// Sort low, middle, high
			int middle = (low + high) / 2;
			if (a[middle] < (a[low]))
				swap(a, low, middle);
			if (a[high] < (a[low]))
				swap(a, low, high);
			if (a[high] < (a[middle]))
				swap(a, middle, high);

			// Place pivot at position high - 1
			swap(a, middle, high - 1);
			int pivot = a[high - 1];

			// Begin partitioning
			int i, j;
			for (i = low, j = high - 1;;) {
				while (a[++i] < (pivot))
					;
				while (pivot < (a[--j]))
					;
				if (i >= j)
					break;
				swap(a, i, j);
			}

			// Restore pivot
			swap(a, i, high - 1);

			// Recurse; only this part changes
			if (k <= i)
				quickSelect(a, low, i - 1, k);
			else if (k > i + 1)
				quickSelect(a, i + 1, high, k);
		}
	}

	/**
	 * Handles printing to console a formatted list of the unsorted array to get
	 * a feel of whether or not it really did sort. 
	 * 
	 * @param a
	 * 			An array of integer items.
	 */
	private static void presortString(int[] a) {
		System.out.print("Unsorted Array: {");
		for(int i = 0; i < 10; i++) {
			System.out.print(" " + a[i]);
		}
		System.out.print(" . . .");
		for(int i = a.length-10; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
		System.out.print(" }\n");
	}
	
	/**
	 * Handles printing to console a formatted list of the sorted array to get
	 * a feel of whether or not it really did sort. 
	 * 
	 * @param a
	 * 			An array of integer items.
	 */
	private static void postsortString(int[] a) {
		System.out.print("Sorted Array: {");
		for(int i = 0; i < 10; i++) {
			System.out.print(" " + a[i]);
		}
		System.out.print(" . . .");
		for(int i = a.length-10; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
		System.out.print(" }\n");
	}
	
	/**
	 * @param a
	 * @param index1
	 * @param index2
	 */
	public static void swap(int[] a, int ind1, int ind2) {
		int tmp = a[ind1];
		a[ind1] = a[ind2];
		a[ind2] = tmp;
    }
}
