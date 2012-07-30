import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;


public class D 
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
	
	static class Posicion
	{
		int x;
		int y;
		int numero;
		
		Posicion(int i, int j, int n)
		{
			x = i;
			y = j;
			numero = n;
		}
		
		ArrayList <Posicion> generarHijos()
		{
			ArrayList <Posicion> hijos = new ArrayList <Posicion> ();
			for(int i = 0; i < 8; i++)
			{
				if(i != x)
					hijos.add(new Posicion(i, y, numero + 1));
				if(i != y)
					hijos.add(new Posicion(x, i, numero + 1));
			}
			int i = x;
			int j = y;
			for(;;)
			{
				i++;
				j++;
				if(i < 0 || i > 7 || j < 0 || j > 7)
					break;
				hijos.add(new Posicion(i, j, numero + 1));
			}
			i = x;
			j = y;
			for(;;)
			{
				i++;
				j--;
				if(i < 0 || i > 7 || j < 0 || j > 7)
					break;
				hijos.add(new Posicion(i, j, numero + 1));
			}
			i = x;
			j = y;
			for(;;)
			{
				i--;
				j++;
				if(i < 0 || i > 7 || j < 0 || j > 7)
					break;
				hijos.add(new Posicion(i, j, numero + 1));
			}
			i = x;
			j = y;
			for(;;)
			{
				i--;
				j--;
				if(i < 0 || i > 7 || j < 0 || j > 7)
					break;
				hijos.add(new Posicion(i, j, numero + 1));
			}
			return hijos;
 		}
	}
	boolean [][] vistado = new boolean[8][8];
	
	public static int bfs(int x, int y, int xf, int yf)
	{
		LinkedList <Posicion> lista = new LinkedList <Posicion> ();
		lista.add(new Posicion(x, y, 0));
		while(!lista.isEmpty())
		{
			Posicion actual = lista.pollFirst();
			if(actual.x == xf && actual.y == yf)
				return actual.numero;
			lista.addAll(actual.generarHijos());
		}
		return -1;
	}
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner();
		while(true)
		{
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			if(x1 == 0 && x2 == 0 && y1 == 0 && y2 == 0)
				return;
			System.out.println(bfs(--x1, --y1, --x2, --y2));
		}
	}

}
