public class Square{

    private boolean isHit;
    private String symbol;

    public Square(){
        this.isHit = false;
        this.symbol = "*";
    }

    public void shoot() {
        this.isHit = true;
    }

    public boolean isHit() {
        return isHit;

    }

    public void setSymbol (String symbol) {
        this.symbol = symbol;
    }

    public String toString() {
        return symbol;
    }
}