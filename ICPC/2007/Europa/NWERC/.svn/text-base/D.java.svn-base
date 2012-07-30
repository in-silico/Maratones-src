import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.Scanner;


public class D 
{
	
	static Point2D interseccionLineas(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4)
	{
		double px = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) / ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));
		double py = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) / ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));
		return new Point2D.Double(px, py);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("INTERSECTING LINES OUTPUT");
		for(int i = 0; i < n; i++)
		{
			double x1 = sc.nextDouble();
			double y1 = sc.nextDouble();
			double x2 = sc.nextDouble();
			double y2 = sc.nextDouble();
			double x3 = sc.nextDouble();
			double y3 = sc.nextDouble();
			double x4 = sc.nextDouble();
			double y4 = sc.nextDouble();
			if(y2 - y1 == 0)
			{
				if(y4 - y3 == 0)
				{
					if(y1 == y3)
					{
						System.out.println("LINE");
					}
					else
					{
						System.out.println("NONE");
					}
				}
				else
				{
					Point2D interseccion = interseccionLineas(x1, y1, x2, y2, x3, y3, x4, y4);
					System.out.printf("POINT %.2d %.2d\n", interseccion.getX(), interseccion.getY());
				}
			}
			else
			{
				double ma = (x2 - x1) / (y2 - y1);
				double mb = (x4 - x3) / (y4 - y3);
				if(Math.abs(ma - mb) < 1e-6)
				{
					if(Math.abs((-y1 * ma + x1) - (-y3 * mb + x3)) < 1e-6)
					{
						System.out.println("LINE");
					}
					else
					{
						System.out.println("NONE");
					}
				}
				else
				{
					Point2D interseccion = interseccionLineas(x1, y1, x2, y2, x3, y3, x4, y4);
					System.out.printf("POINT %.2f %.2f\n", interseccion.getX(), interseccion.getY());
				}
			}
		}
		System.out.println("END OF OUTPUT");
	}

}
