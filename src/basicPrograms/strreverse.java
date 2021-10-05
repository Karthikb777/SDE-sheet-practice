package basicPrograms;

// reversing a string

public class strreverse {

    public static void main(String[] args) {
        String s = "abab";
        StringBuilder strBuild = new StringBuilder();
        strBuild.append(s);
        System.out.println(strBuild.reverse());
    }
}
