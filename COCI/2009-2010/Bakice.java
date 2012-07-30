import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


public class Bakice  
{
	
	static class Silla
	{
		int x;
		int y;
		
		public Silla(int x, int y)
		{
			this.x = x;
			this.y = y;
		}

		public int distancia(Persona p)
		{
			return (x - p.x) * (x - p .x) + (y - p.y) * (y - p.y);
		}
	}
	static class Persona
	{
		int x;
		int y;
		
		public Persona(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
		
		
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		sc.nextInt();
		sc.nextLine();
		LinkedList <Persona> p = new LinkedList <Persona> ();
		LinkedList <Silla> s = new LinkedList <Silla> ();
		for(int i = 0; i < r; i++)
		{
			int j = 0;
			for(char cc : sc.nextLine().toCharArray())
			{
				if(cc == 'L')
					s.add(new Silla(i, j));
				else if(cc == 'X')
					p.add(new Persona(i, j));
				j++;
			}
		}
		int explosiones = 0;
		while(!s.isEmpty() && !p.isEmpty())
		{
			int menorDistancia = Integer.MAX_VALUE;
			Silla menor = null;
			for(Persona persona : p)
			{
				for(Silla silla : s)
				{
					if(silla.distancia(persona) < menorDistancia)
					{
						menorDistancia = silla.distancia(persona);
						menor = silla;
					}
				}
			}
			int cuenta = 0;
			Iterator <Persona> it = p.iterator();
			while(it.hasNext())
			{
				Persona persona = it.next();
				if(menor.distancia(persona) == menorDistancia)
				{
					cuenta++;
					it.remove();
				}
			}
			if(cuenta > 1)
				explosiones++;
			s.remove(menor);
		}
		System.out.println(explosiones);
	}
}