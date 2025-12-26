import java.util.Scanner;


class LowestTransaction{
public static void main(String[]args){

Scanner sc = new Scanner(System.in);

System.out.print("Enter the Size: ");

int n = sc.nextInt();
int arr[] = new int[n];

for(int i= 0;i<n;i++){

System.out.print("Enter "+(i+1)+"st  element: ");
arr[i] = sc.nextInt();
}
for(int i=0;i<n;i++){

System.out.println(arr[i]+" ");

}

int min = arr[0];
for(int i=0;i<n;i++){

if(arr[i]<min)

min=arr[i];
}
System.out.print("Lowest Element: "+min);
}
}