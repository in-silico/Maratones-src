import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;


public class Minotaur 
{
	
	static class Caverna
	{
		char nombre;
		boolean candela = false;
		ArrayList <Caverna> siguientes = new ArrayList <Caverna> (256);
		
		public Caverna(char c)
		{
			nombre = c;
		}
	}
	
	static HashMap <Character, Caverna> cavernas = new HashMap <Character, Caverna> (256);
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(char a = 'A'; a <= 'Z'; a++)
			cavernas.put(a, new Caverna(a));
		while(true)
		{
			String linea = br.readLine();
			if(linea.contains("#"))
				return;
			for(char a = 'A'; a <= 'Z'; a++)
			{
				Caverna actual = cavernas.get(a);
				actual.candela = false;
				actual.siguientes.clear();
			}
			String[] pedazos = new String[2];
			int indice = linea.indexOf('.');
			pedazos[0] = linea.substring(0, indice);
			pedazos[1] = linea.substring(indice + 1, linea.length());
			String descripcion = pedazos[0];
			char[] desc = descripcion.toCharArray();
			int i = 0;
			while(i < desc.length)
			{
				char nombre = desc[i++];
				Caverna actual = cavernas.get(nombre);
				i++;
				while(i != desc.length && desc[i] != ';')
				{
					actual.siguientes.add(cavernas.get(desc[i++]));
				}
				i++;
			}
			String lineaNueva = pedazos[1];
			char m = lineaNueva.charAt(1);
			char t = lineaNueva.charAt(3);
			lineaNueva = lineaNueva.substring(5);
			int k = Integer.parseInt(lineaNueva);
			Caverna theseus = cavernas.get(t);
			Caverna minotauro = cavernas.get(m);
			int cuenta = 0;
			String salida = "";
			while(true)
			{
				boolean pudo = false;
				for(Caverna c : minotauro.siguientes)
				{
					if(!c.candela && c != theseus)
					{
						pudo = true;
						if(cuenta == k)	
						{
							theseus.candela = true;
							cuenta = 0;
							salida += " " + theseus.nombre;
						}
						theseus = minotauro;
						minotauro = c;
						cuenta++;
						break;
					}
				}
				if(!pudo)
				{
					if(cuenta == k)
						salida += " " + theseus.nombre;
					salida += " /" + minotauro.nombre;
					break;
				}
			}
			System.out.println(salida.substring(1));
		}
	}
}
