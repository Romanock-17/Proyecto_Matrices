package Tripleta;

public class Tripleta {
    // Atributos
    private int[][] matriz;

    public Tripleta(int datos, int filas, int columnas) {
        matriz = new int[datos][3];
        matriz[0][0] = filas;
        matriz[0][1] = columnas;
        matriz[0][2] = datos;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }
    public int getMatriz(int fila, int columna) {
        return matriz[fila][columna];
    }
    public void setMatriz(int datos, int fila, int columna) {
        matriz[fila][columna] = datos;
    }


    public void crearTripletas(int[][] matriz) {
        int contador = 1;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] != 0) {
                    this.matriz[contador][0] = i;
                    this.matriz[contador][1] = j;
                    this.matriz[contador][2] = matriz[i][j];
                    contador++;
                }
            }
        }
    }

    //multiplicar tripetas
    public Tripleta multiplicar(Tripleta t2){
        Tripleta t3 = new Tripleta(0, this.matriz[0][0], t2.matriz[0][1]);
        int[][] m1 = this.matriz;
        int[][] m2 = t2.matriz;
        int[][] m3 = t3.matriz;
        int n = m1[0][2];
        int p = m2[0][2];
        int i = 1;
        int j = 1;
        int k = 1;
        int fila = m1[0][0];
        int columna = m2[0][1];
        int a = m1[1][0];
        int c = m2[1][0];
        int suma = 0;
        int k1=0;
        int k2=0;
        while (i <= n) {
            int fila1 = m1[i][0];
            while (j <= p) {
                int columna2 = m2[j][1];
                int valor = 0;
                k1 = a;
                k2 = c;
                while (k1 < n && m1[k1][0] == fila1 && k2 < p && m2[k2][1] == columna2) {
                    if (m1[k1][1] < m2[k2][0]) {
                        k1++;
                    } else if (m1[k1][1] > m2[k2][0]) {
                        k2++;
                    } else {
                        valor += m1[k1][2] * m2[k2][2];
                        k1++;
                        k2++;
                    }
                }
                if (valor != 0) {
                    k++;
                    m3[k][0] = fila1;
                    m3[k][1] = columna2;
                    m3[k][2] = valor;
                }
                j = k2;
            }
            i = k1;
        }
        m3[0][2] = k;
        return t3;
    }
}

