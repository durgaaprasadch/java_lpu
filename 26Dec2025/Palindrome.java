import java.util.Scanner;


class Palindrome{


static boolean Check(int num){

 boolean res=false;

int temp = num;
while(num!=0){
int rev =0;

rev = rev*10 + num%10;
num/=10;
}
return rev==temp?true:false;





}


public static void main(String[]args){

Scanner sc = new Scanner(System.in);

System.out.println("Enter num: ");
int num = sc.nextInt();

Check(num);




}

}