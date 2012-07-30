import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class G 
{
	
	
	static char[][] mundo;
	static boolean[][] visitado = new boolean[51][51];
	static int w, h, oro;
	
	public static void visitar(int i, int j)
	{
		if(i < 0 || i > h || j < 0 || j > w)
			return;
		if(visitado[i][j])
			return;
		visitado[i][j] = true;
		if(mundo[i][j] == '#')
			return;
		if(mundo[i][j] == 'G')
			oro++;
		if(!peligro(i, j))
		{
			visitar(i - 1, j);
			visitar(i + 1, j);
			visitar(i, j + 1);
			visitar(i, j - 1);
		}
	}

	private static  boolean peligro(int i, int j) 
	{
		try
		{
			if(mundo[i - 1][j] == 'T')
				return true;
		}
		catch(Exception e)
		{
		}
		try
		{
			if(mundo[i + 1][j] == 'T')
				return true;
		}
		catch(Exception e)
		{
		}
		try
		{
			if(mundo[i][j + 1] == 'T')
				return true;
		}
		catch(Exception e)
		{
		}
		try
		{
			if(mundo[i][j - 1] == 'T')
				return true;
		}
		catch(Exception e)
		{
		}
		return false;
	}

	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String linea = br.readLine();
			if(linea == null)
				return;
			String[] pedazos = linea.split(" ");
			w = Integer.parseInt(pedazos[0]);
			h = Integer.parseInt(pedazos[1]);
			mundo = new char[h][];
			for(int i = 0; i < h; i++)
				mundo[i] = br.readLine().toCharArray();
			int ii = 0, jj = 0;
			oro = 0;
			for(int i = 0; i < h; i++)
				for(int j = 0; j < w; j++)
				{
					if(mundo[i][j] == 'P')
					{
						ii = i;
						jj = j;
					}
					visitado[i][j] = false;
				}
			visitar(ii, jj);
			System.out.println(oro);
		}
	}

}
