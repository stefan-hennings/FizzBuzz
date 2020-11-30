import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FizzBuzzGeneral {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/settings.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String firstWord = properties.getProperty("firstWord");
        int firstWordFrequency = Integer.parseInt(properties.getProperty("firstWordFrequency"));

        String secondWord = properties.getProperty("secondWord");
        int secondWordFrequency = Integer.parseInt(properties.getProperty("secondWordFrequency"));

        int printFrom = Integer.parseInt(properties.getProperty("printFrom"));
        int printUntil = Integer.parseInt(properties.getProperty("printUntil"));

        for (int i = printFrom; i <= printUntil; i++) {
            if (i % (firstWordFrequency * secondWordFrequency) == 0) {
                System.out.println(firstWord + secondWord);
            } else if (i % secondWordFrequency == 0) {
                System.out.println(secondWord);
            } else if (i % firstWordFrequency == 0) {
                System.out.println(firstWord);
            } else {
                System.out.println(i);
            }
        }
    }
}
