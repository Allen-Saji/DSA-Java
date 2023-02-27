package linkedList;

public class LinkedList {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.next = null;
        tail = newNode;

    }

    public void add(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("Linkedlist is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("Linkedlist is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            return val;
        }
        Node temp = head;
        for (int i = 0; i < size - 2; i++) {
            temp = temp.next;
        }

        int val = temp.next.data;
        temp.next = null;
        tail = temp;
        size--;
        return val;
    }

    // iterative search
    public int itrSearch(int key) {
        int i = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    // helper function for recSearch
    public int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }

        if (head.data == key) {
            return 0;
        }

        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }

        return idx + 1;
    }

    // recursive search
    public int recSearch(int key) {
        return helper(head, key);
    }

    // reverse a linkedlist
    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void deleteNthfromEnd(int n) {
        int sz = 0;
        Node temp = head;
        // calc size of linked list
        while (temp != null) {
            temp = temp.next;
            sz++;
        }

        if (n == sz) {
            head = head.next;// remove first element
            return;
        }

        int i = 1;
        Node prev = head;
        int idxToFind = sz - n;

        while (i < idxToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    public Node findMid() {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;// mid
    }

    public boolean checkPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        // step 1: find mid node
        Node midNode = findMid();

        // step2: reverse second half of the linked list
        Node curr = midNode;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;// right half head
        Node left = head;

        // step3: check left half and right half
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }

            right = right.next;
            left = left.next;
        }

        return true;
    }

    // Floyd's cycle finding algorithm
    public boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                return true;// cycle exists
            }
        }

        return false; // cycle doesn't exist
    }

    public static void removeCycle() {
        // detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                cycle = true;// cycle exists
                break;
            }
        }

        if (cycle == false) {
            return;
        }

        // find the last node
        slow = head;
        Node prev = null;
        while (fast != slow) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // set last node's next value to null
        prev.next = null;
        System.out.println("Cycle removed");
    }

    public Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public Node merge(Node leftHead, Node rightHead) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (leftHead != null && rightHead != null) {
            if (leftHead.data <= rightHead.data) {
                temp.next = leftHead;
                leftHead = leftHead.next;
                temp = temp.next;
            } else {
                temp.next = rightHead;
                rightHead = rightHead.next;
                temp = temp.next;
            }
        }

        while (leftHead != null) {
            temp.next = leftHead;
            leftHead = leftHead.next;
            temp = temp.next;
        }

        while (rightHead != null) {
            temp.next = rightHead;
            rightHead = rightHead.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    public Node mergeSort(Node head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }

        // find mid node of the linkedlist
        Node mid = getMid(head);
        Node rightHead = mid.next;
        mid.next = null;

        // Merge sort right and left
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // merge
        return merge(newLeft, newRight);
    }

    public void zigZag() {
        // find mid
        Node fast = head.next;
        Node slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow;
        // reverse seconod half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node leftHead = head;
        Node rightHead = prev;
        Node nextL, nextR;

        // alternate merge
        while (leftHead != null && rightHead != null) {
            nextL = leftHead.next;
            leftHead.next = rightHead;
            nextR = rightHead.next;
            rightHead.next = nextL;

            leftHead = nextL;
            rightHead = nextR;
        }

    }

    public void printLL() {
        Node temp = head;
        if (head == null) {
            System.out.println("LinkedList is empty!");
        }
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // ll.addFirst(1);
        // ll.addFirst(2);
        // ll.addFirst(3);
        // ll.addFirst(4);
        // ll.printLL();
        // head = ll.mergeSort(head);
        // ll.printLL();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.add(3, 4);
        ll.printLL();
        ll.zigZag();
        ll.printLL();
        // ll.removeFirst();
        // ll.removeLast();
        // ll.reverse();
        // ll.deleteNthfromEnd(3);
        // ll.printLL();
        // System.out.println(ll.checkPalindrome());

        // System.out.println(ll.itrSearch(4));
        // System.out.println(ll.recSearch(2));
        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;
        // System.out.println(ll.isCycle());
        // removeCycle();
        // System.out.println(ll.isCycle());

    }
}
