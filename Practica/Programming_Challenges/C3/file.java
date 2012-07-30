package UVA;
import java.util.ArrayList;
import java.util.Scanner;


public class file 
{
	static class posible
	{
		String nombre;
		int cuenta;
		
		posible(String n, int c)
		{
			nombre = n;
			cuenta = c;
		}

		@Override
		public boolean equals(Object o)
		{
			posible otro = (posible)o;
			if(nombre.equals(otro.nombre))
			{
				otro.cuenta++;
				return true;
			}
			return false;
		}
		
	}
	@SuppressWarnings("unchecked")
	public static void main(String [] args)
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			int ncasos = Integer.parseInt(sc.nextLine());
			sc.nextLine();
			for(int i = 0; i < ncasos; i++)
			{
				String linea;
				ArrayList <String> [] fragmentos = new ArrayList [2048];
				int n = 0;
				for(int j = 0; j < 2048; j++)
				{
					fragmentos[j] = new ArrayList <String> (0);
				}
				int menor = Integer.MAX_VALUE;
				int mayor = Integer.MIN_VALUE;
				while(sc.hasNextLine() && !(linea = sc.nextLine()).equals(""))
				{
					fragmentos[linea.length() - 1].add(linea);
					if(linea.length() < menor)
						menor = linea.length();
					if(linea.length() > mayor)
						mayor = linea.length();
					n++;
				}
				int tamano = mayor + menor;
				ArrayList <posible> posibles = new ArrayList <posible> ();
				for(int j = 0; j < 2048; j++)
				{
					if(!fragmentos[j].isEmpty())
					{
						for(int q = 0; q < fragmentos[j].size(); q++)
						{
							String s = fragmentos[j].get(q);
							for(int w = 0; w < fragmentos[tamano - j - 2].size(); w++)
							{
								if(j != tamano - j - 2 || q != w)
								{
									String t = fragmentos[tamano - j - 2].get(w);
									String nuevo = s + t;
									if(!posibles.contains(new posible(nuevo, 0)))
									{
										posibles.add(new posible(nuevo, 1));
									}
									nuevo = t + s;
									if(!posibles.contains(new posible(nuevo, 0)))
									{
										posibles.add(new posible(nuevo, 1));
									}
								}
							}
						}
					}
				}
				int may = Integer.MIN_VALUE;
				int indice = 0;
				for(int j = 0; j < posibles.size(); j++)
				{
					if(posibles.get(j).cuenta > may)
					{
						may = posibles.get(j).cuenta;
						indice = j;
					}
				}
				System.out.println(posibles.get(indice).nombre);
				if(i != ncasos - 1)
					System.out.println();
			}
		}
		catch(Throwable e)
		{
			return;
		}
	}

}
