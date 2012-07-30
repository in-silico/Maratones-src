import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class Energy 
{

	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int j = 0; j < t; j++)
		{
			String[] pedazos = br.readLine().split(" ");
			int n = Integer.parseInt(pedazos[0]);
			int i = Integer.parseInt(pedazos[1]);
			int k = Integer.parseInt(pedazos[2]);
			int actual = 0;
			boolean activo = true;
			LinkedList <Integer> entradas = new LinkedList <Integer> ();
			for(int a = 0; a < n; a++)
				entradas.add(Integer.parseInt(br.readLine()));
			int inactivaciones = 0;
			int ignorados = 0;
			while(!entradas.isEmpty())
			{
				int entrada = entradas.poll();
				if(activo)
				{
					if(entrada >= actual + i)
					{
						inactivaciones++;
						entradas.push(entrada);
						activo = false;
						actual = actual + i;
					}
					else
					{
						actual = entrada;
					}
				}
				else
				{
					actual = entrada + k;
					while(!entradas.isEmpty() && entradas.peek().intValue() < actual)
					{
						entradas.poll();
						ignorados++;
					}
					activo = true;
				}
			}
			System.out.println("Case " + (j + 1) + ": " + inactivaciones + " " + ignorados);
		}
	}
}
