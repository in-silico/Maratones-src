import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;


public class E 
{
	
	static ArrayList <Integer> cabezas = new ArrayList <Integer> ();
	static ArrayList <Integer> caballeros = new ArrayList <Integer> ();
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Pattern p = Pattern.compile(" ");
		String[] pedazos;
		while(true)
		{
			pedazos = p.split(br.readLine());
			int n = Integer.parseInt(pedazos[0]);
			int m = Integer.parseInt(pedazos[1]);
			if(n == 0 && m == 0)
				return;
			cabezas.clear();
			for(int i = 0; i < n; i++)
			{
				cabezas.add(Integer.parseInt(br.readLine()));
			}
			caballeros.clear();
			for(int i = 0; i < m; i++)
			{
				caballeros.add(Integer.parseInt(br.readLine()));
			}
			int cabezaActual = 0;
			int caballeroActual = 0;
			int cuenta = 0;
			Collections.sort(cabezas);
			Collections.sort(caballeros);
			while(cabezaActual < n && caballeroActual < m)
			{
				if(cabezas.get(cabezaActual) <= caballeros.get(caballeroActual))
				{
					cuenta += caballeros.get(caballeroActual);
					cabezaActual++;
					caballeroActual++;
				}
				else
				{
					caballeroActual++;
				}
			}
			if(cabezaActual == n)
				System.out.println(cuenta);
			else
				System.out.println("Loowater is doomed!");
		}
	}
}
