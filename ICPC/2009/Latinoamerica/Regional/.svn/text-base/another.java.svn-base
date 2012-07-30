import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class another
{
	static int t;
	
	public static void main(String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 100000);
		StringTokenizer st;
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			if(n == 0 && t == 0)
				return;
			st = new StringTokenizer(br.readLine());
			trabajador trabajadores [] = new trabajador[n + 1];
			for(int i = 0; i < n + 1; i++)
			{
				trabajadores[i] = new trabajador();
			}
			for(int i = 0; i < n; i++)
			{
				trabajadores[Integer.parseInt(st.nextToken())].subordinados.add(trabajadores[i + 1]); 
			}
			calcular(trabajadores[0]);
			System.out.println(trabajadores[0].numero);
		}
	}

	private static void calcular(trabajador trabajador)
	{
		for(trabajador tr : trabajador.subordinados)
			calcular(tr);
		if(trabajador.subordinados.size() == 0)
			trabajador.numero = 1;
		else
		{
			Collections.sort(trabajador.subordinados);
			int acum = 0;
			double numero = 0;
			double tam = trabajador.subordinados.size();
			double necesarios = ((t * tam) / 100);
			for(trabajador tr : trabajador.subordinados)
			{
				if(numero++ >= necesarios)
					break;
				acum += tr.numero;
			}
			trabajador.numero = acum;
		}
	}

	static class trabajador implements Comparable <trabajador>
	{
		LinkedList <trabajador> subordinados = new LinkedList <trabajador> ();
		int numero;
		
		@Override
		public int compareTo(trabajador otro) 
		{
			return numero - otro.numero;
		}
		
		
	}
}

