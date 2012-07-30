import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;


public class turing 
{
	static class Scanner
	{
		static InputStreamReader isr;
		char buffer[];
		int pos = -1, desde, hasta, tam;
		
		public Scanner()
		{
			buffer = new char[250000];
			try 
			{
				isr = new InputStreamReader(System.in);
				isr.read(buffer);
			} 
			catch (IOException e) 
			{
				throw(new RuntimeException());
			}
		}
		
		public void leer()
		{
			try
			{
				while(buffer[++pos] <= ' ');
				desde = pos;
				hasta = desde - 1;
				while(buffer[++hasta] > ' ');
				pos = hasta;
				hasta--;
			}
			catch(Exception e)
			{
				if(pos == buffer.length)
					try
					{
						pos = -1;
						int leidos = isr.read(buffer);
						if(leidos < buffer.length)
							buffer[leidos] = '\0';
						leer();
					}
					catch(Exception e1)
					{
						throw(new RuntimeException());
					}
				else
					try
					{
						int hastaDesde = hasta - desde;
						System.arraycopy(buffer, desde, buffer, 0, hastaDesde);
						int leidos = isr.read(buffer, hastaDesde, buffer.length - hastaDesde);
						if(hastaDesde + leidos < buffer.length)
							buffer[hastaDesde + (leidos == -1 ? 0 : leidos)] = '\0';
						pos = -1;
						desde = 0;
						leer();
					}
					catch(Exception e1)
					{
						throw(new RuntimeException());
					}
			}
		}
		
		public String next()
		{
			leer();
			return new String(buffer, desde, hasta - desde + 1);
		}
		
		public int nextInt()
		{
			leer();
			int resultado = 0;
			boolean negativo = buffer[desde] == '-';
			if(negativo)
				desde++;
			resultado -= buffer[desde++] - '0';
			while (desde <= hasta && (resultado *= 10) <= 0) 
				resultado -= buffer[desde++] - '0';
			return negativo ? resultado : -resultado;
		}
		
		public long nextLong()
		{
			leer();
			long resultado = 0;
			boolean negativo = buffer[desde] == '-';
			if(negativo)
				desde++;
			resultado -= buffer[desde++] - '0';
			while (desde <= hasta && (resultado *= 10) <= 0) 
				resultado -= buffer[desde++] - '0';
			return negativo ? resultado : -resultado;
		}
		
		public double nextDouble()
		{
			return Double.parseDouble(next());
		}
		
		public BigInteger nextBigInteger()
		{
			return new BigInteger(next());
		}
		
		public BigDecimal nextBigDecimal()
		{
			return new BigDecimal(next());
		}
	}
	
	static class Regla
	{
		int qnext;
		int cnext;
		boolean derecha;

		
		public Regla(int q, int c, boolean d)
		{
			qnext = q;
			cnext = c;
			derecha = d;
		}
	}
	
	static Regla[][] reglas = new Regla[1001][2];
	static int[] turing = new int[1000];
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			if(n == 0 && m == 0)
				return;
			for(int i = 0; i < 1001; i++)
			{
				reglas[i][0] = null;
				reglas[i][1] = null;
			}
			for(int i = 0; i < n; i++)
			{
				int qprev = sc.nextInt();
				int cprev = sc.nextInt();
				int qnext = sc.nextInt();
				int cnext = sc.nextInt();
				boolean derecha = sc.next().equals("R");
				reglas[qprev][cprev] = new Regla(qnext, cnext, derecha);
			}
			for(int i = 0; i < m; i++)
			{
				int x = sc.nextInt();
				int y = sc.nextInt();
				for(int j = 0; j < x; j++)
					turing[j] = 1;
				for(int j = x; j < 1000; j++)
					turing[j] = 0;
				int cuenta = 0, actual = 0, cabeza = 0;
				boolean termino = false;
				while(cuenta++ < 10000)
				{
					Regla esta = reglas[actual][turing[cabeza]];
					if(esta == null)
					{
						for(int j = 0; j < y; j++)
							if(turing[j] == 0)
							{
								System.out.println("WA");
								termino = true;
								break;
							}
						if(!termino)
						{
							for(int j = y; j < 1000; j++)
								if(turing[j] == 1)
								{
									System.out.println("WA");
									termino = true;
									break;
								}
							if(!termino)
								System.out.println("AC");
							termino = true;
						}
						break;
					}
					if((esta.derecha && cabeza == 999) || (!esta.derecha && cabeza == 0))
					{
						System.out.println("MLE");
						termino = true;
						break;
					}
					else
					{
						turing[cabeza] = esta.cnext;
						if(esta.derecha)
							cabeza++;
						else
							cabeza--;
						actual = esta.qnext;
					}
				}
				if(!termino)
					System.out.println("TLE");
			}
		}
	}
}
