package cs251.lab2;
public interface GomokuInterface {
    int DEFAULT_NUM_COLS = 30;
    int DEFAULT_NUM_ROWS = 30;
    int SQUARES_IN_LINE_FOR_WIN = 5;

    int getNumCols();

    int getNumRows();

    int getNumInLineForWin();

    GomokuInterface.TurnResult handleClickAt(int var1, int var2);

    void initializeGame();

    String getCurrentBoardAsString();

    GomokuInterface.Square getCurrentTurn();

    void setOpponentType(String var1);

    public static enum Square {
        CROSS('X'),
        RING('O'),
        EMPTY('-');

        private final char symbol;

        private Square(char var3) {
            this.symbol = var3;
        }

        public char toChar() {
            return this.symbol;
        }
    }

    public static enum TurnResult {
        CROSS_WINS,
        RING_WINS,
        DRAW,
        GAME_NOT_OVER;

        private TurnResult() {
        }
    }
}
