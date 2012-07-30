import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Mind 
{
	
	
	static boolean[] usadoActual = new boolean[1000];
	static int[] valores = new int[1000];
	static int[] valoresActual = new int[1000];
	static int[] cuenta = new int[10];
	static int[] cuentaActual = new int[10];
	
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numero = 1;
		while(true)
		{
			int n = new Integer(br.readLine());
			if(n == 0)
				return;
			String[] pedazos = br.readLine().split(" ");
			for(int i = 0; i < n; i++)
			{
				valores[i] = new Integer(pedazos[i]);
			}
			for(int i = 0; i < 10; i++)
			{
				cuenta[i] = 0;
			}
			for(int i = 0; i < n; i++)
			{
				cuenta[valores[i]]++;
			}
			System.out.println("Game " + numero++ + ":");
			while(true)
			{
				String[] pedazosActuales = br.readLine().split(" ");
				for(int i = 0; i < n; i++)
				{
					valoresActual[i] = new Integer(pedazosActuales[i]);
					usadoActual[i] = false;
				}
				if(valoresActual[0] == 0)
					break;
				for(int i = 0; i < 10; i++)
				{
					cuentaActual[i] = cuenta[i];
				}
				int strong = 0;
				int weak = 0;
				for(int i = 0; i < n; i++)
				{
					if(valoresActual[i] == valores[i])
					{
						strong++;
						usadoActual[i] = true;
						cuentaActual[valores[i]]--;
					}
				}
				for(int i = 0; i < n; i++)
				{
					if(!usadoActual[i])
					{
						if(cuentaActual[valoresActual[i]] > 0)
						{
							weak++;
							cuentaActual[valoresActual[i]]--;
						}
					}
				}
				System.out.println("    (" + strong + "," + weak + ")");
			}
		}
	}

}
