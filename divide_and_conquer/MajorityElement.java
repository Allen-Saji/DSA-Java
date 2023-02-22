package divide_and_conquer;

public class MajorityElement {
    public static int countInRange(int nums[], int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    public static int majorityElementRec(int nums[], int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority element.
        if (lo == hi) {
            return nums[lo];
        }

        int mid = (hi - lo) / 2 + lo;
        // recurse through the left and right part
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);

        // if left and right match return the element
        if (left == right) {
            return left;
        }

        // otherwise count each elemnt and return the winner
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;

    }

    public static int majorityElement(int nums[]) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 2, 3, 2, 1, 1, 1, 1 };
        System.out.println(majorityElement(nums));
    }
}
