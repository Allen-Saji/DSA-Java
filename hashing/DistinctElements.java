package hashing;

import java.util.HashSet;

//hashset is like hashmap but it only stores uniques values 
public class DistinctElements {
    public static void main(String[] args) {
        int arr[] = { 1, 3, 2, 4, 5, 6, 4, 5 };
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        System.out.println("Distinct Elements: " + set.size());
    }
}
