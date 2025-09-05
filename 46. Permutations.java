//46. Permutations

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> sublist=new ArrayList<>();
        backtrack(nums,list,sublist);
        return list;
    }

    private void backtrack(int[] nums,List<List<Integer>> list,List<Integer> sublist){
        if(sublist.size()==nums.length){
            list.add(new ArrayList<>(sublist));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!sublist.contains(nums[i])){
                sublist.add(nums[i]);
                backtrack(nums,list,sublist);
                sublist.remove(sublist.size()-1);
            }
        } 
    }
}