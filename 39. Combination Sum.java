//39. Combination Sum

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list=new ArrayList<>();
        backtrack(list,new ArrayList<>(),candidates, target,0,0);
        return list;
    }

    private void backtrack(List<List<Integer>> list,List<Integer> sublist,int[] nums,int target,int curSum,int index){
        if(curSum==target){
           list.add(new ArrayList<>(sublist));
        }

        for(int i=index;i<nums.length;i++){
            int newSum=curSum+nums[i];
            if(newSum<=target){
                sublist.add(nums[i]);
                backtrack(list,sublist,nums, target,newSum,i);
                sublist.remove(sublist.size()-1);
            }
        } 
        
    }
}