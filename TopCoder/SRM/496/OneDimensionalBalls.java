import java.util.TreeSet;

public class OneDimensionalBalls
{
	TreeSet <Integer> iniciales = new TreeSet <Integer> ();
	TreeSet <Integer> finales = new TreeSet <Integer> ();
	TreeSet <Integer> distancias = new TreeSet <Integer> ();
	
	int[] actuales = new int[51];
	int tamano;
	int distancia;
	
	public long countValidGuesses(int[] firstPicture, int[] secondPicture)
	{
		finales.clear();
		distancias.clear();
		for(int i : secondPicture)
			finales.add(i);
		iniciales.clear();
		for(int j : firstPicture)
			iniciales.add(j);
		for(int i : iniciales)
			for(int j : finales)
			{
				if(i != j)
					distancias.add(Math.abs(i - j));
			}
		long total = 0;
		for(int i : distancias)
		{
			iniciales.clear();
			for(int j : firstPicture)
				iniciales.add(j);
			long acum = 1;
			distancia = i;
			while(!iniciales.isEmpty())
				if(acum != 0)
					acum *= iniciar(iniciales.first());
				else
					break;
			total += acum;
		}
		return total;
	}
	
	public long iniciar(int i)
	{
		tamano = 0;
		int actual = i;
		while(true)
		{
			iniciales.remove(actual);
			if(finales.contains(actual - distancia) || finales.contains(actual + distancia))
			{
				actuales[tamano++] = actual;
				if(finales.contains(actual + distancia) && iniciales.contains(actual + (distancia << 1)))
				{
					actual = actual + (distancia << 1);
				}
				else
					break;
					
			}
			else
				return 0;
		}
		for(int j = 0; j < tamano; j++)
			dp[j][0] = dp[j][1] = null;
		return dp(0, 0);
	}

	Long[][] dp = new Long[51][2];
	
	private long dp(int i, int j) 
	{
		if(i == tamano)
			return 1;
		if(dp[i][j] != null)
			return dp[i][j];
		int actual = actuales[i];
		if(j == 0)
		{
			long acum = 0;
			if(finales.contains(actual - distancia))
				acum += dp(i + 1, 0);
			if(finales.contains(actual + distancia))
				acum += dp(i + 1, 1);
			return dp[i][j] = acum;
		}
		else
		{
			long acum = 0;
			if(finales.contains(actual + distancia))
				acum += dp(i + 1, 1);
			return dp[i][j] = acum;
		}
	}
}