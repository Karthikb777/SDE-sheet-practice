package DSAprep;

/*
*       find the n-th root of a number m using binary search:
*           optimized approach:
*               take the search space as 1 to m
*               perform binary search on the search space, the condition is, high - low must be greater than 10^-6
*                   if the return value of compute method is greater than m,
*                       do high = mid [i.e shrink the search space]
*                   else do low = mid [i.e shrink the search space]
*               finally return low, because low will hold the n-th root of m
*
*               compute method:
*                   multiply m, n times and return the answer
*
*           TC - log(m x 10^d) if d is the number of decimal places considered for binary search
*               the compute method for loop runs n times
*           total TC - n log ( m x 10^d )
*           SC - O(1)
* */

public class D11NthRoot {

    private static double compute(double m, double n) {
        double ans = 1;
        for (int i = 1; i <=n ; i++) {
            ans *= m;
        }
        return ans;
    }

    public static double nthRoot(double n, double m) {
        double low, high, mid;

        low = 1;
        high = m;

//        the limit for the binary search condition, 1e - 6 is 10^-6
        double exp = 1e-6;

        while ((high - low) >= exp) {
            mid = (low + high) / 2;

            if(compute(mid, n) > m) {
                high = mid;
            }
            else {
                low = mid;
            }
        }

        return low;
    }
    public static void main(String[] args) {
        int n = 2;
        int m = 16;

        System.out.println(nthRoot(n, m));
    }
}
