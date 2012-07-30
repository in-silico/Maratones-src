
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.Locale;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Estudiante
 */
public class F
{

    static class Entrada
    {
        int i, j, horizontales, pasos;

        Entrada(int ii, int jj, int v, int p)
        {
            i = ii;
            j = jj;
            horizontales = v;
            pasos = p;
        }
    }

    static int filas, columnas;
    static char[][] laberinto = new char[105][];
    static int[][] visitados = new int[105][105];
    static int[][] diff = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int caso;

    public static void mejor(double l)
    {
        int ii = 0, ji = 0;
        int iff = 0, jff = 0;
        for(int i = 0; i < filas; i++)
            for(int j = 0; j < columnas; j++)
            {
                if(laberinto[i][j] == 'S')
                {
                    ii = i;
                    ji = j;
                }
                else if(laberinto[i][j] == 'E')
                {
                    iff = i;
                    jff = j;
                }
                visitados[i][j] = Integer.MAX_VALUE;
            }
        LinkedList <Entrada> cola = new LinkedList <Entrada> ();
        cola.add(new Entrada(ii, ji, 0, 0));
        visitados[ii][ji] = 0;
        while(!cola.isEmpty())
        {
            Entrada actual = cola.poll();
            if(visitados[actual.i][actual.j] != actual.horizontales)
            	continue;
            if(actual.i == iff && actual.j == jff)
            {
                int verticales = actual.pasos - actual.horizontales;
                BigDecimal b = new BigDecimal(l).subtract(new BigDecimal(actual.horizontales)).divide(new BigDecimal(verticales), 100, RoundingMode.HALF_UP).multiply(new BigDecimal(100));
                Locale.setDefault(Locale.US);
                if(actual.horizontales > l)
                    continue;
                System.out.println("Case #" + caso + ": " + b.divide(BigDecimal.ONE, 3, BigDecimal.ROUND_HALF_UP).toString() + "%");
                break;
            }
            for(int[] c : diff)
            {
            	int nuevoH = actual.horizontales + (c[1] != 0 ? 1 : 0);
                int in = actual.i + c[0];
                int jn = actual.j + c[1];
                if(in < 0 || in >= filas || jn < 0 || jn >= columnas || visitados[in][jn] <= nuevoH || laberinto[in][jn] == '#')
                    continue;
                visitados[in][jn] = nuevoH;
                cola.add(new Entrada(in, jn, nuevoH, actual.pasos + 1));
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        for(caso = 1; caso <= t; caso++)
        {
            String[] pedazos = br.readLine().split(" ");
            double l = Double.parseDouble(pedazos[0]);
            filas = Integer.parseInt(pedazos[1]);
            for(int i = 0; i < filas; i++)
            {
                laberinto[i] = br.readLine().toCharArray();
                columnas = laberinto[i].length;
            }
            mejor(l);
        }
    }

}
