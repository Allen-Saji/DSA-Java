package tries;

public class Intro {

    static class Node {
        Node children[] = new Node[26];
        boolean endOfWord = false;

        Node() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.endOfWord = true;
    }

    public static boolean search(String key) {
        Node curr = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.endOfWord == true;
    }

    public static boolean wordBreak(String key) {
        if (key.length() == 0) {
            return true;
        }

        for (int i = 1; i <= key.length(); i++) {
            if (search(key.substring(0, i)) &&
                    wordBreak(key.substring(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }

        return true;
    }

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }

        return count + 1;
    }

    public static String ans = "";

    public static void longestWord(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].endOfWord == true) {
                char ch = (char) (i + 'a');
                temp.append(ch);
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);// backtrack
            }
        }
    }

    public static void main(String[] args) {
        // String words[] = { "a", "any", "thee", "there", "their" };
        // for (int i = 0; i < words.length; i++) {
        // insert(words[i]);
        // }

        // System.out.println(search("thee"));
        // System.out.println(search("their"));
        // System.out.println(search("thor"));
        // String arr[] = { "i", "like", "samsung", "sam", "mobile" };
        // for (int i = 0; i < arr.length; i++) {
        // insert(arr[i]);
        // }

        // String key = "isam";
        // System.out.println(wordBreak(key));
        // String prefix = "samsu";
        // System.out.println(startsWith(prefix));

        String words[] = { "a", "ap", "banana", "apple", "apply", "app", "appl" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);

    }

}
