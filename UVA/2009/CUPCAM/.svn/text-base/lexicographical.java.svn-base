import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


public class lexicographical
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
				int leidos = isr.read(buffer);
				if(leidos != buffer.length)
					buffer[leidos] = '\0';
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
		
		public void leerLinea()
		{
			try
			{
				if(buffer[pos + 1] == '\0')
				{
					desde = hasta = -1;
					return;
				}
				while(buffer[++pos] <= ' ' && buffer[pos] != '\n' && buffer[pos] != '\r');
				if(buffer[pos] == '\n' || buffer[pos] == '\r')
					pos++;
				desde = pos;
				hasta = desde - 1;
				while(buffer[++hasta] != '\n' && buffer[hasta] != '\r' && buffer[hasta] != '\0');
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
						leerLinea();
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
						leerLinea();
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
		
		public String nextLn()
		{
			try 
			{
				if((pos != -1 && buffer[pos] == '\0') || (pos == buffer.length && !isr.ready()))
					return null;
			} 
			catch (IOException e) 
			{
			}
			leerLinea();
			if(desde == -1)
				return null;
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
	}
	
	static long[] cuenta = new long[22];
	static String palabraOrdenada;
	static char[] ordenadas;
	
	public static long resolver(String n)
	{
		ordenadas = n.toCharArray();
		Arrays.sort(ordenadas);
		palabraOrdenada = new String(ordenadas);
		String palabraOrdenada = new String(ordenadas);
		long acumulado = 0;
		while(n.length() > 0)
		{
			acumulado += cuenta[20 - n.length()] * palabraOrdenada.indexOf(n.charAt(0)) + 1;
			palabraOrdenada = palabraOrdenada.replace(n.charAt(0) + "", "");
			n = n.substring(1);
		}
		return acumulado;
	}

	static boolean[] quitadas = new boolean[20];
	
	public static char darCaracter(int n)
	{
		n++;
		int i = 0;
		int j = 0;
		while(i < palabraOrdenada.length() && j != n)
			if(!quitadas[i++])
				j++;
		quitadas[i - 1] = true;
		return ordenadas[i - 1];
	}
	
	static char[] aImprimir = new char[21];
	
	public static void imprimir(long n)
	{
		int actual = palabraOrdenada.length();
		for(int i = 0; i < actual; i++) quitadas[i] = false;
		int i = 0;
		while(actual > 0 && n != 0)
		{
			long caracter = --n / cuenta[20 - actual];
			aImprimir[i++] = darCaracter((int) caracter);
			n %= cuenta[20 - actual--];
		}
		aImprimir[i] = '\n';
		try 
		{
			bw.write(aImprimir, 0, i + 1);
		} 
		catch (IOException e) 
		{
		}
	}
	
	static BufferedWriter bw;
	
	public static void main(String [] args) throws IOException
	{
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		cuenta[19] = 1;
		cuenta[18] = 2;
		for(int i = 17; i >= 0; i--)
		{
			cuenta[i] = cuenta[i + 1] * (19 - i) + 1; 
		}
		Scanner sc = new Scanner();
		String linea = sc.nextLn();
		while(true)
		{
			bw.write(resolver(linea) + "\n");
			while(true)
			{
				linea = sc.nextLn();
				if(linea == null || linea.equals("\n") || linea.equals("\r"))
				{
					bw.flush();
					return;
				}
				if(linea.charAt(0) >= 'a' && linea.charAt(0) <= 'z')
					break;
				if(linea.charAt(0) >= '0' && linea.charAt(0) <= '9')
				{
					imprimir(Long.parseLong(linea));
				}
				else
					break;
			}
		}
	}
}
