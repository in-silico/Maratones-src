import java.math.BigInteger;
import java.util.Scanner;


public class E
{
    static int n;

    static BigInteger[][] dp = new BigInteger[65][10];

    static BigInteger dp(int posicion, int anterior)
    {
        if(posicion == n)
            return BigInteger.ONE;
        if(dp[posicion][anterior] != null)
            return dp[posicion][anterior];
        BigInteger suma = BigInteger.ZERO;
        for(int i = anterior; i < 10; i++)
            suma = suma.add(dp(posicion + 1, i));
        return dp[posicion][anterior] = suma;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int ng = sc.nextInt();
        for(int aa = 0; aa < ng; aa++)
        {
            int nn = sc.nextInt();
            n = sc.nextInt();
            for(int i = 0; i < 65; i++)
                for(int j = 0; j < 10; j++)
                    dp[i][j] = null;
            System.out.println(nn + " " + dp(0, 0));
        }
    }
}
