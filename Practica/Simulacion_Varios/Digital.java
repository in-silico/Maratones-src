import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Digital 
{
	static char[][] matriz = new char[100][100];
	static char[] salida = new char[10000];
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int ii = 0; ii < n; ii++)
		{
			int pos = 0;
			char[] lectura = br.readLine().toCharArray();
			double raiz = Math.sqrt(lectura.length);
			if((int) raiz != raiz)
			{
				System.out.println("INVALID");
			}
			else
			{
				int raizI = (int) raiz;
				for(int i = 0; i < raizI; i++)
					for(int j = 0; j < raizI; j++)
						matriz[i][j] = lectura[pos++];
				pos = 0;
				for(int i = 0; i < raizI; i++)
					for(int j = 0; j < raizI; j++)
						salida[pos++] = matriz[j][i];
				System.out.println(new String(salida, 0, raizI * raizI));
			}
		}
	}

}
