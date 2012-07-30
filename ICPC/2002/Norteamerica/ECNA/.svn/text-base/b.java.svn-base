import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class b 
{
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String[] pedazos = br.readLine().split(" ");
			int n = Integer.parseInt(pedazos[0]);
			if(n == 0)
				break;
			int u = Integer.parseInt(pedazos[1]);
			int d = Integer.parseInt(pedazos[2]);
			int actual = 0;
			int cuenta = 0;
			while(true)
			{
				cuenta++;
				actual += u;
				if(actual >= n)
					break;
				cuenta++;
				actual -= d;
			}
			System.out.println(cuenta);
		}
	}

}
