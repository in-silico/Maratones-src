import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;


public class Parking 
{
	
	static class Carro implements Comparable <Carro>
	{
		int original;
		int parque = -1;
		int actual;
		
		public Carro(int o)
		{
			original = o;
			actual = o;
		}

		@Override
		public int compareTo(Carro o) {
			return Integer.valueOf(actual).compareTo(o.actual);
		}
	}
	
	
	static LinkedList <Carro> carros = new LinkedList <Carro> ();
	static ArrayList <Carro> carrosOrden = new ArrayList <Carro> (20);
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.readLine();
		while(n-- != 0)
		{
			int lectura;
			carros.clear();
			carrosOrden.clear();
			while((lectura = Integer.parseInt(br.readLine())) != 99)
				carrosOrden.add(new Carro(lectura));
			carros.addAll(carrosOrden);
			String siguiente;
			while((siguiente = br.readLine()) != null && !siguiente.equals(""))
			{
				int deSalida = Integer.parseInt(siguiente);
				Collections.sort(carros);
				int indice = -1;
				for(Carro c : carros)
					if(c.actual > deSalida)
						break;
					else
						indice = c.actual;
				int aMoverse = -1;
				if(indice == -1)
				{
					Carro ultimo = carros.removeLast();
					ultimo.parque = deSalida;
					aMoverse = 20 + deSalida - ultimo.actual;
				}
				else
				{
					for(Iterator <Carro> it = carros.iterator(); it.hasNext();)
					{
						Carro actual = it.next();
						if(actual.actual == indice)
						{
							it.remove();
							actual.parque = deSalida;
							aMoverse = deSalida - actual.actual;
						}
					}
				}
				for(Carro c : carros)
				{
					c.actual += aMoverse;
					if(c.actual > 20)
						c.actual = c.actual - 20;
				}
			}
			for(Carro c : carrosOrden)
			{
				System.out.print("Original position " + c.original);
				if(c.parque == -1)
					System.out.println(" did not park");
				else
					System.out.println(" parked in " + c.parque);
			}
			if(n != 0)
				System.out.println();
		}
	}
}
