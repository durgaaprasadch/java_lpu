//check given character inputs vowels or consonents



import java.util.Scanner;


class Q4checkVowelConsonent{
public static void main(String[]args){

Scanner sc = new Scanner(System.in);

System.out.println("Enter character: ");
char input = sc.next().charAt(0);


if((input =='a'||input =='e'||input =='i'||input =='o'||input =='u'|| input=='A'||input =='E'||input =='I'||input =='O'||input =='U'))

System.out.println(input+ " is Vowel.");


else System.out.println(input + " is Consonent");


}
}