import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class B {

	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String linea = br.readLine();
			if(linea == null)
				return;
			String[] pedazos = linea.split(" ");
			long n = Long.parseLong(pedazos[0]);
			long b = Long.parseLong(pedazos[1]);
			if(b == 0)
			{
				if(n <= 1)
					System.out.println("yes");
				else
					System.out.println("no");					
			}
			else
			{
				long a = (long) (Math.pow(2, b + 1)) - 1;
				if(n <= a)
				{
					System.out.println("yes");
				}
				else
				{
					System.out.println("no");
				}
			}
		}
	}
}
