import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class D 
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner()
		{
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public String next()
		{

			while(st == null || !st.hasMoreTokens())
			{
				try { st = new StringTokenizer(br.readLine()); }
				catch(Exception e) { throw new RuntimeException(); }
			}
			return st.nextToken();
		}
		
		public int nextInt()
		{
			return Integer.parseInt(next());
		}
		
		public double nextDouble()
		{
			return Double.parseDouble(next());
		}
		
		public String nextLine()
		{
			st = null;
			try { return br.readLine(); }
			catch(Exception e) { throw new RuntimeException(); }
		}
	}
	
	static class Task
	{
		int numero;
		int bs;
		int significancia = -1;
		LinkedList <Task> dependeDe = new LinkedList <Task> ();
		LinkedList <Task> deEllaDependen = new LinkedList <Task> ();
		Boolean[] depende;
		
		public Task(int i)
		{
			numero = i;
			depende = new Boolean[t + 1];
		}
		
		public void calcularSignificancia() 
		{
			if(significancia != -1)
				return;
			significancia = bs;
			for(Task t : deEllaDependen)
			{
				t.calcularSignificancia();
				significancia += t.significancia;
			}
		} 
		
		public boolean depende(Task t)
		{
			if(depende[t.numero] != null)
				return depende[t.numero];
			if(dependeDe.contains(t))
			{
				depende[t.numero] = true;
				return true;
			}
			for(Task i : dependeDe)
			{
				if(i.depende(t))
				{
					depende[t.numero] = true;
					return true;
				}
			}
			depende[t.numero] = false;
			return false;
		}
	}
	
	static class Employee
	{
		LinkedList <Task> tareas = new LinkedList <Task> ();
	}
	
	
	static Task[] tareas = new Task[1001];
	static Employee[] empleados = new Employee[1001];
	static int t;
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			t = sc.nextInt();
			int e = sc.nextInt();
			if(t == 0 && e == 0)
				return;
			for(int i = 1; i <= t; i++)
				tareas[i] = new Task(i);
			for(int j = 1; j <= e; j++)
				empleados[j] = new Employee();
			for(int i = 1; i <= t; i++)
			{
				tareas[i].bs = sc.nextInt();
				int nd = sc.nextInt();
				int ne = sc.nextInt();
				for(int j = 0; j < nd; j++)
				{
					int vecina = sc.nextInt();
					tareas[i].deEllaDependen.add(tareas[vecina]);
					tareas[vecina].dependeDe.add(tareas[i]);
				}
				for(int j = 0; j < ne; j++)
					empleados[sc.nextInt()].tareas.add(tareas[i]);
			}
			for(int i = 1; i <= t; i++)
				tareas[i].calcularSignificancia();
			System.out.println("*****");
			for(int i = 1; i <= e; i++)
			{
				int salario = 0;
				for(Task t : empleados[i].tareas)
				{
					boolean si = true;
					for(Task t1 : empleados[i].tareas)
					{
						if(t == t1)
							continue;
						if(t.depende(t1))
						{
							si = false;
							break;
						}
					}
					if(si)
						salario += t.significancia;
				}
				System.out.println(i + " " + salario);
			}
		}
	}
}
