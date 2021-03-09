package Modul_1_Basic;

public class modul1_if_then_elseif_then_else {
    public static void main(String[] args) {
        int nilaiUjian = 80;
        char indeksPrestasi;

        if (nilaiUjian >= 90) {
            indeksPrestasi = 'A';
        } else if (nilaiUjian >= 80) {
            indeksPrestasi = 'B';
        } else if (nilaiUjian >= 70) {
            indeksPrestasi = 'C';
        } else if (nilaiUjian >= 60) {
            indeksPrestasi = 'D';
        } else if (nilaiUjian >= 50) {
            indeksPrestasi = 'E';
        } else {
            indeksPrestasi = 'F';
        }

        System.out.println("Nilai ujian akhir anda adalah " + indeksPrestasi);
    }
}
