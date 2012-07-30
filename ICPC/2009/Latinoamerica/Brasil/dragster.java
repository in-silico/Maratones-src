package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.TreeMap;


public class dragster
{
	
	public static void main(String [] args)
	{
		DecimalFormat df = new DecimalFormat("0.000000");
		while(true)
		{
			int n = leerNumero();
			if(n == 0) return;
			double[][] probabilidades = new double[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					probabilidades[i][j] = leerDouble();
			Carrera[] carreras = new Carrera[n - 1];
			for(int i = 0; i < n - 1; i++)
				carreras[i] = new Carrera(leerNumero(), leerNumero());
			boolean[] solucionados = new boolean[2 * n];
			for(int i = 1; i < n + 1; i++)
				solucionados[i] = true;
			Carrera ultimaCarrera = carreras[0];
			while(true)
			{
				boolean cambio = false;
				for(int i = 0; i < n - 1; i++)
				{
					Carrera c = carreras[i];
					if(!solucionados[i + n + 1] && solucionados[c.a] && solucionados[c.b])
					{
						TreeMap <Integer, Double> a;
						if(c.a < n + 1)
						{
							a = new TreeMap <Integer, Double> ();
							a.put(c.a, 1.0);
						}
						else
						{
							a = carreras[c.a - n - 1].posibles;
						}
						TreeMap <Integer, Double> b;
						if(c.b < n + 1)
						{
							b = new TreeMap <Integer, Double> ();
							b.put(c.b, 1.0);
						}
						else
						{
							b = carreras[c.b - n - 1].posibles;
						}
						for(int ap : a.navigableKeySet())
						{
							double pos = 0; 
							for(int bp : b.navigableKeySet())
								pos += probabilidades[ap - 1][bp - 1] * b.get(bp);
							c.posibles.put(ap, pos * a.get(ap));
						}
						for(int bp : b.navigableKeySet())
						{
							double pos = 0; 
							for(int ap : a.navigableKeySet())
								pos += probabilidades[bp - 1][ap - 1] * a.get(ap);
							c.posibles.put(bp, pos * b.get(bp));
						}
						if(c.posibles.containsKey(1))
						{
							double pos1 = c.posibles.get(1);
							c.posibles = new TreeMap <Integer, Double> ();
							c.posibles.put(1, pos1);
						}
						solucionados[i + n + 1] = true;
						cambio = true;
						ultimaCarrera = c;
					}
				}
				if(!cambio)
					break;
			}
			System.out.println(df.format(ultimaCarrera.posibles.get(1)));
		}
	}
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	
	public static int leerNumero()

	{

	char[] numero = new char[6];

	int i;

	int indice = 0;

	try

	{

	while((i = br.read()) == ' ' || i == '\n');

	numero[indice++] = (char) i;

	while((i = br.read()) != ' ' && i != '\n' && i != '\r') numero[indice++] = (char) i;

	return Integer.parseInt(new String(numero, 0, indice));

	}

	catch (IOException e) {

	return 0;

	}

	}

	public static double leerDouble()

	{

	char[] numero = new char[6];

	int i;

	int indice = 0;

	try

	{

	while((i = br.read()) == ' ' || i == '\n');

	numero[indice++] = (char) i;

	while((i = br.read()) != ' ' && i != '\n' && i != '\r') numero[indice++] = (char) i;

	return Double.parseDouble(new String(numero, 0, indice));

	}

	catch (IOException e) {

	return 0;

	}
	}
	
	public static class Carrera
	{
		public Carrera(int a, int b) 
		{
			this.a = a;
			this.b = b;
		}

		int a, b;
		
		TreeMap <Integer, Double> posibles = new TreeMap <Integer, Double> ();
	}

}
