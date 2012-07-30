import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class A 
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] pilas = new int[1000];
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++)
		{
			int n = Integer.parseInt(br.readLine());
			int acum = 0;
			for(int j = 0; j < 1000; j++)
				pilas[0] = 0;
			int j = 0;
			boolean todosUno = true;
			for(String s : br.readLine().split("\\s+"))
			{
				acum ^= Integer.parseInt(s);
				if(Integer.parseInt(s) != 1)
					todosUno = false;
				pilas[j++] = Integer.parseInt(s);
				
			}
			if(todosUno)
			{
				if((n & 1) == 0)
					System.out.println("John");
				else
					System.out.println("Brother");
			}
			else
			{
				System.out.println(acum != 0 ? "John" : "Brother");
			}
		}
	}
}