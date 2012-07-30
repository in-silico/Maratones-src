import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class Beggar 
{
	static class Carta implements Comparable <Carta>
	{
		char [] carta;
	    int valor;
	    int pinta;
	    
		Carta(char numero, char suit)
		{
			carta = new char[2];
			carta[0] = numero;
			carta[1] = suit;
		    switch(numero)
		    {
		            case 'T': valor = 10; break;
		            case 'J': valor = 11; break;
		            case 'Q': valor = 12; break;
		            case 'K': valor = 13; break;
		            case 'A': valor = 14; break;
		            default: valor = numero - '0'; break;
		    }
		    switch(suit)
		    {
		            case 'H': pinta = 1; break;
		            case 'D': pinta = 2; break;
		            case 'S': pinta = 3; break;
		            default: pinta = 4; break;
		    }
	    }
	    
	    @Override
	    public int compareTo(Carta otra) 
	    {
	            if(valor < otra.valor)
	                    return 1;
	            else if(valor > otra.valor)
	                    return -1;
	            else
	                    return 0;
	    }       
	    
	    @Override
	    public String toString()
	    {
	    	return new String(carta);
	    }
	}
	
	static LinkedList <Carta> nondealer = new LinkedList <Carta> ();
	static LinkedList <Carta> dealer = new LinkedList <Carta> ();
	static LinkedList <Carta> actuales = new LinkedList <Carta> ();
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			LinkedList <Carta> mazo = new LinkedList <Carta> ();
			actuales.clear();
			nondealer.clear();
			dealer.clear();
			termino = false;
			for(int i = 0; i < 4; i++)
			{
				String linea = br.readLine();
				if(linea.contains("#"))
					return;
				String[] cartas = linea.split(" ");
				for(String s : cartas)
					mazo.add(new Carta(s.charAt(1), s.charAt(0)));
			}
			for(int i = 0; i < 26; i++)
			{
				nondealer.add(mazo.removeFirst());
				dealer.add(mazo.removeFirst());
			}
			boolean quien = false;
			while(true)
			{
				if(quien)
				{
					if(dealer.isEmpty())
						break;
					actuales.add(dealer.removeLast());
				}
				else
				{
					if(nondealer.isEmpty())
						break;
					actuales.add(nondealer.removeLast());
				}
				Carta ultima = actuales.peekLast();
				if(ultima.valor > 10)
				{
					cubrir(!quien);
					if(termino)
					{
						quien = quienPerdio;
						break;
					}
					if(!mayor)
					{
						while(!actuales.isEmpty())
							nondealer.addFirst(actuales.removeFirst());
					}
					else
					{
						while(!actuales.isEmpty())
							dealer.addFirst(actuales.removeFirst());
					}
					actuales.clear();
					quien = mayor;
				}
				else
				{
					quien = !quien;
				}
			}
			if(!quien)
			{
				if(dealer.size() > 10)
					System.out.println("1 " + dealer.size());
				else
					System.out.println("1  " + dealer.size());
			}
			else
			{
				if(nondealer.size() > 10)
					System.out.println("2 " + nondealer.size());
				else
					System.out.println("2  " + nondealer.size());
			}
		}
	}
	
	static boolean mayor;
	static boolean termino;
	static boolean quienPerdio;
	
	private static void cubrir(boolean quien) 
	{
		if(termino)
			return;
		mayor = !quien;
		int aCubrir = actuales.peekLast().valor - 10;
		for(int i = 0; i < aCubrir; i++)
		{
			if(quien)
			{
				if(dealer.isEmpty())
				{
					termino = true;
					quienPerdio = true;
					break;
				}
				actuales.add(dealer.removeLast());
			}
			else
			{
				if(nondealer.isEmpty())
				{
					termino = true;
					quienPerdio = false;
					break;
				}
				actuales.add(nondealer.removeLast());
			}
			if(actuales.peekLast().valor > 10)
			{
				cubrir(!quien);
				return;
			}
		}
	}

}
