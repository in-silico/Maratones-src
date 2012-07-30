import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Gift 
{
	static int m, n;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String[] pedazos = br.readLine().split(" ");
			n = Integer.parseInt(pedazos[0]);
			m = Integer.parseInt(pedazos[1]);
			if(n == 0 && m == 0)
				return;
			if(n > 49 || simular(1, 2))
				System.out.println("Let me try!");
			else
				System.out.println("Don't make fun of me!");
		}
	}

	private static boolean simular(int i, int j) 
	{
		if(i == m)
			return true;
		if(i > n || i < 1)
			return false;
		int salto = (j << 1) - 1;
		return simular(i + salto, j + 1) || simular(i - salto, j + 1);
	}
}
