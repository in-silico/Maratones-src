import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Maja 
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner()
		{
	    	System.setOut(new PrintStream(new BufferedOutputStream(System.out), true));
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
				return !st.hasMoreTokens();
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
			else
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
	
	static int[][] diffs = new int[][]{{-1, 0}, {0, -1}, {1, -1}, {1, 0}, {0, 1}, {-1, 1}};
	
	static Integer[][] todos = new Integer[2000][2000];
	static HashMap <Integer, Long> mapa = new HashMap <Integer, Long> ();
	
	
	public static void main(String[] args)
	{
		int indiceDelta = -1;
		todos[0][0] = 1;
		int i = 500;
		int j = 500;
		mapa.put(1, ((long) i << 32) | j);
		j++;
		for(int valor = 2; valor <= 100000; valor++)
		{
			todos[i][j] = valor;
			mapa.put(valor, ((long) i << 32) | j);
			indiceDelta++;
			if(indiceDelta == diffs.length)
				indiceDelta = 0;
			i += diffs[indiceDelta][0];
			j += diffs[indiceDelta][1];
			if(todos[i][j] != null)
			{
				i -= diffs[indiceDelta][0];
				j -= diffs[indiceDelta][1];
				indiceDelta--;
				if(indiceDelta == -1)
					indiceDelta = diffs.length - 1;
				i += diffs[indiceDelta][0];
				j += diffs[indiceDelta][1];
			}
		}
		Scanner sc = new Scanner();
		while(!sc.endLine())
		{
			int n = sc.nextInt();
			long n1 = mapa.get(n);
			j = (int) n1;
			i = (int) (n1 >> 32);
			j -= 500;
			i -= 500;
			System.out.println(i + " " + j);
		}
		
	}

}
