import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeSet;


public class B 
{
	
	static int[][][] dp = new int[150][150][150];
	
	static ArrayList <char[]> palabras = new ArrayList <char[]> ();
	static char[] abreviacion;
	
	public static int resolver(int letra, int palabra, int letraPalabra)
	{
		if(palabra != palabras.size() && letraPalabra == palabras.get(palabra).length)
			return resolver(letra, palabra + 1, 0);
		if(letra == abreviacion.length)
		{
			if(palabra == palabras.size())
				return 1;
			if(letraPalabra == 0)
				return 0;
			return resolver(letra, palabra, letraPalabra + 1);
		}
		if(palabra == palabras.size())
			return 0;
		if(dp[letra][palabra][letraPalabra] != -1)
			return dp[letra][palabra][letraPalabra];
		char[] palabraC = palabras.get(palabra);
		if(letraPalabra == 0)
		{
			int cuenta = 0;
			for(int i = 0; i < palabraC.length; i++)
			{
				if(palabraC[i] == abreviacion[letra])
					cuenta += resolver(letra + 1, palabra, i + 1);
			}
			return dp[letra][palabra][letraPalabra] = cuenta;
		}
		else
		{
			int cuenta = 0;
			if(palabraC[letraPalabra] == abreviacion[letra])
				cuenta += resolver(letra + 1, palabra, letraPalabra + 1);
			cuenta += resolver(letra, palabra, letraPalabra + 1);
			return dp[letra][palabra][letraPalabra] = cuenta;
		}
	}
	
	static TreeSet <String> insignificantes = new TreeSet <String> ();
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			int n = Integer.parseInt(br.readLine());
			if(n == 0)
				return;
			insignificantes.clear();
			for(int i = 0; i < n; i++)
				insignificantes.add(br.readLine());
			while(true)
			{
				String entrada = br.readLine().trim();
				if(entrada.equals("LAST CASE"))
					break;
				String[] pedazos = entrada.split("\\s+");
				String abrev = pedazos[0];
				palabras.clear();
				for(int i = 1; i < pedazos.length; i++)
				{
					String posible = pedazos[i];
					if(insignificantes.contains(posible))
						continue;
					palabras.add(posible.toCharArray());
				}
				abreviacion = abrev.toLowerCase().toCharArray();
				for(int i = 0; i <= abreviacion.length; i++)
					for(int j = 0; j < palabras.size(); j++)
					{
						int tam = palabras.get(j).length;
						for(int k = 0; k <= tam; k++)
							dp[i][j][k] = -1;
					}
				int valor = resolver(0, 0, 0);
				if(valor == 0)
					System.out.println(abrev + " is not a valid abbreviation");
				else
					System.out.println(abrev + " can be formed in " + valor + " ways");
			}
		}
	}

}
