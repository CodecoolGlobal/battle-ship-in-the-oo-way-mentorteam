import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        
        Ocean ocean = new Ocean();
        ocean.addShip(3, 0, 2);
        ocean.addShip(4, 5, 8);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(ocean);
            System.out.println("Provide x coordinate");
            int x = sc.nextInt();
            System.out.println("Provide y coordinate");
            int y = sc.nextInt();
            if (ocean.shoot(x, y))
                System.out.println("TRAFIONY!");
            else
                System.out.println("PUDŁO!");;
        }
    }
}