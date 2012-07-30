import java.util.Scanner;


public class Lights 
{
	static class Semaforo
	{
		int ciclo;
		int actual = 0;
		int verde;
		
		Semaforo(int c)
		{
			ciclo = c * 2;
			verde = c - 5;
		}
		
		boolean aumentar()
		{
			actual++;
			if(actual == ciclo + 1)
				actual = 1;
			if(actual - 1 < verde)
				return true;
			else
				return false;
		}
	}
	static Semaforo[] semaforos = new Semaforo[100];
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int primera = sc.nextInt();
			int segunda = sc.nextInt();
			int tercera = sc.nextInt();
			if(primera == 0 && segunda == 0 && tercera == 0)
				return;
			int cuenta = tercera == 0 ? 2 : 3;
			semaforos[0] = new Semaforo(primera);
			semaforos[1] = new Semaforo(segunda);
			semaforos[2] = new Semaforo(tercera);
			if(cuenta != 2)
			{
				while(true)
				{
					int siguiente = sc.nextInt();
					if(siguiente == 0)
						break;
					semaforos[cuenta++] = new Semaforo(siguiente);
				}
			}
			int tiempoActual = 0;
			boolean termino = false;
			boolean empezo = false;
			while(tiempoActual <= 18000 && (!termino || !empezo))
			{
				termino = true;
				for(int i = 0; i < cuenta; i++)
					termino = termino & semaforos[i].aumentar();
				if(!termino || !empezo)
					tiempoActual++;
				if(!termino)
					empezo = true;
			}
			if(tiempoActual > 18000)
				System.out.println("Signals fail to synchronise in 5 hours");
			else
			{
				int segundos = tiempoActual % 60;
				int minutos = (tiempoActual / 60) % 60;
				int horas = tiempoActual / 3600;
				System.out.println("0" + horas + ":" + (minutos < 10 ? ("0" + minutos) : (minutos)) + ":" + (segundos < 10 ? ("0" + segundos) : (segundos)));
			}
		}
	}

}
