import java.util.Scanner;


class ArrayAverage{
public static void main(String []args){

Scanner sc = new Scanner(System.in);

int n = sc.nextInt();
int arr[] = new int[n];

System.out.println("Enter elements: ");

double avg =0;
for(int i=0;i<n;i++){

arr[i] = sc.nextInt();

avg = avg+arr[i];
}
avg=avg/n;


System.out.println("average = "+avg);
}
}