class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result= new ArrayList<>();
        backtrack(1,k,n,result,new ArrayList<>());
        return result;
    }
    public void backtrack(int start ,int k,int target,List<List<Integer>> result,List<Integer> curr){
            if(curr.size()==k){
                if(target==0){
                    result.add(new ArrayList<>(curr));
                }
                return;
            }
            for(int i=start;i<=9;i++){
                if(i>target) break;
                
                curr.add(i);
                backtrack(i+1,k,target-i,result,curr);
                curr.remove(curr.size()-1);
            }
        }
    }