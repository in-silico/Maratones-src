import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.LinkedList;


public class A_RoundAbout
{
	
	static final int N = 0;
	static final int W = 1;
	static final int S = 2;
	static final int E = 3;
	
	static class Carro
	{
		int tiempo;
		int objetivo;
		
		public Carro(int t, int o)
		{
			tiempo = t;
			objetivo = o;
		}
		
		@Override
		public String toString() 
		{
			if(objetivo == N)
				return "N";
			if(objetivo == S)
				return "S";
			if(objetivo == W)
				return "W";
			if(objetivo == E)
				return "E";
			return "";
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		System.setIn(new FileInputStream("RoundAbout.in"));
		System.setOut(new PrintStream("RoundAbout.out2")); 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++)
		{
			String northS = br.readLine();
			String eastS = br.readLine();
			String southS = br.readLine();
			String westS = br.readLine();
			Carro north = null;
			Carro east = null;
			Carro south = null;
			Carro west = null;
			LinkedList <Carro> northO = new LinkedList <Carro> ();
			LinkedList <Carro> eastO = new LinkedList <Carro> ();
			LinkedList <Carro> southO = new LinkedList <Carro> ();
			LinkedList <Carro> westO = new LinkedList <Carro> ();
			int tiempo = 0;
			for(char c : northS.toCharArray())
			{
				int donde = 0;
				if(c == 'W')
					donde = W;
				if(c == 'N')
					donde = N;
				if(c == 'S')
					donde = S;
				if(c == 'E')
					donde = E;
				if(c != '-')
					northO.add(new Carro(tiempo, donde));
				tiempo++;
			}
			tiempo = 0;
			for(char c : eastS.toCharArray())
			{
				int donde = 0;
				if(c == 'W')
					donde = W;
				if(c == 'N')
					donde = N;
				if(c == 'S')
					donde = S;
				if(c == 'E')
					donde = E;
				if(c != '-')
					eastO.add(new Carro(tiempo, donde));
				tiempo++;
			}
			tiempo = 0;
			for(char c : southS.toCharArray())
			{
				int donde = 0;
				if(c == 'W')
					donde = W;
				if(c == 'N')
					donde = N;
				if(c == 'S')
					donde = S;
				if(c == 'E')
					donde = E;
				if(c != '-')
					southO.add(new Carro(tiempo, donde));
				tiempo++;
			}
			tiempo = 0;
			for(char c : westS.toCharArray())
			{
				int donde = 0;
				if(c == 'W')
					donde = W;
				if(c == 'N')
					donde = N;
				if(c == 'S')
					donde = S;
				if(c == 'E')
					donde = E;
				if(c != '-')
					westO.add(new Carro(tiempo, donde));
				tiempo++;
			}
			LinkedList <Carro> northF = new LinkedList <Carro> ();
			LinkedList <Carro> eastF = new LinkedList <Carro> ();
			LinkedList <Carro> southF = new LinkedList <Carro> ();
			LinkedList <Carro> westF = new LinkedList <Carro> ();
			tiempo = 0;
			while(north != null || south != null || east != null || west != null || !northO.isEmpty() || !eastO.isEmpty() || !southO.isEmpty() || !westO.isEmpty() || !northF.isEmpty() || !eastF.isEmpty() || !southF.isEmpty() || !westF.isEmpty())
			{
				Carro northN = null;
				Carro eastN = null;
				Carro southN = null;
				Carro westN = null;
				boolean salioN = false;
				boolean salioW = false;
				boolean salioS = false;
				boolean salioE = false;
				if(north != null && north.objetivo == N)
				{
					north = null;
					salioN = true;
				}
				if(east != null && east.objetivo == E)
				{
					east = null;
					salioE = true;
				}
				if(west != null && west.objetivo == W)
				{
					west = null;
					salioW = true;
				}
				if(south != null && south.objetivo == S)
				{
					south = null;
					salioS = true;
				}
				westN = north;
				southN = west;
				eastN = south;
				northN = east;
				west = westN;
				south = southN;
				east = eastN;
				north = northN;
				if(!southF.isEmpty() && !northF.isEmpty() && !westF.isEmpty() && !eastF.isEmpty())
				{
					if(north == null && !salioE)
						north = northF.pollFirst();
				}
				else
				{
					boolean eastFE = eastF.isEmpty();
					boolean westFE = westF.isEmpty();
					boolean southFE = southF.isEmpty();
					boolean northFE = northF.isEmpty();
					if(!southF.isEmpty() && south == null && westFE && !salioW)
					{
						south = southF.pollFirst();
					}
					if(!eastF.isEmpty() && east == null && southFE && !salioS)
					{
						east = eastF.pollFirst();
					}
					if(!northF.isEmpty() && north == null && eastFE && !salioE)
					{
						north = northF.pollFirst();
					}
					if(!westF.isEmpty() && west == null && northFE && !salioN)
					{
						west = westF.pollFirst();
					}
				}
				while(!northO.isEmpty() && northO.peekFirst().tiempo <= tiempo)
					northF.add(northO.pollFirst());
				while(!southO.isEmpty() && southO.peekFirst().tiempo <= tiempo)
					southF.add(southO.pollFirst());
				while(!eastO.isEmpty() && eastO.peekFirst().tiempo <= tiempo)
					eastF.add(eastO.pollFirst());
				while(!westO.isEmpty() && westO.peekFirst().tiempo <= tiempo)
					westF.add(westO.pollFirst());
				tiempo++;
			}
			if(tiempo == 0)
				tiempo = 1;
			System.out.println(--tiempo);
		}
	}

}
