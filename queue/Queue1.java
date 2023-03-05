package queue;

//circular queue implementation
public class Queue1 {
    static int arr[];
    static int size;
    static int rear;
    static int front;

    Queue1(int n) {
        arr = new int[n];
        size = n;
        rear = -1;
        front = -1;
    }

    public static boolean isEmpty() {
        return rear == -1;
    }

    public static boolean isFull() {
        return (rear + 1) % size == front;
    }

    public static void add(int data) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }
        // add 1st element
        if (front == -1) {
            front = 0;
        }

        rear = (rear + 1) % size;
        arr[rear] = data;
    }

    public static int remove() {
        if (isEmpty()) {
            System.out.println("Empty queue!");
            return -1;
        }

        int result = arr[0];
        // last element delete
        if (rear == front) {
            rear = front = -1;
        } else {
            front = (front + 1) % size;
        }
        return result;
    }

    public static int peek() {
        if (isEmpty()) {
            System.out.println("Empty queue!");
            return -1;
        }

        return arr[front];
    }

    public static void main(String[] args) {
        Queue1 q = new Queue1(3);
        q.add(1);
        q.add(2);
        q.add(3);
        remove();
        add(4);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }

    }
}
