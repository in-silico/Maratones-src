import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

public class pachinko
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
	
	static class Linea implements Comparable <Linea>
	{
		double x1, x2, y1, y2;
		
		public Linea(double x1, double y1, double x2, double y2)
		{
			if(x1 < x2)
			{
				this.x1 = x1;
				this.y1 = y1;
				this.x2 = x2;
				this.y2 = y2;
			}
			else
			{
				this.x2 = x1;
				this.y2 = y1;
				this.x1 = x2;
				this.y1 = y2;
			}
		}

		@Override
		public int compareTo(Linea otra) 
		{
			int res = 0;
			if((res = new Double(x1).compareTo(otra.x1)) == 0)
				return -new Double(y1).compareTo(otra.y1);
			return res;
		}
	}
	
	static Linea[] lineas = new Linea[500];
	static int n;
	
	public static void main(String [] args) throws NumberFormatException, IOException
	{
		Scanner sc = new Scanner();
		while(true)
		{
			n = sc.nextInt();
			if(n == -1)
				return;
			for(int i = 0; i < n; i++)
			{
				lineas[i] = new Linea(sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
			}
			Arrays.sort(lineas, 0, n);
			boolean prueba = false;
			int i = -100;
			while(!prueba && i != 101)
			{
				prueba |= simular(i);
				i++;
			}
			if(prueba)
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}
	private static boolean simular(int entrada) 
	{
		double y = 101;
		double x = entrada;
		while(true)
		{
			double yMayor = -1;
			Linea primera = null;
			for(int i = 0; i < n; i++)
			{
				Linea actual = lineas[i];
				if(actual.x1 > x || actual.x2 < x)
					continue;
				double[] v = new double[]{actual.x2 - actual.x1, actual.y2 - actual.y1};
				double yAnterior = yMayor;
				double yNuevo;
				try
				{
					yNuevo = (((x - actual.x1) * v[1]) / (v[0])) + actual.y1;
				}
				catch(Exception e)
				{
					continue;
				}
				if(yNuevo >= y)
					continue;
				yMayor = Math.max(yMayor, yNuevo);
				if(yAnterior != yMayor)
					primera = actual;
			}
			if(primera == null)
				return x >= -10 && x <= 10;
			if(primera.y1 > primera.y2)
			{
				y = primera.y2;
				x = primera.x2;
			}
			else
			{
				y = primera.y1;
				x = primera.x1;
			}
		}
	}
}
