import java.io.IOException;
import java.io.InputStreamReader;


public class C {
	static class Scanner {
		InputStreamReader i;
		char b[];
		int p = -1, d, h, t;
		
		public Scanner() throws IOException {
			b = new char[2500000];
			i = new InputStreamReader(System.in);
			i.read(b);
		}
		
		public void leer(char c) throws IOException {
			try {
				while(b[++p] <= c);
				d = p;
				h = d - 1;
				while(b[++h] > c);
				p = h--;
			}
			catch(Exception e) {
				organizar();
				leer(c);
			}
		}
		
		void organizar() throws IOException {
			int hd = 0;
			if(p != b.length) {
				hd = h - d;
				System.arraycopy(b, d, b, 0, hd);
				d = 0;
			}
			p = -1;
			int l = i.read(b, hd, b.length - hd);
			if(hd + l < b.length)
				b[hd + (l == -1 ? 0 : l)] = '\0';
		}
		
		public String next() throws IOException {
			leer(' ');
			return new String(b, d, h - d + 1);
		}
		
		public String nextLine() throws IOException {
			if(p != -1 && b[p] != '\n') {
				p--;
				leer('\n');
			}
			leer('\n');
			return new String(b, d, h - d + 1);
		}
		
		public int nextInt() throws IOException {
			return (int) nextLong();
		}
		
		public long nextLong() throws IOException {
			leer(' ');
			long r = 0;
			boolean n = b[d] == '-';
			if(n)
				d++;
			r -= b[d++] - '0';
			while (d <= h && (r *= 10) <= 0) 
				r -= b[d++] - '0';
			return n ? r : -r;
		}
		
		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}
	}
	
	private static int sol(int n, int m, int[] tablas) 
	{
		int unicas = 0;
		if(tablas[m] > 0)
		{
			unicas = tablas[m];
			tablas[m] = 0;
		}
		int dobles = 0;
		for(int i = 1; i <= m / 2; i++)
		{
			if(tablas[i] < 1 || tablas[m - i] < 1)
				continue;
			if(i == m - i)
				dobles += tablas[i] / 2;
			else
				dobles += Math.min(tablas[i], tablas[m - i]);
			tablas[i] = 0;
			tablas[m - i] = 0;
		}
		if(unicas + dobles < n)
			return Integer.MAX_VALUE;
		else
		{
			if(unicas > n)
				unicas = n;
			return unicas + (n - unicas) * 2;
		}
	}
	
	static int[] planksA = new int[10001];
	static int[] planksB = new int[10001];
	
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner();
		while(true)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			if(n == 0 && m == 0)
				return;
			int l = sc.nextInt();
			int k = sc.nextInt();
			for(int i = 0; i <= 10000; i++)
			{
				planksA[i] = planksB[i] = 0;
			}
			for(int i = 0; i < k; i++)
			{
				int lectura = sc.nextInt();
				planksA[lectura]++;
				planksB[lectura]++;
			}
			int mejor = Integer.MAX_VALUE;
			if((n * 100) % l == 0)
			{
				mejor = Math.min(mejor, sol((n * 100) / l, m, planksA));
			}
			if((m * 100) % l == 0)
			{
				mejor = Math.min(mejor, sol((m * 100) / l, n, planksB));
			}
			if(mejor == Integer.MAX_VALUE)
			{
				System.out.println("impossivel");
			}
			else
			{
				System.out.println(mejor);
			}
		}	
	}
}
