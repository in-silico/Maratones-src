import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;


public class Chains 
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out), 100000);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			int n = Integer.parseInt(br.readLine());
			if(n == 0)
			{
				bw.flush();
				return;
			}
			int iteraciones = 0;
			TreeSet <Integer> numeros = new TreeSet <Integer> ();
			numeros.add(n);
			bw.write("Original number was " + n + "\n");
			while(true)
			{
				iteraciones++;
				char[] subida = new String(n + "").toCharArray();
				char[] bajadaC = new String(n + "").toCharArray();
				Character[] bajada = new Character[bajadaC.length];
				for(int i = 0; i < bajadaC.length; i++)
					bajada[i] = bajadaC[i];
				Arrays.sort(subida);
				Arrays.sort(bajada, new comparador());
				for(int i = 0; i < bajadaC.length; i++)
					bajadaC[i] = bajada[i];
				int a = Integer.parseInt(new String(subida));
				int b = Integer.parseInt(new String(bajadaC));
				n = b - a;
				bw.write(b + " - " + a + " = " + n + "\n");
				if(numeros.contains(n))
				{
					bw.write("Chain length " + iteraciones + "\n");
					bw.write("\n");
					break;
				}
				else
				{
					numeros.add(n);
				}
			}
			
		}
	}
	
	static class comparador implements Comparator <Character>
	{

		@Override
		public int compare(Character o1, Character o2) 
		{
			return o2.compareTo(o1);
		}
		
	}
}
