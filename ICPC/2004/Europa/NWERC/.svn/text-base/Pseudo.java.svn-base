import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;


public class Pseudo
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i < n; i++)
		{
			int base = sc.nextInt();
			LinkedList < LinkedList <Integer> > pilas = new LinkedList < LinkedList <Integer> > ();
			LinkedList < String > actuales = new LinkedList < String > ();
			int l = sc.nextInt();
			for(int j = 0; j < l; j++)
			{
				LinkedList <Integer> este = new LinkedList <Integer> ();
				este.add(sc.nextInt());
				pilas.add(este);
				actuales.add("");
			}
			Collections.reverse(pilas);
			boolean paila = false;
			int predecir = sc.nextInt();
			forPrincipal:
			for(int j = 1; j < l; j++)
			{
				LinkedList <Integer> actual = pilas.get(j);
				ListIterator < LinkedList <Integer> > it = pilas.listIterator(j);
				LinkedList <Integer> anterior = it.previous();
				ListIterator <Integer> enAnterior = anterior.listIterator(anterior.size());
				while(true)
				{
					int este = actual.peekFirst();
					if(!enAnterior.hasPrevious())
						break;
					int ant = enAnterior.previous();
					if(este > ant)
					{
						int respuesta = base - este + ant;
						actual.push(respuesta);
						if(enAnterior.hasPrevious())
						{
							if(enAnterior.previous() != 1)
							{
								paila = true;
								break forPrincipal;
							}
						}
						else
						{
							enAnterior.add(1);
							enAnterior.previous();
							int agregadosAnteriores = 1;
							for(int k = j - 1; k > 0; k--)
							{
								ArrayList <Integer> agregados = new ArrayList <Integer> ();
								for(int m = 0; m < agregadosAnteriores; m++)
								{
									int suma = pilas.get(k).get(m) + pilas.get(k).get(m + 1);
									if(suma >= base)
									{
										agregados.add(1);
										agregados.add(suma % base);
									}
									else
									{
										agregados.add(suma);
									}
								}
								agregadosAnteriores = agregados.size();
								for(int m = agregados.size() - 1; m >= 0; m--)
								{
									pilas.get(k - 1).push(agregados.get(m));
								}
								if(k - 1 == 0 && pilas.get(k - 1).size() > predecir)
									break forPrincipal;
							}
						}
					}
					else
					{
						actual.push(ant - este);
					}
				}
			}
			if(paila)
				System.out.println("impossible");
			else
			{
				ArrayList <Integer> actual = new ArrayList <Integer> (pilas.get(0));
				ArrayList <Integer> nuevoActual = new ArrayList <Integer> (predecir);
				Collections.reverse(actual);
				for(int j = l; j < predecir; j++)
				{
					if(actual.size() == 1)
					{
						paila = true;
						break;
					}
					nuevoActual.clear();
					for(int k = 0; k < actual.size() - 1; k++)
					{
						int numero = actual.get(k) + actual.get(k + 1);
						if(numero >= base)
						{
							nuevoActual.add(numero % base);
							nuevoActual.add(1);
						}
						else
						{
							nuevoActual.add(numero);
						}
						if(nuevoActual.size() > 10)
							break;
					}
					ArrayList <Integer> temp = actual;
					actual = nuevoActual;
					nuevoActual = temp;
				}
				if(paila)
					System.out.println("unpredictable");
				else
					System.out.println(actual.get(0));
			}
		}
	}
}
