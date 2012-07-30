package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class nap 
{
	static class tiempo implements Comparable <tiempo>
	{
		int empezo;
		int termino;
		
		tiempo(int a, int b)
		{
			empezo = a;
			termino = b;
		}
		
		@Override
		public int compareTo(tiempo o) 
		{
			return this.termino - o.termino;
		}
	}
	public static void main(String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String linea;
		int n = 1;
		while((linea = br.readLine()) != null)
		{
			int ntiempos = Integer.parseInt(linea);
			tiempo [] tiempos = new tiempo[ntiempos + 2];
			tiempos[0] = new tiempo(10 * 60, 10 * 60);
			tiempos[ntiempos + 1] = new tiempo(18 * 60, 18 * 60);
			for(int i = 1; i < ntiempos + 1; i++)
			{
				linea = br.readLine();
				String [] tiempo = linea.split(" ");
				tiempos[i] = new tiempo(Integer.parseInt(tiempo[0].split(":")[0]) * 60 + Integer.parseInt(tiempo[0].split(":")[1]),  Integer.parseInt(tiempo[1].split(":")[0]) * 60 + Integer.parseInt(tiempo[1].split(":")[1]));
			}
			Arrays.sort(tiempos);
			int mayor = 0;
			int tiempoMayor = 0;
			for(int i = 0; i < ntiempos + 1; i++)
			{
				int este = tiempos[i + 1].empezo - tiempos[i].termino; 
				if(este > mayor)
				{
					mayor = este;
					tiempoMayor = tiempos[i].termino;
				}
			}
			System.out.println("Day #" + (n++) + ": the longest nap starts at " + tiempoMayor / 60 + ":" + (tiempoMayor % 60 < 10 ? ("0" + (tiempoMayor % 60)) : (tiempoMayor % 60 + "")) + " and will last for " + (mayor > 59 ? (mayor / 60 + " hours and " + mayor % 60 + " minutes.") : ( mayor % 60 + " minutes.")));
		}
	}
}
