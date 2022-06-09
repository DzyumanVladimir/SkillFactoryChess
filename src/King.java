public class King extends ChessPiece{

    public King(String color){
        super(color);
    }

    public String getColor() {
        return color;
    }

    public String getSymbol() {
        return "K";
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            return (toLine == line + 1 && toColumn == column ||
                    toLine == line - 1 && toColumn == column ||
                    toColumn == column + 1 && toLine == line ||
                    toColumn == column - 1 && toLine == line ||
                    toLine == line + 1 && toColumn == column + 1 ||
                    toLine == line + 1 && toColumn == column - 1 ||
                    toLine == line - 1 && toColumn == column + 1 ||
                    toLine == line - 1 && toColumn == column - 1);
        } else
            return false;
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column){
            for(int i = 0; i <= 7; i++){
                for(int j = 0; j <= 7; j++){
                    if(board.board[i][j] != null &&
                            !getColor().equals(board.board[i][j].getColor()) &&
                            board.board[i][j].canMoveToPosition(board, i, j, line, column)) {
                        return true;
                    }
                }
            }
            return false;
    }
}
