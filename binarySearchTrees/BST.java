package binarySearchTrees;

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

    public static void main(String[] args) {
        int val[] = {5,1,3,2,4,7};
        Node root = null;
        for(int i=0;i<val.length;i++){
            root = insert(root, val[i]);
        }
        inOrder(root);
        System.out.println();
        //System.out.println(search(root,7)); 
        root = delete(root, 1);
        inOrder(root);

    }
}
