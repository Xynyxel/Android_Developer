package Modul_1_Basic;

public class modul1_basic_mutlidimensional_array {
    public static void main(String[] args) {
        int[][] arrInt = new int[3][3];

        for (int x = 0; x < arrInt.length; x++) {
            for (int y = 0; y < arrInt.length ; y++) {
                arrInt[x][y] = x + 1;
                System.out.println("array dengan indeks ["+x+"]"+"["+y+"] "+arrInt[x][y]);
            }
        }
    }
}
