package arrays;

public class BinarySearch {

    public static int binary_search(int arr[], int key) {
        int start = 0;
        int end = arr.length - 1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;

            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 12, 23, 44, 56, 78, 90 };
        int index = binary_search(arr, 44);
        if (index == -1) {
            System.out.println("NOT FOUND!");
        } else {
            System.out.println("Key is found at index: " + index);
        }
    }
}
