package cs251.lab2;

public class Gomoku implements GomokuInterface{
    public static void main(String[] args) {
        Gomoku game = new Gomoku();
        if(args.length > 0){
            game.setOpponentType(args[0]);
        }
        GomokuGUI.showGUI(game);
    }
    @Override
    public int getNumCols() {
        return 0;
    }

    @Override
    public int getNumRows() {
        return 0;
    }

    @Override
    public int getNumInLineForWin() {
        return 0;
    }

    @Override
    public TurnResult handleClickAt(int var1, int var2) {
        return null;
    }

    @Override
    public void initializeGame() {

    }

    @Override
    public String getCurrentBoardAsString() {
        return null;
    }

    @Override
    public Square getCurrentTurn() {
        return null;
    }

    @Override
    public void setOpponentType(String var1) {

    }
}
