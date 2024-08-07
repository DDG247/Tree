import java.util.Arrays;

public class Heap {
    public static void main(String[] args) {

    }
}

class MaxHeap {//大根堆
    int[] heap;
    int size;
    int capacity;

    void swap(int[] heap, int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    void AdjustUp(int[] heap, int child) {
        int parent = (child - 1) / 2;
        while (child > 0) {
            if (heap[child] > heap[parent]) {
                swap(heap, child, parent);
                child = parent;
                parent = (child - 1) / 2;
            } else {
                break;
            }
        }
    }

    void AdjustDown(int[] heap, int parent, int n) {
        int child = 2 * parent + 1;
        while (child < n) {
            if (child + 1 < n && heap[child] < heap[child + 1]) {
                child++;
            }
            if (heap[parent] < heap[child]) {
                swap(heap, child, parent);
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    void HeapCreate(MaxHeap heap, int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            heap.heap[i] = arr[i];
            AdjustUp(heap.heap, i);
        }
        heap.size = heap.capacity = n;
    }

    void HeapPush(MaxHeap heap, int key) {
        if (heap.size == heap.capacity) {
            heap.heap = Arrays.copyOf(heap.heap, heap.capacity * 2);
            heap.capacity *= 2;
        }
        heap.heap[heap.size++] = key;
        AdjustUp(heap.heap,heap.size);
    }

}
