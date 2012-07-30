import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;


public class H 
{
	
	static class Numero implements Comparable<Numero>
	{
		int posicion;
		int numero;
		
		public Numero(int i, int next) {
			posicion = i;
			numero = next;
		}

		@Override
		public int compareTo(Numero o) 
		{
			return Integer.valueOf(numero).compareTo(o.numero) == 0 ? Integer.valueOf(posicion).compareTo(o.posicion) : Integer.valueOf(numero).compareTo(o.numero);
		}
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt())
		{
			int t = sc.nextInt();
			int buscada = sc.nextInt();
			int booklets = sc.nextInt();
			int a = booklets / t;
			int m = 0, n = 0;
			for(int i = 0; i <= booklets; i++)
			{
				if((booklets - a * i) % (a + 1) == 0)
				{
					m = i; 
					n = (booklets - a * i) / (a + 1);
					if(m + n == t)
						break;
				}
			}
			LinkedList <Numero> mapa = new LinkedList <Numero> ();
			for(int i = 0; i < booklets; i++)
			{
				mapa.push(new Numero(i, sc.nextInt()));
			}
			Collections.sort(mapa);
			int escuela = 0;
			boolean termino = false;
			for(int i = n; i > 0 && !termino; i--)
			{
				for(int j = 0; j < a + 1; j++)
				{
					if(escuela == buscada && j == 0)
					{
						int menorPos = Integer.MAX_VALUE;
						int numero = 0;
						for(j = 0; j < a + 1; j++)
						{
							Numero este = mapa.pollFirst();
							if(este.posicion < menorPos)
							{
								menorPos = este.posicion;
								numero = este.numero;
							}
						}
						termino = true;
						System.out.println(numero);
						break;
					}
					mapa.pollFirst();
				}
				escuela++;
			}
			for(int i = m; i > 0 && !termino; i--)
			{
				for(int j = 0; j < a; j++)
				{
					if(escuela == buscada && j == 0)
					{
						int menorPos = Integer.MAX_VALUE;
						int numero = 0;
						for(j = 0; j < a; j++)
						{
							Numero este = mapa.pollFirst();
							if(este.posicion < menorPos)
							{
								menorPos = este.posicion;
								numero = este.numero;
							}
						}
						System.out.println(numero);
						termino = true;
						break;
					}
					mapa.pollFirst();
				}
				escuela++;
			}
		}
	}

}
