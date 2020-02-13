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
        
        int x, y;

        while (true) {
            System.out.println(ocean);
            x = readCoordinate("X");
            y = readCoordinate("Y");
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

    public static int readCoordinate(String symbol) {
        
        Scanner sc = new Scanner(System.in);
        Integer coor = null;

        while (coor == null)
            try { 
                System.out.println("Provide " + symbol);
                coor = sc.nextInt();
            } catch (InputMismatchException e) {
                e.printStackTrace();
                sc.nextLine();
            }
        return coor;
        }

}