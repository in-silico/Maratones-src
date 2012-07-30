import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class isoceles 
{
	static class Scanner
	{
		char[] buffer;
		InputStreamReader isr;
		int p;
		int start;
		
		public Scanner() throws FileNotFoundException
		{
			buffer = new char[6000001];
			isr = new InputStreamReader(System.in);		
			read(0);
		}
		
		void read(int init)
		{
			try
			{
				int tam;
				if((tam = isr.read(buffer, init, buffer.length - init)) < buffer.length - init)
				{
					if(tam < 0)
						tam = 0;
					buffer[tam] = '\0';
				}
			}
			catch(Exception e)
			{
				throw(new RuntimeException());
			}
		}
		
		public void readNext()
		{
			int tam = buffer.length;
			int pos = p;
			while(pos < tam && buffer[pos] <= ' ')
				pos++;
			if(pos == tam)
			{
				read(0);
				readNext();
				return;
			}
			start = pos;
			while(pos < tam && buffer[pos] > ' ')
				pos++;
			if(pos == tam)
			{
				System.arraycopy(buffer, start, buffer, 0, buffer.length - start);
				read(buffer.length - start);
				p = start;
				readNext();
				return;
			}
			p = pos;
		}
		
		public String next()
		{
			readNext();
			return new String(buffer, start, p - start);
		}
		
		
		public long nextLong()
        {
			readNext();
            int d = start;
            int pos = p;
            long r = 0;
            boolean n = buffer[d] == '-';
            if(n)
            	d++;
            r -= buffer[d++] - '0';
            while (d < pos && (r = (r << 1) + (r << 3)) <= 0)
                    r -= buffer[d++] - '0';
            return n ? r : -r;
        }
		
		public int nextInt()
		{
			return (int) nextLong();
		}
		
		public double nextDouble()
		{
			return Double.parseDouble(next());
		}
		
		public String nextLine()
		{
			int tam = buffer.length;
			int pos = p;
			while(pos < tam && buffer[pos] != '\n')
				pos++;
			if(pos == tam)
			{
				read(0);
				return nextLine();
			}
			start = ++pos;
			while(pos < tam && buffer[pos] != '\n')
				pos++;
			if(pos >= tam)
			{
				System.arraycopy(buffer, start, buffer, 0, buffer.length - start);
				read(buffer.length - start);
				return nextLine();
			}
			p = pos;
			return new String(buffer, start, p - start);
		}
		
		public boolean EOF()
		{
			int tam = buffer.length;
			int pos = p;
			while(pos < tam && buffer[pos] <= ' ')
				if(buffer[pos++] == '\0')
					return true;
			pos++;
			if(pos >= tam)
			{
				if(p == 0)
					return false;
				System.arraycopy(buffer, p, buffer, 0, buffer.length - p);
				read(buffer.length - p);
				p = 0;
				return EOF();
			}
			return false;
		}
	}
	
	static class Tripleta implements Comparable <Tripleta>
	{
		int a, b, c;
		
		static int[] temp = new int[3];
		
		public Tripleta(int aa, int bb, int cc)
		{
			temp[0] = aa;
			temp[1] = bb;
			temp[2] = cc;
			Arrays.sort(temp);
			a = temp[0];
			b = temp[1];
			c = temp[2];
		}

		@Override
		public int compareTo(Tripleta o)
		{
			if(a != o.a)
				return a - o.a;
			if(b != o.b)
				return b - o.b;
			if(c != o.c)
				return c - o.c;
			return 0;
		}
	}
	
	static class HashMapa
	{
		int posicion(long h)
		{
			h ^= (h >>> 20) ^ (h >>> 12);
	        return (int) ((h ^ (h >>> 7) ^ (h >>> 4)) & 0x3FF);
		}
	
		static class Nodo
		{
			long distancia;
			int numero;
			int c = caso;
			
			public Nodo(long d, int n)
			{
				distancia = d;
				numero = n;
			}
			
			Nodo siguiente;
		}
		
		Nodo[] nodos;
		int tam;
		
		public HashMapa(int t)
		{
			tam = t;
			nodos = new Nodo[tam];
		}
		
		public Integer dar(long posible)
		{
			int llave = posicion(posible);
			if(nodos[llave] != null)
			{
				Nodo anterior = nodos[llave];
				for(Nodo actual = nodos[llave]; actual != null; actual = actual.siguiente)
				{
					if(actual.distancia == posible && actual.c == caso)
						return actual.numero;
					else if(actual.c != caso)
						anterior.siguiente = actual.siguiente;
					else
						anterior = actual;
				}
			}
			return null;
		}
		
		public Integer poner(long posible, int cual)
		{
			int llave = posicion(posible);
			if(nodos[llave] != null)
			{
				Nodo anterior = nodos[llave];
				for(Nodo actual = nodos[llave]; true; actual = actual.siguiente)
				{
					if(actual.distancia == posible && actual.c == caso)
					{
						return actual.numero = cual;
					}
					if(actual.c != caso)
					{
						anterior.siguiente = actual.siguiente;
					}
					else
						anterior = actual;
					if(actual.siguiente == null)
					{
						actual.siguiente = new Nodo(posible, cual);
						break;
					}
				}
			}
			else
			{
				nodos[llave] = new Nodo(posible, cual);
			}
			return null;
		}
		
		public void limpiar()
		{
			for(int i = 0; i < tam; i++)
				nodos[i] = null;
		}
	}
	
	static int caso = 0;
	static HashMapa mapa = new HashMapa(1024);
	
	
	static long colisiones = 0;
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner();
		long[][] dp = new long[1000][1000];
		long[] puntosA = new long[1000];
		long[] puntosB = new long[1000];
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0)
				return;
			for(int i = 0; i < n; i++)
			{
				puntosA[i] = sc.nextLong();
				puntosB[i] = sc.nextLong();
			}
			int cuenta = 0;
			for(int i = 0; i < n; i++)
				for(int j = i + 1; j < n; j++)
				{
					long temp = (puntosA[i] - puntosA[j]);
					temp *= temp;
					long temp2 = (puntosB[i] - puntosB[j]);
					temp2 *= temp2;
					dp[i][j] = temp + temp2;
					dp[j][i] = dp[i][j];
				}
			for(int i = 0; i < n; i++)
			{
				caso++;
				mapa.limpiar();
				for(int j = 0; j < n; j++)
				{
					long distancia = dp[i][j];
					Integer temp = mapa.dar(distancia);
					if(temp == null)
						mapa.poner(distancia, 1);
					else
					{
						cuenta += temp;
						mapa.poner(distancia, ++temp);
					}
				}
			}
			System.out.println(cuenta);
		}
	}
}
