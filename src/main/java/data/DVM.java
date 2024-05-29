package data;

public class DVM {

    public DVM(int x, int y) {
        this.coordX = x;
        this.coordY = y;
    }

    private final int coordX;

    private final int coordY;

    public int getX() {
        return coordX;
    }

    public int getY() {
        return coordY;
    }

}