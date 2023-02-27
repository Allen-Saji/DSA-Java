package stack;

import java.util.ArrayList;

public class StackProblems {
    static class StackDemo {
        static ArrayList<Integer> stack = new ArrayList<>();

        public static boolean isEmpty() {
            return stack.size() == 0;
        }

        public static void push(int data) {
            stack.add(data);
        }

        public static int pop() {
            if (stack.isEmpty()) {
                return -1;
            }
            int top = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            return top;
        }

        public static int peek() {
            if (stack.isEmpty()) {
                return -1;
            }
            return stack.get(stack.size() - 1);
        }
    }

    public static void main(String[] args) {
        StackDemo s = new StackDemo();
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }

    }
}
