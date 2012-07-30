import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Seconds 
{
	
	static ArrayList <Integer> valores = new ArrayList <Integer> (20000);
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int act = 1;
		while(true)
		{
			valores.clear();
			int n = Integer.parseInt(br.readLine());
			if(n == 0)
				return;
			System.out.println("Output for data set " + act++ + ", " + n + " bytes:");
			int acumulado = 0;
			while(acumulado < n)
			{
				int s = Integer.parseInt(br.readLine());
				valores.add(s);
				acumulado += s;
			}
			acumulado = 0;
			int acumuladoCinco = 0;
			for(int i = 0; i < valores.size(); i++)
			{
				acumuladoCinco += valores.get(i);
				acumulado += valores.get(i);
				if((i + 1) % 5 == 0)
				{
					System.out.print("   Time remaining: ");
					if(acumuladoCinco == 0)
					{
						System.out.println("stalled");
						acumuladoCinco = 0;
						continue;
					}
					double acumuladoFaltante = (n - acumulado);
					double segFaltantes = acumuladoFaltante / (acumuladoCinco / 5.0);
					System.out.println((int) (segFaltantes + 0.999999) + " seconds");
					acumuladoCinco = 0;
				}
			}
			System.out.println("Total time: " + valores.size() + " seconds");
			System.out.println();
		}
	}

}
