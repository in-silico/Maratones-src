import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Oops 
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String linea;
		StringBuilder lineaCompleta = new StringBuilder();
		while((linea = br.readLine()) != null)
			lineaCompleta.append(linea);
		char[] hexa = lineaCompleta.toString().toCharArray();
		int indice = 0;
		while(indice < hexa.length)
		{
			char c = hexa[indice++];
			int tam = 2;
			if(c == '0')
			{
				System.out.print("ADD");
			}
			if(c == '1')
			{
				System.out.print("SUB");
			}
			if(c == '2')
			{
				System.out.print("MUL");
			}
			if(c == '3')
			{
				System.out.print("DIV");
			}
			if(c == '4')
			{
				System.out.print("MOV");
			}
			if(c == '5')
			{
				System.out.print("BREQ");
				tam = 1;
			}
			if(c == '6')
			{
				System.out.print("BRLE");
				tam = 1;
			}
			if(c == '7')
			{
				System.out.print("BRLS");
				tam = 1;
			}
			if(c == '8')
			{
				System.out.print("BRGE");
				tam = 1;
			}
			if(c == '9')
			{
				System.out.print("BRGR");
				tam = 1;
			}
			if(c == 'A')
			{
				System.out.print("BRNE");
				tam = 1;
			}
			if(c == 'B')
			{
				System.out.print("BR");
				tam = 1;
			}
			if(c == 'C')
			{
				System.out.print("AND");
				tam = 3;
			}
			if(c == 'D')
			{
				System.out.print("OR");
				tam = 3;
			}
			if(c == 'E')
			{
				System.out.print("XOR");
				tam = 3;
			}
			if(c == 'F')
			{
				System.out.print("NOT");
				tam = 1;
			}
			char[] registro = {hexa[indice], hexa[indice + 1], hexa[indice + 2], hexa[indice + 3]};
			indice += 4;
			int reg1 = Integer.parseInt(new String(registro), 16);
			int opcode = reg1 >> 14;
			int valor = reg1 & ((1 << 14) - 1);
			if(opcode == 0)
				System.out.print(" R" + valor);
			else if(opcode == 1)
				System.out.print(" $" + valor);
			else if(opcode == 2)
				System.out.print(" PC+" + valor);
			else if(opcode == 3)
				System.out.print(" " + valor);
			if(tam > 1)
			{
				registro = new char[]{hexa[indice], hexa[indice + 1], hexa[indice + 2], hexa[indice + 3]};
				indice += 4;
				reg1 = Integer.parseInt(new String(registro), 16);
				opcode = reg1 >> 14;
				valor = reg1 & ((1 << 14) - 1);
				if(opcode == 0)
					System.out.print(",R" + valor);
				else if(opcode == 1)
					System.out.print(",$" + valor);
				else if(opcode == 2)
					System.out.print(",PC+" + valor);
				else if(opcode == 3)
					System.out.print("," + valor);
			}
			if(tam > 2)
			{
				registro = new char[]{hexa[indice], hexa[indice + 1], hexa[indice + 2], hexa[indice + 3]};
				indice += 4;
				reg1 = Integer.parseInt(new String(registro), 16);
				opcode = reg1 >> 14;
				valor = reg1 & ((1 << 14) - 1);
				if(opcode == 0)
					System.out.print(",R" + valor);
				else if(opcode == 1)
					System.out.print(",$" + valor);
				else if(opcode == 2)
					System.out.print(",PC+" + valor);
				else if(opcode == 3)
					System.out.print("," + valor);
			}
			System.out.println();
		}
	}
}
