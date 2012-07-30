import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class allergy
{
	

	static class Scanner 
	{
		InputStreamReader i;
		char b[];
		int p = -1, d, h, l;
		boolean fin;
		
		public Scanner() throws IOException 
		{
			b = new char[262144];
			i = new InputStreamReader(System.in);
			l = i.read(b);
		}
		
		public void leer(char c) throws IOException 
		{
			try
			{
				if(fin)
					throw(new IOException());
				while(b[++p] <= c && p < l);
				fin |= (d = p) >= l;
				h = d - 1;
				while(b[++h] > c);
				p = h--;
				if(fin)
					h = d = 0;
			}
			catch(Exception e)
			{
				if(fin && (h = d = 0) == 0)
					return;
				int z = 0;
				if(p != b.length) 
				{
					z = h - d;
					System.arraycopy(b, d, b, 0, z);
					d = 0;
				}
				p = -1;
				l = i.read(b, z, b.length - z);
				int l1 = l == -1 ? 0 : l;
				if(z + l1 < b.length)
					b[z + l1] = '\0';
				l = z + l1;
				leer(c);
			}
		}

		public String next() throws IOException 
		{
			leer(' ');
			return new String(b, d, h - d + 1);
		}
		
		public String readLine() throws IOException 
		{
			boolean entro = false;
			if(p != -1 && p < l && b[p] != '\n') 
			{
				p--;
				entro = true;
				leer('\n');
			}
			if(!fin || !entro)
				leer('\n');
			return new String(b, d, h - d + 1);
		}
		
		public int nextInt() throws IOException 
		{
			return (int) nextLong();
		}
		
		public long nextLong() throws IOException 
		{
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
		
		public double nextDouble() throws IOException 
		{
			return Double.parseDouble(next());
		}
	}
	
	
	public static class Componente implements Comparable <Componente>
	{
		int numero;
		boolean inicio = false;
		boolean detectado = false;
		boolean finalizo = false;
		int faltan;
		int diaInicio;
		int diaFin;
		
		public Componente(int n)
		{
			numero = n;
		}

		@Override
		public int compareTo(Componente o)
		{
			return Integer.valueOf(numero).compareTo(o.numero);
		}
	}
	
	
	static HashMap <Long, Integer> valores = new HashMap <Long, Integer> ();
	
	
	static int dp(long actual, int faltantes)
	{
		if(actual == 0)
			return faltantes;
		if(valores.containsKey(actual))
			return valores.get(actual);
		int minimo = Integer.MAX_VALUE;
		for(int i = 1; i <= 7; i++)
		{
			int numAct = (int) ((actual >> (i * 5)) & 31);
			if(i > faltantes && numAct > 0)
			{
				long proximo = numAct - 1;
				proximo <<= (i * 5);
				long mascara = 31L << (i * 5);
				mascara = ~mascara;
				long siguiente = (actual & mascara) | proximo;
				minimo = Math.min(minimo, (faltantes + 1) + dp(siguiente, (i - (faltantes + 1))));
			}
		}
		if(faltantes != 0)
			minimo = Math.min(minimo, 1 + dp(actual, faltantes - 1));
		valores.put(actual, minimo);
		return minimo;
	}
	

	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner();
		int nc = sc.nextInt();
		while(nc-- != 0)
		{
			int n = sc.nextInt();
			long[] numeros = new long[8];
			for(int i = 0; i < n; i++)
				numeros[sc.nextInt()]++;
			long numero = 0;
			for(int i = 0; i < 8; i++)
			{
				numero |= numeros[i] << (i * 5);
			}
			valores.clear();
			System.out.println(dp(numero, 0));
		}
	}
}
