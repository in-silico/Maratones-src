import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;


public class G 
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
			return (p != -1 && p != b.length && b[p] == '\0') || (p < b.length - 1 && b[p + 1] == '\0');
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
	
	static class Punto implements Comparable <Punto>
	{
		int x, y;
		
		public Punto(int xx, int yy)
		{
			x = xx;
			y = yy;
		}

		@Override
		public int compareTo(Punto o) 
		{
			int a = new Integer(x).compareTo(o.x);
			if(a == 0)
			{
				return new Integer(y).compareTo(o.y);
			}
			return a;
		}
	}
	static int[][] ciudad = new int[100][100];
	static Punto[][] puntosMem = new Punto[100][100];
	static int n;
	
	
	public static void calcular(int xi, int yi, int difX, int difY, ArrayList <Punto> donde)
	{
		int i = xi;
		int j = yi;
		int cuenta = 0;
		while(i >= 0 && i < n && j >= 0 && j < n)
		{
			cuenta += ciudad[i][j];
			i += difX;
			j += difY;
		}
		i = xi;
		j = yi;
		int acum = 0;
		while(i >= 0 && i < n && j >= 0 && j < n)
		{
			int derecha = cuenta - acum - ciudad[i][j];
			if(derecha == acum)
			{
				donde.add(puntosMem[i][j]);
			}
			acum += ciudad[i][j];
			i += difX;
			j += difY;
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		ArrayList <Punto> Hs = new ArrayList <Punto> (10000);	
		ArrayList <Punto> Vs = new ArrayList <Punto> (10000);	
		ArrayList <Punto> Ds = new ArrayList <Punto> (10000);	
		ArrayList <Punto> As = new ArrayList <Punto> (10000);	
		boolean yaD[][] = new boolean[100][100];
		boolean yaV[][] = new boolean[100][100];
		boolean yaH[][] = new boolean[100][100];
		boolean yaA[][] = new boolean[100][100];
		Scanner sc = new Scanner();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = sc.nextInt();
		for(int i = 0; i < 100; i++)
			for(int j = 0; j < 100; j++)
				puntosMem[i][j] = new Punto(i, j);
		while(t-- != 0)
		{
			Hs.clear();
			Vs.clear();
			Ds.clear();
			As.clear();
			n = sc.nextInt();
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
				{
					ciudad[i][j] = sc.nextInt();
					yaH[i][j] = false;
					yaD[i][j] = false;
					yaV[i][j] = false;
					yaA[i][j] = false;
				}
			for(int i = 0; i < n; i++)
			{
				calcular(i, 0, 0, 1, Hs);
				calcular(0, i, 1, 0, Vs);
				calcular(0, i, 1, 1, Ds);
				calcular(i, 0, 1, 1, Ds);
				calcular(i, 0, -1, 1, As);
				calcular(n - 1, i, -1, 1, As);
			}
			Collections.sort(Hs);
			bw.append("H");
			bw.append("\n");
			for(Punto p : Hs)
			{
				if(!yaH[p.x][p.y])
				{
					bw.append(p.x + " " + p.y);
					bw.append("\n");
				}
				yaH[p.x][p.y] = true;
			}
			Collections.sort(Vs);
			bw.append("V");
			bw.append("\n");
			for(Punto p : Vs)
			{
				if(!yaV[p.x][p.y])
				{
					bw.append(p.x + " " + p.y);
					bw.append("\n");
				}
				yaV[p.x][p.y] = true;
			}
			Collections.sort(Ds);
			bw.append("D");
			bw.append("\n");
			for(Punto p : Ds)
			{
				if(!yaD[p.x][p.y])
				{
					bw.append(p.x + " " + p.y);
					bw.append("\n");
				}
				yaD[p.x][p.y] = true;
			}
			Collections.sort(As);
			bw.append("A");
			bw.append("\n");
			for(Punto p : As)
			{
				if(!yaA[p.x][p.y])
				{
					bw.append(p.x + " " + p.y);
					bw.append("\n");
				}
				yaA[p.x][p.y] = true;
			}
		}
		bw.flush();
	}
}
