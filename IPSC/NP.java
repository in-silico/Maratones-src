import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


public class NP
{
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
    
    public static void main(String[] args) throws FileNotFoundException
    {
    	Scanner sc = new Scanner(System.in);
    	while(true)
    	{
    		int n = sc.nextInt();
    		int m = sc.nextInt();
    		if(n == 0 && m == 0)
    			return;
    		Polygon poligono = new Polygon(n);
    		for(int i = 0; i < n; i++)
    		{
    			poligono.add(new Point2D.Double(sc.nextInt(), sc.nextInt()));
    		}
    		poligono.close();
    		long areaTotal = 0;
    		for(int i = 0; i < m; i++)
    		{
    			long x1 = sc.nextInt();
    			long y1 = sc.nextInt();
    			long x2 = sc.nextInt();
    			long y2 = sc.nextInt();
    			LinkedList <Point2D> puntos = new LinkedList <Point2D> ();
    			puntos.add(new Point2D.Double(x1, y1));
    			puntos.add(new Point2D.Double(x2, y2));
    			puntos.add(new Point2D.Double(x1, y2));
    			puntos.add(new Point2D.Double(x2, y1));
    			for(Iterator <Point2D> it = puntos.iterator(); it.hasNext();)
					if(poligono.contains(it.next()))
						it.remove();
    			if(puntos.isEmpty())
    			{
    				areaTotal += Math.abs(x2 - x1) * Math.abs(y2 - y1);
    			}
    		}
    		if(Math.abs(areaTotal - poligono.area()) < 1e-6)
    			System.out.println("YES");
    		else
    			System.out.println("NO");
    	}
    }
}
