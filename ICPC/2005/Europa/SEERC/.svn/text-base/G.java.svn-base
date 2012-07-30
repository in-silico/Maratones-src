/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 *
 * @author Estudiante
 */
public class G
{
    static class Scanner
    {
        BufferedReader br;
        StringTokenizer st;

        public Scanner()
        {
            try
            {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
            catch(Exception e)
            {

            }
        }

        public String next()
        {
            try
            {
                while(st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(br.readLine());
                return st.nextToken();
            }
            catch(Exception e)
            {
                return "-1";
            }
        }

        public int nextInt()
        {
            return Integer.parseInt(next());
        }
    }

    static class Respuesta
    {
        BigInteger n;
        char primero;
        char ultimo;

        public Respuesta(BigInteger nn, char pp, char uu)
        {
            n = nn;
            primero = pp;
            ultimo = uu;
        }
    }

    static Respuesta[][] dp = new Respuesta[2][1000];

    public static Respuesta dp(char inicial, int nivel)
    {
        if(dp[inicial - '0'][nivel] != null)
            return dp[inicial - '0'][nivel];
        if(inicial == '0')
        {
            Respuesta a = dp('1', nivel - 1);
            Respuesta b = dp('0', nivel - 1);
            int nuevo = ((a.ultimo == b.primero) && a.ultimo == '0') ? 1 : 0;
            return dp[inicial - '0'][nivel] = new Respuesta(a.n.add(b.n).add(BigInteger.valueOf(nuevo)), a.primero, b.ultimo);
        }
        else
        {
            Respuesta a = dp('0', nivel - 1);
            Respuesta b = dp('1', nivel - 1);
            int nuevo = ((a.ultimo == b.primero) && a.ultimo == '0') ? 1 : 0;
            return dp[inicial - '0'][nivel] = new Respuesta(a.n.add(b.n).add(BigInteger.valueOf(nuevo)), a.primero, b.ultimo);
        }
    }

    public static void main(String[] args)
    {
        dp[0][1] = new Respuesta(BigInteger.ZERO, '1', '0');
        dp[1][1] = new Respuesta(BigInteger.ZERO, '0', '1');
        Scanner sc = new Scanner();
        while(true)
        {
            int n = sc.nextInt();
            if(n < 0)
                return;
            System.out.print(dp('1', n).n + "\r\n");
        }
    }
}