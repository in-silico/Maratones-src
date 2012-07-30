import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;


public class Mash
{
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = 1;
		while(true)
		{
			String linea = br.readLine();
			if(linea == null)
				return;
			String[] pedazos = linea.split(" ");
			int n = Integer.parseInt(pedazos[0]);
			int lucky = Integer.parseInt(pedazos[1]);
			LinkedList <Integer> cartas = new LinkedList <Integer> ();
			for(int i = 2; i < 22; i++)
			{
				cartas.add(Integer.parseInt(pedazos[i]));
			}
			LinkedList <Integer> fila = new LinkedList <Integer> ();
			for(int i = 1; i <= n; i++)
				fila.add(i);
			while(true)
			{
				if(fila.size() == lucky)
					break;
				if(cartas.isEmpty())
					break;			
				int cartaActual = cartas.removeFirst();
				int cuenta = 1;
				for(Iterator <Integer> it = fila.iterator(); it.hasNext(); )
				{
					it.next();
					if(cuenta++ == cartaActual)
					{
						it.remove();
						if(fila.size() == lucky)
							break;
						cuenta = 1;
					}
				}
			}
			int a = 0;
			System.out.println("Selection #" + num++);
			for(int i : fila)
				if(a++ == 0)
					System.out.print(i);
				else
					System.out.print(" " + i);
			System.out.println();
			System.out.println();
		}
	}
	

}
