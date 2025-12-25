import java.util.Scanner;

 class CheckSmallest{
	void check(int a,int b,int c){
	System.out.println( "Smallest among " +a+","+b+","+c+"  is "+(a<b && a<c?a:(b<c)?b:c));	
									}	
}
class FindSmallest{


			static Scanner sc = new Scanner(System.in);
			public static void main(String[]args){

			System.out.print("Enter number1:  ");
			int a = sc.nextInt();

			System.out.print("Enter number2:  ");
			int b= sc.nextInt();

			System.out.print("Enter number3:  ");
			int c = sc.nextInt();

			CheckSmallest obj = new CheckSmallest();

				obj.check(a,b,c);

/*for(int i=1;i<=input;i++ ){

System.out.println("Enter Number: "+i);
int nums = sc.nextInt();

}*/

}


}