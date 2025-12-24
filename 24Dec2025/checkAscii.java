//print ASCII values for the chars


import java.util.Scanner;

class checkAscii {

public static void main(String[]args){

System.out.println("Enter char: ");


Scanner sc = new Scanner(System.in);
char input = sc.next().charAt(0);
int i = 0;
while(input >=0 && input <='z'){

   i = input;
   break;

}
System.out.println(i);

}


}