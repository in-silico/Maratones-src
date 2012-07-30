import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;


public class i
{
	static TreeMap <Integer, String> entrada = new TreeMap <Integer, String> ();
	static TreeMap <String, Integer> entradaS = new TreeMap <String, Integer> ();
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		for(int i = 0; i < 16; i++)
		{
			entrada.put(i, generar(i));
			entradaS.put(generar(i), i);
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++)
		{
			String a = br.readLine();
			String b = br.readLine();
			int aI = entradaS.get(a.trim());
			int bI = entradaS.get(b.trim());
			System.out.println(entrada.get(aI + bI));
		}
	}
	
	public static String generar(int n)
	{
		if(n == 0)
			return "{}";
		StringBuilder salida = new StringBuilder(n * 10);
		salida.append("{");
		for(int i = 0; i < n - 1; i++)
		{
			salida.append(generar(i) + ",");
		}
		salida.append(generar(n - 1) + "}");
		return salida.toString();
	}
}
