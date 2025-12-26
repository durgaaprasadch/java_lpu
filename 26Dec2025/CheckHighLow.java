import java.util.Scanner;



class CheckHighLow{

static Scanner sc = new Scanner(System.in);

static int checkHigh(int arr[]){

int n = arr.length;

int max = arr[0];
for(int i=0;i<n;i++){

if(max<arr[i])
max=arr[i];
}
return max;

}

static int checkLow(int arr[]){

int n = arr.length;
int min= arr[0];

for(int i = 0;i<n;i++){

if(arr[i]<min)
min = arr[i];
}
return min;

}

public static void main(String[]args){


System.out.print("Enter the size of Array: ");
int n = sc.nextInt();
int arr[] = new int[n];

for(int i=0;i<n;i++){

System.out.print("Enter " +(i+1) + " element(s): ");
arr[i] = sc.nextInt();

}

System.out.println("Highest= "+checkHigh(arr) );
System.out.println("Lowest= "+checkLow(arr) );



}

}