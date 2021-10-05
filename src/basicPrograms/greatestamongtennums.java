package basicPrograms;

// greatest among n numbers, n can be any number greater than 1

public class greatestamongtennums {
    public static int max(int[] arr) {
        int maximum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maximum) maximum = arr[i];
        }

        return maximum;
    }
    public static void main(String[] args) {
        int [] arr = {1200, 3, 13, 2, 25};
        System.out.println(max(arr));
    }
}
