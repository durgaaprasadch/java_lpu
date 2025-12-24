//right a program to find a ind num is valid or not starts with 6,7,8,9



import java.util.Scanner;

class validNumber{
public static void main(String[]args){

Scanner sc = new Scanner(System.in);

System.out.print("Enter A valid number: ");
long num = sc.nextLong();
int count = 0;
//int quo=0;
int ld =0;

while(num!=0){
        ld = (int)num%10;
	num/=10;  
	count++;
	

//System.out.println(count);				

if(count==10){

//System.out.println(num);
if(ld >=6 && ld <=9){
System.out.println("valid");
}

else
System.out.println("Invalid number.");
}
}

//while(num>0)

}
}


