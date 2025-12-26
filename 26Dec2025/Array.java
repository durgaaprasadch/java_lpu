import java.util.Scanner;



class Array{


static Scanner sc = new Scanner(System.in);
static void arrVal(int arr[]){

int n=arr.length;
for(int i=0;i<n;i++){
 arr[i] = sc.nextInt();

}
}


public static void main(String[]args){


System.out.println("Enter size: ");
int n = sc.nextInt();
int arr[] = new int[n];

arrVal(arr);





/*
for(int i=n-1;i>=0;i--){

System.out.println(arr[i]);
}
*/





}
}