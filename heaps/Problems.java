package heaps;

import java.util.ArrayList;

public class Problems {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) { // O(log(n))
            // add to last index
            arr.add(data);
            int child = arr.size() - 1; // child index
            int parent = (child - 1) / 2; // parent index

            while (arr.get(child) < arr.get(parent)) {
                // swap
                int temp = arr.get(child);
                arr.set(child, arr.get(parent));
                arr.set(parent, temp);

                child = parent;
                parent = (child - 1) / 2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIndex = i;

            if (left < arr.size() && arr.get(minIndex) > arr.get(left)) {
                minIndex = left;
            }

            if (right < arr.size() && arr.get(minIndex) > arr.get(right)) {
                minIndex = right;
            }

            if (minIndex != i) {
                // swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIndex));
                arr.set(minIndex, temp);

                heapify(minIndex); // update minIndex, left, and right based on the updated i
            }
        }

        public int remove() {
            int data = arr.get(0);

            // swap first and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // remove last
            arr.remove(arr.size() - 1);

            // heapify
            heapify(0);
            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while (!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }
    }
}
