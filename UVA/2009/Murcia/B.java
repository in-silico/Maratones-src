import java.io.IOException;
import java.io.InputStreamReader;


public class B 
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
	
	static int generaciones, cortar;
	
	static class Persona
	{
		int numero;
		int generacion;
		Persona padre;
		Persona madre;
		
		public Persona(int n, int g)
		{
			numero = n;
			generacion = g;
			if(generacion != 20)
			{
				padre = new Persona(n << 1, generacion + 1);
				madre = new Persona((n << 1) + 1, generacion + 1);
			}
		}
		
		public int contar()
		{
			if(numero == cortar || generacion == generaciones)
			{
				return 1;
			}
			int cuenta = 1 + padre.contar() + madre.contar();
			return cuenta;
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		Persona inicial = new Persona(1, 1);
		Scanner sc = new Scanner();
		int t = sc.nextInt();
		while(t-- != 0)
		{
			generaciones = sc.nextInt();
			int h1 = sc.nextInt();
			int h2 = sc.nextInt();
			cortar = Math.max(h1, h2);
			System.out.println(inicial.contar());
		}
		
	}
}
