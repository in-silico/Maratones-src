
import re

if __name__ == "__main__":
    import sys
    archivoEntrada = open(sys.argv[1], 'r')
    archivoSalida = open(sys.argv[2], 'w')
    n = 0
    palabras = []
    for linea in archivoEntrada:
        linea = linea.replace("\n", "")
        if n == 0:
            a = linea.rsplit(" ")
            d = int(a[1])
        elif n <= d:
            palabras.append(linea)
        else:
            z = 0
            for palabra in palabras:
                if re.match(linea.replace("(","[").replace(")","]"), palabra) != None:
                    z += 1
            archivoSalida.write("Case #" + str((n - d)) + ":" + " " + str(z) + "\n")
        n += 1