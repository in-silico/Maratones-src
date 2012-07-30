package UVA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class cdvii
{
	
	static class entrada implements Comparable <entrada>
	{
		int dia;
		int hora;
		int minuto;
		boolean enter;
		int kilometro;
		
		public entrada(int d, int h, int m, boolean e, int k)
		{
			dia = d;
			hora = h;
			minuto = m;
			enter = e;
			kilometro = k;
		}

		@Override
		public int compareTo(entrada otra) 
		{
			if(dia == otra.dia)
			{
				if(hora == otra.hora)
				{
					return minuto - otra.minuto;
				}
				return hora - otra.hora;
			}
			return dia - otra.dia;
		}
	}
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int ncasos = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < ncasos; i++)
		{
			int [] horas = new int[24];
			for(int j = 0; j < 24; j++)
			{
				horas[j] = sc.nextInt();
			}
			sc.nextLine();
			String linea = "";
			Hashtable <String, ArrayList <entrada>> carros = new Hashtable <String, ArrayList <entrada>> (500);
			while(sc.hasNextLine() && (!(linea = sc.nextLine()).equals("")))
			{
				StringTokenizer st = new StringTokenizer(linea);
				String placa = st.nextToken();
				String [] fecha = st.nextToken().split(":");
				int dia = Integer.parseInt(fecha[1]);
				int hora = Integer.parseInt(fecha[2]);
				int minuto = Integer.parseInt(fecha[3]);
				boolean enter = st.nextToken().equals("enter");
				int kilometro = Integer.parseInt(st.nextToken());
				entrada actual = new entrada(dia, hora, minuto, enter, kilometro);
				if(carros.containsKey(placa))
				{
					carros.get(placa).add(actual);
				}
				else
				{
					ArrayList <entrada> entradas = new ArrayList <entrada> (10);
					entradas.add(actual);
					carros.put(placa, entradas);
				}
			}
			Set <String> placas = carros.keySet();
			String [] aPlacas = new String [placas.size()];
			placas.toArray(aPlacas);
			Arrays.sort(aPlacas);
			for(String placa : aPlacas)
			{
				ArrayList <entrada> entradas = carros.get(placa);
				Collections.sort(entradas);
				int acumulado = 200;
				entrada actual = null;
				for(entrada e : entradas)
				{
					if(actual == null)
					{	
						if(e.enter)
							actual = e;
					}
					else
					{
						if(e.enter)
						{
							actual = e;
						}
						else
						{
							acumulado += 100;
							acumulado += Math.abs(actual.kilometro - e.kilometro) * horas[actual.hora];
							actual = null;
						}
					}
				}
				if(acumulado > 200)
					System.out.println(placa + " $" + (acumulado / 100) + "." + ((acumulado % 100) < 10 ? "0" + (acumulado % 100) : (acumulado % 100)));
			}
			if(i != ncasos - 1)
				System.out.println();
		}
	}

}
