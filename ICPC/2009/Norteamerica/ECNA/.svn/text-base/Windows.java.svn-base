import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Windows 
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		System.setIn(new FileInputStream("b.in"));
		System.setOut(new PrintStream("bsa.out"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int desktop = 1;
		while(true)
		{
			int n = Integer.parseInt(br.readLine());
			if(n == 0)
				return;
			ArrayList <Rectangle2D> ventanas = new ArrayList <Rectangle2D> ();
			for(int i = 0; i < n; i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				ventanas.add(new Rectangle2D.Double(c, r, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			int m = Integer.parseInt(br.readLine());
			System.out.println("Desktop " + desktop++ + ":");
			for(int j = 0; j < m; j++)
			{
				int enDonde = -1;
				StringTokenizer st = new StringTokenizer(br.readLine());
				double y = Integer.parseInt(st.nextToken());
				double x = Integer.parseInt(st.nextToken());
				for(int i = ventanas.size() - 1; i >= 0; i--)
				{
					if(ventanas.get(i).contains(x, y))
					{
						enDonde = i + 1;
						break;
					}
				}
				if(enDonde == -1)
				{
					System.out.println("background");
				}
				else
				{
					System.out.println("window " + enDonde);
				}
			}
		}
	}
}
