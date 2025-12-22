import java.util.Scanner;



class checkMaxValue{

      public static void main(String[]args)
{


Scanner sc = new Scanner(System.in);

System.out.print("Enter Num1: ");
int num1 = sc.nextInt();

System.out.print("Enter Num2: ");
int num2= sc.nextInt();

System.out.print("Enter Num3: ");
int num3 = sc.nextInt(); 



System.out.println((num1>num2 && num1>num3)? num1: (num2 > num3)? num2:num3);








}



}