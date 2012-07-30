import java.io.InputStreamReader;


public class C
{
	static class Scanner
	{
		char[] buffer;
		InputStreamReader isr;
		int p;
		int start;
		
		public Scanner()
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
	
	static long[] paises = new long[51];
	static int n, m;
	static long[][] combinatoria = new long[400][5];
	
	static long combinatoria(int a, int b)
	{
		if(combinatoria[a][b] != 0)
			return combinatoria[a][b];
		if(b == 2)
		{
			long al = a;
			return combinatoria[a][b] = (al * (al - 1)) / 2;
		}
		if(b == 3)
		{
			long al = a;
			return combinatoria[a][b] = (al * (al - 1) * (al - 2)) / 6;
		}
		else
		{
			long al = a;
			return combinatoria[a][b] = (al * (al - 1) * (al - 2) * (al - 3)) / 24;
		}
	}
	
	static long[][] dpTres = new long[51][4];
	
	static long intentarTres(int actual, int acum)
	{
		if(dpTres[actual][acum] != -1)
			return dpTres[actual][acum];
		if(actual == m)
			return 0;
		if(paises[actual] == 0)
			return dpTres[actual][acum] = intentarTres(actual + 1, acum);
		if(acum == 2)
			return dpTres[actual][acum] = paises[actual] + intentarTres(actual + 1, acum);
		else
			return dpTres[actual][acum] = paises[actual] * intentarTres(actual + 1, acum + 1) + intentarTres(actual + 1, acum);
	}
	
	static long calcularTres()
	{
		long acum = 0;
		for(int i = 0; i <= m; i++)
		{
			if(i != m && paises[i] >= 3)
				acum += combinatoria((int) paises[i], 3);
			for(int j = 0; j < 4; j++)
				dpTres[i][j] = -1;
		}
		return acum + intentarTres(0, 0);
		
	}
	
	static long[][] dpCuatroR = new long[51][5];
	
	static long intentarCuatroR(int actual, int acum)
	{
		if(dpCuatroR[actual][acum] != -1)
			return dpCuatroR[actual][acum];
		if(actual == m)
			return 0;
		if(paises[actual] == 0)
			return dpCuatroR[actual][acum] = intentarCuatroR(actual + 1, acum);
		if(acum == 3)
			return dpCuatroR[actual][acum] = paises[actual] + intentarCuatroR(actual + 1, acum);
		long a = 0;
		if(paises[actual] >= 4 && acum == 0)
			a += combinatoria((int) paises[actual], 4);
		if(paises[actual] >= 3 && acum == 0)
			a += combinatoria((int) paises[actual], 3) * intentarCuatroR(actual + 1, 3);
		if(paises[actual] >= 3 && acum == 1)
			a += combinatoria((int) paises[actual], 3);
		if(acum != 1)
			a += paises[actual] * intentarCuatroR(actual + 1, acum + 1);
		return dpCuatroR[actual][acum] = a + intentarCuatroR(actual + 1, acum);
	}

	static long[][][] dpCuatro = new long[51][5][2];
	
	static long intentarCuatro(int actual, int acum, int doble)
	{
		if(dpCuatro[actual][acum][doble] != -1)
			return dpCuatro[actual][acum][doble];
		if(actual == m)
			return 0;
		if(paises[actual] == 0)
			return dpCuatro[actual][acum][doble] = intentarCuatro(actual + 1, acum, doble);
		if(acum == 3)
			return dpCuatro[actual][acum][doble] = paises[actual] + intentarCuatro(actual + 1, acum, doble);
		else if(acum == 2)
		{
			if(doble == 1)
				return dpCuatro[actual][acum][doble] = paises[actual] * intentarCuatro(actual + 1, acum + 1, doble) + intentarCuatro(actual + 1, acum, doble);
			else
			{
				if(paises[actual] == 1)
					return dpCuatro[actual][acum][doble] = paises[actual] * intentarCuatro(actual + 1, acum + 1, doble) + intentarCuatro(actual + 1, acum, doble);
				else
					return dpCuatro[actual][acum][doble] = paises[actual] * intentarCuatro(actual + 1, acum + 1, doble) + combinatoria((int) paises[actual], 2) + intentarCuatro(actual + 1, acum, doble);
			}
				
		}
		else
		{
			if(paises[actual] == 1)
				return dpCuatro[actual][acum][doble] = paises[actual] * intentarCuatro(actual + 1, acum + 1, doble) + intentarCuatro(actual + 1, acum, doble);
			else
				return dpCuatro[actual][acum][doble] = paises[actual] * intentarCuatro(actual + 1, acum + 1, doble) + combinatoria((int) paises[actual], 2) * intentarCuatro(actual + 1, acum + 2, 1) + intentarCuatro(actual + 1, acum, doble);
		}
		
	}
	
	static long calcularCuatro()
	{
		long acum = 0;
		for(int i = 0; i <= m; i++)
			for(int j = 0; j < 5; j++)
				dpCuatroR[i][j] = -1;
		acum += intentarCuatroR(0, 0);	
		for(int i = 0; i <= m; i++)
			for(int j = 0; j < 5; j++)
				for(int k = 0; k < 2; k++)
					dpCuatro[i][j][k] = -1;
		acum += intentarCuatro(0, 0, 0);	
		return acum;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			n = sc.nextInt();
			m = sc.nextInt();
			if(n == 0 && m == 0)
				return;
			for(int i = 0; i < m; i++)
				paises[i] = 0;
			for(int i = 0; i < n; i++)
				paises[sc.nextInt() - 1]++;
			System.out.println(calcularTres() + " " + calcularCuatro());
		}
	}
}