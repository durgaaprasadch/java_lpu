//college management System 

//if no uniform = blocked for 1day


import java.util.Scanner;

class CollegeManagementSystem{

public static void main(String[]args){

Scanner sc = new Scanner(System.in);

System.out.println(" Hello! Welcome To LPU College Management System");
System.out.println(" Here, You Can Find Rules And Regulations and their Effects And Measures");

System.out.println(" Classified Into Parts: \n 1.Entry & Exit Rules.\n 2.Attendance Rules.\n 3.Dress Code Rules.\n 4.Mobile Phone Rules.\n 5.Behavior & Discipline Rules.\n ");


System.out.println("Enter the value(1-5) To know them.");


int input = sc.nextInt();

if(input>=1 && input<=5){

	if(input == 1){
	System.out.println("***Entry & Exit Rules***\n");
	System.out.println(" 1.Came late to the college campus.\n 2.Left the campus during college hours without permission.\n 3.Went outside the university and tried to re-enter the same day.\n 4.Entered the campus without carrying a college ID card.\n");

	System.out.println("Enter the value(1-4) to Know the Consequence: ");
	int digit = sc.nextInt();
	if(digit == 1){
	System.out.println("You will enjoy a full day of self-reflection at home.");
	}
	else if(digit == 2){
	System.out.println("Your Attendance will disappear for the day without negotiation.");
	}
	else if(digit == 3){
	System.out.println("Your re-entry will become a tomorrow problem.");
	}
	else if(digit == 4){
	System.out.println("The system will behave as if the student does not exist.");
	}

	else System.out.println("Invalid Input.");

	}
	
	if(input == 2){
	System.out.println("***Attendance Rules***\n");
System.out.println(" 1.Remained absent from classes without a valid reason.\n 2.Came late to classes after the lecture has started.\n 3.Did not maintain the minimum attendance percentage.\n");

	System.out.println("Enter the value(1-3) to Know the Consequence: ");
	int digit = sc.nextInt();
 	if(digit == 1){
	System.out.println("The attendance register will not feel bad at all.");
	}
	else if(digit == 2){
	System.out.println("The door will become the strictest teacher.");
	}

	else if(digit == 3){
	System.out.println("Exam permission will go into under-review mode.");
	}
	
	else System.out.println("Invalid Input. ");

	}

	if(input == 3){
	System.out.println("***Dress Code Rules***\n");
	System.out.println(" 1.Wore dress that was not according to the college dress code.\n 2.Came to college in improper or casual clothing.\n 3.Ignored the prescribed uniform or appearance rules.\n");

	System.out.println("Enter the value(1-3) to Know the Consequence: ");
        int digit = sc.nextInt();
 	if(digit == 1){
	System.out.println("Fashion will be stopped at the gate.");
	}
	else if(digit == 2){
	System.out.println("A free return trip home will be approved.");
	}

	else if(digit == 3){
	System.out.println("The student will become an example without volunteering.");
	}

	else System.out.println("Invalid Input. ");




         }

	
	if(input == 4){

	System.out.println("***Mobile Phone Rules***\n");
	System.out.println(" 1.Used a mobile phone during class hours.\n 2.Attended calls or used social media inside the classroom.\n 3.Kept the mobile phone switched on during lectures.\n");

	System.out.println("Enter the value(1-3) to Know the Consequence: ");
	int digit = sc.nextInt();
 	if(digit == 1){
	System.out.println("The phone will be taken away for quality separation time.");}
	else if(digit ==2){
	System.out.println("The lecture will suddenly become very personal.");
	}
	else if(digit == 3){
	System.out.println("The ringtone will announce the mistake to everyone.");

	}
else System.out.println("Invalid Input. ");



 	}
	if(input == 5){
	System.out.println("***Behavior & Discipline Rules***\n");
	System.out.println(" 1.Behaved improperly with faculty or staff.\n 2.Created disturbance in the classroom.\n 3.Damaged or misused college property.\n");

	System.out.println("Enter the value(1-3) to Know the Consequence : ");
	int digit = sc.nextInt();
 	if(digit == 1){
	System.out.println("Confidence will be reduced immediately.");}
	else if(digit ==2){
	System.out.println("The lecture will suddenly become very personal.");
	}

	else if(digit ==3){
	System.out.println("The wallet will learn discipline faster than the student.");
	}

else System.out.println("Invalid Input. ");



	}
	
	
}

else
System.out.println("Invalid Input. ");


}

}