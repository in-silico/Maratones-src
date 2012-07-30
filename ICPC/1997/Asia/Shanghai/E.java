import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class E
{
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nCasos = 1;
		while(true)
		{
			String turnoS = br.readLine().trim();
			int turnos = Integer.parseInt(turnoS);
			if(turnos == 0)
				break;
			System.out.println("Case " + nCasos++ + ":");
			LinkedList <Integer> a = new LinkedList <Integer> ();
			LinkedList <Integer> b = new LinkedList <Integer> ();
			LinkedList <Integer> mesa = new LinkedList <Integer> ();
			for(String s : br.readLine().split(" "))
			{
				if(Integer.parseInt(s) == 0)
					break;
				a.add(Integer.parseInt(s));
			}
			for(String s : br.readLine().split(" "))
			{
				if(Integer.parseInt(s) == 0)
					break;
				b.add(Integer.parseInt(s));
			}
			int turnoActual;
			LinkedList <Integer> actual = b;
			if(!a.isEmpty() && !b.isEmpty())
				for(turnoActual = 0; turnoActual < turnos; turnoActual++)
				{
					if(actual == a)
						actual = b;
					else
						actual = a;
					if(actual.isEmpty())
						break;
					int sacada = actual.pollFirst();
					if(mesa.contains(sacada))
					{
						actual.add(sacada);
						int esta = mesa.pollLast();
						while(esta != sacada)
						{
							actual.add(esta);
							esta = mesa.pollLast();
						}
						actual.add(esta);
					}
					else
					{
						mesa.add(sacada);
					}
				}
			if(a.isEmpty())
			{
				System.out.println("B");
			}
			else if(b.isEmpty())
			{
				System.out.println("A");
			}
			else
			{
				System.out.print(a.pollFirst());
				while(!a.isEmpty())
					System.out.print(" " + a.pollFirst());
				System.out.println();
				System.out.print(b.pollFirst());
				while(!b.isEmpty())
					System.out.print(" " + b.pollFirst());
				System.out.println();
				if(mesa.isEmpty())
				{
					System.out.print("NULL");
				}
				else
				{
					System.out.print(mesa.pollFirst());
					while(!mesa.isEmpty())
						System.out.print(" " + mesa.pollFirst());
				}
				System.out.println();
			}
		}
	}

}
