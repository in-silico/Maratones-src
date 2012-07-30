import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;


public class I 
{
	static String letras;
	
	static class Nombre implements Comparable <Nombre>
	{
		String n;

		public Nombre(String nombre)
		{
			n = nombre;
		}
		@Override
		public int compareTo(Nombre o) 
		{
			for(int i = 0; i < n.length(); i++)
			{
				if(i >= o.n.length())
					break;
				if(o.n.charAt(i) != n.charAt(i))
					return letras.indexOf(n.charAt(i)) - letras.indexOf(o.n.charAt(i));
			}
			return n.length() - o.n.length();
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		System.setIn(new FileInputStream("s.txt"));
		System.setOut(new PrintStream("salds.txt"));
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		letras = br.readLine();
		ArrayList <Nombre> nombres = new ArrayList <Nombre> ();
		while(true)
		{
			String siguiente = br.readLine();
			if(siguiente == null)
				break;
			nombres.add(new Nombre(siguiente));
		}
		Collections.sort(nombres);
		for(Nombre nombre : nombres)
		{
			System.out.println(nombre.n);
		}
	}
}