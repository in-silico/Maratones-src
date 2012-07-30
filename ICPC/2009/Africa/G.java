import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class G 
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

	
	static class Empresa
	{
		int numero;
		ArrayList <Integer> controla = new ArrayList <Integer> (235);
		ArrayList <Integer> loControla = new ArrayList <Integer> (235);
		boolean[] loControlaHash = new boolean[235];
		boolean[] controlaHash = new boolean[235];
		
		public Empresa(int n)
		{
			numero = n;
		}
		
		public void limpiar()
		{
			controla.clear();
			loControla.clear();
			for(int i = 0; i < 235; i++)
				loControlaHash[i] = controlaHash[i] = false;
		}
		
		public void agregarControl(Empresa a)
		{
			if(!controlaHash[a.numero])
			{
				controlaHash[a.numero] = true;
				controla.add(a.numero);
				for(int x : a.controla)
				{
					agregarControl(empresas[x]);
					empresas[x].agregarLoControla(this);
				}
				for(int x : loControla)
				{
					empresas[x].agregarControl(a);
					a.agregarLoControla(empresas[x]);
				}
			}
		}

		public void agregarLoControla(Empresa a) 
		{
			if(!loControlaHash[a.numero])
			{
				loControlaHash[a.numero] = true;
				loControla.add(a.numero);
				for(int x : a.loControla)
				{
					agregarLoControla(empresas[x]);
					empresas[x].agregarControl(this);
				}
				for(int x : controla)
				{
					empresas[x].agregarLoControla(a);
					a.agregarControl(empresas[x]);
				}
			}
		}
	}
	
	static Empresa[] empresas = new Empresa[235];
	public static void main(String[] args) throws IOException
	{
		int k = 1;
		Scanner sc = new Scanner();
		for(int i = 0; i < 235; i++)
			empresas[i] = new Empresa(i);
		while(true)
		{
			for(int i = 0; i < 235; i++)
				empresas[i].limpiar();
			int n = sc.nextInt();
			int t = sc.nextInt();
			if(n == 0 && t == 0)
				System.exit(0);
			int rejected = 0;
			for(int i = 0; i < t; i++)
			{
				int aa = sc.nextInt();
				int bb = sc.nextInt();
				if(aa == bb)
				{
					rejected++;
					continue;
				}
				Empresa a = empresas[aa];
				Empresa b = empresas[bb];
				boolean rej = false;
				for(int x : a.loControla)
				{
					if(x == bb)
					{
						rejected++;
						rej = true;
						break;
					}
				}
				if(!rej)
				{
					a.agregarControl(b);
					b.agregarLoControla(a);
				}
			}
//			for(int i = 1; i <= 15; i++)
//			{
//				System.out.print(i + " lo controlan:");
//				for(int j : empresas[i].loControla)
//					System.out.print(" " + j);
//				System.out.print(" Controla:");
//				for(int j : empresas[i].controla)
//					System.out.print(" " + j);
//				System.out.println();
//			}
			System.out.println(k++ + ". " + rejected);
		}
	}

}
