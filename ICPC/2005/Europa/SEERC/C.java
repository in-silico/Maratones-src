/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Estudiante
 */
public class C
{
    static int[][][] backtrack = new int[82][9][9];
    static int visitado = 1 << 10;
    
    public static void marcar(int[][] sudoku, int i, int j, int n)
    {
        int mascara = 1 << n;
        sudoku[i][j] = mascara + visitado;
        mascara = ~mascara;
        for(int a = 0; a < 9; a++)
        {
            if(a != j)
                sudoku[i][a] &= mascara;
            if(a != i)
                sudoku[a][j] &= mascara;
        }
        int imenor = (i / 3) * 3;
        int imayor = imenor + 3;
        int jmenor = (j / 3) * 3;
        int jmayor = jmenor + 3;
        for(int a = imenor; a < imayor; a++)
            for(int b = jmenor; b < jmayor; b++)
                if(a != i || b != j)
                    sudoku[a][b] &= mascara;
    }
    
    public static boolean backtrack(int[][] sudoku, int altura)
    {
        boolean paila = false;
        int menorNumero = 10;
        int imejor = 0;
        int jmejor = 0;
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++)
            {
                int numero = Integer.bitCount(sudoku[i][j]);
                if(sudoku[i][j] < visitado)
                {
                    paila = true;
                    if(numero < menorNumero)
                    {
                        menorNumero = numero;
                        imejor = i;
                        jmejor = j;
                    }
                }
            }
        if(!paila)
        {
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                    System.out.print(Integer.numberOfTrailingZeros(sudoku[i][j]) + 1);
                System.out.print("\n");
            }
            return true;
        }
        if(menorNumero == 1)
        {
            marcar(sudoku, imejor, jmejor, Integer.numberOfTrailingZeros(sudoku[imejor][jmejor]));
            return backtrack(sudoku, altura + 1);
        }
        else
        {
            for(int i = 0; i < 9; i++)
                for(int j = 0; j < 9; j++)
                    backtrack[altura][i][j] = sudoku[i][j];
            int temp = sudoku[imejor][jmejor];
            for(int a = 0; a <= 9; a++)
            {
                if((temp & 1) == 1)
                {
                        for(int i = 0; i < 9; i++)
                            for(int j = 0; j < 9; j++)
                                sudoku[i][j] = backtrack[altura][i][j];
                        marcar(sudoku, imejor, jmejor, a);
                        if(backtrack(sudoku, altura + 1))
                            return true;
                }
                temp >>= 1;
            }
            return false;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[][] sudoku = new int[9][9];
        for(int caso = 0; caso < t; caso++)
        {
            for(int i = 0; i < 9; i++)
                for(int j = 0; j < 9; j++)
                    sudoku[i][j] = (1 << 9) - 1;
            for(int i = 0; i < 9; i++)
            {
                String s = br.readLine();
                for(int j = 0; j < 9; j++)
                {
                    int n = s.charAt(j) - '0';
                    if(n == 0)
                        continue;
                    n--;
                    marcar(sudoku, i, j, n);
                }
            }
            backtrack(sudoku, 0);
        }
    }
}
