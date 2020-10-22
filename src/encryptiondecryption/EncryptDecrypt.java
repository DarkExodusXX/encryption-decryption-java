package encryptiondecryption;

import java.io.File;
import java.util.Scanner;

public class EncryptDecrypt {

    static public StringBuilder encryptDecrypt(String data, int key, String in, String alg) {
        StringBuilder result = new StringBuilder();
        if (in == null) {
            return algorithm(alg, data, key, result);
        } else {
            File file = new File(in);
            try (Scanner scanner = new Scanner(file)) {
                data = scanner.nextLine();
                return algorithm(alg, data, key, result);
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
        return null;
    }

    static public StringBuilder algorithm(String alg, String data, int key, StringBuilder result) {
        if (alg == null || alg.equals("shift")) {
            for (int i = 0; i < data.length(); i++) {
                final String upperDict = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                final String lowerDict = "abcdefghijklmnopqrstuvwxyz";
                int i1 = upperDict.indexOf(data.charAt(i));
                int i2 = lowerDict.indexOf(data.charAt(i));
                if (i1 != -1 || i2 != -1) {
                    if (data.charAt(i) == Character.toUpperCase(data.charAt(i))) {
                        result.append(upperDict.charAt((i1 + key + 26) % upperDict.length()));
                    } else {
                        result.append(lowerDict.charAt((i2 + key + 26) % lowerDict.length()));
                    }
                } else {
                    result.append(data.charAt(i));
                }
            }
        } else {
            for (int i = 0; i < data.length(); i++) {
                result.append((char)((int) data.charAt(i) + key));
            }
        }
        return result;
    }
}
