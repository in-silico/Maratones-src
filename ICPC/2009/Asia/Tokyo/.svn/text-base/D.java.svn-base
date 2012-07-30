import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;


public class D 
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st = null;
		
		public Scanner()
		{
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public int nextInt()
		{
			try
			{
				while(st == null || !st.hasMoreTokens())
					st = new StringTokenizer(br.readLine());
				return Integer.parseInt(st.nextToken());
			}
			catch(Exception e)
			{
				throw(new RuntimeException());
			}
		}
	}
	
	static class Polygon
	{
		ArrayList <Line2D> lines;
		Point2D anterior = null;
		
		public Polygon(int minSize)
		{
			lines = new ArrayList <Line2D> (minSize);
		}
		
		public void add(Point2D nuevo)
		{
			if(anterior != null)
			{
					lines.add(new Line2D.Double(anterior, nuevo));
			}
			anterior = nuevo;
		}
		
		public void close()
		{
			lines.add(new Line2D.Double(anterior, lines.get(0).getP1()));
		}
		
		public static Point2D subtract(Point2D a, Point2D b)
		{
			return new Point2D.Double(a.getX() - b.getX(), a.getY() - b.getY());
		}
		
		static double abs(Point2D a)
		{
			return Math.sqrt(a.getX() * a.getX() + a.getY() * a.getY());
		}	
		
		static double cross(Point2D a, Point2D b)
		{
			return (a.getX() * b.getY()) - (a.getY() * b.getX());
		}
		
		static boolean is_point_online(Point2D a, Point2D b, Point2D c)
		{
			return abs(subtract(a, c)) + abs(subtract(b,c)) <= abs(subtract(a, b));
		}
		
		public boolean intersects(Polygon other)
		{
			for(Line2D lineaA : lines)
			{
				if(other.contains(lineaA.getP1()))
					return true;
				for(Line2D lineB : other.lines)
				{
					if(lineaA.intersectsLine(lineB))
						return true;
				}
			}
			for(Line2D line : other.lines)
			{
				if(contains(line.getP1()))
					return true;
			}
			return false;
		}

		public boolean contains(Point2D p)
		{
			int cnt = 0;
			for(Line2D line : lines)
			{
				Point2D curr = subtract(line.getP1(), p);
				Point2D next = subtract(line.getP2(), p);
				if(curr.getY() > next.getY())
				{
					Point2D temp = curr;
					curr = next;
					next = temp;
				}
				if(curr.getY() < 0 && 0 <= next.getY() && cross(next, curr) >= 0)
					cnt++;
				if(is_point_online(line.getP1(), line.getP2(), p))
					return true;
			}
			return cnt % 2 == 1;
		}
		
		public boolean containsLine(Line2D l)
		{
			for(Line2D line : lines)
				if(line.intersectsLine(l))
					return true;
			return false;
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
		for(int i = 2; i < n; i++)
		{
			while(top >= 2 && cross(p2[top - 2], p2[top - 1], points.get(i)) <= -EPSILON)
				--top;
			p2[top++] = points.get(i);
		}
		int r = top;
		for(int i = n - 2; i >= 0; i--)
		{
			while(top > r && cross(p2[top - 2], p2[top - 1], points.get(i)) <= -EPSILON)
				--top;
			if(i != 0)
				p2[top++] = points.get(i);
		}
		for(int i = 0; i < top; i++)
			result.add(p2[i]);
	}
	
	public static Polygon sacarP(ArrayList <Point2D> a)
	{
		Polygon p = new Polygon(a.size() + 1);
		for(Point2D pu : a)
			p.add(pu);
		p.close();
		return p;
	}
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner();
		while(true)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			if(n == 0 && m == 0)
				return;
			ArrayList <Point2D> a = new ArrayList <Point2D> ();
			ArrayList <Point2D> b = new ArrayList <Point2D> ();
			for(int i = 0; i < n; i++)
				a.add(new Point2D.Double(sc.nextInt(), sc.nextInt()));
			for(int i = 0; i < m; i++)
				b.add(new Point2D.Double(sc.nextInt(), sc.nextInt()));
			if(n > 2)
			{
				ArrayList <Point2D> nuevo = new ArrayList <Point2D> ();
				convexHull(a, nuevo);
				a = nuevo;
			}
			if(m > 2)
			{
				ArrayList <Point2D> nuevo = new ArrayList <Point2D> ();
				convexHull(b, nuevo);
				b = nuevo;
			}
			if(n > 2 && m > 2)
			{
				Polygon pA = sacarP(a);
				Polygon pB = sacarP(b);
				if(pA.intersects(pB))
					System.out.println("NO");
				else
					System.out.println("YES");
			}
			else if(n > 2 && m == 1)
			{
				Polygon pA = sacarP(a);
				Point2D pu = b.get(0);
				if(pA.contains(pu))
					System.out.println("NO");
				else
					System.out.println("YES");
			}
			else if(n == 1 && m > 2)
			{
				Polygon pB = sacarP(b);
				Point2D pu = a.get(0);
				if(pB.contains(pu))
					System.out.println("NO");
				else
					System.out.println("YES");
			}
			else if(n > 2 && m == 2)
			{
				Polygon pA = sacarP(a);
				Line2D li = new Line2D.Double(b.get(0), b.get(1));
				if(pA.containsLine(li))
					System.out.println("NO");
				else
					System.out.println("YES");
			}
			else if(n == 2 && m > 2)
			{
				Polygon pB = sacarP(b);
				Line2D li = new Line2D.Double(a.get(0), a.get(1));
				if(pB.containsLine(li))
					System.out.println("NO");
				else
					System.out.println("YES");
			}
			else if(n == 2 && m == 2)
			{
				Line2D lA = new Line2D.Double(a.get(0), a.get(1));
				Line2D lB = new Line2D.Double(b.get(0), b.get(1));
				if(lA.intersectsLine(lB))
					System.out.println("NO");
				else
					System.out.println("YES");
			}
			else if(n == 2 && m == 1)
			{
				Line2D li = new Line2D.Double(a.get(0), a.get(1));
				Point2D pu = b.get(0);
				if(Polygon.is_point_online(li.getP1(), li.getP2(), pu))
					System.out.println("NO");
				else
					System.out.println("YES");
				
			}
			else if(n == 1 && m == 2)
			{
				Line2D li = new Line2D.Double(b.get(0), b.get(1));
				Point2D pu = a.get(0);
				if(Polygon.is_point_online(li.getP1(), li.getP2(), pu))
					System.out.println("NO");
				else
					System.out.println("YES");
			}
			else
				System.out.println("YES");
		}
	}
}
