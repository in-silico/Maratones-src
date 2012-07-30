import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.Scanner;

public class Babel 
{
	static class Bloque
	{
		Point2D centro;
		int radio2;

		public Bloque(double x, double y, int r, boolean a)
		{
			centro = new Point2D.Double(x, y);
			radio2 = r * r;
		}
		
		public Bloque(double x, double y, int r)
		{
			centro = new Point2D.Double(x, y);
			radio2 = r;
		}
		
		public Bloque unir(Bloque otro)
		{
			double xx = otro.centro.getX() * otro.radio2 + centro.getX() * radio2;
			double yy = otro.centro.getY() * otro.radio2 + centro.getY() * radio2;
			int rr = otro.radio2 + radio2;
			xx /= rr;
			yy /= rr;
			return new Bloque(xx, yy, rr);
		}
		
		public boolean estaDentro(Point2D otro)
		{
			double distancia = otro.distanceSq(centro);
			return distancia < radio2;
		}
	}
	
	static class Torre
	{
		LinkedList <Bloque> bloques = new LinkedList <Bloque> ();
		
		public Torre subTorre(int hasta)
		{
			Torre nueva = new Torre();
			for(int i = 0; i <= hasta; i++)
				nueva.bloques.add(bloques.get(i));
			return nueva;
		}
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0)
				return;
			Torre torre = new Torre();
			for(int i = 0; i < n; i++)
				torre.bloques.add(new Bloque(sc.nextInt(), sc.nextInt(), sc.nextInt(), true));
			boolean paila = false;
			int nPaila = -1;
			for(int i = 1; i < n; i++)
			{
				Torre sTorre = torre.subTorre(i);
				while(sTorre.bloques.size() != 1)
				{
					if(sTorre.bloques.get(sTorre.bloques.size() - 2).estaDentro(sTorre.bloques.peekLast().centro))
						sTorre.bloques.add(sTorre.bloques.pollLast().unir(sTorre.bloques.pollLast()));
					else
					{
						paila = true;
						nPaila = i;
						break;
					}
				}
				if(paila)
					break;
			}
			if(paila)
				System.out.println("Unfeasible " + nPaila);
			else
				System.out.println("Feasible");
		}
	}
}
