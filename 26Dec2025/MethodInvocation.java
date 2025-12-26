import java.util.Scanner;



class MethodInvocation{

public static void main(String[]args){

System.out.println("Main Method Start.");
test();

System.out.println(integer(9));

System.out.println("Main Method End.");
}


static void test() {
System.out.println(" Test Method Start.");
integer(9);
System.out.println("Test Method End.");


}
static int integer(int a){
System.out.println(" integer Method Start.");
System.out.println(" integer Method End.");
return a;
}
}