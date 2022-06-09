public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            if (toLine == line || toColumn == column)
                return false;
            else if (Math.abs(toLine - line) == Math.abs(toColumn - column)) {
                //Если ходит по диагонали вниз и вправо
                if (toColumn > column && toLine > line) {
                    for (int i = 1; i + column < toColumn; i++) {
                        if (chessBoard.board[line + i][column + i] != null) {
                            return false;
                        }
                    }
                    return true;
                }
                //Если ходит по диагонали вверх и влево
                else if (toColumn < column && toLine < line) {
                    for (int i = 1; column - i > toColumn; i++) {
                        if (chessBoard.board[line - i][column - i] != null) {
                            return false;
                        }
                    }
                    return true;
                }
                //Если ходит по диагонали вниз и влево
                else if (toLine > line && toColumn < column) {
                    for (int i = 1; line + i < toLine; i++) {
                        if (chessBoard.board[line + i][column - i] != null) {
                            return false;
                        }
                    }
                    return true;
                }
                //Если ходит по диагонали вверх и вправо
                else {
                    for (int i = 1; line - i > toLine; i++) {
                        if (chessBoard.board[line - i][column + i] != null) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public String getSymbol() {
        return "B";
    }

}
