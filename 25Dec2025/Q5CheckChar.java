import java.util.Scanner;

class Q5CheckChar {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a character: ");
        char ch = sc.next().charAt(0);

        if (ch >= '0' && ch <= '9') {
            System.out.println("Digit");
        } else {
            System.out.println("Not a digit");
        }
    }
}
