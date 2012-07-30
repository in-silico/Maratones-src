import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;


public class Argentina {

	static class Jugador implements Comparable <Jugador>
	{
		int ataque;
		int defensa;
		String nombre;
		
		public Jugador(String next, int nextInt, int nextInt2) {
			nombre = next;
			ataque = nextInt;
			defensa = nextInt2;
		}

		@Override
		public int compareTo(Jugador o) 
		{
			if(Integer.valueOf(ataque).compareTo(o.ataque) == 0)
			{
				if(Integer.valueOf(defensa).compareTo(o.defensa) == 0)
				{
					return -nombre.compareTo(o.nombre);
				}
				return -Integer.valueOf(defensa).compareTo(o.defensa);
			}
			return Integer.valueOf(ataque).compareTo(o.ataque);
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int	t = Integer.parseInt(br.readLine());
		for(int i = 1; i <= t; i++)
		{
			System.out.println("Case " + i + ":");
			Stack <Jugador> jugadores = new Stack <Jugador> ();

			for(int j = 0; j < 10; j++)
			{
				String[] pedazos = br.readLine().split(" ");
				jugadores.push(new Jugador(pedazos[0], Integer.parseInt(pedazos[1]), Integer.parseInt(pedazos[2])));
			}
			ArrayList <String> atacantes = new ArrayList <String> ();
			ArrayList <String> defensas = new ArrayList <String> ();
			Collections.sort(jugadores);
			for(int j = 0; j < 5; j++)
				atacantes.add(jugadores.pop().nombre);
			for(int j = 0; j < 5; j++)
				defensas.add(jugadores.pop().nombre);
			Collections.sort(atacantes);
			Collections.sort(defensas);
			System.out.print("(" + atacantes.remove(0));
			for(String j : atacantes)
				System.out.print(", " + j);
			System.out.println(")");
			System.out.print("(" + defensas.remove(0));
			for(String j : defensas)
				System.out.print(", " + j);
			System.out.println(")");
		}
	}
}
