public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {9, 5, 6, 3, 5, 3, 1, 0, 96, 66};
        heapSort(arr);
        for (int j : arr) {
            System.out.print(j + " ");
        }

    }

    static void heapSort(int[] arr) {
        MaxHeap maxHeap = new MaxHeap();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            maxHeap.AdjustUp(arr, i);
        }
        int end = n - 1;
        while (end > 0) {
            maxHeap.swap(arr, 0, end);
            maxHeap.AdjustDown(arr, 0, end);
            end--;
        }
    }
}
