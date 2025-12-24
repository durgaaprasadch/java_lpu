import java.util.Scanner;


class sumOfNumbers{
static Scanner sc = new Scanner(System.in);

static void totalSum(int num){

int sum = 0;
for(int i=1;i<num;i++){

sum=sum+i;

}
System.out.println( sum);
};

public static void main(String[]args){

int num = sc.nextInt();
totalSum(num);
}

}