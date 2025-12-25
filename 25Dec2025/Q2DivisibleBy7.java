import java.util.Scanner;


class CheckBy7{

static void Div7(int num) {

if((num%7 == 0) )

System.out.print(num+" is Divisible by 7.");
else
System.out.print(num+" is not Divisible by 7.");

}
}

class Q2DivisibleBy7{
public static void main(String[]args){


System.out.print("Enter num: ");

Scanner sc = new Scanner(System.in);

int num = sc.nextInt();
CheckBy7 obj = new CheckBy7();


if(num == 0)

System.out.print( "0/anything = 0");
else

obj.Div7(num);


}

}