// Question 8:
// Check if the Sentence Is Pangram
// https://leetcode.com/problems/check-if-the-sentence-is-pangram/

public class Question8 {
    public boolean checkIfPangram(String sentence) {
        int[] arr = new int[26];

        // checks the frequency of the alphabets
        for (var i : sentence.toCharArray()) {
            arr[i - 'a']++;
        }

        // checks if any of the arr index contains zero
        for (var i : arr) {
            if (i == 0)
                return false;
        }

        return true;
    }

    public boolean checkIfPangramAnotherSolution(String sentence) {
        int[] arr = new int[26];

        // checks the frequency of the alphabets
        for (var i : sentence.toCharArray()) {
            arr[i - 'a']++;
        }

        // checks if any of the arr index contains zero
        for (var i : arr) {
            if (i == 0)
                return false;
        }

        return true;
    }
}
