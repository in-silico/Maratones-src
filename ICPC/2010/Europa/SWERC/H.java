import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

//DP - O(n³*k²)
public class H {


	static TreeMap<Character, Integer> mapa = new TreeMap <Character, Integer> ();
	static TreeMap<Integer, Character> mapa2 = new TreeMap <Integer, Character> ();

	static int matrizR[][] = new int[26][26];
	static int matrizT[][] = new int[26][26];
	static long dp[][][] = new long[200][200][];
	static int este[] = new int[200];
	static int k;

	static long[] solucionar(int desde, int hasta)
	{
		if(dp[desde][hasta] != null)
			return dp[desde][hasta];
		if(desde == hasta)
		{
			long[] resultado = new long[k];
			for(int i = 0; i < k; i++)
				resultado[i] = -1;
			resultado[este[desde]] = 0;
			return dp[desde][hasta] = resultado;
		}
		else
		{
			long[] resultado = new long[k];
			for(int i = 0; i < k; i++)
				resultado[i] = -1;
			for(int i = desde; i < hasta; i++)
			{
				long[] parteA = solucionar(desde, i);
				long[] parteB = solucionar(i + 1, hasta);
				for(int j = 0; j < k; j++)
				{
					if(parteA[j] == -1)
						continue;
					for(int m = 0; m < k; m++)
					{
						if(parteB[m] == -1)
							continue;
						int donde = matrizR[j][m];
						long cuanto = matrizT[j][m] + parteA[j] + parteB[m];
						if(resultado[donde] == -1)
							resultado[donde] = cuanto;
						else if(resultado[donde] > cuanto)
							resultado[donde] = cuanto;
					}
				}
			}
			return dp[desde][hasta] = resultado;
		}
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int empezo = 0;
		for(int i = 0; i < 200; i++)
			for(int j = 0; j < 200; j++)
				dp[i][j] = null;
		while(true)
		{
			k = Integer.parseInt(br.readLine());
			if(k == 0)
				break;
			if(empezo++ != 0)
				System.out.println();
			mapa.clear();
			mapa2.clear();
			String[] pedazos = br.readLine().split(" ");
			for(int i = 0; i < k; i++)
			{
				char este = pedazos[i].charAt(0);
				mapa.put(este, i);
				mapa2.put(i, este);
			}
			for(int i = 0; i < k; i++)
			{
				pedazos = br.readLine().split(" ");
				for(int j = 0; j < k; j++)
				{
					String[] pedazosI = pedazos[j].split("-");
					int t = Integer.parseInt(pedazosI[0]);
					char lec = pedazosI[1].charAt(0);
					matrizR[i][j] = mapa.get(lec);
					matrizT[i][j] = t;
				}
			}
			for(int i = 0; i < 200; i++)
				for(int j = 0; j < 200; j++)
					dp[i][j] = null;
			int n = Integer.parseInt(br.readLine());
			for(int i = 0; i < n; i++)
			{
				char[] lectura = br.readLine().toCharArray();
				int tam = lectura.length;
				for(int j = 0; j < tam; j++)
					este[j] = mapa.get(lectura[j]);
				for(int j = 0; j < tam; j++)
					for(int m = 0; m < tam; m++)
						dp[j][m] = null;
				long[] respuesta = solucionar(0, tam - 1);
				int posMejor = 0;
				long valMejor = Long.MAX_VALUE;
				for(int j = 0; j < k; j++)
					if(respuesta[j] == -1)
						continue;
					else
						if(respuesta[j] < valMejor)
						{
							valMejor = respuesta[j];
							posMejor = j;
						}
				System.out.println(valMejor + "-" + mapa2.get(posMejor));
			}
		}
	}
}
