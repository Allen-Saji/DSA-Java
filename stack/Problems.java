package stack;

import java.util.Stack;

public class Problems {

    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }

        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder sb = new StringBuilder("");
        while (!s.isEmpty()) {
            sb.append(s.peek());
            s.pop();
        }

        String newStr = sb.toString();
        return newStr;
    }

    public static void printStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }

    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for (int i = 1; i < stocks.length; i++) {
            int currPrice = stocks[i];
            while (!s.isEmpty() && currPrice > stocks[s.peek()]) {
                s.pop();
            }

            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - s.peek();
            }

            s.push(i);
        }

    }

    public static void nextGreaterElement(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int nxtGreater[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nxtGreater[i] = -1;
            } else {
                nxtGreater[i] = arr[s.peek()];
            }

            s.push(i);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(nxtGreater[i] + " ");
        }

    }

    public static void main(String[] args) {
        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // s.push(4);
        // s.push(5);

        // printStack(s);
        // reverseStack(s);
        // printStack(s);

        // pushAtBottom(s, 0);

        // String str = "allen";
        // System.out.println(reverseString(str));

        // int stocks[] = { 100, 80, 60, 70, 60, 85, 100 };
        // int span[] = new int[stocks.length];
        // stockSpan(stocks, span);
        // for (int i = 0; i < span.length; i++) {
        // System.out.println(span[i]);
        // }
        int arr[] = { 6, 8, 0, 1, 3 };
        nextGreaterElement(arr);

    }
}
