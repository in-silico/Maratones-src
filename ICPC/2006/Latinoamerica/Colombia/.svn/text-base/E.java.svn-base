import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;


public class E 
{
	static class Point2D
	{
		BigInteger x, y;
		
		public Point2D(BigInteger xx, BigInteger yy)
		{
			x = xx;
			y = yy;
		}
	}
	
	static class Line2D
	{
		Point2D p1, p2;
		
		public Line2D(Point2D s, Point2D e)
		{
			p1 = s;
			p2 = e;
		}
		
		public Point2D getP1()
		{
			return p1;
		}
		
		public Point2D getP2()
		{
			return p2;
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
				lines.add(new Line2D(anterior, nuevo));
			}
			anterior = nuevo;
		}
		
		public void close()
		{
			lines.add(new Line2D(anterior, lines.get(0).getP1()));
		}
		
		public String area()
		{
			BigInteger area = BigInteger.ZERO;
			for(Line2D line : lines)
			{
				area = area.add(line.getP1().x.multiply(line.getP2().y));
				area = area.subtract(line.getP2().x.multiply(line.getP1().y));
			}
			area = area.abs().multiply(BigInteger.TEN).shiftRight(1);
			String areaF = area.toString();
			areaF = areaF.substring(0, areaF.length() - 1) + "." + areaF.charAt(areaF.length() - 1);
			return areaF.length() < 3 ? "0" + areaF : areaF;
		}
	}
	public static BigInteger sumatoria(BigInteger n)
	{
		return n.multiply(n.add(BigInteger.ONE)).shiftRight(1);
	}
	
	public static BigInteger antiSumatoria(BigInteger n)
	{
		BigInteger low = BigInteger.ZERO;
		BigInteger mid = null, sumatoriaMid;
		BigInteger high = n;
		while(low.compareTo(high) <= 0)
		{
			mid = low.add(high).shiftRight(1);
			sumatoriaMid = sumatoria(mid);
			if(n.compareTo(sumatoriaMid) > 0)
				low = mid.add(BigInteger.ONE);
			else if(n.equals(sumatoriaMid))
				return mid;
			else
				high = mid.subtract(BigInteger.ONE);
		}
		return mid.subtract(n.compareTo(sumatoria(mid)) < 0 ? BigInteger.ONE : BigInteger.ZERO);
	}
	
	public static Point2D partir(BigInteger numero)
	{
		BigInteger diagonal = antiSumatoria(numero);
		BigInteger sumatoriaDiagonal = sumatoria(diagonal);
		BigInteger y = numero.subtract(sumatoriaDiagonal);
		return new Point2D(diagonal.subtract(y), y);
	}
	
	public static Polygon calcularPoligono(BigInteger numero)
	{
		Point2D actual = partir(numero);
		int n = actual.x.intValue();
		Polygon poligono = new Polygon(n);
		for(int i = 0; i < n - 1; i++)
		{
			actual = partir(actual.y);
			poligono.add(partir(actual.x));
		}
		poligono.add(partir(actual.y));
		poligono.close();
		return poligono;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String lineaActual = null;
		while(!(lineaActual = br.readLine().replace(" ", "")).equals("*"))
		{
			System.out.println(calcularPoligono(new BigInteger(lineaActual)).area());
		}
	}
}
