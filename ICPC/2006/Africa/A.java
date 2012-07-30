import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class A 
{
	
	public static void main(String[] args) throws IOException
	{
		System.setOut(new PrintStream("sal.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caso = 1;
		while(true)
		{
			String cadena = br.readLine().trim();
			int i = Integer.parseInt(cadena.substring(0, cadena.indexOf(' ') == -1 ? cadena.length() : cadena.indexOf(' ')));
			if(i == 0)
				return;
			cadena = cadena.substring(cadena.indexOf(' ') == -1 ? cadena.length() : cadena.indexOf(' ')).trim();
			int n = Integer.parseInt(cadena.substring(0, cadena.indexOf(' ') == -1 ? cadena.length() : cadena.indexOf(' ')));
			cadena = cadena.substring(cadena.indexOf(' ') == -1 ? cadena.length() : cadena.indexOf(' ')).trim();
			int corte = cadena.indexOf(' ');
			if(cadena.charAt(0) == '"')
			{
				cadena = cadena.substring(1);
				corte = cadena.indexOf('"');
			}
			String a = cadena.substring(0, corte);
			cadena = cadena.substring(corte + 1).trim();
			corte = cadena.indexOf(' ') == -1 ? cadena.length() : cadena.indexOf(' ');
			if(cadena.charAt(0) == '"')
			{
				cadena = cadena.substring(1);
				corte = cadena.indexOf('"');
			}
			String b = cadena.substring(0, corte);
			int indice = (i - 1) / n;
			String resultado;
			if(indice % 2 == 0)
				resultado = a;
			else
				resultado = b;
			System.out.println(caso++ + ". " + resultado.toLowerCase());
		}
	}

}
