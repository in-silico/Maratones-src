
import java.util.*;
import java.io.*;
import java.math.BigInteger;

/**
 *
 * @author seb
 */
public class fair_warning {

    static LinkedList<BigInteger> t = new LinkedList<BigInteger>();
    static int n;

    static BigInteger GCD(BigInteger A, BigInteger B) {
        BigInteger a=A; BigInteger b=B, tmp;
        while (!b.equals(BigInteger.ZERO)) {
            tmp = b;
            b = a.mod(b);
            a = tmp;
        }
        return a;
    }

    static BigInteger GCD(LinkedList<BigInteger> nums) {
        BigInteger tmp = nums.pop();
        while (nums.size() > 0) {
            tmp = GCD(tmp,nums.pop());
        }
        return tmp;
    }

    public static void main(String args[]) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt(); in.nextLine();
        for (int i=1; i<=c; i++) {
            StringTokenizer tok = new StringTokenizer(in.nextLine());
            n = Integer.parseInt(tok.nextToken());
            for (int j=0; j<n; j++) {
                t.add(new BigInteger(tok.nextToken()));
            }
            Collections.sort(t);
            LinkedList<BigInteger> diffs = new LinkedList<BigInteger>();
            for (int j=0; j<n-1; j++) {
                diffs.add(t.get(j+1).subtract(t.get(j)));
            }
            BigInteger T = GCD(diffs);
            if (t.get(0).mod(T).equals(BigInteger.ZERO)) {
                System.out.printf("Case #%d: 0\n",i);
            } else {
                BigInteger k0=t.get(0).divide(T).add(BigInteger.ONE);
                BigInteger y0=T.multiply(k0).subtract(t.get(0));
                System.out.printf("Case #%d: %s\n",i,y0.toString());
            }
            t.clear();
        }
    }

}
