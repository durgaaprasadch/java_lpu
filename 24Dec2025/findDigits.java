//write a program to count the no of digits 


import java.util.Scanner;


class findDigits{

public static void main(String[]args){


Scanner sc = new Scanner(System.in);
int count=0;

System.out.println("Enter Number: ");
long input = sc.nextLong();

while(input>0)
{
input/=10;  
count++;
//System.out.println("Your Number contains "+count+" Digits"); //prints count n time 
}
System.out.println("Your Number contains "+count+" Digits"); //must print outside loop


}

}