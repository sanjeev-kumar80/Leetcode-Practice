class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

        for (int i : weights) {
           left = Math.max(left, i);
            right += i;
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (daysRequired(weights, mid) <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
            return left;
    }

     public int daysRequired(int[] weights, int capacity) {
        int days = 1;
        int currentLoad = 0;

        for (int weight : weights) {

            if (currentLoad + weight > capacity) {
                days++;
                currentLoad = weight;
            } else {
                currentLoad += weight;
            }
        }

        return days;
    }
}