import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a abrabic number from 1 to 3999");
        String year = sc.nextLine();

        convertToRomanNumber(Integer.parseInt(year));
        System.out.println(convertToRomanNumber(Integer.parseInt(year)));
    }


    public static String convertToRomanNumber(int number) {

        int[] digits = splitNumber(number);
        if (number > 0 && number < 4000) {
            if (digits.length == 4) {
                return convertThousands(digits[0]) + convertHundreds(digits[1]) + convertTens(digits[2]) + convertUnits(digits[3]);
            } else if (digits.length == 3) {
                return convertHundreds(digits[0]) + convertTens(digits[1]) + convertUnits(digits[2]);
            } else if (digits.length == 2) {
                return convertTens(digits[0]) + convertUnits(digits[1]);
            } else if (digits.length == 1) {
                return convertUnits(digits[0]);
            }
        } else {
            return "Error, Incorrect Number";
        }
        return null;
    }

    public static int[] splitNumber(int number) {

        String numberText = String.valueOf(number);

        int[] resultNumbers = new int[numberText.length()];

        for (int i = 0; i < numberText.length(); i++) {

            resultNumbers[i] = Character.getNumericValue(numberText.charAt(i));
        }

        return resultNumbers;
    }


    public static String convertThousands(int number) {

        if (number == 3) {
            return "MMM";
        } else if (number == 2) {
            return "MM";
        } else if (number == 1) {
            return "M";
        } else {
            return "";
        }
    }

    public static String convertHundreds(int number) {

        String[] romanHundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        return romanHundreds[number];
    }


    public static String convertTens(int number) {
        switch (number) {
            case 1:
                return "X";
            case 2:
                return "XX";
            case 3:
                return "XXX";
            case 4:
                return "XL";
            case 5:
                return "L";
            case 6:
                return "LX";
            case 7:
                return "LXX";
            case 8:
                return "LXXX";
            case 9:
                return "XC";
            default:
                return "";
        }
    }

    public static String convertUnits(int number) {
        switch (number) {
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            default:
                return "";
        }
    }
}
