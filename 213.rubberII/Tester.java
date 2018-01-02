import java.util.ArrayList;
import java.util.Arrays;

class Tester {
    public static void main(String[] args) {
            int[] nums = {6,3,10,8,2,10,3,5,10,5,3};

            Solution sol = new Solution();

            sol.printOut(nums);

            int val = sol.rob(nums);

            System.out.println("ans is " + val);
    }
}