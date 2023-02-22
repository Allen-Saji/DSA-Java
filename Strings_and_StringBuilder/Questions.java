package Strings_and_StringBuilder;

import java.util.Arrays;

public class Questions {

    public static int lowerCaseVowels(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' ||
                    str.charAt(i) == 'o' || str.charAt(i) == 'u') && str.charAt(i) >= 97) {
                count++;
            }
        }
        return count;
    }

    public static String firstLetterToUppercase(String str) {

        StringBuilder sb = new StringBuilder();
        sb.append(str.toUpperCase().charAt(0));

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(str.toUpperCase().charAt(i));
            } else {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void anagrams(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        if (str1.length() == str2.length()) {
            Arrays.sort(arr1);
            Arrays.sort(arr2);

            if (Arrays.equals(arr1, arr2)) {
                System.out.println("Yes, " + str1 + " and " + str2 + " are anagrams!");
            } else {
                System.out.println("Not anagrams!");
            }
        } else {
            System.out.println("Not anagrams, length not equal!");
        }
    }

    public static void main(String[] args) {
        // String str = "i am ikkassi from kanjirapally";
        String str1 = "race";
        String str2 = "care";
        anagrams(str1, str2);
        // System.out.println(lowerCaseVowels(str));
        // System.out.println(firstLetterToUppercase(str));
    }
}
