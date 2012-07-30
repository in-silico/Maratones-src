import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;


public class E
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
	
	static class Punto implements Comparable <Punto>
	{
		long coordenadaX;
		long coordenadaY;
		boolean existe = true;
		boolean ordenado = false;
		ArrayList <Punto> conexiones = new ArrayList <Punto> ();
		
		public Punto(long x, long y)
		{
			coordenadaX = x;
			coordenadaY = y;
		}

		@Override
		public int compareTo(Punto o) 
		{
			int comparable = new Long(coordenadaX).compareTo(o.coordenadaX);
			if(comparable == 0)
			{
				return new Long(coordenadaY).compareTo(o.coordenadaY);
			}
			return comparable;
		}

		public boolean tieneConexion(Punto pf) 
		{
			if(!ordenado)
			{
				Collections.sort(conexiones);
				ordenado = true;
			}
			return Collections.binarySearch(conexiones, pf) >= 0;
		}
	}

	static TreeMap <Punto, Punto> puntos = new TreeMap <Punto, Punto> ();
	static ArrayList <Punto> puntosO = new ArrayList <Punto> ();

	
	public static long convertir(double d)
	{
		return Math.round(d * 10);
	}
	
	public static Punto darPunto(long x, long y)
	{
		Punto nuevo = new Punto(x, y);
		Punto posible = puntos.get(nuevo);
		if(posible != null)
			return posible;
		puntos.put(nuevo, nuevo);
		puntosO.add(nuevo);
		return nuevo;
	}
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner();
		int t = sc.nextInt();
		while(t-- != 0)
		{
			puntos.clear();
			puntosO.clear();
			int n = sc.nextInt();
			for(int i = 0; i < n; i++)
			{
				long a = convertir(sc.nextDouble());
				long b = convertir(sc.nextDouble());
				long c = convertir(sc.nextDouble());
				long d = convertir(sc.nextDouble());
				Punto in = darPunto(a, b);
				Punto fi = darPunto(c, d);
				in.conexiones.add(fi);
				fi.conexiones.add(in);
			}
			Collections.sort(puntosO);
			int cuenta = 0;
			for(Punto p : puntosO)
			{
				int tamCon = p.conexiones.size();
				for(int i = 0; i < tamCon; i++)
				{
					Punto pi = p.conexiones.get(i);
					if(!pi.existe)
						continue;
					for(int j = i + 1; j < tamCon; j++)
					{
						Punto pf = p.conexiones.get(j);
						if(!pf.existe)
							continue;
						if(pi.tieneConexion(pf))
							cuenta++;
					}
				}
				p.existe = false;
			}
			System.out.println(cuenta);
		}
		
	}

}
