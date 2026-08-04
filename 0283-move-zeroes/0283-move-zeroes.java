class Solution {
    public void moveZeroes(int[] nums) {
        
        int zeroStartInd = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0 && zeroStartInd != -1){
                int temp = nums[i];
                nums[i] = nums[zeroStartInd];
                nums[zeroStartInd] = temp;
                zeroStartInd += 1;
            }
            else if(nums[i]==0 && zeroStartInd == -1){
                zeroStartInd = i;
            }
        }
    }
}