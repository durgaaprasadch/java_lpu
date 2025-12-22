//program to check if whether alphabet or not then whether it is capital or small



import java.util.Scanner;


class alphabetOrNot{
public static void main(String[]args){

Scanner sc = new Scanner(System.in);


System.out.print("Enter character: ");
char input = sc.next().charAt(0);


if((input>='A' && input<='Z') || (input >='a' && input <='z' )){

if(input>='A' && input<='Z'){

System.out.println("Upper Case");
}

else
System.out.println("Lower Case");






}
else System.out.println("Not an alphabet");




}
}