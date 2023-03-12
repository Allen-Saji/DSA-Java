package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class UsingArrays {
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
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        // tree.preOrder(root);
        // tree.inOrder(root);
        // tree.postOrder(root);
        // tree.levelOrder(root);
        // System.out.println(tree.height(root));
        // System.out.println(tree.Count(root));
        System.out.println(tree.Sum(root));
    }
}