import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class E
{
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String[] pedazos = br.readLine().split(" ");
			int num1 = Integer.valueOf(pedazos[0]);
			int num2 = Integer.valueOf(pedazos[1]);
			if(num1 == -1 && num2 == -1)
				return;
			if(num1 == 1 || num2 == 1)
				System.out.println(num1 + "+" + num2 + "=" + (num1 + num2));
			else
				System.out.println(num1 + "+" + num2 + "!=" + (num1 + num2));
		}
	}

}
