package binarySearchTrees;

import java.util.ArrayList;

public class BST {
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

    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(val > root.data){
            root.right = insert(root.right, val);
        }else{
            root.left = insert(root.left, val);
        }
        return root;
    }

    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static boolean search(Node root, int n){
        if(root == null){
            return false;
        }
        
        if(root.data == n){
            return true;
        }

        if(n>root.data){
           return search(root.right, n);
        }else{
           return search(root.left, n);
        }
    }

    public static Node delete(Node root, int val){
        if(root.data > val){
           root.left =  delete(root.left, val);
        }
        else if(root.data < val){
            root.right = delete(root.right, val);
        }
        else{
            //case 1: leaf node
            if(root.left == null && root.right == null){
                return null;
            }
            //case 2: single child
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            //case 3: 2 children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root){
        while(root.left!=null){
            root = root.left;
        }

        return root;
    }

    public static void printInRange(Node root, int k1, int k2){
        if(root == null){
            return;
        }
        if(root.data > k2){
            printInRange(root.left, k1, k2);
        }else if(root.data < k1){
            printInRange(root.right, k1, k2);
        }else{
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }
    }

    public static void printPath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+" -> ");
        }
        System.out.println("null");
    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);
        }
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size()-1);
    }

    public static boolean validBST(Node root, Node min, Node max ){
        if(root == null){
            return true;
        }

        if(min != null && root.data <= min.data){
            return false;
        }

        if(max != null && root.data >= max.data){
            return false;
        }

        return validBST(root.left, min, root) && validBST(root.right, root, max);
    }

    public static Node mirror(Node root){
        if(root == null){
            return null;
        }
        Node leftMirror = mirror(root.left);
        Node rightMirror = mirror(root.right);

        root.left = rightMirror;
        root.right = leftMirror;
        return root;
    }

    public static void preOrder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        int val[] = {8,5,1,3,2,4,7,10,11,12,14,19};
        Node root = null;
        for(int i=0;i<val.length;i++){
            root = insert(root, val[i]);
        }
        //inOrder(root);
        //System.out.println();
        //System.out.println(search(root,7)); 
        //root = delete(root, 1);
        //inOrder(root);
        //printInRange(root, 11, 19);
        // ArrayList<Integer> path = new ArrayList<>();
        // printRoot2Leaf(root, path);
        // if(validBST(root, null, null)){
        //     System.out.println("Valid");
        // }else{
        //     System.out.println("Not Valid");
        // }
        preOrder(root);
        System.out.println();
        root = mirror(root);
        preOrder(root);

    }
}
