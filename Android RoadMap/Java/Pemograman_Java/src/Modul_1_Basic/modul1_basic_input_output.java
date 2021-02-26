package Modul_1_Basic;

// import library scanner
import java.util.Scanner;

// import library BufferedReader
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class modul1_basic_input_output {
    public static void main(String[] args) {
        // Input menggunakan Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("Program penjumalahan sangat sederhana");
        System.out.print("Masukan Angka pertama : ");
        int value = scanner.nextInt();
        System.out.print("Masukan Angka kedua : ");
        int anotherValue = scanner.nextInt();
        int result = value + anotherValue;
        System.out.println("Hasilnya adalah : " + result);

        // Input menggunakan BufferedReader
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(streamReader);
        System.out.println("Program penjumlahan sangat sederhana");
        int value1 = 0;
        int anotherValue1 = 0;
        try {
            System.out.print("Masukan Angka pertama : ");
            value1 = Integer.parseInt(bufferedReader.readLine());
            System.out.print("Masukan Angka kedua : ");
            anotherValue1 = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        int resul = value1 + anotherValue1;
        System.out.println("Hasilnya adalah : " + resul);

        // Output print dan println
        System.out.println("Dicetak pakai println()");
        System.out.println("Ini juga dicetak pakai println()");
        System.out.print("Ini dicetak dengan print()");
        System.out.print(" dan ini juga dicetak dengan print()");
    }
}

