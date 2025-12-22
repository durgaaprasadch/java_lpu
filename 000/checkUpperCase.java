//program to check whether the first character was uppercase or not


import java.util.Scanner;


class checkUpperCase {

public static void main(String[]args){

Scanner sc = new Scanner(System.in);


System.out.println("enter char: ");
char ch = sc.next().charAt(0);


System.out.println((ch>='A' && ch<= 'Z')?"yes Upper Case":


(ch>='a' && ch<= 'z')?"lower Case":
(ch>='0' && ch<='9')? "its a number" : "Special Char");



}






}