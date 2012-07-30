import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


public class E 
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
		
		public boolean endLine()
		{
			try 
			{
				String next = br.readLine();
				while(next != null && next.trim().isEmpty())
					next = br.readLine();
				if(next == null)
					return true;
				st = new StringTokenizer(next);
				return false;
			}
			catch(Exception e) { throw new RuntimeException(); }
		}
	}

	static double cross(Point2D p1, Point2D p2, Point2D p3)
	{
	    return (p2.getX() - p1.getX()) * (p3.getY() - p1.getY()) - (p2.getY() - p1.getY()) * (p3.getX() - p1.getX());
	}

	static class Comp implements Comparator <Point2D>
	{
		@Override
		public int compare(Point2D p1, Point2D p2) 
		{
			if(p1.getY() < p2.getY()) return -1;
			if(p1.getY() > p2.getY()) return 1;
			if(p1.getX() < p2.getX()) return -1;
			return 1;
		}
	}

	static final double EPSILON = 1e-12;
	
	static void convexHull(List <Point2D> points, List <Point2D> result)
	{
		int n = points.size();
		Point2D[] p2 = new Point2D[points.size() + 1];
	    Collections.sort(points, new Comp());
	    int top = 0;
	    p2[top++] = points.get(0);
	    p2[top++] = points.get(1);
	    for (int i = 2; i < n; i++)
	    {
	        while (top >= 2 && cross(p2[top - 2], p2[top - 1], points.get(i)) <= -EPSILON)
	            --top;
	        p2[top++] = points.get(i);
	    }
	    int r = top;
	    for (int i = n - 2; i >= 0; i--)
	    {
	        while (top > r && cross(p2[top - 2], p2[top - 1], points.get(i)) <= -EPSILON)
	            --top;
	        if (i != 0)
	            p2[top++] = points.get(i);
	    }
	    for(int i = 0; i < top; i++)
	    	result.add(p2[i]);
	}

	public static void main(String[] args)
	{
		LinkedList <Point2D> puntos = new LinkedList <Point2D> ();
		ArrayList <Point2D> resultado = new ArrayList <Point2D> ();
		Scanner sc = new Scanner();
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0)
				return;
			sc.endLine();
			puntos.clear();
			for(int i = 0; i < n; i++)
			{
				puntos.add(new Point2D.Double(sc.nextInt(), sc.nextInt()));
				sc.endLine();
			}
			int cuenta = 0;
			while(!puntos.isEmpty())
			{
				resultado.clear();
				convexHull(puntos, resultado);
				puntos.removeAll(resultado);
				cuenta++;
				if(puntos.size() != 0 && puntos.size() < 3)
					break;
			}
			System.out.println(((cuenta & 1) == 1) ? "Take this onion to the lab!" : "Do not take this onion to the lab!");
		}
	}

}
