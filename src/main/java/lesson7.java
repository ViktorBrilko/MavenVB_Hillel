import org.junit.Test;

public class lesson7 {

    public static void main(String[] args) {
        String initText = "once.upon a time i started to,do.this homework:and it was very,tough.for:me";
        String result = changeText(initText);
        System.out.println(result);
    }

    public static String changeText(String text) {
        StringBuilder stringBuilder = new StringBuilder(text);
        String upperText = "";
        String dot = ".";
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.substring(i, i + 1).equals(dot)) {
                upperText = upperText + stringBuilder.substring(i, i + 1) + stringBuilder.substring(i + 1, i + 2).replace(stringBuilder.substring(i + 1, i + 2), stringBuilder.substring(i + 1, i + 2).toUpperCase());
                stringBuilder.deleteCharAt(i + 1);
            } else {
                upperText = upperText + stringBuilder.substring(i, i + 1);
            }
        }

        String[] newText = upperText.split("[ .:,]");

        stringBuilder.replace(0, stringBuilder.length(), newText[0]);
        stringBuilder.replace(0, 1, stringBuilder.substring(0, 1).toUpperCase());
        newText[0] = stringBuilder.toString();

        return String.join(" ", newText);
    }



}

