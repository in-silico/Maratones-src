package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

public class football
{
	
	static class equipo implements Comparable <equipo>
	{
		String nombre;
		int puntos = 0;
		int juegos = 0;
		int ganados = 0;
		int empatados = 0;
		int perdidos = 0;
		int favor = 0;
		int contra = 0;
		
		@Override
		public int compareTo(equipo otro)
		{
			if(otro.puntos == puntos)
			{
				if(otro.ganados == ganados)
				{
					if(otro.favor - otro.contra == favor - contra)
					{
						if(otro.favor == favor)
						{
							if(otro.juegos == juegos)
							{
								return toLowerCase(otro.nombre).compareTo(toLowerCase(nombre));
							}
							return otro.juegos - juegos;
						}
						return favor - otro.favor;
					}
					return (favor - contra) - (otro.favor - otro.contra);
				}
				return ganados - otro.ganados;
			}
			return puntos - otro.puntos;
		}

		private String toLowerCase(String nombre) 
		{
			String otro = "";
			for(char a : nombre.toCharArray())
			{
				a %= 256;
				if(a >= 'A' && a <= 'Z')
					a = (char) (a - 'A' + 'a');
				otro += a;
			}
			return otro;
		}
	}
	
	public static void main(String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ncasos = Integer.parseInt(br.readLine());
		for(int i = 0; i < ncasos; i++)
		{
			String nombre = br.readLine();
			int numeroE = Integer.parseInt(br.readLine());
			Hashtable <String, equipo> equipos = new Hashtable <String, equipo> (30);
			for(int j = 0; j < numeroE; j++)
			{
				String nombreE = br.readLine();
				equipo actual = new equipo();
				actual.nombre = nombreE;
				equipos.put(nombreE, actual);
			}
			int numeroP = Integer.parseInt(br.readLine());
			for(int j = 0; j < numeroP; j++)
			{
				String [] partido = br.readLine().split("#");
				String e1 = partido[0];
				String e2 = partido[2];
				String [] goles = partido[1].split("@");
				int g1 = Integer.parseInt(goles[0]);
				int g2 = Integer.parseInt(goles[1]);
				equipo eq1 = equipos.get(e1);
				equipo eq2 = equipos.get(e2);
				eq1.juegos++;
				eq2.juegos++;
				eq1.favor += g1;
				eq1.contra += g2;
				eq2.favor += g2;
				eq2.contra += g1;
				if(g1 > g2)
				{
					eq1.ganados++;
					eq2.perdidos++;
					eq1.puntos += 3;
				}
				else if(g1 < g2)
				{
					eq2.ganados++;
					eq1.perdidos++;
					eq2.puntos += 3;
				}
				else
				{
					eq1.empatados++;
					eq2.empatados++;
					eq1.puntos++;
					eq2.puntos++;
				}
			}
			List <equipo> equiposO = Collections.list(Collections.enumeration(equipos.values()));
			Collections.sort(equiposO);
			System.out.print(nombre + '\n');
			int j = 1;
			int q = equiposO.size() - 1;
			for(; q > -1; q--)
			{
				equipo a = equiposO.get(q);
				String nt = a.nombre;
				String otro = "";
				for(char sd : nt.toCharArray())
				{
					sd %= 128;
					otro += sd;
				}
				a.nombre = otro;
				System.out.print((j++) + ") " + a.nombre + " " + a.puntos + "p, " + a.juegos + "g (" + a.ganados + "-" + a.empatados + "-" + a.perdidos + "), " + (a.favor - a.contra) + "gd (" + a.favor + "-" + a.contra + ")" + '\n');
			}
			if(i != ncasos - 1)
				System.out.print('\n');
		}
	}
}
