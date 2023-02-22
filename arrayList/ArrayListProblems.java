package arrayList;

import java.util.*;

public class ArrayListProblems {

    public static int storeWater(ArrayList<Integer> height) {
        int maxWater = 0;
        int lp = 0, rp = height.size() - 1;
        while (lp < rp) {
            int waterLevel = Math.min(height.get(lp), height.get(rp));
            int width = rp - lp;
            int currWater = width * waterLevel;
            maxWater = Math.max(maxWater, currWater);

            if (height.get(lp) < height.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }

        return maxWater;
    }

    public static boolean pairSum1(ArrayList<Integer> arr, int targetSum) {
        // two pointer approach
        int lp = 0, rp = arr.size() - 1;

        while (lp < rp) {
            if (arr.get(lp) + arr.get(rp) == targetSum) {
                return true;
            } else if (arr.get(lp) + arr.get(rp) > targetSum) {
                rp--;
            } else {
                lp++;
            }
        }

        return false;
    }

    // sorted arraylist but rotated at a pivot
    public static boolean pairSum2(ArrayList<Integer> arr, int targetSum) {
        // two pointer approach
        int pivot = -1;
        for (int i = 0; i < arr.size(); i++) {

            if (arr.get(i) > arr.get(i + 1)) {
                pivot = i;
                break;
            }
        }

        int lp = pivot + 1, rp = pivot;

        while (lp != rp) {
            if (arr.get(lp) + arr.get(rp) == targetSum) {
                return true;
            } else if (arr.get(lp) + arr.get(rp) > targetSum) {
                rp = (arr.size() + rp - 1) % arr.size();
            } else {
                lp = (lp + 1) % arr.size();
            }
        }

        return false;
    }

    public static ArrayList<Integer> lonelyNumber(ArrayList<Integer> arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        Collections.sort(arr);

        if (arr.get(0) != arr.get(1) && arr.get(1) != (arr.get(0) + 1)) {
            ans.add(arr.get(0));
        }

        for (int i = 1; i < arr.size() - 1; i++) {
            if (arr.get(i) != arr.get(i + 1) && arr.get(i) != arr.get(i - 1)
                    && arr.get(i + 1) != (arr.get(i) + 1) && arr.get(i - 1) != arr.get(i) - 1) {
                ans.add(arr.get(i));
            }
        }

        if (arr.get(arr.size() - 1) != arr.get(arr.size() - 2)
                && arr.get(arr.size() - 2) != arr.get(arr.size() - 1) - 1) {
            ans.add(arr.get(arr.size() - 1));
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(11);
        height.add(12);
        height.add(6);
        height.add(8);
        height.add(9);
        height.add(10);

        // System.out.println(lonelyNumber(height));

        // System.out.println(storeWater(height));
        // System.out.println(pairSum1(height, 18));
        System.out.println(pairSum2(height, 23));

    }
}
