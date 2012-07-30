import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class A 
{
	static class Scanner {
		InputStreamReader i;
		char b[];
		int p = -1, d, h, t;
		
		public Scanner() throws IOException {
			b = new char[250000];
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
	
	
	public static String escoger(int d, int n, char[] numero)
	{
		for(int i = 0; i <= 10; i++)
		{
			posiciones.get(i).clear();
		}
		for(int i = 0; i < n; i++)
		{
			posiciones.get(numero[i] - '0').add(i);
		}
		int posActual = -1;
		int nDigitos = 0;
		StringBuilder sb = new StringBuilder();
		while(nDigitos != n - d)
		{
			int desde = posActual;
			int hasta = n - (n - d - nDigitos);
			for(int i = 9; i >= 0; i--)
			{
				int indice = Collections.binarySearch(posiciones.get(i), desde + 1);
				if(indice >= 0)
				{
					posActual = posiciones.get(i).get(indice);
					sb.append(i);
					break;
				}
				else
				{
					int insercion = indice + 1;
					insercion *= -1;
					if(insercion == posiciones.get(i).size())
						continue;
					if(posiciones.get(i).get(insercion) > hasta)
						continue;
					posActual = posiciones.get(i).get(insercion);
					sb.append(i);
					break;
				}
			}
			nDigitos++;
		}
		return sb.toString();
	}
	
	static ArrayList <ArrayList <Integer> > posiciones = new ArrayList <ArrayList <Integer> > (10);
	
	public static void main(String[] args) throws IOException
	{
		for(int i = 0; i <= 10; i++)
		{
			posiciones.add(new ArrayList <Integer> ());
		}
		Scanner sc = new Scanner();
		while(true)
		{
			int n = sc.nextInt();
			int d = sc.nextInt();
			if(n == 0 && d == 0)
				return;
			System.out.println(escoger(d, n, sc.nextLine().toCharArray()));
		}
	}
}
