import java.awt.geom.Line2D;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G
{
    static class Scanner
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        public String next()
        {
            try
            {
                while(st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(br.readLine());
            }
            catch(Exception e)
            {
                throw(new RuntimeException(e.getMessage()));
            }
            return st.nextToken();
        }

        public int nextInt()
        {
            return Integer.parseInt(next());
        }
    }

    static boolean[][][] moles = new boolean[11][40][40];
    static Integer[][][] dp = new Integer[11][40][40];
    static int d;
    static int tMax;
    static int n;

    static int gcd(int a, int b)
    {
        if(b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    static int dp(int tiempo, int x, int y)
    {
        if(tiempo > tMax)
            return 0;
        if(dp[tiempo][x][y] != null)
            return dp[tiempo][x][y];
        int mejor = 0;
        for(int i = x - d; i <= x + d; i++)
            for(int j = y - d; j <= y + d; j++)
            {
                if(i < 0 || i >= n || j < 0 || j >= n || (x - i) * (x - i) + (y - j) * (y - j) > d * d)
                    continue;
                Line2D linea = new Line2D.Double(x, y, i, j);
                int cuenta = 0;
                int a = i - x;
                int b = j - y;
                int c = gcd(Math.abs(a), Math.abs(b));
                if(c == 0)
                    c = 1;
                a /= c;
                b /= c;
                int xAct = x;
                int yAct = y;
                while(true)
                {
                    if(xAct < 0 || xAct >= n || yAct < 0 || yAct >= n)
                        break;
                    if(moles[tiempo][xAct][yAct])
                        cuenta++;
                    if(xAct == i && yAct == j)
                        break;
                    xAct += a;
                    yAct += b;
                }
                mejor = Math.max(mejor, cuenta + dp(tiempo + 1, i, j));
            }
        return dp[tiempo][x][y] = mejor;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner();
        while(true)
        {
            n = sc.nextInt();
            d = sc.nextInt();
            n += 2 * d;
            int m = sc.nextInt();
            if(n == 0 && d == 0 && m == 0)
                return;
            for(int i = 0; i < 11; i++)
                for(int j = 0; j < n; j++)
                    for(int k = 0; k < n; k++)
                    {
                        moles[i][j][k] = false;
                        dp[i][j][k] = null;
                    }
            tMax = 0;
            for(int i = 0; i < m; i++)
            {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int t = sc.nextInt();
                tMax = Math.max(tMax, t);
                moles[t][x + d][y + d] = true;
            }
            int mejor = 0;
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    mejor = Math.max(mejor, dp(1, i, j));
            System.out.println(mejor);
        }
    }
}