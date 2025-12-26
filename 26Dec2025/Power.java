import java.util.Scanner;

class Power{

static int Check(int num,int pow){

int res = 1;
for(int i =1;i<=pow;i++){
 
res = res*num;
}

return res;
}

public static void main(String[]args){

Scanner sc = new Scanner(System.in);

System.out.print("Enter num: ");
int num = sc.nextInt();
System.out.print("Enter the power: ");
int pow = sc.nextInt();



System.out.println(Check(num,pow));

}

}