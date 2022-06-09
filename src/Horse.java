public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            //Лошадь способна перепрыгивать через фигуры, поэтому проверки ячеек между начальной и конечной позицией нет
            return (toLine == line + 2 && (toColumn == column - 1 || toColumn == column + 1)) ||
                    (toLine == line - 2 && (toColumn == column - 1 || toColumn == column + 1)) ||
                    (toColumn == column - 2 && (toLine == line - 1 || toLine == line + 1)) ||
                    (toColumn == column + 2 && (toLine == line - 1 || toLine == line + 1));
        }

        return false;
    }
    public String getSymbol() {
        return "H";
    }
}
