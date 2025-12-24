import java.util.Scanner;

class checkVowelCons{

static Scanner sc = new Scanner(System.in);

public static void main(String[]args){

System.out.println("Enter char: ");

char input = sc.next().charAt(0);
if((input>='a')&&(input <='z') ||(input>='A') && (input <='Z') ){

switch(input)
{
case 'a': case 'e' : case 'i' : case 'o': case 'u':
case 'A': case 'E' : case 'I' : case 'O': case 'U':{

System.out.println(" "+ input+" is Vowel.");
break;
}

default:
if((input>='a')&&(input <='z') ||(input>='A') && (input <='Z') ){
System.out.println(" "+input+" is Consonent.");
//break;
}
else if(input>='0' && input<='9')
System.out.println(" "+input+" is Invalid Input.");
}}

else 
System.out.println(" "+input+" is not an alphabet.");


}
}