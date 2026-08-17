class Solution {
    public double findMaxAverage(int[] arr, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        double max = sum * 1.0 / k;

        for (int i = k; i < arr.length; i++) {
            sum += arr[i];       // add new element
            sum -= arr[i - k];   // remove old element
            double avg = sum * 1.0 / k;
            max = Math.max(max, avg);
        }
        return max;
    }
}
