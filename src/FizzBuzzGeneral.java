import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FizzBuzzGeneral {
    String firstWord;
    int firstWordFrequency;

    String secondWord;
    int secondWordFrequency;

    String bothWords;
    int bothWordsFrequency;

    int printFrom;
    int printUntil;

    public FizzBuzzGeneral() {
        setProperties();

        fizzWithIf();

        fizzWithTernary();

        fizzWithSwitch();
    }

    private void setProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/settings.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        firstWord = properties.getProperty("firstWord");
        firstWordFrequency = Integer.parseInt(properties.getProperty("firstWordFrequency"));

        secondWord = properties.getProperty("secondWord");
        secondWordFrequency = Integer.parseInt(properties.getProperty("secondWordFrequency"));

        bothWords = firstWord + secondWord;
        bothWordsFrequency = firstWordFrequency * secondWordFrequency;

        printFrom = Integer.parseInt(properties.getProperty("printFrom"));
        printUntil = Integer.parseInt(properties.getProperty("printUntil"));
    }

    private void fizzWithIf() {
        for (int i = printFrom; i <= printUntil; i++) {
            if (i % bothWordsFrequency == 0) {
                System.out.println(bothWords);
            } else if (i % secondWordFrequency == 0) {
                System.out.println(secondWord);
            } else if (i % firstWordFrequency == 0) {
                System.out.println(firstWord);
            } else {
                System.out.println(i);
            }
        }
    }

    //Mainly just curious if I could do it with only ternary
    private void fizzWithTernary() {
        for (int i = printFrom; i <= printUntil; i++) {
            System.out.println(
                    i % bothWordsFrequency == 0
                        ? bothWords
                        : i % secondWordFrequency == 0
                        ? secondWord
                        : i % firstWordFrequency == 0
                        ? firstWord
                        : i
            );
        }
    }

//    private void fizzWithTernary() {
//        for (int i = printFrom; i <= printUntil; i++) {
//            System.out.println(
//                    i % bothWordsFrequency == 0 ? bothWords :
//                    i % secondWordFrequency == 0 ? secondWord :
//                    i % firstWordFrequency == 0 ? firstWord :
//                    i
//            );
//        }
//    }

    //Work in progress - this is what I'd like my final product to look like if I can find a better way to check the condition.
    private void fizzWithSwitch() {
        for (int i = printFrom; i <= printUntil; i++) {
            System.out.println(
                    switch (modulusToZero(i)) {
                        case "both" -> bothWords;
                        case "second" -> secondWord;
                        case "first" -> firstWord;
                        default -> i;
                    }
            );
        }
    }

    private String modulusToZero(int i) {
        if (i % bothWordsFrequency == 0) {
            return "both";
        } else if (i % secondWordFrequency == 0) {
            return "second";
        } else if (i % firstWordFrequency == 0) {
            return "first";
        } else {
            return "number";
        }
    }

    public static void main(String[] args) {
        new FizzBuzzGeneral();
    }
}
