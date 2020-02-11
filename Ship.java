import java.util.List;

class Ship {
    private List<Square> squares;

    public Ship(List<Square> squares) {
        this.squares = squares;
    }

    public boolean contains(Square square) {
        return squares.contains(square);
    }
}