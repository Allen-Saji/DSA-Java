package arrays;

public class Arrays {

    public static void reverse(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void print_subarrays(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static int kadanes(int arr[]) {
        int max_sum = Integer.MIN_VALUE;
        int curr_sum = 0;

        for (int i = 0; i < arr.length; i++) {
            curr_sum += arr[i];
            if (curr_sum < 0) {
                curr_sum = 0;
            }
            max_sum = Integer.max(max_sum, curr_sum);
        }

        // if all array elements are negative
        if (max_sum == 0) {
            max_sum = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                max_sum = Integer.max(max_sum, arr[i]);
            }
        }
        return max_sum;
    }

    public static int trapped_water(int height[]) {
        int n = height.length;
        int max_left_height[] = new int[n];
        int max_right_height[] = new int[n];

        max_left_height[0] = height[0];
        for (int i = 1; i < n; i++) {
            max_left_height[i] = Math.max(max_left_height[i - 1], height[i]);
        }

        max_right_height[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            max_right_height[i] = Math.max(max_right_height[i + 1], height[i]);
        }

        int trapped_water = 0;

        for (int i = 0; i < n; i++) {
            int water_level = Math.min(max_left_height[i], max_right_height[i]);
            trapped_water += water_level - height[i];
        }
        return trapped_water;
    }

    public static int BuyandSellStocks(int prices[]) {
        int n = prices.length;
        int max_profit = 0;
        int buyPrice = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (buyPrice < prices[i]) {
                int profit = prices[i] - buyPrice;
                max_profit = Math.max(max_profit, profit);
            } else {
                buyPrice = prices[i];
            }
        }
        return max_profit;
    }

    public static void main(String[] args) {
        // int arr[] = { -1, -2, -3, -4, 0 };
        int height[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        // int prices[] = { 7, 1, 5, 3, 6, 4, 9 };
        // reverse(arr);
        // print_subarrays(arr);
        // System.out.println(kadanes(arr));
        System.out.println(trapped_water(height));
        // System.out.println(BuyandSellStocks(prices));

    }
}
