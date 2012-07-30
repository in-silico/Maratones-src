import java.io.IOException;
import java.io.InputStreamReader;


public class F 
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
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner();
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0)
				return;
			int primero = sc.nextInt();
			int segundo = sc.nextInt();
			boolean subida = primero > segundo ? false : true;
			int anterior = segundo;
			int cuenta = 0;
			for(int i = 0; i < n - 2; i++)
			{
				int nuevo = sc.nextInt();
				if((subida && nuevo < anterior) || (!subida && nuevo > anterior))
				{
					cuenta++;
					subida = !subida;
				}
				anterior = nuevo;
			}
			int nuevo = primero;
			if((subida && nuevo < anterior) || (!subida && nuevo > anterior))
			{
				cuenta++;
				subida = !subida;
			}
			anterior = primero;
			nuevo = segundo;
			if((subida && nuevo < anterior) || (!subida && nuevo > anterior))
			{
				cuenta++;
				subida = !subida;
			}
			System.out.println(cuenta);
		}
	}

}
