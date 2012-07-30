import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;


public class C
{
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("c.in"));
		while(true)
		{
			int n = Integer.parseInt(br.readLine().trim());
			if(n == 0)
				return;
			int l = Integer.parseInt(br.readLine().trim());
			boolean[] ropa = new boolean[n];
			int actual = 0;
			HashSet <Integer> actuales = new HashSet <Integer> ();
			for(int i = 0; i < l; i++)
			{
				String[] pedazos = br.readLine().split(" ");
				boolean w = pedazos[0].trim().equals("W");
				int numero = Integer.parseInt(pedazos[1].trim());
				if(w)
				{
					if(actuales.contains(numero))
						actuales.remove(numero);
					else
						continue;
					actual = numero;
					System.out.println("The launderer gives back batch " + actual + ".");
					int anterior = actual - 1;
					if(anterior < 0)
						anterior = n - 1;
					if(!ropa[anterior])
						System.out.println(actual + " is freed.");
					int ultimo = 0;
					for(int indice = actual + 1; ropa[indice % n]; indice++)
					{
						System.out.println(indice % n + " is freed.");
						ultimo = indice % n;
						ropa[indice % n] = false;
					}
					if(!ropa[(ultimo + 2) % n] && anterior != (ultimo + 1) % n)
						System.out.println((ultimo + 1) % n + " is freed.");
				}
				else
				{
					int cuenta = 0;
					int cuentaActual = 0;
					int empezoActual = -1;
					for(int indice = actual; cuenta <= 2; indice++)
					{
						if((indice % n) == actual)
							cuenta++;
						if(ropa[indice % n])
							cuentaActual = 0;
						else
						{
							if(cuentaActual == 0)
								empezoActual = indice % n;
							cuentaActual++;
							if(cuentaActual == numero + 2)
							{
								break;
							}
						}
					}
					if(cuentaActual == numero + 2)
					{
						System.out.println("The launderer gives ticket " + empezoActual + ".");
						for(int j = 0; j < numero; j++)
							ropa[(empezoActual + j + 1) % n] = true;
						actual = (empezoActual + numero + 1) % n;
						actuales.add(empezoActual);
					}
					else
					{
						System.out.println("No space left, please come back later.");
					}
				}
				
			}
		}
	}
}
