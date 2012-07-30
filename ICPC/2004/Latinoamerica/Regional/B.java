import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class B 
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
	
	static class Bola
	{
		double x;
		double y;
		boolean coche = false;
		boolean jugador = false;
		
		double distancia(Bola otra)
		{
			return Math.sqrt(((x - otra.x) * (x - otra.x)) + ((y - otra.y) * (y - otra.y)));
		}
	}
	
	private static double pega(Bola a, Bola b, double grados, double dist)
	{
		double x_2 = dist * Math.cos(Math.toRadians(grados)) + a.x;
		double y_2 = dist * Math.sin(Math.toRadians(grados)) + a.y;
		Line2D linea = new Line2D.Double(a.x, a.y, x_2, y_2);
		double v = linea.ptSegDist(new Point2D.Double(b.x, b.y));
		if(Math.abs(v) >= 10e-6)
			return 0;
		return dist - a.distancia(b);
	}
	
	static Bola desp(Bola a, double angle, double dist)
	{
		double x = a.x + dist * Math.cos(Math.toRadians(angle));
		double y = a.y + dist * Math.sin(Math.toRadians(angle));
		Bola b = new Bola();
		b.x = x;
		b.y = y;
		return b;
	}
	
	static ArrayList <Bola> actuales = new ArrayList <Bola> ();
	
	
	static class Pegada implements Comparable <Pegada>
	{
		Bola bola;
		double valor;
		
		Pegada(Bola b, double v)
		{
			bola = b;
			valor = v;
		}

		@Override
		public int compareTo(Pegada o) 
		{
			return Double.valueOf(valor).compareTo(o.valor);
		}
	}
	static void simular(Bola inicial, double angulo, double distancia)
	{
		Bola nueva = desp(inicial, angulo, distancia);
		ArrayList <Pegada> pegadas = new ArrayList <Pegada> ();
		for(Bola b : actuales)
		{
			double pegada = pega(inicial, b, angulo, distancia);
			if(Math.abs(pegada) >= 10e-6d)
				pegadas.add(new Pegada(b, inicial.distancia(b)));
		}
		Collections.sort(pegadas);
		actuales.add(inicial);
		Bola anterior = inicial;
		for(Pegada p : pegadas)
		{
			Bola b = p.bola;
			anterior.x = b.x;
			anterior.y = b.y;
			anterior = b;
		}
		anterior.x = nueva.x;
		anterior.y = nueva.y;
	}

	static void jugar(Scanner sc, boolean jugador)
	{
		Bola nueva = new Bola();
		nueva.jugador = jugador;
		nueva.x = sc.nextInt();
		nueva.y = sc.nextInt();
		int angulo = sc.nextInt();
		int distancia = sc.nextInt();
		simular(nueva, angulo, distancia);
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int nc = sc.nextInt();
		for(int aa = 0; aa < nc; aa++)
		{
			String jA = sc.next();
			String jB = sc.next();
			actuales.clear();
			Bola coche = new Bola();
			coche.coche = true;
			coche.x = sc.nextInt();
			coche.y = sc.nextInt();
			int angulo = sc.nextInt();
			int distancia = sc.nextInt();
			Bola temp = desp(coche, angulo, distancia);
			coche.x = temp.x;
			coche.y = temp.y;
			actuales.add(coche);
			jugar(sc, false);
			jugar(sc, true);
			for(int i = 0; i < 4; i++)
			{
				int nA = 0;
				int nB = 0;
				for(Bola b : actuales)
				{
					if(b.coche)
						continue;
					if(b.jugador)
						nB++;
					if(!b.jugador)
						nA++;
				}
				if(nA == 3)
					jugar(sc, true);
				else if(nB == 3)
					jugar(sc, false);
				else
				{
					double mejorD = Double.MAX_VALUE;
					Bola mejor = null;
					for(Bola b : actuales)
					{
						if(b == coche)
							continue;
						if(coche.distancia(b) < mejorD)
						{
							mejorD = coche.distancia(b);
							mejor = b;
						}
					}
					jugar(sc, !mejor.jugador);
				}
			}
			double menor = Double.MAX_VALUE;
			boolean ganador = false;
			for(Bola b : actuales)
			{
				if(b == coche)
					continue;
				if(b.distancia(coche) < menor)
				{
					menor = b.distancia(coche);
					ganador = b.jugador;
				}
			}
			int cuenta = 0;
			while(true)
			{
				menor = Double.MAX_VALUE;
				Bola bolaMenor = null;
				for(Bola b : actuales)
				{
					if(b == coche)
						continue;
					if(b.distancia(coche) < menor)
					{
						menor = b.distancia(coche);
						bolaMenor = b;
					}
				}
				if(bolaMenor.jugador == ganador)
				{
					cuenta++;
					for(int i = 0; i < actuales.size(); i++)
						if(actuales.get(i) == bolaMenor)
							actuales.remove(i);
				}
				else
					break;
			}
			System.out.println((ganador ? jB : jA) + " " + cuenta);
		}
	}
}