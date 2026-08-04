class Solution {
    public List<Integer> findMissingElements(int[] arr) {
        List<Integer> ans = new ArrayList<>();

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            int current = arr[i];

            while (current + 1 < arr[i + 1]) {
                ans.add(current + 1);
                current++;
            }
        }

        return ans;
    }
}