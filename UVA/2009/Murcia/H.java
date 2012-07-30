import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class H 
{

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
		
		public boolean noTieneMas()
		{
			return (p != -1 && p != b.length && b[p] == '\0') || (p != -1 && p < b.length - 1 && b[p + 1] == '\0');
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
	
	
	public static ArrayList <Long> potencias = new ArrayList <Long> ();
	
	public static void main(String[] args) throws IOException
	{
		for(long i = 0; i <= 31; i++)
		{
			for(long j = 0; j <= 20; j++)
			{
				potencias.add((1L << i) * ((long)Math.pow(3L, j)));
			}
		}
		Collections.sort(potencias);
		Scanner sc = new Scanner();
		while(true)
		{
			long m = sc.nextLong();
			if(m == 0)
				return;
			int indice = Collections.binarySearch(potencias, m);
			if(indice >= 0)
			{
				System.out.println(potencias.get(indice));
			}
			else
			{
				indice += 1;
				indice *= -1;
				System.out.println(potencias.get(indice));
			}
		}
	}

}
