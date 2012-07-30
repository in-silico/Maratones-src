import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class Machined
{	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		try
		{
			System.setIn(new FileInputStream("surface.in"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while(true)
			{
				int n = Integer.parseInt(br.readLine());
				if(n == 0)
					return;
				int[] todos = new int[n];
				for(int i = 0; i < n; i++)
				{
					boolean empezo = false;
					int indice = 0;
					for(char c : br.readLine().toCharArray())
					{
						if(c == ' ' && !empezo)
						{
							empezo = true;
							indice++;
						}
						else if(c == ' ')
							indice++;
						else if(empezo)
							break;
					}
					todos[i] = indice;
				}
				int menor = Integer.MAX_VALUE;
				for(int i = 0; i < n; i++)
					menor = Math.min(menor, todos[i]);
				int cuenta = 0;
				for(int i = 0; i < n; i++)
					cuenta += todos[i] - menor;
				System.out.println(cuenta);
			}
		}
		catch(FileNotFoundException e)
		{
			return;
		}
	}

}
