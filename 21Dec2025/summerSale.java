// add multiple products if cart crosses 10000 give discount 20% and give final price after discount.

import java.util.Scanner;
class summerSale{

public static void main(String[]args){

Scanner sc = new Scanner(System.in);


System.out.println("Enter Product1 name: ");
String prodName = sc.nextLine();
System.out.println("Enter Product1 PRICE: ");
int prod1Cost = sc.nextInt();


sc.nextLine();
System.out.println("Enter Product2 name: ");
String prod2 = sc.nextLine();
System.out.println("Enter Product2 PRICE: ");
int prod2Cost = sc.nextInt();


sc.nextLine();
System.out.println("Enter product3 name: ");
String prod3 = sc.nextLine();
System.out.println("Enter Product3 PRICE: ");
int prod3Cost = sc.nextInt();




int total ;
double finalPrice;
double discountPrice;

total = prod1Cost+prod2Cost+prod3Cost;

if(total>=10000){

discountPrice = total * 0.2;
finalPrice = total-discountPrice;
System.out.println("Hurray You're Eligible For Discount.The Final Price: " + finalPrice);


}




}
}