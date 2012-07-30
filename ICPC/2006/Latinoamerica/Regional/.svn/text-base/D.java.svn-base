import java.io.*;
import java.util.*;
import java.math.*;

/**
 *
 * @author seb
 */
public class D {

    int l;

    class Par {
        BigInteger fila, col;

        public Par() {

        }

        public Par(String f, String c) {
            fila = new BigInteger(f);
            col = new BigInteger(c);
        }

        public Par(BigInteger f, BigInteger c) {
            fila = f;
            col = c;
        }

        public Par suma(Par b) {
            Par p = new Par();
            p.fila = fila.add(b.fila);
            p.col = col.add(b.col);
            return p;
        }

        public boolean valid(BigInteger n) {
            boolean val = ((fila.compareTo(n)<0) && (fila.compareTo(BigInteger.ZERO)>=0));
            val &= ((col.compareTo(n)<0) && (col.compareTo(BigInteger.ZERO)>=0));
            return val;
        }
    }

    Par getPair(char []cad, int i) throws Exception {
        if (i==l)
            return new Par("0","0");
        BigInteger n = BigInteger.ONE.shiftLeft(l-i-1);
        switch (cad[i]){
            case 'p':
                return getPair(cad, i+1);
            case 'q':
                return (new Par(BigInteger.ZERO,n)).suma( getPair(cad,i+1) );
            case 'r':
                return (new Par(n,n)).suma( getPair(cad,i+1) );
            case 's':
                return (new Par(n,BigInteger.ZERO)).suma( getPair(cad,i+1) );
            default:
                throw new Exception("No sea bruto");
        }
    }

    String getStr(Par pair){
        char []cad = new char[l];
        for (int i=0; i<l; i++){
            BigInteger n = BigInteger.ONE.shiftLeft(l-i-1);
            if (pair.fila.compareTo(n) < 0){
                if (pair.col.compareTo(n) < 0)
                    cad[i]='p';
                else
                    cad[i]='q';
            } else {
                if (pair.col.compareTo(n) < 0)
                    cad[i]='s';
                else
                    cad[i]='r';
            }
            pair = new Par(pair.fila.mod(n), pair.col.mod(n));
        }
        return new String(cad);
    }

    /*
     *
     */
    int main() throws Exception {
        int n;
        Par delta[] = {new Par("-1","0"), new Par("1","0"),
            new Par("0","-1"), new Par("0","1")};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        for (int i=0; i<n; i++) {
            String cad1 = br.readLine().trim();
            l = cad1.length() - 1;
            Par p = getPair(cad1.substring(1).toCharArray(),0);
            BigInteger size = BigInteger.ONE.shiftLeft(l);
            for (int j=0; j<4; j++) {
                Par p2 = delta[j].suma(p);
                if (p2.valid(size)) {
                    String cad2 = "m" + getStr(p2);
                    System.out.print(cad2);
                } else {
                    System.out.print("<none>");
                }
                if (j<3) System.out.print(" ");
            }
            System.out.print("\n");
        }
        return 0;
    }

    public static void main(String args[]) throws Exception {
        Main m = new Main();
        m.main();
    }

}
