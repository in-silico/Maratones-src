import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringTokenizer;


public class P1 
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
                            return st.hasMoreTokens();
                    }
                    catch(Exception e) { throw new RuntimeException(); }
            }
    }
	
	static class Respuesta
	{
		String s;
		int n;
		
		public Respuesta(String ss, int nn)
		{
			s = ss;
			n = nn;
		}
	}
	
	static class Exon implements Comparable <Exon>
	{
		int inicial;
		int fin;
		int posInicial;
		
		public Exon(int i, int f, int pi)
		{
			inicial = i;
			fin = f;
			posInicial = pi;
		}

		@Override
		public int compareTo(Exon o) 
		{
			return inicial - o.inicial;
		}
	}
	
	static int n;
	static Exon[] exones = new Exon[1001];
	static Respuesta[] dp = new Respuesta[1001];
	
	static Respuesta dp(int exon)
	{
		if(dp[exon] != null)
			return dp[exon];
		Exon actual = exones[exon];
		int acum = 0;
		String resAcum = "";
		for(int i = exon + 1; i < n; i++)
		{
			if(exones[i].inicial > actual.fin)
			{
				Respuesta siguiente = dp(i);
				if(siguiente.n > acum)
				{
					acum = siguiente.n;
					resAcum = siguiente.s;
				}
			}
		}
		return dp[exon] = new Respuesta(acum == 0 ? (exones[exon].posInicial + "") : (exones[exon].posInicial + " " + resAcum), acum + 1);
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			n = sc.nextInt();
			if(n == 0)
				return;
			for(int i = 0; i < n; i++)
				exones[i] = new Exon(sc.nextInt(), sc.nextInt(), i + 1);
			Arrays.sort(exones, 0, n);
			for(int i = 0; i < n; i++)
				dp[i] = null;
			int acum = 0;
			String resAcum = "";
			for(int i = 0; i < n; i++)
			{
				Respuesta siguiente = dp(i);
				if(siguiente.n > acum)
				{
					acum = siguiente.n;
					resAcum = siguiente.s;
				}
			}
			System.out.println(resAcum);
		} 
	}
	
}
