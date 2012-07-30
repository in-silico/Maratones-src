import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;


public class C 
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
	
	
	static boolean[] noPrimos = new boolean[1000000];
	
	static class Factor implements Comparable <Factor>
	{
		int nf;
		int nv;
		
		public Factor(int n)
		{
			nf = n;
			nv = 1;
		}

		@Override
		public int compareTo(Factor o) 
		{
			return Integer.valueOf(nf).compareTo(o.nf);
		}
		
		@Override
		public String toString() {
			return nf + "^" + nv;
		}
	}
	
	public static LinkedList <Factor> factoresPrimosDe(int n)
	{
		LinkedList <Factor> resultado = new LinkedList <Factor> ();
		if(n == 1)
		{
			return resultado;
		}
		if(!noPrimos[n])
		{
			resultado.add(new Factor(n));
			return resultado;
		}
		while(n != 1)
		{
			if(!noPrimos[n])
			{
				boolean esta  = false;
				for(Factor f : resultado)
				{
					if(f.nf == n)
					{
						f.nv++;
						esta = true;
						break;
					}
				}
				if(!esta)
				{
					resultado.add(new Factor(n));
					return resultado;
				}
				return resultado;
			}
			for(int i = 2; i <= n; i++)
			{
				if(n % i == 0)
				{
					boolean esta  = false;
					for(Factor f : resultado)
					{
						if(f.nf == i)
						{
							f.nv++;
							esta = true;
							break;
						}
					}
					if(!esta)
					{
						resultado.add(new Factor(i));
					}
					n /= i;
					break;
				}
			}
		}
		return resultado;
	}
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner();
		for(int i = 2; i < 1000000; i++)
		{
			if(!noPrimos[i])
			{
				for(int j = i + i; j < 1000000; j += i)
				{
					noPrimos[j] = true;
				}
			}
		}
		int k = 1;
		while(true)
		{
			int na = sc.nextInt();
			int nb = sc.nextInt();
			if(na == 0 && nb == 0)
				return;
			LinkedList <Factor> factoresA = factoresPrimosDe(na);
			LinkedList <Factor> factoresB = factoresPrimosDe(nb);
			Collections.sort(factoresA);
			Collections.sort(factoresB);
			int cuentaDim = 0;
			int cuentaDif = 0;
			while(!factoresA.isEmpty() || !factoresB.isEmpty())
			{
				Factor posibleA = factoresA.peek();
				Factor posibleB = factoresB.peek();
				if(posibleA == null)
				{
					for(Factor b : factoresB)
					{
						cuentaDim++;
						cuentaDif += b.nv;
					}
					break;
				}
				if(posibleB == null)
				{
					for(Factor b : factoresA)
					{
						cuentaDim++;
						cuentaDif += b.nv;
					}
					break;
				}
				if(posibleA.nf == posibleB.nf)
				{
					cuentaDim++;
					cuentaDif += Math.abs(posibleA.nv - posibleB.nv);
					factoresA.removeFirst();
					factoresB.removeFirst();
				}
				else if(posibleA.nf > posibleB.nf)
				{
					cuentaDim++;
					cuentaDif += posibleB.nv;
					factoresB.removeFirst();
				}
				else
				{
					cuentaDim++;
					cuentaDif += posibleA.nv;
					factoresA.removeFirst();
				}
			}
			System.out.println(k++ + ". " + cuentaDim + ":" + cuentaDif);
		}
	}

}
