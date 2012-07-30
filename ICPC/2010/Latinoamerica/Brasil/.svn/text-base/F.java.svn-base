import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class F 
{
	
	static class Piloto implements Comparable <Piloto>
	{
		int numero;
		ArrayList <Integer> resultados = new ArrayList <Integer> ();
		int puntos;
		
		public Piloto(int n)
		{
			numero = n;
		}

		@Override
		public int compareTo(Piloto o) 
		{
			return Integer.valueOf(puntos).compareTo(o.puntos);
		}
		
	}
	
	public static void main(String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String[] lineaUno = br.readLine().split(" ");
			int g = Integer.parseInt(lineaUno[0]);
			int p = Integer.parseInt(lineaUno[1]);
			if(g == 0 && p == 0)
				return;
			Piloto[] pilotos = new Piloto[p];
			for(int i = 0; i < p; i++)
			{
				pilotos[i] = new Piloto(i + 1);
			}
			for(int i = 0; i < g; i++)
			{
				String[] lineaActual = br.readLine().split(" ");
				for(int j = 0; j < lineaActual.length; j++)
				{
					pilotos[j].resultados.add(Integer.parseInt(lineaActual[j]));
				}
			}
			int s = Integer.parseInt(br.readLine());
			for(int i = 0; i < s; i++)
			{
				int[] puntos = new int[p + 1];
				String[] lineaActual = br.readLine().split(" ");
				int num = Integer.parseInt(lineaActual[0]);
				for(int j = 1; j <= num; j++)
				{
					puntos[j] = Integer.parseInt(lineaActual[j]);
				}
				for(Piloto pi : pilotos)
				{
					pi.puntos = 0;
				}
				for(Piloto pi : pilotos)
				{
					for(int r : pi.resultados)
					{
						pi.puntos += puntos[r];
					}
				}
				Arrays.sort(pilotos);
				int mejor = pilotos[pilotos.length - 1].puntos;
				ArrayList <Integer> mejores = new ArrayList <Integer> ();
				for(Piloto pi : pilotos)
				{
					if(pi.puntos == mejor)
					{
						mejores.add(pi.numero);
					}
				}
				Collections.sort(mejores);
				System.out.print(mejores.get(0));
				for(int j = 1; j < mejores.size(); j++)
				{
					System.out.print(" " + mejores.get(j));
				}
				System.out.println();
			}
		}
	}

}
