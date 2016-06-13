import java.io.IOException;

/**
 * Created by Shin on 5/19/2016.
 */
public class powerOfThree {
    public static boolean isPowerOfThree(int n) {
        System.out.println(Math.log(n) + " " + Math.log10(n));
        System.out.println(Math.log(3) + " " + Math.log10(3));
        System.out.println(Math.log(n)/Math.log(3) + " " + Math.log10(n)/Math.log10(3));

        return Math.log10(n)/Math.log10(4) % 1 == 0;
    }

    public static void main(String args[]) throws IOException{
        int a = (int)Math.pow(3,5);
        System.out.println(isPowerOfThree(a));
    }
}
