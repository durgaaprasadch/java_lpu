//1.pin validation whether it matches to user pin or not
//2.amount must be multiples of 100
//3.amount<=available balance
//4.message 


import java.util.Scanner;

class atmMachine{
public static void main(String[]args){

Scanner sc = new Scanner(System.in);

int availableBalance = 5000;
int pin = 1234;


System.out.println("Enter Your Pin: ");
int pinUser = sc.nextInt();

if (pin == pinUser){

System.out.println("Successfully Logged In.Your Available Balance: "+ availableBalance);
 System.out.print("Enter Amount to Withdraw: ");


int withdrawAmount = sc.nextInt();

System.out.println( availableBalance - withdrawAmount );






}
else System.out.println("Wrong Pin");












}
}