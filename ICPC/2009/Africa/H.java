import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class H 
{
	
	static class Scanner 
	{
		InputStreamReader i;
		char b[];
		int p = -1, d, h, l;
		boolean fin;
		
		public Scanner() throws IOException 
		{
			b = new char[5000000];
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
	
	static class Ciudad implements Comparable <Ciudad>
	{
		int n;
		int punto;
		
		public Ciudad(int p)
		{
			punto = p;
			n = 1;
		}
		@Override
		public int compareTo(Ciudad o) 
		{
			return Integer.valueOf(punto).compareTo(o.punto);
		}
		@Override
		public String toString() {
			return "Ciudad [n=" + n + ", punto=" + punto + "]";
		}
	}
	
	static int n = 0, k = 0;
	
	public static int intentar(ArrayList <Ciudad> posibles)
	{
		int mejorCuenta = n;
		int kActual = k;
		int cuentaActual = 0;
		int cuentaActualK = 0;
		int numeroDivisiones = 0;
		int diferenciaActual = Math.abs(mejorCuenta - cuentaActual);
		int acumulado = 0;
		for(Ciudad c : posibles)
		{
			if(numeroDivisiones == k - 1)
			{
				cuentaActualK += c.n * k;
			}
			else
			{
				int posibleCuenta = cuentaActual + c.n * kActual;
				int posibleDiferencia = Math.abs(mejorCuenta - posibleCuenta);
				boolean deTodas = false;
				if(posibleDiferencia == diferenciaActual)
				{
					int mejorCuentaH = mejorCuenta - (cuentaActualK + c.n * k) / k;
					double dejando = ((double) mejorCuentaH) / (kActual - 1);
					double actual = ((double) mejorCuenta) / kActual;
					if((actual - dejando) * 20 >= actual)
						deTodas = true;
				}
				if(posibleDiferencia < diferenciaActual || deTodas)
				{
					cuentaActual = posibleCuenta;
					cuentaActualK = cuentaActualK + c.n * k;
					diferenciaActual = posibleDiferencia;
				}
				else
				{
					numeroDivisiones++;
					acumulado += Math.abs(cuentaActualK - n);
					kActual--;
					mejorCuenta -= cuentaActualK / k;
					cuentaActual = c.n * kActual;
					cuentaActualK = c.n * k;
					diferenciaActual = Math.abs(mejorCuenta - cuentaActual);
				}
			}
		}
		acumulado += Math.abs(cuentaActualK - n);
		if(numeroDivisiones != k - 1)
		{
			int numeroFaltantes = k - 1 - numeroDivisiones;
			acumulado += numeroFaltantes * n;
		}
		return acumulado;
	}
	
	static int nc = 1;
	
	public static void main(String[] args) throws IOException
	{
		System.setIn(new FileInputStream("H.in"));
		Scanner sc = new Scanner();
		ArrayList <Ciudad> ciudadesX = new ArrayList <Ciudad> (100000);
		ArrayList <Ciudad> ciudadesY = new ArrayList <Ciudad> (100000);
		ArrayList <Ciudad> ciudadesXF = new ArrayList <Ciudad> (100000);
		ArrayList <Ciudad> ciudadesYF = new ArrayList <Ciudad> (100000);
		while(true)
		{
			n = sc.nextInt();
			k = sc.nextInt();
			if(n == 0 && k == 0)
				return;
			ciudadesX.clear();
			ciudadesY.clear();
			ciudadesXF.clear();
			ciudadesYF.clear();
			for(int i = 0; i < n; i++)
			{
				ciudadesX.add(new Ciudad(sc.nextInt()));
				ciudadesY.add(new Ciudad(sc.nextInt()));
			}
			Collections.sort(ciudadesX);
			Collections.sort(ciudadesY);
			Ciudad anterior = ciudadesX.get(0);
			ciudadesXF.add(anterior);
			int i = 0;
			for(Ciudad c : ciudadesX)
			{
				if(i++ == 0)
					continue;
				if(c.punto == anterior.punto)
					anterior.n++;
				else
				{
					ciudadesXF.add(c);
					anterior = c;
				}
			}
			i = 0;
			anterior = ciudadesY.get(0);
			ciudadesYF.add(anterior);
			for(Ciudad c : ciudadesY)
			{
				if(i++ == 0)
					continue;
				if(c.punto == anterior.punto)
					anterior.n++;
				else
				{
					ciudadesYF.add(c);
					anterior = c;
				}
			}
			int cuenta = intentar(ciudadesXF);
			cuenta = Math.min(cuenta, intentar(ciudadesYF));
			k *= k;
			int gcd = gcd(cuenta, k);
			cuenta /= gcd;
			k /= gcd;
			System.out.println(nc++ + ". " + cuenta + "/" + k);
		}
	}

	private static int gcd(int a, int b) 
	{
		if(b == 0)
			return a;
		return gcd(b, a % b);
	}

	
}
