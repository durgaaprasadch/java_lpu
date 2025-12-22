//check given num is even or odd



import java.util.Scanner;


class checkEvenOdd{

public static void main(String[]args){


Scanner sc = new Scanner(System.in);

System.out.println("enter num");
int num= sc.nextInt();

String result= (num%2==0?"even":"odd");
System.out.println(result);











}







}