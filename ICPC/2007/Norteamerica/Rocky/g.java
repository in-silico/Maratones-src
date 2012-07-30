import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class g
{
	
	static byte[][][] dp = new byte[8192][109][14]; // 12 MB
	
	static void poner(int set, int menor, int mayor)
	{
		dp[set][menor][mayor / 8] |= 1 << (mayor % 8);
	}
	
	static boolean dar(int set, int menor, int mayor)
	{
		byte valor = dp[set][menor][mayor / 8];
		valor >>= (mayor % 8);
		valor &= 1;
		return valor == 1;
	}
	
	static int mejor;
	static int tam;
	static int maximo;
	static int[] valores = new int[13];
	
	static int contar(int set)
	{
		int suma = 0;
		for(int i = 0; i < tam; i++)
		{
			if(((set >> i) & 1) == 1)
			{
				suma += valores[i];
			}
		}
		return suma;
	}
	static void dp(int set, int menor, int mayor)
	{
		if(menor > maximo || mayor > maximo)
			return;
		if(dar(set, menor, mayor))
			return;
		poner(set, menor, mayor);
		if(menor == mayor && menor != 0)
		{
			int otro = contar(set);
			if(otro == mayor)
				mejor = Math.max(mejor, mayor);
		}
		else
		{
			for(int i = 0; i < tam; i++)
			{
				if(((set >> i) & 1) == 1)
				{
					int siguiente = set ^ (1 << i);
					dp(siguiente, menor, mayor);
					int menorSiguiente = menor + valores[i];
					if(menor != 0)
					{
						dp(siguiente, Math.min(mayor, menorSiguiente), Math.max(mayor, menorSiguiente));
					}
					else
					{
						for(int j = 0; j < tam; j++)
						{
							if(i == j)
								continue;
							if(((set >> j) & 1) == 1)
							{
								int siguiente2 = siguiente ^ (1 << j);
								int menorSiguiente2 = menorSiguiente + valores[j];
								if(menorSiguiente2 != mayor)
									dp(siguiente2, Math.min(mayor, menorSiguiente2), Math.max(mayor, menorSiguiente2));
							}
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caso = 1;
		while(true)
		{
			String[] pedazos = br.readLine().split("\\s+");
			tam = Integer.parseInt(pedazos[0]);
			if(tam == 0)
				return;
			for(int i = 0; i < tam; i++)
				valores[i] = Integer.parseInt(pedazos[i + 1]);
			mejor = 0;
			int set = 1 << tam;
			set -= 1;
			maximo = contar(set) / 3;
			for(int i = 0; i <= set; i++)
				for(int j = 0; j <= maximo; j++)
					for(int k = 0; k < 14; k++)
						dp[i][j][k] = 0;
			dp(set, 0, 0);
			System.out.println("Case " + caso++ + ": " + mejor);
		}
	}

}
