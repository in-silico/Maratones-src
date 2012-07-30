import java.util.LinkedList;
import java.util.Scanner;


public class B 
{
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			LinkedList <Integer> a = new LinkedList <Integer> ();
			int n = sc.nextInt();
			if(n == 0)
				return;
			for(int i = 0; i < n; i++)
			{
				a.add(sc.nextInt());
			}
			LinkedList <Integer> b = new LinkedList <Integer> ();
			n = sc.nextInt();
			for(int i = 0; i < n; i++)
			{
				b.add(sc.nextInt());
			}
			int porA = 0;
			int porB = 0;
			while(!(a.isEmpty() && b.isEmpty()))
			{
				if(a.isEmpty())
				{
					porB += b.poll();
					continue;
				}
				else if(b.isEmpty())
				{
					porA += a.poll();
					continue;
				}
				if(a.peek() > b.peek())
				{
					porB += b.poll();
				}
				else if(a.peek() < b.peek())
				{
					porA += a.poll();
				}
				else
				{
					porA += a.poll();
					porB += b.poll();
					porA = Math.max(porA, porB);
					porB = porA;
				}
			}
			System.out.println(Math.max(porA, porB));
		}
	}
}
