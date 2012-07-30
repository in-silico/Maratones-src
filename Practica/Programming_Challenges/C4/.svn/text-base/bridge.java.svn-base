package UVA;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class bridge 
{
	public static void main(String [] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int ncasos = sc.nextInt();
		for(int i = 0; i < ncasos; i++)
		{
			sc.nextLine();
			while(!sc.nextLine().equals(""))
			{
			}
			int npersonas = sc.nextInt();
			int [] personas = new int[npersonas];
			for(int j = 0; j < npersonas; j++)
			{
				personas[j] = sc.nextInt();
			}
			Arrays.sort(personas);
			if(npersonas == 1)
			{
				System.out.println(personas[0]);
				System.out.println(personas[0]);
				if(i != ncasos - 1)
					System.out.println();
				continue;
			}
			if(npersonas == 2)
			{
				System.out.println(personas[1]);
				System.out.println(personas[0] + " " + personas[1]);
				if(i != ncasos - 1)
					System.out.println();
				continue;
			}
			int menor = personas[0];
			int smenor = personas[1];
			Stack <Integer> pila = new Stack <Integer> ();
			for(int j = 2; j < npersonas; j++)
			{
				pila.add(personas[j]);
			}
			ArrayList <String> salida = new ArrayList <String> ();
			int acumulado = 0;
			while(!pila.isEmpty())
			{
				if(pila.size() == 1)
				{
					int siguiente = pila.pop();
					salida.add(menor + " " + siguiente);
					salida.add(menor + "");
					salida.add(menor + " " + smenor);
					acumulado += menor + smenor;
					acumulado += siguiente;
					break;
				}
				else
				{
					int siguiente = pila.pop();
					int siguiente1 = pila.pop();
					if(!(menor + siguiente + smenor + smenor > siguiente + siguiente1 + menor + menor))
					{
						salida.add(menor + " " + smenor);
						salida.add(menor + "");
						acumulado += menor + smenor;
						salida.add(siguiente1 + " " + siguiente);
						acumulado += siguiente;
						salida.add(smenor + "");
						acumulado += smenor;
						if(pila.size() == 0)
						{
							salida.add(menor + " " + smenor);
							acumulado += smenor;
						}
					}
					else
					{
						salida.add(menor + " " + siguiente);
						acumulado += siguiente;
						salida.add(menor + "");
						salida.add(menor + " " + siguiente1);
						acumulado += menor + siguiente1;
						salida.add(menor + "");
						acumulado += menor;
						if(pila.size() == 0)
						{
							salida.add(menor + " " + smenor);
							acumulado += smenor;
						}
					}
				}
			}
			System.out.println(acumulado);
			for(String s : salida)
				System.out.println(s);
			if(i != ncasos - 1)
				System.out.println();
		}
	}

}
