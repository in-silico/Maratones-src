import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;


public class C 
{
	
	static int[][] permutaciones = {{0, 1, 2}, {0, 2, 1}, {1, 2, 0}, {1, 0, 2}, {2, 1, 0}, {2, 0, 1}};
	
	
	public static int convertirDe(String s)
	{
		s = s.toLowerCase();
		if(s.equals("a"))
			return 0;
		if(s.equals("a#") || s.equals("bb"))
			return 1;
		if(s.equals("b"))
			return 2;
		if(s.equals("c"))
			return 3;
		if(s.equals("c#") || s.equals("db"))
			return 4;
		if(s.equals("d"))
			return 5;
		if(s.equals("d#") || s.equals("eb"))
			return 6;
		if(s.equals("e"))
			return 7;
		if(s.equals("f"))
			return 8;
		if(s.equals("f#") || s.equals("gb"))
			return 9;
		if(s.equals("g"))
			return 10;
		if(s.equals("g#") || s.equals("ab"))
			return 11;
		return -1;
	}
	
	public static String convertirA(int s)
	{
		switch(s)
		{
			case 0: return "A";
			case 1: return "A#";
			case 2: return "B";
			case 3: return "C";
			case 4: return "C#";
			case 5: return "D";
			case 6: return "D#";
			case 7: return "E";
			case 8: return "F";
			case 9: return "F#";
			case 10: return "G";
			case 11: return "G#";
		}
		return null;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Pattern p = Pattern.compile("\\s+");
		int[] este = new int[3];
		int[] perme = new int[3];
		while(true)
		{
			String actual = br.readLine();
			if(actual.equals(""))
				return;
			String[] pedazos = p.split(actual);
			este[0] = convertirDe(pedazos[0]);
			este[1] = convertirDe(pedazos[1]);
			este[2] = convertirDe(pedazos[2]);
			boolean termino = false;
			for(int[] act : permutaciones)
			{
				for(int i = 0; i < 3; i++)
					perme[i] = este[act[i]];
				if((perme[0] + 4) % 12 == perme[1] && (perme[1] + 3) % 12 == perme[2])
				{
					System.out.println(pedazos[0] + " " + pedazos[1] + " " + pedazos[2] + " is a " + convertirA(perme[0]) + " Major chord.");
					termino = true;
					break;
				}
				if((perme[0] + 3) % 12 == perme[1] && (perme[1] + 4) % 12 == perme[2])
				{
					System.out.println(pedazos[0] + " " + pedazos[1] + " " + pedazos[2] + " is a " + convertirA(perme[0]) + " Minor chord.");
					termino = true;
					break;
				}
			}
			if(!termino)
				System.out.println(pedazos[0] + " " + pedazos[1] + " " + pedazos[2] + " is unrecognized.");
			
		}
	}
}
