package lesson7;

import org.junit.Test;

import java.io.*;

public class lesson7 {

    public static void main(String[] args) {
        String a = "";
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/lesson7/InputText.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                 a = a + line;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        String result = changeText(a);

        try (BufferedWriter writter = new BufferedWriter(new FileWriter("src/main/java/lesson7/OutputText.txt"))) {

                writter.write(result);

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(result);
    }



    public static String changeText(String text) {
        StringBuilder stringBuilder = new StringBuilder(text);
        String upperText = "";
        String dot = ".";
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.substring(i, i + 1).equals(dot)) {
                upperText = upperText + stringBuilder.substring(i, i + 1) + ":" + stringBuilder.substring(i + 1, i + 2).replace(stringBuilder.substring(i + 1, i + 2), stringBuilder.substring(i + 1, i + 2).toUpperCase());
                stringBuilder.deleteCharAt(i + 1);
            } else {
                upperText = upperText + stringBuilder.substring(i, i + 1);
            }
        }

        System.out.println(upperText);

        String[] newText = upperText.split("[ :,]");

        stringBuilder.replace(0, stringBuilder.length(), newText[0]);
        stringBuilder.replace(0, 1, stringBuilder.substring(0, 1).toUpperCase());
        newText[0] = stringBuilder.toString();

        return String.join(" ", newText);
    }



}

