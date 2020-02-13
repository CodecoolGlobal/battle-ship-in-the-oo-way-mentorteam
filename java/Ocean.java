import java.util.ArrayList;
import java.util.List;
import java.lang.IllegalArgumentException;

public class Ocean{

    final static int WIDTH = 10;
    final static int HEIGHT = 10;
    private List<ArrayList<Square>> board;
    private List<Ship> ships;

    public Ocean(){
        board = new ArrayList<ArrayList<Square>>();
        ships = new ArrayList<>();

        ArrayList<Square> row;
        for (int i = 0; i < HEIGHT; i++){
            row = new ArrayList<>();
            for (int j = 0; j < WIDTH; j++){
                row.add(new Square());
            }
            board.add(row);
        }
    }

    public boolean addShip(int shipLength, int x, int y) throws IllegalArgumentException { 
        if (x < 0 || x >= WIDTH)
            throw new IllegalArgumentException("x coordinate should be in range 0..9");
        if (y < 0 || y >= HEIGHT)
            throw new IllegalArgumentException("y coordinate should be in range 0..9");
        if (shipLength < 1 || shipLength > 4)
            throw new IllegalArgumentException();
        
        List<Square> squares = new ArrayList<Square>();
        for (int i = 0 ; i < shipLength ; i++)
            squares.add(board.get(y).get(x + i));
        
        ships.add(new Ship(squares));
        System.out.println(ships);
        return true;
    }

    public boolean shoot(int x, int y) throws IllegalArgumentException {
        if (x < 0 || x >= WIDTH)
            throw new IllegalArgumentException("x coordinate should be in range 0..9");
        if (y < 0 || y >= HEIGHT)
            throw new IllegalArgumentException("y coordinate should be in range 0..9");

        Square square = board.get(x).get(y);
        
        square.shoot();

        for (Ship ship : ships) {

            if (ship.contains(square)) {
                square.setSymbol("X");
                return true;
            }
        }
        square.setSymbol("O");
        return false;

    }
    
    public String toString(){

        String str = " 12345678910\n";
        char alpha = 97;
        for (ArrayList<Square> row : board) {
            str = str + alpha;
            for (Square square : row) {
                str = str + square.toString();
            }
            str  = str + "\n";
            alpha++;
        }
        return str;
    }
}