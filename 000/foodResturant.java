//lpu restaurant


import java.util.Scanner;

class foodResturant{
public static void main(String[]args){

Scanner sc = new Scanner(System.in);


System.out.println("Hey..Welcome.");



System.out.println("Choose Here.V For Veg Menu and N For Non-Veg Menu");
char input = sc.next().charAt(0);
int total=0;

if(input=='V'){

System.out.println(" 1.Veg Biryani -- $100\n 2.Fried Rice -- $70\n 3.Paneer Biryani -- $150\n 4.Veg Thali -- $150\n");

int opt = sc.nextInt();
System.out.println("And Quantities");
int quan = sc.nextInt();


if(opt==1){ 
total = 100*quan;
}
if(opt==2){ 
total = 70*quan;
}
if(opt==3){ 
total = 150*quan;
}if(opt==4){ 
total = 150*quan;
}

System.out.println(" Total Bill for your order: "+total);

}

if(input=='N')
{

System.out.println(" 1.Chicken Biryani -- $150\n 2.Egg Fried Rice -- $120\n 3.Mutton Biryani -- $250\n 4.Non-Veg Thali -- $250\n");

int opt = sc.nextInt();
System.out.println("And Quantities");
int quan = sc.nextInt();


if(opt==1){ 
total = 150*quan;
}
if(opt==2){ 
total = 120*quan;
}
if(opt==3){ 
total = 250*quan;
}if(opt==4){ 
total = 250*quan;
}

System.out.println(" Total Bill for your order: "+total);




}

//stem.out.println("Invalid Input "+" "+ "Enter V " +" "+ "OR"+" N ONLY");



}


}