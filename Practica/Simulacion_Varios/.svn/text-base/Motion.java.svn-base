import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Motion
{
	
	static class Celda
	{
		int numero = -1;
		char direccion;
		
		public Celda(char d)
		{
			direccion = d;
		}
	}

	static Celda[][] mundo;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String[] pedazos = br.readLine().split(" ");
			int f = Integer.parseInt(pedazos[0]);
			int c = Integer.parseInt(pedazos[1]);
			int e = Integer.parseInt(pedazos[2]);
			if(f == 0 && c == 0 && e == 0)
				return;
			mundo = new Celda[f][c];
			for(int i = 0; i < f; i++)
			{
				char[] linea = br.readLine().toCharArray();
				for(int j = 0; j < c; j++)
				{
					mundo[i][j] = new Celda(linea[j]);
				}
			}
			int iActual = 0;
			int jActual = e - 1;
			int pasosActual = 1;
			while(true)
			{
				try
				{
					if(mundo[iActual][jActual].numero != -1)
					{
						System.out.println((mundo[iActual][jActual].numero - 1) + " step(s) before a loop of " + (pasosActual - mundo[iActual][jActual].numero) + " step(s)");
						break;
					}
					else
					{
						mundo[iActual][jActual].numero = pasosActual++;
						char direccion = mundo[iActual][jActual].direccion;
						switch(direccion)
						{
							case 'N' : iActual--; break;
							case 'S' : iActual++; break;
							case 'E' : jActual++; break;
							case 'W' : jActual--; break;
						}
					}
				}
				catch(Exception ex)
				{
					System.out.println(--pasosActual + " step(s) to exit");
					break;
				}
			}
		}
		
	}
}
