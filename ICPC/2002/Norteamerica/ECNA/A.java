import java.awt.geom.Line2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;


public class A 
{
	
	static class Linea
	{
		Line2D linea;
		int n;
		
		public Linea(Line2D l, int nn)
		{
			linea = l;
			n = nn;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		LinkedList <Linea> top = new LinkedList <Linea> ();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			top.clear();
			int n = Integer.parseInt(br.readLine());
			if(n == 0)
				return;
			for(int i = 1; i <= n; i++)
			{
				String[] pedazos = br.readLine().split(" ");
				Linea nueva = new Linea(new Line2D.Double(Double.parseDouble(pedazos[0]), Double.parseDouble(pedazos[1]), Double.parseDouble(pedazos[2]), Double.parseDouble(pedazos[3])), i);
				ListIterator <Linea> it = top.listIterator();
				while(it.hasNext())
				{
					Linea anterior = it.next();
					if(anterior.linea.intersectsLine(nueva.linea))
						it.remove();
				}
				top.add(nueva);
			}
			boolean empezo = false;
			System.out.print("Top sticks: ");
			for(Linea l : top)
			{
				if(empezo)
					System.out.print(", " + l.n);
				else
				{
					System.out.print(l.n);
					empezo = true;
				}	
			}
			System.out.println(".");
		}
	}

}
