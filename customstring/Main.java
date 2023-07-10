package customstring;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("\nUsing for-loop and user values:");
int x, y;
char hChar1, vChar1;
int ht1, wd1;
char answer = 'y';
Scanner input1 = new Scanner(System.in);
while (answer == 'y') {
System.out.print("\nPlease enter height of a box: ");
ht1 = input1.nextInt();
System.out.print("\nPlease enter width of a box:");
wd1 = input1.nextInt();
input1.nextLine(); //clean the buffer
System.out.print("\nPlease enter the horizontal charcters to draw box: ");
hChar1 = input1.nextLine().charAt(0);
System.out.print("\nPlease enter the vertical charcters to draw box: ");
vChar1 = input1.nextLine().charAt(0);
for (x=1; x<= wd1;x++)
{
System.out.print("" + hChar1);
}
System.out.print("\n");
for(x=1;x<= ht1-2;x++)
{
System.out.print(""+ vChar1);
for (y=1;y <= wd1-2;y++)
System.out.print(" ");
System.out.print("" + vChar1 + "\n");
}
for(x=1;x<= wd1;x++)
{
System.out.print(hChar1);
}
System.out.print("\n\n");
System.out.print("Continue? Type 'y' for yes:");
answer = input1.nextLine().charAt(0);
}
System.out.println("\n\nThank you for using my drawbox program");

      
    }
}
