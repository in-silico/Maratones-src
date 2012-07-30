import java.io.InputStreamReader;

public class D 
{
	static class Scanner
	{
		char[] buffer;
		InputStreamReader isr;
		int p;
		int start;
		
		public Scanner()
		{
			buffer = new char[10000000];
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
				else 
					throw(new RuntimeException());
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

	static int[] dishes = new int[501];
	static int[] lds = new int[501];
	static int[] lis = new int[501];
	static int N;
	
	static int maxDish() 
	{
		for(int i = 0; i < N; i++)
			lds[i] = lis[i] = 1;
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < i; j++)
			{
				if(lds[i] < lds[j] + 1 && dishes[i] <= dishes[j])
					lds[i] = lds[j] + 1;
				if(lis[i] < lis[j] + 1 && dishes[i] >= dishes[j])
					lis[i] = lis[j] + 1;
			}
		}
		int max = 0;
		for(int i = 0; i < N; i++)
		{
			double pivote = dishes[i] + 0.5;
			int bestLds = 0;
			int bestLis = 0;
			for(int j = 0; j < N; j++)
			{
				if(dishes[j] <= pivote)
					bestLds = Math.max(bestLds, lds[j]);
				if(dishes[j] >= pivote)
					bestLis = Math.max(bestLis, lis[j]);
				max = Math.max(max, bestLis + bestLds);
			}
			pivote = dishes[i] - 0.5;
			bestLds = 0;
			bestLis = 0;
			for(int j = 0; j < N; j++)
			{
				if(dishes[j] <= pivote)
					bestLds = Math.max(bestLds, lds[j]);
				if(dishes[j] >= pivote)
					bestLis = Math.max(bestLis, lis[j]);
				max = Math.max(max, bestLis + bestLds);
			}
		}
		return max;
	}

	public static void main(String args[]) 
	{
		Scanner in = new Scanner();
		while (true) 
		{
			N = in.nextInt();
			if(N == 0) 
				return;
			for (int i = 0; i < N; i++) 
				dishes[i] = in.nextInt();
			System.out.println(maxDish());
		}
	}
}
