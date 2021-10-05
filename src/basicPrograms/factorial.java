package basicPrograms;

// factorial of a number
public class factorial {
    public static void main(String[] args) {
        int num = 4;
        int fact = 1;
        while(num != 0) {
            fact *= num--;
        }
        System.out.println(fact);
    }
}
