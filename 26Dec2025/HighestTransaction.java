import java.util.Scanner;

class HighestTransaction{

static Scanner sc = new Scanner(System.in);
static void checkHigh(int arr[]){

int n = arr.length;
int max=arr[0];
for(int i=0;i<n;i++){

if(arr[i]>max){
max=arr[i];
}
}
System.out.println("The max element is: "+max);
}


public static void main(String[]args){

System.out.println("Enter Size: ");
int n = sc.nextInt();
int arr[] = new int[n];

for(int i=0;i<n;i++){
System.out.println("Enter "+(i+1)+"st"+" element.");
arr[i]=sc.nextInt();
}

checkHigh(arr);
}


}