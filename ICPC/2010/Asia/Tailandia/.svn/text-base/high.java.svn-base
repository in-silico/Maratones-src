import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

public class high 
{
    public static void main(String [] args)
    {
    	Scanner sc = new Scanner(System.in);
    	int n = Integer.parseInt(sc.next());
    	for(int i = 0; i < n; i++)
    	{
    		BigDecimal suma = new BigDecimal("0");
    		String linea;
    		while(!(linea = sc.next()).equals("0"))
    			suma = suma.add(new BigDecimal(linea), new MathContext(30, RoundingMode.DOWN));
    		String resultado = suma.toPlainString();
    		while(resultado.contains(".") && (resultado.endsWith("0") || resultado.endsWith(".")))
    			resultado = resultado.substring(0, resultado.length() - 1);
    		System.out.println(resultado.length() == 0 ? "0" : resultado);
    	}
    }
}