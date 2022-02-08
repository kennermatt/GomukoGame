//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package cs251.lab2;

public enum GomokuInterface$Square {
    CROSS('X'),
    RING('O'),
    EMPTY('-');

    private final char symbol;

    private GomokuInterface$Square(char var3) {
        this.symbol = var3;
    }

    public char toChar() {
        return this.symbol;
    }
}
