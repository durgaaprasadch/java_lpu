import java.util.Scanner;



class EvenOdd{

static void check(int num){

if(num%2==0)
System.out.print(num +" is Even.");
else
System.out.print(num +" is Odd.");

}

}

class Q1EvenOdd{

public static void main(String []args){

Scanner sc = new Scanner(System.in);



System.out.print("Enter num: ");
int num = sc.nextInt();

EvenOdd obj = new EvenOdd();

obj.check(num);


}
}