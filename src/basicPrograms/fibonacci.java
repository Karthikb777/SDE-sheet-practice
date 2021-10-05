package basicPrograms;

// fibonacci series of a number
public class fibonacci {
    public static int findFibonacci(int n) {
        if(n < 2) return 1;
        else return findFibonacci(n-1) + findFibonacci(n-2);
    }
    public static void main(String[] args) {
        int num = 6;
        for (int i = 0; i < num; i++) {
            System.out.print(findFibonacci(i) + " ");
        }
    }
}
