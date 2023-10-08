public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        int n = arr.length;

        System.out.println("Original Array:");
        printArray(arr);

        mergeSort(arr);

        System.out.println("\nSorted Array:");
        printArray(arr);
    }

    // Method to perform Merge Sort
    public static void mergeSort(int[] arr) {
        int n = arr.length;
        if (n > 1) {
            // Find the middle of the array
            int mid = n / 2;

            // Split the array into two halves
            int[] leftHalf = new int[mid];
            int[] rightHalf = new int[n - mid];

            System.arraycopy(arr, 0, leftHalf, 0, mid);
            System.arraycopy(arr, mid, rightHalf, 0, n - mid);

            // Recursively sort the two halves
            mergeSort(leftHalf);
            mergeSort(rightHalf);

            // Merge the sorted halves
            merge(arr, leftHalf, rightHalf);
        }
    }

    // Method to merge two sorted arrays into one sorted array
    public static void merge(int[] arr, int[] left, int[] right) {
        int n1 = left.length;
        int n2 = right.length;

        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < n1) {
            arr[k++] = left[i++];
        }

        while (j < n2) {
            arr[k++] = right[j++];
        }
    }

    // Utility method to print an array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
