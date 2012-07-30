import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;


public class J 
{
	
	static class Piloto implements Comparable <Piloto>
	{
		String nombre;
		String apellido;
		int puntos = 0;
		int[] resultados = new int[8];
		
		public Piloto(String n, String a)
		{
			nombre = n;
			apellido = a;
		}

		@Override
		public int compareTo(Piloto o)
		{
			if(puntos == o.puntos)
			{
				for(int i = 0; i < 8; i++)
				{
					if(resultados[i] != o.resultados[i])
						return Integer.valueOf(resultados[i]).compareTo(o.resultados[i]);
				}
				if(apellido.equals(o.apellido))
				{
					return -nombre.compareTo(o.nombre);
				}
				return -apellido.compareTo(o.apellido);
			}
			return Integer.valueOf(puntos).compareTo(o.puntos);
		}
	}
	
	static class Equipo implements Comparable <Equipo>
	{
		String nombre;
		int puntos = 0;
		
		public Equipo(String equipoS) 
		{
			nombre = equipoS;
		}

		@Override
		public int compareTo(Equipo o) 
		{
			if(puntos == o.puntos)
				return -nombre.compareTo(o.nombre);
			return Integer.valueOf(puntos).compareTo(o.puntos);
		}
	}
	
	static class PEq
	{
		Piloto p;
		Equipo e;
	}
	
	static TreeMap <String, Piloto> pilotos = new TreeMap <String, Piloto> ();
	static TreeMap <String, Equipo> equipos = new TreeMap <String, Equipo> ();

	static PEq leerPilotoEquipo(String s)
	{
		s = s.trim();
		s = s.substring(s.indexOf(' '));
		s = s.trim();
		String nombre = s.substring(0, s.indexOf(' '));
		s = s.substring(s.indexOf(' '));
		s = s.trim();
		String apellido = s.substring(0, s.indexOf(' '));
		s = s.substring(s.indexOf(' '));
		s = s.trim();
		String equipoS = s.substring(0, s.lastIndexOf('.'));
		String nombreAp = nombre + apellido;
		PEq retorno = new PEq();
		Piloto posible = pilotos.get(nombreAp);
		if(posible == null)
		{
			posible = new Piloto(nombre, apellido);
			pilotos.put(nombreAp, posible);
		}
		retorno.p = posible;
		Equipo equipo = equipos.get(equipoS);
		if(equipo == null)
		{
			equipo = new Equipo(equipoS);
			equipos.put(equipoS, equipo);
		}
		retorno.e = equipo;
		return retorno;
	}

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] puntos = new int[] {10, 8, 6, 5, 4, 3, 2, 1};
		int season = 1;
		while(true)
		{
			equipos.clear();
			pilotos.clear();
			int n = Integer.valueOf(br.readLine().trim());
			if(n == 0)
				return;
			for(int i = 0; i < n; i++)
			{
				br.readLine();
				br.readLine();
				for(int j = 0; j < 8; j++)
				{
					PEq este = leerPilotoEquipo(br.readLine());
					este.p.puntos += puntos[j];
					este.p.resultados[j]++;
					este.e.puntos += puntos[j];
				}
				br.readLine();
			}
			ArrayList <Piloto> pilotosO = new ArrayList <Piloto> (pilotos.values());
			Collections.sort(pilotosO);
			ArrayList <Equipo> equiposO = new ArrayList <Equipo> (equipos.values());
			Collections.sort(equiposO);
			System.out.println("Season " + season++ + ":");
			System.out.println("Drivers Standing:");
			Collections.reverse(pilotosO);
			for(Piloto p : pilotosO)
			{
				String salida = p.nombre + " " + p.apellido;
				while(salida.length() != 25)
					salida += " ";
				salida += " ";
				salida += p.puntos;
				System.out.println(salida);
			}
			System.out.println();
			Collections.reverse(equiposO);
			System.out.println("Teams Standing:");
			for(Equipo e : equiposO)
			{
				String salida = e.nombre;
				while(salida.length() != 25)
					salida += " ";
				salida += " ";
				salida += e.puntos;
				System.out.println(salida);
			}
			System.out.println();
		}
	}
}
