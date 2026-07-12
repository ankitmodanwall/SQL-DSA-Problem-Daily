class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] arr1 = arr.clone();
        Arrays.sort(arr1);
        Map<Integer, Integer> ranks = new HashMap<>();
        int rank = 1;
        for(int x : arr1){
            if(!ranks.containsKey(x)){
                ranks.put(x, rank);
                rank++;
            }
        }
        for(int i = 0; i<arr.length; i++){
            arr[i] = ranks.get(arr[i]);
        }
        return arr;
    }
}