package binarySearchTrees;

public class BST2 {
    
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void preOrder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static Node createBalancedBST(int arr[], int start, int end){
        if(start>end){
            return null;
        }

        int mid = (start+end)/2;
        Node root = new Node(arr[mid]);
        root.left = createBalancedBST(arr, start, mid-1);
        root.right = createBalancedBST(arr, mid+1, end);

        return root;
    }

    static class Info{
        boolean isBST;
        int min;
        int max;
        int size;

        public Info(boolean isBST, int size, int min, int max){
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }

    public static int maxBST = 0;

    public static Info largestBST(Node root){
        if(root == null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if(root.data >= rightInfo.min || root.data <= leftInfo.max){
            return new Info(false, size, min, max);
        }

        if(leftInfo.isBST && rightInfo.isBST){
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }
    public static void main(String[] args) {
        // int arr[] = {3,5,6,8,10,11,12};
        // Node root = createBalancedBST(arr, 0, arr.length - 1);
        // preOrder(root);
        //inOrder(root);
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left  = new Node(5);
        root.left.right = new Node(20);
        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.right = new Node(80);
        root.right.right.left = new Node(65);

        Info info = largestBST(root);
        System.out.println("Size of largest BST: " + maxBST);
    }
}
