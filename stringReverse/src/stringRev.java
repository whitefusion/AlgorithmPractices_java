import java.io.IOException;

/**
 * Created by Shin on 5/15/2016.
 */
public class stringRev {
    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) throws IOException {
        String myS = "what the fuck !";
        System.out.println(reverseString(myS));
    }
}
