import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class guessing 
{
	static Integer[][] arregloMejor = new Integer[1001][21];
	
	public static int mejor(int nPosibles, int iPosibles)
	{
		if(arregloMejor[nPosibles][iPosibles] != null)
		{
			return arregloMejor[nPosibles][iPosibles];
		}
		if(nPosibles == 0)
		{
			return 0;
		}
		if(iPosibles == 0)
		{
			return nPosibles;
		}
		if(nPosibles == 1)
		{
			return 1;
		}
		int maximo = Integer.MAX_VALUE;
		for(int i = 1; i < nPosibles; i++)
		{
			int mejorEste = mejor(nPosibles - i, iPosibles);
			mejorEste = Math.max(mejorEste, mejor(i - 1, iPosibles - 1));
			maximo = Math.min(maximo, mejorEste);
		}
		int mejor = maximo + 1;
		arregloMejor[nPosibles][iPosibles] = mejor;
		return mejor;
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nc = Integer.parseInt(br.readLine());
		for(int i = 0; i < nc; i++)
		{
			String linea = br.readLine();
			String[] lineaA = linea.split(" ");
			int n = Integer.parseInt(lineaA[0]);
			int s = Integer.parseInt(lineaA[1]) - 1;
			System.out.println(mejor(n, s));
		}
	}
}
