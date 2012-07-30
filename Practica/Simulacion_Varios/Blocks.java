import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Blocks 
{
	static class Bloque
	{
		int numero;
		int pilaActual;
		int posicionActual;
		
		public Bloque(int n)
		{
			numero = n;
			pilaActual = n;
			posicionActual = 0;
		}
	}
	
	static int n;
	static Bloque[][] mundo;
	
	public static void moverEncima(Bloque a)
	{
		for(int i = a.posicionActual + 1; i < n; i++)
		{
			if(mundo[a.pilaActual][i] == null)
				break;
			else
			{
				Bloque aMover = mundo[a.pilaActual][i];
				poner(aMover, aMover.numero, 0);
			}
		}
	}
	
	private static void moverPila(Bloque a, int pila, int posicion) 
	{
			int posActual = 1;
			for(int i = a.posicionActual + 1; i < n; i++)
			{
				if(mundo[a.pilaActual][i] == null)
					break;
				poner(mundo[a.pilaActual][i], pila, posicion + posActual++);
			}
			mundo[pila][posicion] = a;
			mundo[a.pilaActual][a.posicionActual] = null;
			a.pilaActual = pila;
			a.posicionActual = posicion;
	}
	
	public static void poner(Bloque a, int pila, int posicion)
	{
		mundo[a.pilaActual][a.posicionActual] = null;
		mundo[pila][posicion] = a;
		a.pilaActual = pila;
		a.posicionActual = posicion;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		Bloque[] bloques = new Bloque[25];
		mundo = new Bloque[25][25];
		for(int i = 0; i < n; i++)
		{
			bloques[i] = new Bloque(i);
			mundo[i][0] = bloques[i];
		}
		while(true)
		{
			String comando = br.readLine();
			if(comando.equals("quit"))
			{
				for(int i = 0; i < n; i++)
				{
					System.out.print(i + ":");
					for(int j = 0; j < n; j++)
					{
						if(mundo[i][j] == null)
							break;
						System.out.print(" " + mundo[i][j].numero);
					}
					System.out.println();
				}
				return;
			}
			String[] pedazos = comando.split(" ");
			String orden = pedazos[0];
			String ordenD = pedazos[2];
			Bloque a = bloques[Integer.parseInt(pedazos[1])];
			Bloque b = bloques[Integer.parseInt(pedazos[3])];
			if(a.numero == b.numero || a.pilaActual == b.pilaActual)
				continue;
			if(orden.equals("move") && ordenD.equals("onto"))
			{
				moverEncima(a);
				moverEncima(b);
				poner(a, b.pilaActual, b.posicionActual + 1);
			}
			else if(orden.equals("move") && ordenD.equals("over"))
			{
				moverEncima(a);
				for(int i = b.posicionActual + 1; i < n; i++)
				{
					if(mundo[b.pilaActual][i] == null)
					{
						poner(a, b.pilaActual, i);
						break;
					}
				}
			}
			else if(orden.equals("pile") && ordenD.equals("onto"))
			{
				moverEncima(b);
				moverPila(a, b.pilaActual, b.posicionActual + 1);
			}
			else if(orden.equals("pile") && ordenD.equals("over"))
			{
				int i = 0;
				for(i = b.posicionActual; i < n; i++)
					if(mundo[b.pilaActual][i] == null)
						break;
				moverPila(a, b.pilaActual, i);
			}
		}
	}
}
