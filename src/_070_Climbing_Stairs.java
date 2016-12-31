/**
 * 
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * @author Shengyi
 *
 */

public class _070_Climbing_Stairs {
	public int climbStairs(int n) {
        if (n == 0) {
        	return 0;
        }
        
        if (n == 1) {
        	return 1;
        }
        
        int a = 1;
        int b = 1;
        int c = 0;
        
        for (int i = 2; i < n + 1; i++) {
        	c = a + b;
        	a = b;
        	b = c;
        }
        
        return c;
    }
}
