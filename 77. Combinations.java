//77. Combinations

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=i+1;
        }
        List<List<Integer>> list=new ArrayList<>();
        backtrack(list,new ArrayList<>(),nums,k,0);
        return list;
    }

    private void backtrack(List<List<Integer>> list,List<Integer> sublist,int[] nums,int k,int index){
        if(sublist.size()==k){
            list.add(new ArrayList<>(sublist));
        }

        for(int i=index;i<nums.length;i++){
            sublist.add(nums[i]);
            backtrack(list,sublist,nums,k,i+1);
            sublist.remove(sublist.size()-1);
        }
    }
}