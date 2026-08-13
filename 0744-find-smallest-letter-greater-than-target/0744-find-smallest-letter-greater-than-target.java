class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (letters[mid] <= target) {
                low = mid + 1;   // right side jao
            } else {
                high = mid - 1;  // left side jao
            }
        }
        // agar target se bada letter nahi mila toh wrap-around
        return letters[low % letters.length];
    }
}
