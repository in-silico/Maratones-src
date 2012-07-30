import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Mobile 
{
	static boolean bien = true;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static int leerMobil() throws IOException
	{
		String[] pedazos = br.readLine().split(" ");
		int wl = Integer.parseInt(pedazos[0]);
		int dl = Integer.parseInt(pedazos[1]);
		int wr = Integer.parseInt(pedazos[2]);
		int dr = Integer.parseInt(pedazos[3]);
		if(wl == 0)
			wl = leerMobil();
		if(wr == 0)
			wr = leerMobil();
		bien = bien && wl * dl == wr * dr;
		return wl + wr;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++)
		{
			br.readLine();
			if(i != 0)
				System.out.println();
			bien = true;
			leerMobil();
			if(bien)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

}
