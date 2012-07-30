import java.io.IOException;
import java.io.InputStreamReader;


public class sky 
{
	private static int leerEntero() throws IOException 
    {
            char actual;
            while((actual = (char) is.read()) < '0' || actual > '9');
            int digitos = 1;
            numero[0] = actual;
            while((actual = (char) is.read()) >= '0' && actual <= '9')
            {
                    numero[digitos++] = actual;
            }
            return Integer.parseInt(new String(numero, 0, digitos));
    }

    static InputStreamReader is;
    static char [] numero = new char[10];
    
	public static void main(String [] args) throws IOException
	{
		is = new InputStreamReader(System.in);
		int n = leerEntero();
		for(int i = 1; i <= n; i++)
		{
			int nEdificios = leerEntero();
			int [] alturas = new int[nEdificios];
			int [] pesos = new int[nEdificios];
			for(int j = 0; j < nEdificios; j++)
			{
				alturas[j] = leerEntero();
			}
			for(int j = 0; j < nEdificios; j++)
			{
				pesos[j] = leerEntero();
			}
			int [] solucion = new int[nEdificios];
			int mayorAbsolutoIncremental = 0;
			for(int j = 0; j < 1; j++)
			{
				solucion[j] = pesos[j];
				mayorAbsolutoIncremental = Math.max(mayorAbsolutoIncremental, solucion[j]);
				for(int k = j + 1; k < nEdificios; k++)
				{
					int alturaActual = alturas[k];
					int max = 0;
					for(int l = 0; l < k; l++)
					{
						if(alturaActual > alturas[l])
						{
							if(solucion[l] > max)
								max = solucion[l];
						}
						solucion[k] = max > 0 ? max + pesos[k] : pesos[k];
						mayorAbsolutoIncremental = Math.max(mayorAbsolutoIncremental, solucion[k]);
					}
				}
			}
			int mayorAbsolutoDecremental = 0;
			for(int j = 0; j < 1; j++)
			{
				solucion[j] = pesos[j];
				mayorAbsolutoDecremental = Math.max(mayorAbsolutoDecremental, solucion[j]);
				for(int k = j + 1; k < nEdificios; k++)
				{
					int alturaActual = alturas[k];
					int max = 0;
					for(int l = 0; l < k; l++)
					{
						if(alturaActual < alturas[l])
						{
							if(solucion[l] > max)
								max = solucion[l];
						}
						solucion[k] = max > 0 ? max + pesos[k] : pesos[k];
						mayorAbsolutoDecremental = Math.max(mayorAbsolutoDecremental, solucion[k]);
					}
				}
			}
			if(mayorAbsolutoIncremental < mayorAbsolutoDecremental)
			{
				System.out.println("Case " + i + ". Decreasing (" + mayorAbsolutoDecremental + "). Increasing (" + mayorAbsolutoIncremental + ").");
			}
			else
			{
				System.out.println("Case " + i + ". Increasing (" + mayorAbsolutoIncremental + "). Decreasing (" + mayorAbsolutoDecremental + ").");
			}
		}
	}

}
