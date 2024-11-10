import java.util.PriorityQueue;
import java.util.TreeSet;

public class HeapTreeBST {

    public static void main(String[] args) {
        int[] data = {13, 4, 7, 21, 15, 25, 31, 9, 43};


        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : data) {
            minHeap.add(num);
        }

        System.out.println("Heap (Min-Heap) elements in ascending order:");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
        System.out.println();

        TreeSet<Integer> bst = new TreeSet<>();
        for (int num : data) {
            bst.add(num);
        }

        System.out.println("BST elements in in-order (ascending):");
        for (int num : bst) {
            System.out.print(num + " ");
        }
    }
}
