package divide_and_conquer;

public class DivideandConquer {

    public static void mergeSort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }

        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid);// left part
        mergeSort(arr, mid + 1, ei);// right part
        merge(arr, si, mid, ei);

    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int k = 0;
        int i = si;
        int j = mid + 1;

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // copying to main array
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }

    }

    public static void quickSort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        // pivot = last element
        int pidx = partition(arr, si, ei);
        quickSort(arr, si, pidx - 1);// left side
        quickSort(arr, pidx + 1, ei);// right side
    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1;

        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        // place pivot at its original position
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;

        return i;
    }

    public static int rotatedArraySearch(int arr[], int target, int si, int ei) {
        if (si > ei) {
            return -1;
        }

        int mid = si + (ei - si) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        // if mid is on line1
        if (arr[si] <= arr[mid]) {
            // left
            if (target >= arr[si] && target <= arr[mid]) {
                return rotatedArraySearch(arr, target, si, mid - 1);
            } else {
                return rotatedArraySearch(arr, target, mid + 1, ei);// right
            }
        }
        // if mid on line2
        else {
            // right
            if (target <= arr[ei] && target >= arr[mid]) {
                return rotatedArraySearch(arr, target, mid + 1, ei);
            } else {
                return rotatedArraySearch(arr, target, si, mid - 1);
            }
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        // int arr[] = { 4, 5, 6, 7, 8, 0, 1, 2, 3 };
        // mergeSort(arr, 0, arr.length - 1);
        // quickSort(arr, 0, arr.length - 1);
        // printArr(arr);
        // System.out.println(rotatedArraySearch(arr, 3, 0, arr.length - 1));
    }
}
