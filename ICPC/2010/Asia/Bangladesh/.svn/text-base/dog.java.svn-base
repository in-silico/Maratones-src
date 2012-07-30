import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class dog
{
	
	static double diferenciaMaxima = 1e-6;
	static class Punto
	{
		double x, y, distancia;

		public Punto(String x, String y) 
		{
			this.x = Integer.parseInt(x);
			this.y = Integer.parseInt(y);
		}

		public Punto(double x, double y) 
		{
			this.x = x;
			this.y = y;
		}
		
		public void distancia(Punto otro)
		{
			distancia = calcularDistancia(otro);
		}
		
		public double calcularDistancia(Punto otro)
		{
			double x1 = x - otro.x;
			x1 *= x1;
			double y1 = y - otro.y;
			y1 *= y1;
			return Math.sqrt(x1 + y1);
		}
	}
	
	public static void main(String [] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nCasos = Integer.parseInt(br.readLine());
		for(int i = 0; i < nCasos;)
		{
			String [] ab = br.readLine().split(" ");
			int a = Integer.parseInt(ab[0]);
			int b = Integer.parseInt(ab[1]);
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue <Punto> pilaA = new LinkedList <Punto> ();
			Punto anteriorA = new Punto(st.nextToken(), st.nextToken());
			pilaA.add(anteriorA);
			double distanciaA = 0;
			for(int j = 1; j < a; j++)
			{
				Punto siguiente = new Punto(st.nextToken(), st.nextToken());
				anteriorA.distancia(siguiente);
				distanciaA += anteriorA.distancia;
				anteriorA = siguiente;
				pilaA.add(siguiente);
			}
			st = new StringTokenizer(br.readLine());
			Queue <Punto> pilaB = new LinkedList <Punto> ();
			Punto anteriorB = new Punto(st.nextToken(), st.nextToken());
			pilaB.add(anteriorB);
			double distanciaB = 0;
			for(int j = 1; j < b; j++)
			{
				Punto siguiente = new Punto(st.nextToken(), st.nextToken());
				anteriorB.distancia(siguiente);
				distanciaB += anteriorB.distancia;
				anteriorB = siguiente;
				pilaB.add(siguiente);
			}
			double tiempoActual = 0;
			Punto actualA = pilaA.poll();
			Punto actualB = pilaB.poll();
			double distanciaMinima = Integer.MAX_VALUE;
			double distanciaMaxima = 0;
			while(!(pilaA.isEmpty() && pilaB.isEmpty()))
			{
				double tiempoLlegadaA = actualA.distancia / distanciaA + tiempoActual;
				double tiempoLlegadaB = actualB.distancia / distanciaB + tiempoActual;
				Punto siguienteA = pilaA.peek();
				Punto siguienteB = pilaB.peek();
				double cosenoA = (siguienteA.x - actualA.x) / actualA.distancia;
				double cosenoB = (siguienteB.x - actualB.x) / actualB.distancia;
				double senoA = (siguienteA.y - actualA.y) / actualA.distancia;
				double senoB = (siguienteB.y - actualB.y) / actualB.distancia;
				double vx1 = distanciaA	* cosenoA;
				double vx2 = distanciaB * cosenoB;
				double vy1 = distanciaA	* senoA;
				double vy2 = distanciaB * senoB;
				double tiempoSiguiente;
				if(Math.abs(tiempoLlegadaA - tiempoLlegadaB) < diferenciaMaxima)
				{
					siguienteA = pilaA.poll();
					siguienteB = pilaB.poll();
					tiempoSiguiente = tiempoLlegadaA;
				}
				else if(tiempoLlegadaA > tiempoLlegadaB)
				{
					tiempoSiguiente = tiempoLlegadaB;
					siguienteB = pilaB.poll();
					siguienteA = new Punto(vx1 * (tiempoSiguiente - tiempoActual) + actualA.x,
										   vy1 * (tiempoSiguiente - tiempoActual) + actualA.y);
					actualA.distancia(siguienteA);
					siguienteA.distancia(pilaA.peek());
				}
				else
				{
					tiempoSiguiente = tiempoLlegadaA;
					siguienteA = pilaA.poll();
					siguienteB = new Punto(vx2 * (tiempoLlegadaA - tiempoActual) + actualB.x,
										   vy2 * (tiempoLlegadaA - tiempoActual) + actualB.y);
					actualB.distancia(siguienteB);
					siguienteB.distancia(pilaB.peek());
				}
				double distanciaInicio = actualA.calcularDistancia(actualB);
				double distanciaFin = siguienteA.calcularDistancia(siguienteB);
				distanciaMinima = Math.min(distanciaMinima, Math.min(distanciaInicio, distanciaFin));
				distanciaMaxima = Math.max(distanciaMaxima, Math.max(distanciaInicio, distanciaFin));
				double t = - (vx1 - vx2) * ((vx2 - vx1) * tiempoActual + actualA.x - actualB.x) - (vy1 - vy2) * (((vy2 - vy1) * tiempoActual) + actualA.y - actualB.y);
				t /= ((vx1 - vx2) * (vx1 - vx2) + (vy1 - vy2) * (vy1 - vy2));
				if(t < tiempoSiguiente && t > tiempoActual)
				{
					Punto minimoA = new Punto(vx1 * (t - tiempoActual) + actualA.x,
							   				  vy1 * (t - tiempoActual) + actualA.y);
					Punto minimoB = new Punto(vx2 * (t - tiempoActual) + actualB.x,
							   				  vy2 * (t - tiempoActual) + actualB.y);
					double distanciaT = minimoA.calcularDistancia(minimoB);
					distanciaMinima = Math.min(distanciaMinima, distanciaT);
					distanciaMaxima = Math.max(distanciaMaxima, distanciaT);
				}
				actualA = siguienteA;
				actualB = siguienteB;
				tiempoActual = tiempoSiguiente;
			}
			System.out.println("Case " + ++i + ": " + (Math.round(distanciaMaxima - distanciaMinima)));
		}
	}
}
