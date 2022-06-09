public class Queen extends ChessPiece {

    public Queen(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    public String getSymbol() {
        return "Q";
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            if (Math.abs(toLine - line) == Math.abs(toColumn - column) && toLine != line && toColumn != column) {
                //Если ходит по диагонали, как слон
                return new Bishop(getColor()).canMoveToPosition(chessBoard, line, column, toLine, toColumn);
            } else {
                //Если ходит по прямой, как ладья
                return new Rook(getColor()).canMoveToPosition(chessBoard, line, column, toLine, toColumn);
            }
        } else
            return false;
    }
}
