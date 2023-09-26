package WorkWithStrings;
import java.util.Arrays;
import java.util.Scanner;

/*
* Ввести n чисел з консолі.
Знайти число, цифри в якому йдуть в строгому порядку зростання.
*  Якщо таких чисел декілька, знайти перше з них.*/
public class WorkWithStrings {

    public static void main(String[] args) {
    System.out.println("Enter array of numbers with \",\"delimit");
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        int [] validNumbersArray = getInputValidator(data);
       for(int number: validNumbersArray){
           if(number<=9){
               continue;
           }
           if(isIncreasedNumber(number)){
               System.out.println(number);
               break;
           }
           else {
               System.out.println("Increased number doesn't exist in current array");
           }

       }

    }
    ///Method for check digits in number get in increased order
    ///@1param - number for checking
    ///@return - boolean type:
    ///true - if digit in increased order,
    ///false - digits doesn't in increased order
   public static boolean isIncreasedNumber(int number){
    int lastDigit = number%10;
    number/=10;
    while (number>0){
        int currentDigit = number%10;
        if(currentDigit>=lastDigit){
            return false;
        }
        lastDigit=currentDigit;
        number/=10;
    }
    return true;
   }
    ///Method for validate user input and get abs for negative numbers
    static int[] getInputValidator(String str)throws NumberFormatException{
        String[] numbersStr = str.split(",");
        System.out.println(Arrays.toString(numbersStr));
        int[] numbersArray = new int[numbersStr.length];
        for(int i = 0;i < numbersStr.length;i++)
        {
            try {
                numbersArray[i] = Integer.parseInt(numbersStr[i]);
            }catch (NumberFormatException ex){
                System.out.println("Invalid input:"+ex);
            }
        }
        return numbersArray;
    }
}


