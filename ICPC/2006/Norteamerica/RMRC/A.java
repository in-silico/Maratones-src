import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class A 
{
	
	static class Pedazo implements Comparable <Pedazo>
	{
		ArrayList <Integer> cartas = new ArrayList <Integer> ();
		int numero;
		
		public Pedazo(int num)
		{
			numero = num;
		}

		@Override
		public int compareTo(Pedazo o) 
		{
			if(cartas.size() == o.cartas.size())
				return Integer.valueOf(numero).compareTo(o.numero);
			return -Integer.valueOf(cartas.size()).compareTo(o.cartas.size());
		}
		
		public String toString() 
		{
			return numero == 0 ? "Spades" : numero == 1 ? "Hearts" : numero == 2 ? "Diamonds" : "Clubs";
		}
	}
	public static class Mano
	{
		Pedazo espadas = new Pedazo(0);
		Pedazo corazones = new Pedazo(1);
		Pedazo diamantes = new Pedazo(2);
		Pedazo treboles = new Pedazo(3);
		int hcp = 0;
		String distribucion;
		boolean balanceado = false;
		
		ArrayList <Pedazo> enOrden = new ArrayList <Pedazo> ();
		
		public void calcular()
		{
			enOrden.add(espadas);
			enOrden.add(corazones);
			enOrden.add(diamantes);
			enOrden.add(treboles);
			Collections.sort(enOrden);
			for(Pedazo p : enOrden)
				for(int i : p.cartas)
				{
				
					if(i == 14)
						hcp += 4;
					else if(i == 13)
						hcp += 3;
					else if(i == 12)
						hcp += 2;
					else if(i == 11)
						hcp += 1;
				}
			distribucion = distribucion();
			balanceado |= distribucion.equals("4-3-3-3");
			balanceado |= distribucion.equals("4-4-3-2");
			balanceado |= distribucion.equals("5-3-3-2");
		}

		private String distribucion() 
		{
			String s = "";
			for(Pedazo p : enOrden)
				s += "-" + p.cartas.size();
			return s.substring(1);
		}
	}


	private static void leerCarta(Scanner sc, Mano mano) 
	{
		String pedazo = sc.next();
		char pinta = pedazo.charAt(0);
		char num = pedazo.charAt(1);
		int numero = 0;
		if(num >= '2' && num <= '9')
			numero = num - '0';
		else if(num == 'T')
			numero = 10;
		else if(num == 'J')
			numero = 11;
		else if(num == 'Q')
			numero = 12;
		else if(num == 'K')
			numero = 13;
		else
			numero = 14;
		if(pinta == 'S')
			mano.espadas.cartas.add(numero);
		else if(pinta == 'H')
			mano.corazones.cartas.add(numero);
		else if(pinta == 'D')
			mano.diamantes.cartas.add(numero);
		else
			mano.treboles.cartas.add(numero);
	}
	
	public static void main(String[] args)
	{
		int numero = 1;
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			Mano mano = new Mano();
			for(int i = 0; i < 13; i++)
				leerCarta(sc, mano);
			mano.calcular();
			System.out.print("Hand #" + numero++ + ": ");
			if(mano.hcp >= 10 && mano.enOrden.get(0).cartas.size() >= 8)
				System.out.println("4 " + mano.enOrden.get(0));
			else if(mano.hcp >= 10 && mano.hcp <= 13 && mano.distribucion.startsWith("7"))
				System.out.println("3 " + mano.enOrden.get(0));
			else if(mano.hcp >= 8 && mano.hcp <= 9 && mano.enOrden.get(0).cartas.size() >= 7 && mano.enOrden.get(0).numero <= 1)
				System.out.println("2 " + mano.enOrden.get(0));
			else if(mano.hcp >= 8 && mano.hcp <= 11 && mano.enOrden.get(0).cartas.size() == 6 && (mano.enOrden.get(0).numero <= 1 || (mano.enOrden.get(1).cartas.size() == 6 && mano.enOrden.get(1).numero <= 1)))
				System.out.println("2 " + mano.enOrden.get(0));
			else if(mano.hcp >= 11 && mano.hcp <= 15 && (mano.distribucion.equals("4-4-4-1") || mano.distribucion.equals("5-4-4-0")) && cuatroEspadas(mano))
				System.out.println("2 Diamonds");
			else if(mano.hcp >= 15 && mano.hcp <= 17 && mano.balanceado && stopped(mano))
				System.out.println("1 No Trump");
			else if(mano.hcp >= 20 && mano.hcp <= 22 && mano.balanceado)
				System.out.println("2 No Trump");
			else if(mano.hcp >= 22)
				System.out.println("2 Clubs");
			else if(mano.hcp >= 13 && mano.hcp <= 16)
			{
				ArrayList <Pedazo> pe = new ArrayList <Pedazo> ();
				for(Pedazo p : mano.enOrden)
				{
					if(p.cartas.size() >= 5 && p.numero <= 1)
						pe.add(p);
				}
				if(pe.isEmpty())
				{
					for(Pedazo p : mano.enOrden)
						if(p.numero > 1)
							pe.add(p);
					Collections.sort(pe);
					System.out.println("1 " + pe.get(0));
				}
				else
				{
					Collections.sort(pe);
					System.out.println("1 " + pe.get(0));
				}
			}
			else if(mano.hcp >= 17)
			{
				while(mano.enOrden.size() != 1 && mano.enOrden.get(0).cartas.size() == mano.enOrden.get(1).cartas.size())
					mano.enOrden.remove(0);
				System.out.println("1 " + mano.enOrden.get(0));
			}
			else
				System.out.println("Pass");
				
		}
	}

	private static boolean stopped(Mano mano) 
	{
		boolean[] stopped = new boolean[4];
		for(Pedazo p : mano.enOrden)
		{
			if(p.cartas.contains(14) || (p.cartas.contains(13) && p.cartas.size() >= 2) || (p.cartas.contains(12) && p.cartas.size() >= 3) || (p.cartas.contains(11) && p.cartas.size() >= 4))
				stopped[p.numero] = true;
		}
		int cuenta = 0;
		for(boolean b : stopped)
			if(b)
				cuenta++;
		return cuenta >= 3;
	}

	private static boolean cuatroEspadas(Mano mano) 
	{
		for(Pedazo p : mano.enOrden)
			if(p.numero == 0)
				return p.cartas.size() >= 4;
		return false;
	}
}
