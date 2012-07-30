import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class H
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

    static class Nodo
    {
       LinkedList <Nodo> adjacentes = new LinkedList <Nodo> ();
       int numero;
    }

    static Nodo[] nodos = new Nodo[1024];
    static int n;
    static Double[][] dp = new Double[1024][101];
    static double numeroNodos;

    static double dp(int nodo, int k)
    {
        if(k == 0)
            return 1 / numeroNodos;
        if(dp[nodo][k] != null)
            return dp[nodo][k];
        double acum = 0;
        for(Nodo no : nodos[nodo].adjacentes)
            acum += dp(no.numero, k - 1) / no.adjacentes.size();
        return dp[nodo][k] = acum;
    }

    static boolean intentar(int k)
    {
        for(int i = 0; i < 1 << n; i++)
            for(int j = 0; j <= k; j++)
                dp[i][j] = null;
        for(int i = 0; i < k; i++)
            for(int l = 0; l < n; l++)
            {
                double acum = 0;
                for(int j = 0; j < (1 << n); j++)
                {
                		if(((j >> l) & 1) == 1)
                			acum += dp(j, i);
                }
                if(acum >= 0.75 || acum <= 0.25)
                    return false;
            }
        return true;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner();
        while(true)
        {
            int k = sc.nextInt();
            n = sc.nextInt();
            int e = sc.nextInt();
            numeroNodos = 1 << n;
            if(k == 0 && n == 0 && e == 0)
                return;
            for(int i = 0; i < 1 << n; i++)
            {
                nodos[i] = new Nodo();
                nodos[i].numero = i;
            }
            for(int i = 0; i < e; i++)
            {
                int a = sc.nextInt();
                int b = sc.nextInt();
                nodos[a].adjacentes.add(nodos[b]);
                nodos[b].adjacentes.add(nodos[a]);
            }
            if(intentar(k))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}
