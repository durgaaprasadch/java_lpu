import java.util.Scanner;

class daysFinder{

static Scanner sc = new Scanner(System.in);

public static void main(String[] args){



System.out.println("Enter Month: ");

int month = sc.nextInt();

if(month>=1 && month <=12){

switch(month){
case 2:
 System.out.println("contains 28/29 Days");
break;

case 4:case 6: case 9: case 11:System.out.println(month + " contains 30 Days");break;

default :
System.out.println( " contains 31 Days");



}
}
else System.out.println(month + " is invalid Input");
}
}