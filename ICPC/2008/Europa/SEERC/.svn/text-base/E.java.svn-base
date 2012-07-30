import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class E
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner()
		{
	    	System.setOut(new PrintStream(new BufferedOutputStream(System.out), true));
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
				return !st.hasMoreTokens();
			}
			catch(Exception e) { throw new RuntimeException(); }
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
                    return abs(subtract(a, c)) + abs(subtract(b, c)) <= abs(subtract(a, b));
            }

            // Ya esta implementado en ((Line2D) lineA).intersectsLine(lineB)
            public static boolean lines_intersect(Line2D a, Line2D b)
            {
                    return cross(subtract(a.getP2(), a.getP1()), subtract(b.getP1(), a.getP1())) *
                               cross(subtract(a.getP2(), a.getP1()), subtract(b.getP2(), a.getP1())) < 0 && 
                               cross(subtract(b.getP2(), b.getP1()), subtract(a.getP1(), b.getP1())) *
                               cross(subtract(b.getP2(), b.getP1()), subtract(a.getP2(), b.getP1())) < 0;
            }
            
            // Funciona para cualquier poligono excepto si es self-intersecting
            public double area() 
            {
                    double area = 0;
                    for (Line2D line : lines) 
                    {
                            area += line.getP1().getX() * line.getP2().getY();
                            area -= line.getP2().getX() * line.getP1().getY();
                    }
                    area /= 2.0;
                    return Math.abs(area);
            }

            // Funciona para cualquier poligono excepto si es self-intersecting
            public double areaUnsigned() 
            {
                    double area = 0;
                    for (Line2D line : lines) 
                    {
                            area += line.getP1().getX() * line.getP2().getY();
                            area -= line.getP2().getX() * line.getP1().getY();
                    }
                    area /= 2.0;
                    return area;
            }

            // Funciona para cualquier poligono excepto si es self-intersecting
            public Point2D centerOfMass() 
            {
                    double cx = 0, cy = 0;
                    double area = areaUnsigned();
                    double factor = 0;
                    for (Line2D line : lines) 
                    {
                            factor = line.getP1().getX() * line.getP2().getY() - line.getP2().getX() * line.getP1().getY();
                            cx += (line.getP1().getX() + line.getP2().getX()) * factor;
                            cy += (line.getP1().getY() + line.getP2().getY()) * factor;
                    }
                    area *= 6.0d;
                    factor = 1 / area;
                    cx *= factor;
                    cy *= factor;
                    return new Point2D.Double(cx, cy);
            }
            
            public boolean intersects(Polygon other)
            {
                    for(Line2D lineA : lines)
                    {
                            if(other.contains(lineA.getP1()))
                                    return true;
                            for(Line2D lineB : other.lines)
                            {
                                    if(lineA.intersectsLine(lineB))
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
                        if (curr.getY() < 0 && 0 <= next.getY() && cross(next, curr) >= 0)
                        {
                            cnt++;
                        }
                        if (is_point_online(line.getP1(), line.getP2(), p))
                                    return true;
                      }
                      return  cnt % 2 == 1;
            }
    }
    
    public static void main(String[] args)
    {
    	Scanner sc = new Scanner();
    	while(true)
    	{
    		int n = sc.nextInt();
    		if(n == 0)
    			return;
    		Polygon p = new Polygon(n);
    		for(int i = 0; i < n; i++)
    			p.add(new Point2D.Double(sc.nextDouble(), sc.nextDouble()));
    		if(n < 3)
    			System.out.println("0");
    		else
    		{
    			p.close();
    			System.out.println(Math.round(p.area()));
    		}
    	}
    }
}