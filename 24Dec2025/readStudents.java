//give details of n students


import java.util.Scanner;

class readStudents{
public static void main(String[]args){

Scanner sc = new Scanner(System.in);
int count=1;

System.out.println("Enter How many students you entering: ");

int num = sc.nextInt();
String name;
int id,marks;

do{
sc.nextLine();
System.out.println("Enter Name: ");
 name = sc.nextLine();

System.out.println("Enter ID: ");
id = sc.nextInt();

System.out.println("Enter Marks: ");
marks = sc.nextInt();

System.out.println( "Student name: "+ name + "ID: "+id + "Marks: "+ marks );
count++;

}

while(count <= num);



}

}