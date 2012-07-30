import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;


public class E
{
	
	static class Persona implements Comparable <Persona>
	{
		String nombre;
		ArrayList <Persona> hijos = new ArrayList <Persona> ();
		int cuantos;
		int[] dp = new int[1001];
		
		public Persona(String n)
		{
			for(int i = 0; i < 1001; i++)
				dp[i] = -1;
			nombre = n;
		}
		
		public int visitar(int numero)
		{
			if(numero > 1000)
				return 0;
			if(numero == 0)
				return 1;
			if(dp[numero] != -1)
				return dp[numero];
			int cuenta = 0;
			for(Persona p : hijos)
				cuenta += p.visitar(numero - 1);
			return dp[numero] = cuenta;
		}

		@Override
		public int compareTo(Persona o)
		{
			if(cuantos == o.cuantos)
				return nombre.compareTo(o.nombre);
			return -Integer.valueOf(cuantos).compareTo(o.cuantos);
		}
	}
	
	static TreeMap <String, Persona> personas = new TreeMap <String, Persona> ();
	static Persona[] personasA = new Persona[1001];
	
	
	static Persona darPersona(String s)
	{
		if(personas.containsKey(s))
			return personas.get(s);
		Persona nueva = new Persona(s);
		personas.put(s, nueva);
		return nueva;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int arbol = 1; arbol <= n; arbol++)
		{
			if(arbol != 1)
				System.out.println();
			String[] pedazos = br.readLine().split("\\s+");
			int total = Integer.parseInt(pedazos[0]);
			int pregunta = Integer.parseInt(pedazos[1]);
			personas.clear();
			for(int i = 0; i < total; i++)
			{
				pedazos = br.readLine().split("\\s+");
				Persona actual = darPersona(pedazos[0]);
				int nHijos = Integer.parseInt(pedazos[1]);
				for(int j = 0; j < nHijos; j++)
					actual.hijos.add(darPersona(pedazos[j + 2]));
			}
			int cuenta = 0;
			for(Persona p : personas.values())
			{
				personasA[cuenta++] = p;
			}
			for(int i = 0; i < cuenta; i++)
			{
				personasA[i].cuantos = personasA[i].visitar(pregunta);
			}
			Arrays.sort(personasA, 0, cuenta);
			System.out.println("Tree " + arbol + ":");
			for(int i = 0; i < Math.min(cuenta, 3); i++)
			{
				if(personasA[i].cuantos == 0)
					break;
				System.out.println(personasA[i].nombre + " " + personasA[i].cuantos);
			}
			if(cuenta > 3 && personasA[2].cuantos != 0)
			{
				int actual = 3;
				while(actual < cuenta && personasA[actual].cuantos == personasA[2].cuantos)
				{
					System.out.println(personasA[actual].nombre + " " + personasA[actual].cuantos);
					actual++;
				}
			}
		}
	}
}
