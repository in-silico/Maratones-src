import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class c 
{
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int a = 0; a < t; a++)
		{
			int n = Integer.parseInt(br.readLine());
			long acumCinco = 5;
			int total = 0;
			while(true)
			{
				long numero = n / acumCinco;
				if(numero == 0)
					break;
				acumCinco *= 5L;
				total += numero;
			}
			System.out.println(total);
		}
	}

}
