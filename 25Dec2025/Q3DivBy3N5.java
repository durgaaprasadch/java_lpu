import java.util.Scanner;


class CheckDiv{

static void DivBy3N5(int num){

if((num%3 == 0) && (num%5 == 0))

System.out.print(num+" is Divisible by Both 3 And 5.");
else 

System.out.print(num+" is not Divisible by Both 3 And 5.");

}
}

class Q3DivBy3N5{


public static void main(String[]args){

Scanner sc = new Scanner(System.in);
System.out.print("Enter number: ");

int num = sc.nextInt();

CheckDiv obj = new CheckDiv();
if(num == 0)

System.out.print( "0/anything = 0");
else
obj.DivBy3N5(num);

}
}