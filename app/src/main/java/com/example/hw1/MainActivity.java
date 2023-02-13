package com.example.hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn = findViewById(R.id.submitBtnId);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText inputNumber = findViewById(R.id.editTxtId);
                TextView outputNumber = findViewById(R.id.outputId);
                String userInput = inputNumber.getText().toString();

                try {
                    String finalOutput = test(Integer.parseInt(userInput));
                    if (Integer.parseInt(userInput) < 0 || Integer.parseInt(userInput) > 999999999){
                        outputNumber.setVisibility(View.INVISIBLE);
                        Toast.makeText(MainActivity.this, "please enter a valid input!", Toast.LENGTH_LONG).show();
                    } else {
                        outputNumber.setText(inputNumber.getText() + " in letters is: \n \n" + finalOutput);
                        outputNumber.setVisibility(View.VISIBLE);
                    }
                } catch (NumberFormatException e){
                    outputNumber.setVisibility(View.INVISIBLE);
                    Toast.makeText(MainActivity.this, "please enter a valid input!", Toast.LENGTH_LONG).show();
                }
            }
        });

        Button exitBtn = findViewById(R.id.exitBtnId);
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
    }

        static String value = "";
        static int firstDigit = 0;
        static int secondDigit = 0;
        static int thirdDigit = 0;
        static int fourthDigit = 0;
        static int fifthDigit = 0;
        static int sixthDigit = 0;
        static int seventhDigit = 0;
        static int eighthDigit = 0;
        static int ninthDigit = 0;

        public static String[] one_digit = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        public static String[] two_digits_until_twenty = {"eleven", "twelve", "thirteen", "fourteen",
                "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        public static String[] two_digits_after_twenty = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};


    public static String test(int number) {
        if (number == 0) {
            return "zero";
        } else if (number < 10) {
            return lessThanTen(number);
        } else if (number == 10) {
            return "ten";
        } else if (number < 20) {
            return lessThanTwenty(number);
        } else if (number == 20) {
            return "twenty";
        } else if (number < 100) {
            return lessThanHundred(number);
        } else if (number == 100) {
            return "one hundred";
        } else if (number < 1000) {
            return lessThanThousand(number);
        } else if (number == 1000) {
            return "one thousand";
        } else if (number < 10000) {
            return lessThanTenThousand(number);
        } else if (number == 10000){
            return "ten thousand";
        } else if (number < 100000){
            return lessThanHundredThousand(number);
        } else if (number == 100000){
            return "hundred thousand";
        } else if (number < 1000000){
            return lessThanMillion(number);
        } else if (number == 1000000){
            return "one million";
        } else if (number < 10000000){
            return lessThanTenMillion(number);
        } else if (number == 10000000){
            return "ten million";
        } else if (number < 100000000){
            return lessThanHundredMillion(number);
        } else if (number == 100000000){
            return "hundred million";
        } else {
            return lessThanBillion(number);
        }
    }


        public static String lessThanTen(int number) {
            for (int i = 0; i < number; i++) {
                value = one_digit[i];
            }
            return value;
        }
        public static String lessThanTwenty(int number) {
            if (number < 10){
                return lessThanTen(number);
            } else if (number == 10){
                return "ten";
            } else {
                for (int i = 0; i < number % 10; i++) {
                    value = two_digits_until_twenty[i];
                }
                return value;
            }
        }
        public static String lessThanHundred(int number) {
            firstDigit = number / 10;
            secondDigit = number % 10;
            String val1 = "";
            String val2 = "";
            if (number < 10) {
                return lessThanTen(number);
            } else if (number == 10) {
                return "ten";
            } else if (number < 20) {
                return lessThanTwenty(number);
            } else if (number == 20) {
                return "twenty";
            } else {
                for (int i = 1; i < firstDigit; i++) {
                    val1 = two_digits_after_twenty[i - 1];
                }
                for (int j = 0; j < secondDigit; j++) {
                    val2 = one_digit[j];
                }
                return val1 + " " + val2;
            }
        }
        public static String lessThanThousand(int number) {
            firstDigit = number / 100;
            secondDigit = (number / 10) % 10;
            thirdDigit = number % 100;
            if (number < 100){
                return lessThanHundred(number);
            } else if (secondDigit == 0 && thirdDigit == 0) {
                return lessThanTen(firstDigit) + " hundred";
            } else if (secondDigit == 1) {
                String val1 = lessThanTen(firstDigit);
                return val1 + " hundred " + lessThanTwenty(number % 100);
            } else {
                String val1 = lessThanTen(firstDigit);
                if (secondDigit == 0) {
                    String val2 = lessThanTen(thirdDigit);
                    return val1 + " hundred " + val2;
                } else {
                    String val2 = lessThanHundred(number % 100);
                    return val1 + " hundred " + val2;
                }
            }
        }
        public static String lessThanTenThousand(int number) {
            firstDigit = number / 1000;
            secondDigit = (number / 100) % 10;
            thirdDigit = (number / 10) % 10;
            fourthDigit = number % 10;
            String newNum;
            if (number < 1000){
                return lessThanThousand(number);
            } else if (secondDigit == 0 && thirdDigit == 0 && fourthDigit == 0) {
                return lessThanTen(firstDigit) + " thousand";
            } else if (secondDigit == 0 && thirdDigit == 0) {
                return lessThanTen(firstDigit) + " thousand " + lessThanTen(fourthDigit);
            } else if (secondDigit == 0) {
                newNum = String.valueOf(thirdDigit) + String.valueOf(fourthDigit);
                return lessThanTen(firstDigit) + " thousand " + lessThanHundred(Integer.parseInt(newNum));
            } else {
                newNum = String.valueOf(secondDigit) + String.valueOf(thirdDigit) + String.valueOf(fourthDigit);
                String val1 = lessThanTen(firstDigit);
                return val1 + " thousand " + lessThanThousand(Integer.parseInt(newNum));
            }
        }
        public static String lessThanHundredThousand(int number){
            firstDigit = number / 10000;
            secondDigit = (number / 1000) % 10;
            thirdDigit = (number / 100) % 10;
            fourthDigit = (number / 10) % 10;
            fifthDigit = number % 10;
            String newNum1;
            String newNum2;
            String newNum;
            if (number < 10000){
                return lessThanTenThousand(number);
            } else if (secondDigit == 0 && thirdDigit == 0 && fourthDigit == 0 && fifthDigit == 0) {
                String a = "";
                for (int i = 1; i < firstDigit; i++) {
                    a = two_digits_after_twenty[i - 1];
                }
                return a + " thousand";
            } else if (secondDigit == 0 && thirdDigit == 0 && fourthDigit == 0) {
                String a = "";
                for (int i = 1; i < firstDigit; i++) {
                    a = two_digits_after_twenty[i - 1];
                }
                return a + " thousand " + lessThanTen(fifthDigit);
            } else if (secondDigit == 0 && thirdDigit == 0) {
                String a = "";
                for (int i = 1; i < firstDigit; i++) {
                    a = two_digits_after_twenty[i - 1];
                }
                newNum = String.valueOf(fourthDigit) + String.valueOf(fifthDigit);
                return a + " thousand " + lessThanHundred(Integer.parseInt(newNum));
            } else if (secondDigit == 0) {
                String a = "";
                for (int i = 1; i < firstDigit; i++) {
                    a = two_digits_after_twenty[i - 1];
                }
                newNum = String.valueOf(thirdDigit) + String.valueOf(fourthDigit) + String.valueOf(fifthDigit);
                return a + " thousand " + lessThanThousand(Integer.parseInt(newNum));
            }
            else {
                newNum1 = String.valueOf(firstDigit) + String.valueOf(secondDigit);
                newNum2 = String.valueOf(thirdDigit) + String.valueOf(fourthDigit) + String.valueOf(fifthDigit);
                String val1 = lessThanHundred(Integer.parseInt(newNum1));
                String val2 = lessThanThousand(Integer.parseInt(newNum2));
                return val1 + " thousand " + val2;
            }
        }
        public static String lessThanMillion(int number) {
            firstDigit = number / 100000;
            secondDigit = (number / 10000) % 10;
            thirdDigit = (number / 1000) % 10;
            fourthDigit = (number / 100) % 10;
            fifthDigit = (number / 10) % 10;
            sixthDigit = number % 10;
            String newNum1;
            String newNum2;
            String newNum;
            if (number < 100000){
                return lessThanHundredThousand(number);
            } else if (secondDigit == 0 && thirdDigit == 0 && fourthDigit == 0 && fifthDigit == 0 && sixthDigit == 0) {
                String a = "";
                for (int i = 0; i < firstDigit; i++) {
                    a = one_digit[i];
                }
                return a + " hundred thousand";
            } else if (secondDigit == 0 && thirdDigit == 0 && fourthDigit == 0 && fifthDigit == 0) {
                String a = "";
                for (int i = 0; i < firstDigit; i++) {
                    a = one_digit[i];
                }
                return a + " hundred thousand " + lessThanTen(sixthDigit);
            } else if (secondDigit == 0 && thirdDigit == 0 && fourthDigit == 0) {
                String a = "";
                for (int i = 0; i < firstDigit; i++) {
                    a = one_digit[i];
                }
                newNum = String.valueOf(fifthDigit) + String.valueOf(sixthDigit);
                return a + " hundred thousand " + lessThanHundred(Integer.parseInt(newNum));
            } else if (secondDigit == 0 && thirdDigit == 0) {
                String a = "";
                for (int i = 0; i < firstDigit; i++) {
                    a = one_digit[i];
                }
                newNum = String.valueOf(fourthDigit) + String.valueOf(fifthDigit) + String.valueOf(sixthDigit);
                return a + " hundred thousand " + lessThanThousand(Integer.parseInt(newNum));
            } else if (secondDigit == 0) {
                String a = "";
                for (int i = 0; i < firstDigit; i++) {
                    a = one_digit[i];
                }
                newNum = String.valueOf(thirdDigit) + String.valueOf(fourthDigit) + String.valueOf(fifthDigit) + String.valueOf(sixthDigit);
                return a + " hundred thousand " + lessThanTenThousand(Integer.parseInt(newNum));
            }
            else {
                String a = "";
                for (int i = 0; i < firstDigit; i++) {
                    a = one_digit[i];
                }
                newNum1 = String.valueOf(secondDigit) + String.valueOf(thirdDigit);
                newNum2 = String.valueOf(fourthDigit) + String.valueOf(fifthDigit) + String.valueOf(sixthDigit);
                String val1 = lessThanHundred(Integer.parseInt(newNum1));
                String val2 = lessThanThousand(Integer.parseInt(newNum2));
                return a + " hundred " + val1 + " thousand " + val2;
            }
        }
        public static String lessThanTenMillion(int number){
            firstDigit = number / 1000000;
            secondDigit = (number / 100000) % 10;
            thirdDigit = (number / 10000) % 10;
            fourthDigit = (number / 1000) % 10;
            fifthDigit = (number / 100) % 10;
            sixthDigit = (number / 10) % 10;
            seventhDigit = number % 10;
            String newNum;
            if (number < 1000000){
                return lessThanMillion(number);
            } else if (secondDigit == 0 && thirdDigit == 0 && fourthDigit == 0 && fifthDigit == 0 && sixthDigit == 0 && seventhDigit == 0) {
                String a = "";
                for (int i = 0; i < firstDigit; i++) {
                    a = one_digit[i];
                }
                return a + " million";
            } else if (secondDigit == 0 && thirdDigit == 0 && fourthDigit == 0 && fifthDigit == 0 && sixthDigit == 0) {
                String a = "";
                for (int i = 0; i < firstDigit; i++) {
                    a = one_digit[i];
                }
                return a + " million " + lessThanTen(seventhDigit);
            } else if (secondDigit == 0 && thirdDigit == 0 && fourthDigit == 0 && fifthDigit == 0) {
                String a = "";
                for (int i = 0; i < firstDigit; i++) {
                    a = one_digit[i];
                }
                newNum = String.valueOf(sixthDigit) + String.valueOf(seventhDigit);
                return a + " million " + lessThanHundred(Integer.parseInt(newNum));
            } else if (secondDigit == 0 && thirdDigit == 0 && fourthDigit == 0) {
                String a = "";
                for (int i = 0; i < firstDigit; i++) {
                    a = one_digit[i];
                }
                newNum = String.valueOf(fifthDigit) + String.valueOf(sixthDigit) + String.valueOf(seventhDigit);
                return a + " million " + lessThanThousand(Integer.parseInt(newNum));
            } else if (secondDigit == 0 && thirdDigit == 0) {
                String a = "";
                for (int i = 0; i < firstDigit; i++) {
                    a = one_digit[i];
                }
                newNum = String.valueOf(fourthDigit) + String.valueOf(fifthDigit) + String.valueOf(sixthDigit) + String.valueOf(seventhDigit);
                return a + " million " + lessThanTenThousand(Integer.parseInt(newNum));
            } else if (secondDigit == 0) {
                String a = "";
                for (int i = 0; i < firstDigit; i++) {
                    a = one_digit[i];
                }
                newNum = String.valueOf(thirdDigit) + String.valueOf(fourthDigit) + String.valueOf(fifthDigit) + String.valueOf(sixthDigit) + String.valueOf(seventhDigit);
                return a + " million " + lessThanHundredThousand(Integer.parseInt(newNum));
            }
            else {
                String a = "";
                for (int i = 0; i < firstDigit; i++) {
                    a = one_digit[i];
                }
                newNum = String.valueOf(secondDigit) + String.valueOf(thirdDigit) + String.valueOf(fourthDigit) +
                        String.valueOf(fifthDigit) + String.valueOf(sixthDigit) +  String.valueOf(seventhDigit);
                return a + " million " + lessThanMillion(Integer.parseInt(newNum));
            }
        }
        public static String lessThanHundredMillion(int number){
            firstDigit = number / 10000000;
            secondDigit = (number / 1000000) % 10;
            thirdDigit = (number / 100000) % 10;
            fourthDigit = (number / 10000) % 10;
            fifthDigit = (number / 1000) % 10;
            sixthDigit = (number / 100) % 10;
            seventhDigit = (number / 10) % 10;
            eighthDigit = number % 10;
            String newNum1;
            String newNum2;
            String newNum;
            if (number < 10000000){
                return lessThanHundredThousand(number);
            } else if (secondDigit == 0 && thirdDigit == 0 && fourthDigit == 0 && fifthDigit == 0 && sixthDigit == 0 &&
                    seventhDigit == 0 && eighthDigit == 0) {
                String a = "";
                for (int i = 1; i < firstDigit; i++) {
                    a = two_digits_after_twenty[i - 1];
                }
                return a + " million";
            } else if (secondDigit == 0 && thirdDigit == 0 && fourthDigit == 0 && fifthDigit == 0 && sixthDigit == 0 &&
                    seventhDigit == 0) {
                String a = "";
                for (int i = 1; i < firstDigit; i++) {
                    a = two_digits_after_twenty[i - 1];
                }
                return a + " million " + lessThanTen(eighthDigit);
            } else if (secondDigit == 0 && thirdDigit == 0 && fourthDigit == 0 && fifthDigit == 0 && sixthDigit == 0) {
                String a = "";
                for (int i = 1; i < firstDigit; i++) {
                    a = two_digits_after_twenty[i - 1];
                }
                newNum = String.valueOf(seventhDigit) + String.valueOf(eighthDigit);
                return a + " million " + lessThanHundred(Integer.parseInt(newNum));
            } else if (secondDigit == 0 && thirdDigit == 0 && fourthDigit == 0 && fifthDigit == 0) {
                String a = "";
                for (int i = 1; i < firstDigit; i++) {
                    a = two_digits_after_twenty[i - 1];
                }
                newNum = String.valueOf(sixthDigit) + String.valueOf(seventhDigit) + String.valueOf(eighthDigit);
                return a + " million " + lessThanThousand(Integer.parseInt(newNum));
            } else if (secondDigit == 0 && thirdDigit == 0 && fourthDigit == 0) {
                String a = "";
                for (int i = 1; i < firstDigit; i++) {
                    a = two_digits_after_twenty[i - 1];
                }
                newNum = String.valueOf(fifthDigit) + String.valueOf(sixthDigit) + String.valueOf(seventhDigit) + String.valueOf(eighthDigit);
                return a + " million " + lessThanTenThousand(Integer.parseInt(newNum));
            } else if (secondDigit == 0 && thirdDigit == 0) {
                String a = "";
                for (int i = 1; i < firstDigit; i++) {
                    a = two_digits_after_twenty[i - 1];
                }
                newNum = String.valueOf(fourthDigit) + String.valueOf(fifthDigit) + String.valueOf(sixthDigit) +
                        String.valueOf(seventhDigit) + String.valueOf(eighthDigit);
                return a + " million " + lessThanHundredThousand(Integer.parseInt(newNum));
            } else if (secondDigit == 0) {
                String a = "";
                for (int i = 1; i < firstDigit; i++) {
                    a = two_digits_after_twenty[i - 1];
                }
                newNum = String.valueOf(thirdDigit) + String.valueOf(fourthDigit) + String.valueOf(fifthDigit) +
                        String.valueOf(sixthDigit) + String.valueOf(seventhDigit) + String.valueOf(eighthDigit);
                return a + " million " + lessThanMillion(Integer.parseInt(newNum));
            }
            else {
                newNum1 = String.valueOf(firstDigit) + String.valueOf(secondDigit);
                newNum2 = String.valueOf(thirdDigit) + String.valueOf(fourthDigit) + String.valueOf(fifthDigit) +
                        String.valueOf(sixthDigit) +  String.valueOf(seventhDigit) + String.valueOf(eighthDigit);
                return lessThanHundred(Integer.parseInt(newNum1)) + " million " + lessThanMillion(Integer.parseInt(newNum2));
            }
        }
        public static String lessThanBillion(int number){
            firstDigit = number / 100000000;
            secondDigit = (number / 10000000) % 10;
            thirdDigit = (number / 1000000) % 10;
            fourthDigit = (number / 100000) % 10;
            fifthDigit = (number / 10000) % 10;
            sixthDigit = (number / 1000) % 10;
            seventhDigit = (number / 100) % 10;
            eighthDigit = (number / 10) % 10;
            ninthDigit = number % 10;
            String newNum1;
            String newNum2;
            String newNum;
            if (number < 100000000){
                return lessThanHundredMillion(number);
            } else if (secondDigit == 0 && thirdDigit == 0 && fourthDigit == 0 && fifthDigit == 0 && sixthDigit == 0 &&
                    seventhDigit == 0 && eighthDigit == 0 && ninthDigit == 0) {
                String a = "";
                for (int i = 0; i < firstDigit; i++) {
                    a = one_digit[i];
                }
                return a + " hundred million";
            }
            else if (secondDigit == 0 && thirdDigit == 0 && fourthDigit == 0 && fifthDigit == 0 && sixthDigit == 0 &&
                    seventhDigit == 0 && eighthDigit == 0) {
                String a = "";
                for (int i = 0; i < firstDigit; i++) {
                    a = one_digit[i];
                }
                return a + " hundred million " + lessThanTen(ninthDigit);
            } else if (secondDigit == 0 && thirdDigit == 0 && fourthDigit == 0 && fifthDigit == 0 && sixthDigit == 0 &&
                    seventhDigit == 0) {
                String a = "";
                for (int i = 0; i < firstDigit; i++) {
                    a = one_digit[i];
                }
                newNum = String.valueOf(eighthDigit) + String.valueOf(ninthDigit);
                return a + " hundred million " + lessThanHundred(Integer.parseInt(newNum));
            } else if (secondDigit == 0 && thirdDigit == 0 && fourthDigit == 0 && fifthDigit == 0 && sixthDigit == 0) {
                String a = "";
                for (int i = 0; i < firstDigit; i++) {
                    a = one_digit[i];
                }
                newNum = String.valueOf(seventhDigit) + String.valueOf(eighthDigit) + String.valueOf(ninthDigit);
                return a + " hundred million " + lessThanThousand(Integer.parseInt(newNum));
            } else if (secondDigit == 0 && thirdDigit == 0 && fourthDigit == 0 && fifthDigit == 0) {
                String a = "";
                for (int i = 0; i < firstDigit; i++) {
                    a = one_digit[i];
                }
                newNum = String.valueOf(sixthDigit) + String.valueOf(seventhDigit) + String.valueOf(eighthDigit) +
                        String.valueOf(ninthDigit);
                return a + " hundred million " + lessThanTenThousand(Integer.parseInt(newNum));
            } else if (secondDigit == 0 && thirdDigit == 0 && fourthDigit == 0) {
                String a = "";
                for (int i = 0; i < firstDigit; i++) {
                    a = one_digit[i];
                }
                newNum = String.valueOf(fifthDigit) + String.valueOf(sixthDigit) + String.valueOf(seventhDigit) +
                        String.valueOf(eighthDigit) + String.valueOf(ninthDigit);
                return a + " hundred million " + lessThanHundredThousand(Integer.parseInt(newNum));
            } else if (secondDigit == 0 && thirdDigit == 0) {
                String a = "";
                for (int i = 0; i < firstDigit; i++) {
                    a = one_digit[i];
                }
                newNum = String.valueOf(fourthDigit) + String.valueOf(fifthDigit) + String.valueOf(sixthDigit) +
                        String.valueOf(seventhDigit) + String.valueOf(eighthDigit) + String.valueOf(ninthDigit);
                return a + " hundred million " + lessThanMillion(Integer.parseInt(newNum));
            }
            else {
                newNum1 = String.valueOf(firstDigit) + String.valueOf(secondDigit) + String.valueOf(thirdDigit);
                newNum2 = String.valueOf(fourthDigit) + String.valueOf(fifthDigit) + String.valueOf(sixthDigit) +
                        String.valueOf(seventhDigit) + String.valueOf(eighthDigit) + String.valueOf(ninthDigit);
                return lessThanThousand(Integer.parseInt(newNum1)) + " million " + lessThanMillion(Integer.parseInt(newNum2));
            }
        }
}