import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class D {
	static class Scanner {
		InputStreamReader i;
		char b[];
		int p = -1, d, h, t;
		
		public Scanner() throws IOException {
			b = new char[5000000];
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

	static ArrayList <Posicion> dp = new ArrayList <Posicion> (1000000);
	
	static class Posicion
	{
		int inicio;
		int fin;
		int valorInicio = -1;
		int valorFin = -1;
		
		public Posicion(int i, int f)
		{
			inicio = i;
			fin = f;
		}
	}
	
	public static int visitar(int columna, int entrada)
	{
		if(columna == h)
			return -1;
		Posicion actual = dp.get(columna);
		if(actual.inicio == -1)
		{
			int prueba = visitar(columna + 1, entrada);
			if(prueba < 0)
				return -1;
			return 1 + prueba;
		}
		if(entrada >= actual.fin && entrada >= actual.inicio)
		{
			if(actual.valorInicio == -1)
				actual.valorInicio = 1 + visitar(columna + 1, actual.inicio);
			return entrada - actual.inicio + actual.valorInicio;
		}
		if(actual.valorFin == -1)
			actual.valorFin = 1 + visitar(columna + 1, actual.fin);
		if(columna == 0)
		{
			return actual.fin + actual.valorFin;
		}
		if(entrada <= actual.fin && entrada <= actual.inicio)
		{
			return actual.fin - entrada + actual.valorFin;
		}
		if(actual.valorInicio == -1)
			actual.valorInicio = 1 + visitar(columna + 1, actual.inicio);
		int menor = entrada - actual.inicio + (actual.fin - actual.inicio) + actual.valorFin;
		menor = Math.min(menor, actual.fin - entrada + (actual.fin - actual.inicio) + actual.valorInicio);
		return menor;
	}
	
	static int w, h; 
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner();
		int n = sc.nextInt();
		while(n-- != 0)
		{
			dp.clear();
			w = sc.nextInt();
			h = sc.nextInt();
			for(int j = 0; j < h; j++)
			{
				char[] nuevo = sc.next().toCharArray();
				int indice = 0;
				int indiceP = -1;
				int indiceF = -1;
				boolean empezo = false;
				for(char c : nuevo)
				{
					if(((c - '0') & 1) == 0)
					{
						if(!empezo)
						{
							indiceP = indice;
							empezo = true;
						}
						indiceF = indice;
					}
					indice++;
				}
				dp.add(new Posicion(indiceP, indiceF));
			}
			int respuesta = visitar(0, 0);
			System.out.println(respuesta < 0 ? 0 : respuesta);
		}
	}
}
