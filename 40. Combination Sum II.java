//40. Combination Sum II

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list=new ArrayList<>();
        dfs(list,new ArrayList<>(),candidates,target,0,0);
        return list;
    }

    private void dfs(List<List<Integer>> list,List<Integer> sublist,int[] nums,int target,int cur,int index){
        if(cur==target){
            list.add(new ArrayList<>(sublist));
        }

        for(int i=index;i<nums.length;i++){
           if(i>index && nums[i]==nums[i-1]){
            continue;
           }
           int newSum=cur+nums[i];
           if(newSum<=target){
             sublist.add(nums[i]);
             dfs(list,sublist,nums, target, newSum, i+1);
             sublist.remove(sublist.size()-1);
           }
        }
    }
}