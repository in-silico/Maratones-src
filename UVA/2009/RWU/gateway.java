import java.io.IOException;
import java.io.InputStreamReader;


public class Gateway
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
		
		static int[] ps = new int[1000001];		
		static int[] qs = new int[1000001];
		
		static int[] ns = new int[100];

		public static void main(String[] args) throws IOException
		{
			Scanner sc = new Scanner();
			int t = sc.nextInt();
			for(int cs = 1; cs <= t; cs++)
			{
				int p = sc.nextInt();
				for(int i = 0; i < p; i++)
					ns[i] = sc.nextInt();
				int n = sc.nextInt();
				long p0 = sc.nextInt();
				long q0 = sc.nextInt();
				long a = sc.nextInt();
				long b = sc.nextInt();
				long c = sc.nextInt();
				long d = sc.nextInt();
				long e = sc.nextInt();
				long f = sc.nextInt();
				long m = sc.nextInt();
				ps[0] = (int) p0;
				qs[0] = (int) q0;
				for(int i = 1; i <= n; i++)
				{
					long pant = ps[i - 1];
					long qant = qs[i - 1];
					ps[i] = (int) ((a * pant + b * qant + c) % m);
					qs[i] = (int) ((d * pant + e * qant + f) % m);
					if(qs[i] < ps[i])
					{
						int temp = qs[i];
						qs[i] = ps[i];
						ps[i] = temp;
					}
				}
				int cuenta = 0;
				for(int i = 1; i <= n - p + 1; i++)
				{
					boolean mal = false;
					for(int j = 0; j < p; j++)
					{
						int ij = i + j;
						if(ns[j] > qs[ij] || ns[j] < ps[ij])
						{
							mal = true;
							break;
						}
					}
					if(!mal)
						cuenta++;
				}
				System.out.println("Case " + cs + ": " + cuenta);
			}
		}
		

}
