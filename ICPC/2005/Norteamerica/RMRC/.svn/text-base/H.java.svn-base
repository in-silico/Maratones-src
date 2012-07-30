import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class H 
{
	static int base;
	static int P;
	static int modulo;
	static int offset;

	static long powMod(int base, int exp, int P)
	{
		if(exp == 0)
			return 1;
		if(exp == 1)
			return base % P;
		long medio = powMod(base, exp >> 1, P);
		return (medio * medio * powMod(base, ((exp & 1) == 1) ? 1 : 0, P)) % P;
	}
	static int equiv(int iteracion)
	{
		if(iteracion == 0)
			return 1;
		int res = equiv(iteracion - 1);
		long xx = (long) Math.pow(base, res);
		if(xx < offset)
			return (int) xx;
		long x = powMod(base, res, P);
		return ((int) (((x - offset + P) % P) + offset));	
	}
	
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner()
		{
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public String next()
		{

			while(st == null || !st.hasMoreTokens())
			{
				try { st = new StringTokenizer(br.readLine()); }
				catch(Exception e) { throw new RuntimeException(); }
			}
			return st.nextToken();
		}

		public int nextInt()
		{
			return Integer.parseInt(next());
		}
		
		public double nextDouble()
		{
			return Double.parseDouble(next());
		}
		
		public String nextLine()
		{
			st = null;
			try { return br.readLine(); }
			catch(Exception e) { throw new RuntimeException(); }
		}
		
		public boolean endLine()
		{
			try 
			{
				String next = br.readLine();
				while(next != null && next.trim().isEmpty())
					next = br.readLine();
				if(next == null)
					return true;
				st = new StringTokenizer(next);
				return st.hasMoreTokens();
			}
			catch(Exception e) { throw new RuntimeException(); }
		}
	}
	
	static class SuperScanner
	{
		char[] buffer;
		InputStreamReader isr;
		int p;
		int start;
		
		public SuperScanner()
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
	
	static class SuperWriter
	{
		char[] buffer;
		OutputStreamWriter os;
		int pos;
		
		public SuperWriter()
		{
			buffer = new char[6000001];
			os = new OutputStreamWriter(System.out);
			pos = 0;
		}
		
		public void println(String s)
		{
			print(s);
			print("\n");
		}
		
		public void print(String s)
		{
			int tam = s.length();
			if(pos + tam > buffer.length)
				tam = buffer.length - pos;
			s.getChars(0, tam, buffer, pos);
			pos += tam;
			if(pos == buffer.length)
			{
				try
				{
					os.write(buffer);
					pos = 0;
					print(s.substring(tam));
				}
				catch(Exception e)
				{
					throw(new RuntimeException());
				}
			}
		}

		public void flush() 
		{
			try 
			{
				os.write(buffer, 0, pos);
				pos = 0;
				os.flush();
			}
			catch (IOException e) 
			{
				throw(new RuntimeException());
			}
		}
	}
	
	static long[] todos = new long[101];
	static int[] encontrados = new int[10000000];
	
	static void hallarPeriodo(int base, int modulo)
	{
		if(todos[base] != -1)
		{
			long res = todos[base];
			P = (int) res;
			res >>= 32;
			offset = (int) res;
			return;
		}
		for(int i = 0; i < modulo; i++)
			encontrados[i] = -1;
		int actual = 1;
		encontrados[1] = 0;
		for(int i = 1; i < modulo; i++)
		{
			actual *= base;
			actual %= modulo;
			if(encontrados[actual] != -1)
			{
				P = i - encontrados[actual];
				offset = encontrados[actual];
				long guardar = P;
				long off = offset;
				off <<= 32;
				guardar |= off;
				todos[base] = guardar;
				return;
			}
			encontrados[actual] = i;
		}
	}
	
	static int[] periodos = new int[] {0, 0, 1, 0, 62500, 7, 500000, 0, 31250, 4, 32, 7, 15625, 7, 50000, 0, 62500, 3, 250000, 0, 1, 7, 500000, 0, 62500, 4, 500000, 0, 31250, 7, 8, 7, 15625, 2, 125000, 0, 12500, 7, 500000, 0, 1, 7, 500000, 0, 62500, 7, 250000, 0, 6250, 3, 16, 4, 3125, 7, 500000, 0, 62500, 4, 500000, 0, 1, 7, 62500, 0, 12500, 2, 62500, 0, 31250, 7, 32, 7, 15625, 4, 500000, 0, 62500, 7, 250000, 0, 1, 7, 250000, 0, 62500, 7, 100000, 0, 31250, 4, 32, 7, 15625, 7, 125000, 0, 62500, 2, 25000, 0, 1, 7, 100000, 0, 62500, 4, 500000, 0, 31250, 7, 16, 7, 15625, 3, 10000, 0, 62500, 7, 500000, 0, 1, 7, 500000, 0, 62500, 7, 62500, 0, 31250, 2, 2, 7, 15625, 7, 500000, 0, 2500, 4, 500000, 0, 1, 7, 250000, 0, 62500, 3, 250000, 0, 6250, 7, 32, 4, 3125, 4, 500000, 0, 62500, 7, 125000, 0, 1, 7, 125000, 0, 12500, 7, 500000, 0, 31250, 4, 32, 7, 15625, 7, 250000, 0, 62500, 3, 250000, 0, 1, 7, 500000, 0, 62500, 4, 100000, 0, 31250, 7, 4, 7, 15625, 2, 62500, 0, 62500, 7, 100000, 0, 1, 4};
	static int[] diezA = new int[] {0, 10, 100, 1000, 10000, 100000, 1000000, 10000000};
	
	public static void main(String[] args) throws IOException
	{
		SuperScanner sc = new SuperScanner();
		SuperWriter sw = new SuperWriter();
		modulo = (int) Math.pow(10, 7);
		for(int i = 0; i < todos.length; i++)
			todos[i] = -1;
		while(true)
		{
			base = sc.nextInt();
			if(base == 0)
			{
				sw.flush();
				return;
			}
			int iter = sc.nextInt();
			int numero = sc.nextInt();
			P = periodos[2 * base];
			offset = periodos[2 * base + 1];
			int resultado = ((int) powMod(base, equiv(iter - 1), modulo));
			resultado %= diezA[numero];
			String salida = resultado + "";
			int tam = salida.length();
			while(tam < numero)
			{
				sw.print("0");
				tam++;
			}
			sw.println(salida);
		}
	}
}
