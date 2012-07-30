import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


public class Natjecanje
{
	
	static int mejor(LinkedList <Integer> s, ArrayList <Integer> r, int actual)
	{
		if(actual == r.size())
			return s.size();
		int mejor = Integer.MAX_VALUE;
		int a = r.get(actual);
		for(int i = 0; i < s.size(); i++)
		{
			int val = s.get(i);
			if(Math.abs(val - a) == 1)
			{
				s.remove(i);
				mejor = Math.min(mejor, mejor(s, r, actual + 1));
				s.add(i, val);
			}
		}
		mejor = Math.min(mejor, mejor(s, r, actual + 1));
		return mejor;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		int s = sc.nextInt();
		int r = sc.nextInt();
		LinkedList <Integer> sL = new LinkedList <Integer> ();
		ArrayList <Integer> rL = new ArrayList <Integer> ();
		for(int i = 0; i < s; i++)
			sL.add(sc.nextInt());
		for(int i = 0; i < r; i++)
			rL.add(sc.nextInt());
		Iterator <Integer> it = sL.iterator();
		while(it.hasNext())
		{
			int i = it.next();
			if(rL.contains(i))
			{
				rL.remove(Integer.valueOf(i));
				it.remove();
			}
		}
		System.out.println(mejor(sL, rL, 0));
	}

}
