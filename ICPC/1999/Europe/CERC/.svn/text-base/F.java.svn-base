import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class F 
{
	
	static class Moneda
	{
		int peso, costo;
		
		public Moneda(int c, int p)
		{
			costo = c;
			peso = p;
		}
	}
	static ArrayList <Moneda> monedas = new ArrayList <Moneda> (500);
	static int[] mejor = new int[10001];
	

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
		
		public int nextInt() throws IOException
		{
			return (int) nextLong();
		}
		
		public long nextLong() throws IOException
		{
			leer(' ');
			long r = 0;
			boolean n  = b[d] == '-';
			if(n) d++;
			r -= b[d++] - '0';
			while(d <= h && (r *= 10) <= 0)
				r -= b[d++] - '0';
			return n ? r : -r;
		}
		
		public double nextDouble() throws NumberFormatException, IOException
		{
			return Double.parseDouble(next());
		}
	}
	
	
	static int costo(int peso)
	{
		if(peso == 0)
		{
			return 0;
		}
		if(peso < 0)
			return Integer.MAX_VALUE;
		if(mejor[peso] != -1)
			return mejor[peso];
		int menor = Integer.MAX_VALUE;
		for(Moneda m : monedas)
		{
			if(m.peso > peso)
				continue;
			int costo = costo(peso - m.peso);
			if(costo == Integer.MAX_VALUE)
				continue;
			menor = Math.min(menor, costo + m.costo);
		}
		return mejor[peso] = menor;
	}
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner();
		int t = sc.nextInt();
		for(int i = 0; i < t; i++)
		{
			for(int j = 0; j < 10001; j++)
				mejor[j] = -1;
			monedas.clear();
			int a = sc.nextInt();
			int b = sc.nextInt();
			int nm = sc.nextInt();
			for(int j = 0; j < nm; j++)
			{
				int aa = sc.nextInt();
				int bb = sc.nextInt();
				monedas.add(new Moneda(aa, bb));
			}
			int resultado = costo(b - a);
			if(resultado == Integer.MAX_VALUE)
				System.out.println("This is impossible.");
			else
				System.out.println("The minimum amount of money in the piggy-bank is " + resultado + ".");
		}
	}

}
