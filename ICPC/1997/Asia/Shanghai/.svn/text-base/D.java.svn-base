import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;


public class D 
{
	static class Persona implements Comparable <Persona>
	{
		int tiempo;
		int desde;
		int hasta;
		
		public Persona(int tiempo, int desde, int hasta) {
			this.tiempo = tiempo;
			this.desde = desde;
			this.hasta = hasta;
		}

		@Override
		public int compareTo(Persona o) {
			return Integer.valueOf(tiempo).compareTo(o.tiempo);
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return tiempo + " " + desde + " " + hasta;
		}
		
	}
	
	static LinkedList <Persona> enOrden = new LinkedList <Persona> ();
	static LinkedList <Persona> actuales = new LinkedList <Persona> ();
	static LinkedList <Persona> dentro = new LinkedList <Persona> ();
	
	static void insertar(int tiempo)
	{
		while(!enOrden.isEmpty() && enOrden.peekFirst().tiempo <= tiempo)
		{
			Persona aInsertar = enOrden.pollFirst();
			ListIterator <Persona> it = actuales.listIterator();
			while(true)
			{
				if(!it.hasNext())
				{
					it.add(aInsertar);
					break;
				}
				Persona siguiente = it.next();
				if(siguiente.desde > aInsertar.desde)
				{
					it.previous();
					it.add(aInsertar);
					break;
				}
			}
		}
	}
	
	public static final int IDLE = 0;
	public static final int SUBIENDO = 1;
	public static final int BAJANDO = 2;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cuenta = 0;
		while(true)
		{
			String[] pedazos = br.readLine().split(" ");
			int tamano = Integer.parseInt(pedazos[0]);
			int inicio = Integer.parseInt(pedazos[1]);
			int fin = Integer.parseInt(pedazos[2]);
			if(tamano == 0 && inicio == 0 && fin == 0)
				return;
			if(cuenta++ != 0)
				System.out.println();
			enOrden.clear();
			actuales.clear();
			dentro.clear();
			while(true)
			{
				pedazos = br.readLine().split(" ");
				int tiempo = Integer.parseInt(pedazos[0]);
				int desde = Integer.parseInt(pedazos[1]);
				int hasta = Integer.parseInt(pedazos[2]);
				if(tiempo == 0 && desde == 0 && hasta == 0)
					break;
				enOrden.add(new Persona(tiempo, desde, hasta));
			}
			Collections.sort(enOrden);
			int estado = IDLE;
			int piso = 0;
			boolean anterior = false;
			for(int tiempo = 0; tiempo <= fin; tiempo++)
			{
				insertar(tiempo);
				if(estado == IDLE)
				{
					if(actuales.isEmpty())
					{
						if(tiempo >= inicio && tiempo <= fin)
						{
							System.out.println(tiempo + ": Idle at story " + piso);
						}
						continue;
					}
					int indice = 0;
					int indiceMejorA = -1;
					for(Persona p : actuales)
					{
						if(p.desde == piso)
							if(p.hasta < piso)
								indiceMejorA = indice;
							else if(p.hasta > piso && indiceMejorA == -1)
								indiceMejorA = indice;
						indice++;
					}
					if(indiceMejorA == -1)
					{
						if(actuales.peekFirst().desde < piso)
							estado = BAJANDO;
						else
							estado = SUBIENDO;
						tiempo--;
						continue;
					}
					else
					{
						Persona siguiente = actuales.get(indiceMejorA); 
						if(siguiente.hasta < piso)
							estado = BAJANDO;
						else
							estado = SUBIENDO;
						tiempo--;
						continue;
					}
				}
				else 
				{
					boolean salieron = false;
					ListIterator <Persona> it = dentro.listIterator();
					while(it.hasNext())
					{
						Persona actual = it.next();
						if(actual.hasta == piso)
						{
							salieron = true;
							it.remove();
						}
					}
					if(salieron)
					{
						if(tiempo >= inicio && tiempo <= fin)
							System.out.println(tiempo + ": Let customers get out at story " + piso);			
						if(tiempo + 1 >= inicio && tiempo + 1 <= fin)
							System.out.println((tiempo + 1) + ": Let customers get out at story " + piso);
						if(tiempo + 2 >= inicio && tiempo + 2 <= fin)	
							System.out.println((tiempo + 2) + ": Let customers get out at story " + piso);
						tiempo += 2;
						continue;
					}
					if(estado == SUBIENDO)
					{
						boolean entraron = false;
						it = actuales.listIterator();
						while(it.hasNext())
						{
							Persona actual = it.next();
							if(actual.desde == piso && actual.hasta > piso)
							{
								entraron = true;
							}
						}
						if(entraron && !anterior)
						{
							insertar(tiempo + 2);
							it = actuales.listIterator();
							while(it.hasNext())
							{
								Persona actual = it.next();
								if(actual.desde == piso && actual.hasta > piso)
								{
									it.remove();
									dentro.add(actual);
								}
							}
							if(tiempo >= inicio && tiempo <= fin)
								System.out.println(tiempo + ": Let upstair-customers get in at story " + piso);
							if(tiempo + 1 >= inicio && tiempo + 1 <= fin)
								System.out.println((tiempo + 1) + ": Let upstair-customers get in at story " + piso);
							if(tiempo + 2 >= inicio && tiempo + 2 <= fin)
								System.out.println((tiempo + 2) + ": Let upstair-customers get in at story " + piso);
							anterior = true;
							tiempo += 2;
							continue;
						}
						else
						{
							anterior = false;
							boolean sube = !dentro.isEmpty();
							it = actuales.listIterator();
							while(it.hasNext())
							{
								Persona actual = it.next();
								if(actual.desde > piso)
								{
									sube = true;
								}
							}
							if(sube)
							{
								if(tiempo >= inicio && tiempo <= fin)
									System.out.println(tiempo + ": Going up to " + (piso + 1));
								if(tiempo + 1 >= inicio && tiempo + 1 <= fin)
									System.out.println((tiempo + 1) + ": Going up to " + (piso + 1));
								tiempo++;
								piso++;
								continue;
							}
							else
							{
								estado = IDLE;
								tiempo--;
								continue;
							}
						}
					}
					else if(estado == BAJANDO)
					{
						boolean entraron = false;
						it = actuales.listIterator();
						while(it.hasNext())
						{
							Persona actual = it.next();
							if(actual.desde == piso && actual.hasta < piso)
							{
								entraron = true;
							}
						}
						if(entraron && !anterior)
						{
							insertar(tiempo + 2);
							it = actuales.listIterator();
							while(it.hasNext())
							{
								Persona actual = it.next();
								if(actual.desde == piso && actual.hasta < piso)
								{
									it.remove();
									dentro.add(actual);
								}
							}
							if(tiempo >= inicio && tiempo <= fin)
								System.out.println(tiempo + ": Let downstair-customers get in at story " + piso);
							if(tiempo + 1 >= inicio && tiempo + 1 <= fin)
								System.out.println((tiempo + 1) + ": Let downstair-customers get in at story " + piso);
							if(tiempo + 2 >= inicio && tiempo + 2 <= fin)
								System.out.println((tiempo + 2) + ": Let downstair-customers get in at story " + piso);
							anterior = true;
							tiempo += 2;
							continue;
						}
						else
						{
							anterior = false;
							boolean sube = !dentro.isEmpty();
							it = actuales.listIterator();
							while(it.hasNext())
							{
								Persona actual = it.next();
								if(actual.desde < piso)
								{
									sube = true;
								}
							}
							if(sube)
							{
								if(tiempo >= inicio && tiempo <= fin)
									System.out.println(tiempo + ": Going down to " + (piso - 1));
								if(tiempo + 1 >= inicio && tiempo + 1 <= fin)
									System.out.println((tiempo + 1) + ": Going down to " + (piso - 1));
								tiempo++;
								piso--;
								continue;
							}
							else
							{
								estado = IDLE;
								tiempo--;
								continue;
							}
						}
					}
				}
				
			}
		}
	}
}
