package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;



public class exchanging 
{
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String [] args)
	{
		while(true)
		{
			int a = leerNumero();
			int b = leerNumero();
			if(a == 0 && b == 0) return;
			HashSet <Integer> as = new HashSet <Integer> ();
			HashSet <Integer> bs = new HashSet <Integer> ();
			for(int i = 0; i < a; i++)
				as.add(leerNumero());
			for(int i = 0; i < b; i++)
				bs.add(leerNumero());
			ArrayList <Integer> asmbs = new ArrayList <Integer> ();
			asmbs.addAll(as);
			for(int i : as)
			{
				if(bs.contains(i))
					asmbs.remove(new Integer(i));
			}
			ArrayList <Integer> bsmas = new ArrayList <Integer> ();
			bsmas.addAll(bs);
			for(int i : bs)
			{
				if(as.contains(i))
					bsmas.remove(new Integer(i));
			}
			System.out.println(Math.min(asmbs.size(), bsmas.size()));
		}
	}
	
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
}
