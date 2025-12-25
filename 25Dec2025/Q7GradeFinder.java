//



import java.util.Scanner;

class Q7GradeFinder{



public static void main(String[]args)

{
Scanner sc = new Scanner(System.in);

System.out.print("Enter Your Marks: ");

int marks = sc.nextInt();
String res;


if(marks >= 50){


		if(marks>90 && marks <=100){
		res ="O Grade";
		}
		else if(marks>75 && marks <=90){
		res ="First Class";
		}
		else if(marks>60 && marks <=75){	
		res ="Second Class";
		}
		else if(marks>=50 && marks <=60){
		res ="Just Pass";
		}
	}
else {
res ="Fail";

System.out.println(res);

int input = sc.nextInt();

System.out.print("Enter no of Subjects You Got less than 50: ");

res ="You Got "+ input + " Backlog(s).";

}



System.out.println(res);










}


}