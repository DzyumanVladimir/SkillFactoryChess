public class Rook extends ChessPiece {

    public Rook(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    public String getSymbol() {
        return "R";
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            if ((toLine != line && toColumn == column) || (toLine == line && toColumn != column)) {
                int endLine = toLine == line ? toColumn : toLine; //Направление, в котором должна двигаться фигура, горизонталь/вертикаль
                int startLine = toLine == line ? column : line;
                for (int i = 1; i < 8; i++) {
                    startLine = endLine > startLine? startLine + 1:startLine - 1;
                    if(startLine == endLine){
                        break;
                    }
                    if (toLine != line && chessBoard.board[startLine][column] != null) {
                        return false;
                    } else if (toColumn != column && chessBoard.board[line][startLine] != null) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}

