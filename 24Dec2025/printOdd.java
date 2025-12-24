//write a program to print odd num 1-20



import java.util.Scanner;

class printOdd{

public static void main(String[]args){

Scanner sc = new Scanner(System.in);
int input = sc.nextInt();
int count=0;
int i =1;

while(i<=input){

if(i%2!=0){
System.out.println(i);
count++;
}
i++;

}



}

}