package basicPrograms;

// is a leap year or not
public class leapyear {
    public static void main(String[] args) {
        int year = 2020;
        boolean leap = false;

        if(year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) leap = true;
                else leap = false;
            }
            else leap = true;
        }
        if (leap) System.out.println("is a leap year");
        else System.out.println("not a leap year");
    }
}
