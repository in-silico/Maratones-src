import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Compound
{
	static HashMap <String, String> palabras = new HashMap <String, String> ();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException
	{
		ArrayList <String> dobles = new ArrayList <String> (120000);
		while(true)
		{
			String nueva = br.readLine();
			if(nueva == null)
				break;
			palabras.put(nueva, nueva);
		}
		for(String s : palabras.keySet())
		{
			for(int i = 0; i < s.length(); i++)
				if(palabras.containsKey(s.substring(0, i + 1)) && palabras.containsKey(s.substring(i + 1, s.length())))
				{
					dobles.add(s);
					break;
				}
		}
		Collections.sort(dobles);
		for(String s : dobles)
			System.out.println(s);
	}
}
