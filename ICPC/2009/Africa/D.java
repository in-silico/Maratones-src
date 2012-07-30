import java.io.IOException;
import java.io.InputStreamReader;


public class D
{
	
	static class Scanner 
	{
		InputStreamReader i;
		char b[];
		int p = -1, d, h, l;
		boolean fin;
		
		public Scanner() throws IOException 
		{
			b = new char[152];
			i = new InputStreamReader(System.in);
			l = i.read(b);
		}
		
		public void leer(char c) throws IOException 
		{
			try
			{
				if(fin)
					b = new char[2000000000];
				while(b[++p] <= c && p < l);
				d = p;
				fin |= d >= l;
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
				if(z + (l == -1 ? 0 : l) < b.length)
					b[z + (l == -1 ? 0 : l)] = '\0';
				l += z;
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
	
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner();
		int k = 1;
		while(true)
		{
			int n0 = sc.nextInt();
			if(n0 == 0)
				return;
			int n1 = n0 * 3;
			boolean par = n1 % 2 == 0;
			int n2 = par ? n1 / 2 : (n1 + 1) / 2;
			int n3 = 3 * n2;
			int n4 = n3 / 9;
			System.out.println(k++ + ". " + (par ? "even" : "odd") + " " + n4);
		}
	}

}
