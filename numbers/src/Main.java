import java.util.Scanner;

public class Main {
        public static void main(String[] args){
            Scanner getNum = new Scanner(System.in);
            int num = getNum.nextInt();
            if (num > -1 && num < 129){
                String bin = binaryConverter(num);
                System.out.println(bin);
            }
            else if (num > -1 && num < 100001){
                String hex = hexiConverter(num);
                System.out.println(hex);
            }
            else{
                System.out.println("The number " + num + " exceeds the bounds of this algorithm!");
            }
        }

        public static String binaryConverter(int x){
            if (x == 0){
                return "00000000";
            }
            String output = "";
            while (x > 0){
                output += String.valueOf(x % 2);
                x /= 2;
            }
            while (output.length() < 8){
                output += "0";
            }
            String temp = "";
            for (int i = output.length() - 1; i > -1; i--){
                temp += output.charAt(i); // here
            }
            output = temp;
            temp = "";
            for (int i = 0; i < output.length(); i++){
                if (output.charAt(i) == '0'){
                    temp += "1";
                }
                else{
                    temp += "0";
                }
            }
            output = temp;
            int outputLength = 7;
            while (output.charAt(outputLength) == '1'){
                outputLength--;
            }
            output = output.substring(0, outputLength);
            output += "1";
            while (output.length() < 8){
                output += "0";
            }
            return output;
        }

        public static String hexiConverter(int x){
            String output = "";
            while (x > 0){
                int remainder = x % 16;
                if (remainder == 10){
                    output += "A";
                }
                else if (remainder == 11){
                    output += "B";
                }
                else if (remainder == 12){
                    output += "C";
                }
                else if (remainder == 13){
                    output += "D";
                }
                else if (remainder == 14){
                    output += "E";
                }
                else if (remainder == 15){
                    output += "F";
                }
                else{
                    output += String.valueOf(remainder);
                }
                x /= 16;
            }
            String temp = "0x";
            for (int i = output.length() - 1; i > -1; i--){
                temp += output.charAt(i); // here
            }
            output = temp;
            return output;
        }
}