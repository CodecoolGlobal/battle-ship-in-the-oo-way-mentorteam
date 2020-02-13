import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        
        Ocean ocean = new Ocean();
        try {
            ocean.addShip(3, 0, 2);
            ocean.addShip(4, 5, 8);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(ocean);

            try { 
                System.out.println("Provide x coordinate");
                int x = sc.nextInt();
                System.out.println("Provide y coordinate");
                int y = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(e);
            }
            

            try {
                if (ocean.shoot(x, y))
                    System.out.println("TRAFIONY!");
                else
                    System.out.println("PUDŁO!");
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }
}