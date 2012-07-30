import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Autofish
{
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.readLine();
		while(n-- != 0)
		{
			int nBaits = 0;
			int baits = 0;
			int nFish = 0;
			int ultimoFish = 0;
			int nFishU = 0;
			boolean empezo = false;
			while(true)
			{
				String entrada = br.readLine();
				if(entrada == null || entrada.equals(""))
				{
					System.out.println(nFish);
					if(n != 0)
						System.out.println();
					break;
				}
				else if(entrada.equals("bait"))
				{
					ultimoFish++;
					if(nBaits == 3)
					{
						continue;
					}
					else if(baits == 1)
					{
						nBaits++;
						baits = 0;
					}
					else
					{
						baits++;
					}
				}
				else if(entrada.equals("lunch"))
				{
					ultimoFish++;
				}
				else if(entrada.equals("fish"))
				{
					if(nBaits == 0)
					{
						ultimoFish++;
						continue;
					}
					if(!empezo)
					{
						nFish++;
						empezo = true;
						ultimoFish = 0;
						nFishU = 0;
						nBaits--;
					}
					else
					{
						ultimoFish++;
						nFishU++;
						if(nFishU >= 3 && ultimoFish >= 7)
						{
							nBaits--;
							nFish++;
							ultimoFish = 0;
							nFishU = 0;
						}
					}
				}
			}
		}
	}

}
