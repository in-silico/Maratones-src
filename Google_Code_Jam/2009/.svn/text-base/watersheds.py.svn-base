
h = 0
w = 0

if __name__ == "__main__":
    import sys
    import watersheds
    archivoEntrada = open(sys.argv[1], 'r')
    archivoSalida = open(sys.argv[2], 'w')
    nmapas = int(archivoEntrada.readline().replace("\n", ""))
    for i in range(0, nmapas):
        watersheds.letraActual = 0
        a = archivoEntrada.readline().replace("\n", "").rsplit(" ")
        h = int(a[0])
        w = int(a[1])
        mapa = []
        for j in range(0, h):
            mapa.append(archivoEntrada.readline().replace("\n", "").rsplit(" "))
            for k in range(0, w):
                mapa[j][k] = int(mapa[j][k])
        mapaSalida = []
        for j in range(0, h):
            mapaSalida.append([])
            for k in range(0, w):
                if j > 0:
                    north = mapa[j - 1][k]
                else:
                    north = 10001    
                if j < h - 1:
                    south = mapa[j + 1][k]
                else:
                    south = 10001
                if k > 0:
                    west = mapa[j][k - 1]
                else:
                    west = 10001
                if k < w - 1:
                    east = mapa[j][k + 1]
                else:
                    east = 10001
                x = watersheds.calcular(north, west, east, south, mapa[j][k])
                if x.capitalize() != x:
                    watersheds.letraActual += 1;
                mapaSalida[j].append(x)
        for j in range(0, h):
            for k in range(0, w):
                if mapaSalida[j][k].capitalize() == mapaSalida[j][k]:
                    watersheds.arreglar(mapaSalida, j, k, watersheds)
                    if watersheds.termino == 1:
                        watersheds.letraActual += 1;  
        archivoSalida.write('Case #' + str(i + 1) + ':')
        for j in range(0, h):
            archivoSalida.write('\n')
            for k in range(0, w):
                if k == 0:
                    archivoSalida.write(mapaSalida[j][k])
                else:
                    archivoSalida.write(' ' + mapaSalida[j][k])
        if i < nmapas - 1:
            archivoSalida.write('\n')
            
                
                
letras = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
letraActual = 0

def calcular(north, west, east, south, actual):
    menor = north
    menores = 'N'
    if west < menor:
        menor = west
        menores = 'W'
    if east < menor:
        menor = east
        menores = 'E'
    if south < menor:
        menor = south
        menores = 'S'
    if actual <= menor:
        return '0'
    else:
        return menores

def arreglar(mapaSalida, i, j, watersheds):
    if mapaSalida[i][j] == '0':
        watersheds.termino = 1
        mapaSalida[i][j] = letras[letraActual]
        return mapaSalida[i][j]
    if mapaSalida[i][j].capitalize() != mapaSalida[i][j]:
        watersheds.termino = 0
        return mapaSalida[i][j]
    else:
        if mapaSalida[i][j] == 'N':
            mapaSalida[i][j] = arreglar(mapaSalida, i - 1, j, watersheds)
        elif mapaSalida[i][j] == 'W':
            mapaSalida[i][j] = arreglar(mapaSalida, i, j - 1, watersheds)
        elif mapaSalida[i][j] == 'E':
            mapaSalida[i][j] = arreglar(mapaSalida, i, j + 1, watersheds)
        elif mapaSalida[i][j] == 'S':
            mapaSalida[i][j] = arreglar(mapaSalida, i + 1, j, watersheds)
        return mapaSalida[i][j]