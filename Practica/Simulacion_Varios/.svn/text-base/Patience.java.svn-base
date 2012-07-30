import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class Patience 
{
	
	static class Carta
	{
		char pinta;
		char numero;
		
		public Carta(String s) 
		{
			numero = s.charAt(0);
			pinta = s.charAt(1);
		}

		public boolean cuadra(Carta otra)
		{
			return pinta == otra.pinta || numero == otra.numero;
		}
	}
	
	static LinkedList <LinkedList <Carta> > pilas;
	
	public static boolean intentar()
	{
		boolean movio = false;
		int indice = -1;
		while(++indice != pilas.size())
		{
			LinkedList <Carta> esta = pilas.get(indice);
			LinkedList <Carta> anterior = indice < 1 ? null : pilas.get(indice - 1);	
			LinkedList <Carta> tresAntes = indice < 3 ? null : pilas.get(indice - 3);
			if(tresAntes != null)
			{
				if(tresAntes.peekFirst().cuadra(esta.peekFirst()))
				{
					tresAntes.push(esta.pollFirst());
					movio = true;
					if(esta.isEmpty())
					{
						pilas.remove(indice);
					}
					break;
				}
			}
			if(anterior != null)
			{
				if(anterior.peekFirst().cuadra(esta.peekFirst()))
				{
					anterior.push(esta.pollFirst());
					movio = true;
					if(esta.isEmpty())
					{
						pilas.remove(indice);
					}
					break;
				}
			}
		}
		return movio;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String lineaUno = br.readLine();
			if(lineaUno.charAt(0) == '#')
				return;
			String lineaDos = br.readLine();
			String[] cartasUno = lineaUno.split(" ");
			String[] cartasDos = lineaDos.split(" ");
			pilas = new LinkedList< LinkedList <Carta> > ();
			for(String s : cartasUno)
			{
				LinkedList <Carta> nueva = new LinkedList <Carta> ();
				nueva.add(new Carta(s));
				pilas.add(nueva);
			}
			for(String s : cartasDos)
			{
				LinkedList <Carta> nueva = new LinkedList <Carta> ();
				nueva.add(new Carta(s));
				pilas.add(nueva);
			}
			while(intentar());
			if(pilas.size() > 1)
				System.out.print(pilas.size() + " piles remaining:");
			else
				System.out.print(pilas.size() + " pile remaining:");
			for(LinkedList <Carta> actual : pilas)
			{
				System.out.print(" " + actual.size());
			}
			System.out.println();
		}
	}

}
