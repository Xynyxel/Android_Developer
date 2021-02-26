package Modul_1_Basic;

public class modul1_basic_string {
    public static void main(String[] args) {

        // Char to String
        char[] dicodingChars = { 'd', 'i', 'c', 'o', 'd', 'i', 'n', 'g' };
        String dicodingString = new String(dicodingChars);
        System.out.println(dicodingString);

        // String Length
        int length = dicodingString.length();
        System.out.println("Panjang string dari dicoding = "+length);

        // ChartAt how to get char from string with index
        for (int i = 0; i < dicodingString.length() ; i++) {
            if (i == dicodingString.length()-1) System.out.println(dicodingString.charAt(i));
            else System.out.print(dicodingString.charAt(i)+",");
        }

        // Contains apakah didalam string terdapat
        Boolean cek = dicodingString.contains("di");
        System.out.println("Apakah kata di terdapat pada variabel dicodingString : "+cek);

        // Equals memeriksa 2 buah variabel memiliki nilai string yang sama
        String dicodingString1 = "Dicoding";
        String dicodingString2 = "dicoding";
        System.out.println("string 0 dan 1 : "+dicodingString.equals(dicodingString1));
        System.out.println("string 0 dan 2 : "+dicodingString.equals(dicodingString2));

        // isEmpty apakah sebuah variabel memiliki string kosong atau tidak
        String kosong = "";
        System.out.println("Apakah Variabel kosong? => "+kosong.isEmpty());
        System.out.println("Apakah Variabel dicodingString? => "+dicodingString.isEmpty());
    }
}
