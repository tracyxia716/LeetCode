/**
 * Created by xianeng on 2018/1/19.
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));
    }

    public static int searchInsert(int[] nums, int target) {
//        for(int n : nums) {
//            if(target  == n)
//        }

        int i = 0;
        for (i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (target == n) {
                return i;
            }
            if (n > target) {
                return i;
            }
        }

        return i;
    }
}
