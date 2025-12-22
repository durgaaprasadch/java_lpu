//calculator 


import java.util.Scanner;


class basicCaclculator{

public static void main(String[]args)
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter num1: ");
double num1 = sc.nextDouble();

System.out.print("Enter num2: ");
double num2 = sc.nextDouble();
 double result=0;

System.out.println("Enter operation to do\n 1.For Addition\n 2.For Subtraction\n 3.For Multiplication\n 4.For Division");

int operation = sc.nextInt();

if(operation == 1){
result = num1 + num2;
}
else if(operation ==2){
result = num1-num2;
}
else if(operation ==3){
result = num1*num2;
}
else if(operation ==4){
result = num1/num2;
}


System.out.println("Answer is "+result);
}

}