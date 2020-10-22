package encryptiondecryption;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    static Scanner scannerForLine = new Scanner(System.in);
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String mode = "enc";
        int key = 0;
        String data = null;
        String in = null;
        String out = null;
        String alg = null;
        StringBuilder result =  null;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                mode = args[i + 1];
            }
            if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i + 1]);
            }
            if (args[i].equals("-data")) {
                data = args[i + 1];
            }
            if (args[i].equals("-in")) {
                in = args[i + 1];
            }
            if (args[i].equals("-out")) {
                out = args[i + 1];
            }
            if (args[i].equals("-alg")) {
                alg = args[i + 1];
            }
        }
        if (data != null || in != null) {
            if (mode.equals("enc")) {
                result = EncryptDecrypt.encryptDecrypt(data, key, in, alg);
            } else {
                result = EncryptDecrypt.encryptDecrypt(data, -key, in, alg);
            }
            if (out == null) {
                System.out.println(result);
            } else {
                File file = new File(out);
                try (FileWriter fileWriter = new FileWriter(file)) {
                    assert result != null;
                    fileWriter.write(result.toString());
                } catch (Exception e) {
                    System.out.println("Error");
                }
            }
        } else {
            System.out.println("Error");
        }
    }
}

