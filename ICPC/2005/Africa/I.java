import java.util.Scanner;
import java.util.TreeSet;

public class I 
{
	static class Punto implements Comparable <Punto>
	{
		int x, y;
		
		public Punto(int i, int j)
		{
			x = i;
			y = j;
		}

		@Override
		public int compareTo(Punto o) 
		{
			if(o.x == x)
				return Integer.valueOf(o.y).compareTo(y);
			return Integer.valueOf(o.x).compareTo(x);
		}
	}

	static TreeSet <Punto> puntos = new TreeSet <Punto> ();
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int i = 0;
			int j = 0;
			String entrada = sc.nextLine();
			if(entrada.equals("Q"))
				return;
			puntos.clear();
			puntos.add(new Punto(0, 0));
			int cuenta = 0;
			for(char c : entrada.toCharArray())
			{
				if(c == 'Q')
					break;
				if(c == 'U')
					i++;
				if(c == 'D')
					i--;
				if(c == 'R')
					j++;
				if(c == 'L')
					j--;
				Punto nuevo = new Punto(i, j);
				if(puntos.contains(nuevo))
					cuenta++;
				else
					puntos.add(nuevo);
			}
			System.out.println(cuenta);
		}
	}
}
