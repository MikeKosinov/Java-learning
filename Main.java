import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter an array of numbers. Items separate with <,>");
        Scanner sc = new Scanner(System.in);
        String arrayData= sc.nextLine();
        int [] intArr = getInputValidator(arrayData);
        getBubbleSort(intArr,intArr.length);
        System.out.println(Arrays.toString(intArr));
sc.close();

}
//Method for validate user input and get abs for negative numbers
static int[] getInputValidator(String str){
        String[] numbersStr = str.split(",");
    int[] numbersArray = new int[numbersStr.length];
    for(int i = 0;i < numbersStr.length;i++)
    {
        try {

            numbersArray[i] = Integer.parseInt(numbersStr[i]);
            if(numbersArray[i]<0){
               numbersArray[i]= Math.abs(numbersArray[i]);
            }
        }catch (NumberFormatException ex){
            System.out.println("Invalid input:"+ex);
        }
    }
        return numbersArray;
}
//BubbleSort method for valid user input
    static void getBubbleSort(int[] arr, int n)
    {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

}