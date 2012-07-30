import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;


public class K 
{
	static class Scanner
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		public String next()
		{
			while(st == null || !st.hasMoreTokens())
			{
				try
				{
					st = new StringTokenizer(br.readLine());
				}
				catch(Exception e)
				{
					throw new RuntimeException(e.getMessage());
				}
			}
			return st.nextToken();
		}
		
		public long nextLong()
		{
			return Long.parseLong(next());
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			sc.next();
			sc.next();
			sc.next();
			long consumo = sc.nextLong();
			long mayor = 0;
			long actual = 0;
			long anterior = 0;
			int numeroLeaks = 0;
			if(consumo == 0)
				return;
			while(true)
			{
				long valor = sc.nextLong();
				actual += (valor - anterior) * (consumo + numeroLeaks * 100);
				mayor = Math.max(mayor, actual);
				anterior = valor;
				String siguiente = sc.next();
				if(siguiente.equals("Goal"))
				{
					System.out.println(new BigDecimal(mayor).divide(new BigDecimal(100), 3, BigDecimal.ROUND_DOWN));
					break;
				}
				if(siguiente.equals("Leak"))
				{
					numeroLeaks++;
				}
				if(siguiente.equals("Mechanic"))
				{
					numeroLeaks = 0;
				}
				if(siguiente.equals("Fuel"))
				{
					sc.next();
					consumo = sc.nextLong();
				}
				if(siguiente.equals("Gas"))
				{
					sc.next();
					actual = 0;
				}
			}
		}
	}

}
