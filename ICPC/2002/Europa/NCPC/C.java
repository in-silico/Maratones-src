import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.PriorityQueue;
import java.util.Scanner;


public class C 
{
	static class Rango implements Comparable <Rango>
	{
		int a;
		int b;
		
		public Rango(int a, int b) 
		{
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Rango o) 
		{
			if(a == o.a)
				return b - o.b;
			return a - o.a;
		}
		
		
	}
	
	public static boolean simular(int empleados, Rango[] r)
	{
		PriorityQueue <Rango> pq = new PriorityQueue <Rango> ();
		for(Rango rango : r)
			pq.add(rango);
		for(int i = 0; true; i++)
		{
			if(pq.isEmpty())
				break;
			if(i % 7 == 5 || i % 7 == 6)
				continue;
			if(pq.peek().b < i)
				return false;
			int cuentaEmpleados = 0;
			while(pq.peek().a <= i && pq.peek().b >= i)
			{
				if(cuentaEmpleados++ == empleados)
					break;
				pq.poll();
				if(pq.isEmpty())
					return true;
			}
		}
		return true;
	}
	
	public static boolean simularF(int empleados, Rango[] r)
	{
		PriorityQueue <Rango> pq = new PriorityQueue <Rango> ();
		for(Rango rango : r)
			pq.add(rango);
		for(int i = 0; true; i++)
		{
			if(pq.isEmpty())
				break;
			if(pq.peek().b < i)
				return false;
			int cuentaEmpleados = 0;
			while(pq.peek().a <= i && pq.peek().b >= i)
			{
				if(cuentaEmpleados++ == empleados)
					break;
				pq.poll();
				if(pq.isEmpty())
					return true;
			}
		}
		return true;
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		System.setIn(new FileInputStream("c.in"));
		System.setOut(new PrintStream("c.salida"));
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int i = 0; i < tc; i++)
		{
			int m = sc.nextInt();
			int p = sc.nextInt() >> 1;
			Rango[] rangos = new Rango[m];
			for(int j = 0; j < m; j++)
				rangos[j] = new Rango(sc.nextInt() - 1, sc.nextInt() - 1);
			if(simular(p, rangos))
				System.out.println("fine");
			else if(simularF(p, rangos))
				System.out.println("weekend work");
			else
				System.out.println("serious trouble");
		}
	}
}
