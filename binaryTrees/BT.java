package binaryTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BT {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public void preOrder(Node root) {
            if (root == null) {
                return;
            }

            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public void inOrder(Node root) {
            if (root == null) {
                return;
            }

            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public void postOrder(Node root) {
            if (root == null) {
                return;
            }

            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        public void levelOrder(Node root) {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }

                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }

        public int height(Node root) {
            if (root == null) {
                return 0;
            }

            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            return Math.max(leftHeight, rightHeight) + 1;
        }

        public int Count(Node root) {
            if (root == null) {
                return 0;
            }

            int leftCount = Count(root.left);
            int rightCunt = Count(root.right);

            return leftCount + rightCunt + 1;
        }

        public int Sum(Node root) {
            if (root == null) {
                return 0;
            }

            int leftSum = Sum(root.left);
            int rightSum = Sum(root.right);

            return leftSum + rightSum + root.data;
        }

        // TC: O(n^2)
        public int diameter2(Node root) {
            if (root == null) {
                return 0;
            }

            int leftDiam = diameter2(root.left);
            int leftHt = height(root.left);
            int rightDiam = diameter2(root.right);
            int rightHt = height(root.right);

            // diameter that includes the root node
            int selfDiam = leftHt + rightHt + 1;

            return Math.max(selfDiam, (Math.max(leftDiam, rightDiam)));
        }

        // static class Info {
        // int diam;
        // int ht;

        // public Info(int diam, int ht) {
        // this.diam = diam;
        // this.ht = ht;
        // }
        // }

        // TC: O(n)
        // public Info diameter(Node root) {
        // if (root == null) {
        // return new Info(0, 0);
        // }

        // Info leftInfo = diameter(root.left);
        // Info rightInfo = diameter(root.right);

        // int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht +
        // rightInfo.ht + 1);
        // int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        // return new Info(diam, ht);
        // }

        public boolean isIdentical(Node root, Node subroot) {
            if (root == null && subroot == null) {
                return true;
            } else if (root == null || subroot == null || root.data != subroot.data) {
                return false;
            }

            if (!isIdentical(root.left, subroot.left)) {
                return false;
            }

            if (!isIdentical(root.right, subroot.right)) {
                return false;
            }

            return true;
        }

        public boolean isSubTree(Node root, Node subroot) {
            if (root == null) {
                return false;
            }

            if (root.data == subroot.data) {
                if (isIdentical(root, subroot)) {
                    return true;
                }
            }

            return isSubTree(root.left, subroot) || isSubTree(root.right, subroot);
        }

        static class Info {
            Node node;
            int hd; // horizontal distance

            public Info(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }

        public void topView(Node root) {
            Queue<Info> q = new LinkedList<>();
            HashMap<Integer, Node> map = new HashMap<>();
            int min = 0, max = 0;

            q.add(new Info(root, 0));
            q.add(null);

            while (!q.isEmpty()) {
                Info curr = q.remove();
                if (curr == null) {
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {

                    if (!map.containsKey(curr.hd)) {
                        map.put(curr.hd, curr.node);
                    }

                    if (curr.node.left != null) {
                        q.add(new Info(curr.node.left, curr.hd - 1));
                        min = Math.min(curr.hd - 1, min);
                    }

                    if (curr.node.right != null) {
                        q.add(new Info(curr.node.right, curr.hd + 1));
                        max = Math.max(curr.hd + 1, max);
                    }
                }
            }

            for (int i = min; i <= max; i++) {
                System.out.print(map.get(i).data + " ");
            }
        }

        public void KLevel(Node root, int level, int k){
            if(root == null){
                return;
            }

            if(level == k){
                System.out.print(root.data+" ");
                return;
            }

            KLevel(root.left, level+1, k);
            KLevel(root.right, level+1, k);
        }

        public boolean getPath(Node root, int n, ArrayList<Node> path){
            if(root == null){
                return false;
            }

            path.add(root);

            if(root.data == n){
                return true;
            }

            boolean foundLeft = getPath(root.left, n, path);
            boolean foundRight = getPath(root.right, n, path);

            if(foundLeft || foundRight){
                return true;
            }

            path.remove(path.size()-1);

            return false;
        }

        public int lcaDist(Node root, int n){
            if(root == null){
                return -1;
            }
            if(root.data == n){
                return 0;
            }
            int leftDist = lcaDist(root.left, n);
            int rightDist = lcaDist(root.right, n);

            if(leftDist ==-1 && rightDist ==1){
                return -1;
            }else if(leftDist == -1){
                return rightDist+1;
            }else{
                return leftDist+1;
            }
        }

        //min distance between two nodes
        public int minDist(Node root, int n1, int n2){
            Node lca = Lca2(root, n1, n2);

            return lcaDist(lca, n1) + lcaDist(lca, n2);
        }

        public Node Lca2(Node root, int n1, int n2){
            if(root == null || root.data == n1 || root.data == n2){
                return root;
            }

            Node leftLca = Lca2(root.left, n1, n2);
            Node rightLca = Lca2(root.right, n1, n2);

            if(leftLca == null){
                return rightLca;
            }

            if(rightLca == null){
                return leftLca;
            }

            return root;
        }


        //Lowest Common Ancestor Approach 1 || TC = O(n) || SC = n
        public Node Lca(Node root, int n1, int n2){
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();

            getPath(root, n1, path1);
            getPath(root, n2, path2);

            int i=0;
            for(;i<path1.size() && i<path2.size();i++){
                if(path1.get(i)!=path2.get(i)){
                    break;
                }
            }
            //last equal node -> (i-1)th
            Node lca = path1.get(i-1);

            return lca;
        }

        public int KthAncestor(Node root,int n, int k){
            if(root == null){
                return -1;
            }

            if(root.data == n){
                return 0;
            }

            int leftDist = KthAncestor(root.left, n, k);
            int rightDist = KthAncestor(root.right, n, k);

            if(leftDist == -1 && rightDist == -1){
                return -1;
            }

            int max = Math.max(leftDist, rightDist);
            if(max+1 == k){
                System.out.println(root.data);
            }

            return max+1;
        }

        public static void main(String[] args) {
            // int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
            BinaryTree tree = new BinaryTree();
            // Node root = tree.buildTree(nodes);
            // tree.preOrder(root);
            // tree.inOrder(root);
            // tree.postOrder(root);
            // tree.levelOrder(root);
            // System.out.println(tree.height(root));
            // System.out.println(tree.Count(root));
            // System.out.println(tree.Sum(root));
            // System.out.println(tree.diameter2(root));
            // System.out.println(tree.diameter(root).diam);

            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right.left = new Node(6);
            root.right.right = new Node(7);

            // Node subroot = new Node(2);
            // subroot.left = new Node(4);
            // subroot.right = new Node(5);

            // System.out.println(tree.isSubTree(root, subroot));
            //tree.topView(root);
            // int k = 2;
            // tree.KLevel(root, 1, k);

            int n1 = 4, n2 = 7;
            int k = 2;
            //System.out.println(tree.Lca(root, n1, n2).data);
            //System.out.println(tree.Lca2(root, n1, n2).data);
            //System.out.println(tree.minDist(root, n1, n2));
            tree.KthAncestor(root, n2, k);
        }
    }
}