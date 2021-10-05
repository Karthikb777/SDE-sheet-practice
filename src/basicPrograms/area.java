package basicPrograms;

// area of square, rectangle, triangle, circle
public class area {
    public static double areaOfSquare(double side) {
        return side * side;
    }

    public static double areaOfRect(double len, double breadth) {
        return len * breadth;
    }

    public static double areaOfTri(double base, double height) {
        return 0.5 * base * height;
    }

    public static double areaOfCircle(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    public static void main(String[] args) {
        System.out.println("square: " + areaOfSquare(3));
        System.out.println("rect: " + areaOfRect(3, 4));
        System.out.println("triangle: " + areaOfTri(3, 4));
        System.out.println("circle: " + areaOfCircle(3));
    }
}
