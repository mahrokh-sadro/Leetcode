//90. Subsets II

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list,new ArrayList<>(),nums,0);
        return list;
    }

    private void backtrack(List<List<Integer>> list,List<Integer> sublist,int[] nums ,int index ){
        list.add(new ArrayList<>(sublist));
        
        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]){
               continue;
            }
            sublist.add(nums[i]);
            backtrack(list, sublist,nums , i+1);
            sublist.remove(sublist.size()-1);
        }
    }
}
