import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class f 
{
	static class Letra
	{
		public Letra(char c) 
		{
			letra = c;
		}
		
		char letra;
		int costo;
	}
	
	static class Tecla
	{
		public Tecla(char c) 
		{
			tecla = c;
		}

		char tecla;
	}
	
	static Letra[] letrasT = new Letra[100];
	static Tecla[] teclasT = new Tecla[100];
	
	static class Respuesta
	{
		Respuesta anterior;
		Tecla actual;
		ArrayList <Letra> letras = new ArrayList <Letra> ();
		int costo;
		
		public Respuesta(Respuesta ant, int tecla, int inicio, int fin)
		{
			anterior = ant;
			actual = teclasT[tecla];
			costo = 0;
			int num = 1;
			for(int i = inicio; i < fin; i++)
			{
				letras.add(letrasT[i]);
				costo += num++ * letrasT[i].costo;
			}
			if(anterior != null)
				costo += anterior.costo;
		}
		
		@Override
		public String toString() 
		{
			String salida = "";
			for(Letra l : letras)
				salida += l.letra;
			return salida;
		}
	}
	
	static Respuesta[][] dp = new Respuesta[100][100];
	
	static Respuesta solucionar(int teclaActual, int letraActual)
	{
		int indiceLetra = letraActual + 1;
		if(dp[teclaActual][indiceLetra] != null)
			return dp[teclaActual][indiceLetra];
		if(teclaActual == 1)
		{
			return dp[teclaActual][indiceLetra] = new Respuesta(null, 1, 0, letraActual + 1);
		}
		else
		{
			Respuesta actual = null;
			int costoActual = Integer.MAX_VALUE;
			for(int i = letraActual + 1; i >= 0; i--)
			{
				Respuesta posible = solucionar(teclaActual - 1, i - 1);
				posible = new Respuesta(posible, teclaActual, i, letraActual + 1);
				if(posible.costo <= costoActual)
				{
					actual = posible;
					costoActual = actual.costo;
				}
			}
			return dp[teclaActual][indiceLetra] = actual;
		}
	}
	

	static Respuesta[] respuestas = new Respuesta[100];
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int aa = 1; aa <= t; aa++)
		{
			String[] pedazos = br.readLine().split("\\s+");
			int k = Integer.parseInt(pedazos[0]);
			int l = Integer.parseInt(pedazos[1]);
			String teclasS = br.readLine();
			int i = 1;
			for(char c : teclasS.toCharArray())
			{
				teclasT[i++] = new Tecla(c);
			}
			String letrasS = br.readLine();
			i = 0;
			for(char c : letrasS.toCharArray())
			{
				letrasT[i++] = new Letra(c);
			}
			for(i = 0; i < l; i++)
			{
				letrasT[i].costo = Integer.parseInt(br.readLine());
			}
			for(i = 0; i <= k + 1; i++)
				for(int j = 0; j <= l + 1; j++)
					dp[i][j] = null;
			Respuesta mejor = solucionar(k, l - 1);
			for(i = k; i >= 1; i--)
			{
				respuestas[i] = mejor;
				mejor = mejor.anterior;
			}
			System.out.println("Keypad #" + aa + ":");
			for(i = 1; i <= k; i++)
			{
				System.out.println(respuestas[i].actual.tecla + ": " + respuestas[i]);
			}
			System.out.println();
		}
	}
}
