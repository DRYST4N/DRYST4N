import java.util.ArrayList;

public class Modelo {
    public int pelotaX = 51;
    public int pelotaY = 79;
    public int velocidadPelota_dx = 2; // velocidad en el eje x
    public int velocidadPelota_dy = 2; // velocidad en el eje y
    public int pelotaDiametro = 10;
    public int pelota_dano = 1;
    public int vida = 1;
    public int paletaX = 100; // Posicion inicial de la paleta
    public int paletaY = 500; // Posicion vertical de la paleta
    public int paletaWidth = 70; // Ancho de la paleta
    public int paletaHeight = 15; // Altura de la paleta
    public int ladrilloWidth = 30;
    public int ladrilloHeight = 20;

    public ArrayList<int[][]> niveles = new ArrayList<>();
    public int nivelActual = 0;

    public Modelo() {
        // Define aquí las matrices de niveles
        int constBloques[][];

        // Define aquí la primera matriz de niveles
        constBloques = new int[][]{
                {0, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 0}
        };
        niveles.add(constBloques);
        constBloques = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, -1, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0}
        };
        niveles.add(constBloques);
        // Agrega las demás matrices de niveles de la misma manera

    }

    public int[][] getNivel(int nivel) {
        if (nivel >= 1 && nivel <= niveles.size()) {
            return niveles.get(nivel - 1); // Niveles indexados desde 1
        }
        return null;
    }
    public int[][] getNivelActual() {
        if (nivelActual >= 0 && nivelActual < niveles.size()) {
            return niveles.get(nivelActual);
        } else {
            return null;
        }
    }
}
