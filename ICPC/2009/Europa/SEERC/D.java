import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class D
{
    static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;

		public Scanner()
		{
                        System.setOut(new PrintStream(new BufferedOutputStream(System.out), true));
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next()
		{

			while(st == null || !st.hasMoreTokens())
			{
				try { st = new StringTokenizer(br.readLine()); }
				catch(Exception e) { throw new RuntimeException(); }
			}
			return st.nextToken();
		}

		public int nextInt()
		{
			return Integer.parseInt(next());
		}

		public double nextDouble()
		{
			return Double.parseDouble(next());
		}

		public String nextLine()
		{
			st = null;
			try { return br.readLine(); }
			catch(Exception e) { throw new RuntimeException(); }
		}

		public boolean endLine()
		{
			try
			{
				String next = br.readLine();
				while(next != null && next.trim().isEmpty())
					next = br.readLine();
				if(next == null)
					return true;
				st = new StringTokenizer(next);
				return !st.hasMoreTokens();
			}
			catch(Exception e) { throw new RuntimeException(); }
		}
	}

    static class Nodo
    {
        LinkedList <Nodo> vecinos = new LinkedList <Nodo> ();
        Integer visitado = null;
    }
    
    static Nodo[] nodos = new Nodo[5000];
    static int mayor;


    private static void dfs(Nodo nodo, int i)
    {
        nodo.visitado = i;
        for(Nodo n : nodo.vecinos)
        {
            if(n.visitado != null)
                mayor = Math.max(mayor, i - n.visitado + 1);
            else
                dfs(n, i + 1);
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        for(int caso = 0; caso < t; caso++)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            for(int i = 1; i <= n; i++)
                nodos[i] = new Nodo();
            for(int i = 0; i < m; i++)
            {
                int a = sc.nextInt();
                int b = sc.nextInt();
                nodos[a].vecinos.add(nodos[b]);
                nodos[b].vecinos.add(nodos[a]);
            }
            mayor = 0;
            dfs(nodos[1], 1);
            if(mayor == 2)
                mayor = 0;
            System.out.println(mayor);
        }
    }
}
