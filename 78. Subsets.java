//78. Subsets

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        backtrack(list,new ArrayList<>(),nums,0);
        return list;
    }

    private void backtrack(List<List<Integer>> list,List<Integer> sublist,int[] nums,int index){
        list.add(new ArrayList<>(sublist));

        for(int i=index;i<nums.length;i++){
            sublist.add(nums[i]);
            backtrack(list,sublist,nums,i+1);
            sublist.remove(sublist.size()-1);
        }
    }
}