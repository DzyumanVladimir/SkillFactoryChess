import java.util.Scanner;

public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            if (chessBoard.board[line][column].getColor().equals("White")) {
                if (chessBoard.board[line][column].check) { //Первый ход белой пешки допускает перемещение на 2 клетки
                    return toColumn == column && ((toLine == line + 2 && chessBoard.board[line + 1][column] == null)
                            || toLine == line + 1);
                } else
                    return toColumn == column && toLine == line + 1;
            } else if (chessBoard.board[line][column].getColor().equals("Black")) {
                if (chessBoard.board[line][column].check) { //Первый ход черной пешки допускает перемещение на 2 клетки
                    return toColumn == column && ((toLine == line - 2 && chessBoard.board[line - 1][column] == null)
                            || toLine == line - 1);
                } else
                    return toColumn == column && toLine == line - 1;
            }
        }
        return false;
    }

    public String getSymbol() {
        return "P";
    }

    //Превращение пешки
    public ChessPiece changePawn(ChessBoard chessBoard, int line, int column) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Change pawn, enter for change:\n" +
                "R - Rook\n" +
                "Q - Queen\n" +
                "H - Horse\n" +
                "B - Bishop");
        String answer = scanner.nextLine();
        switch (answer) {
            case "R":
                chessBoard.board[line][column] = new Rook(chessBoard.nowPlayer);
                System.out.println("Change pawn to rook");
                break;
            case "Q":
                chessBoard.board[line][column] = new Queen(chessBoard.nowPlayer);
                System.out.println("Change pawn to queen");
                break;
            case "H":
                chessBoard.board[line][column] = new Horse(chessBoard.nowPlayer);
                System.out.println("Change pawn to horse");
                break;
            case "B":
                chessBoard.board[line][column] = new Bishop(chessBoard.nowPlayer);
                System.out.println("Change pawn to bishop");
                break;
            default:
                System.out.println("invalid input value");
                changePawn(chessBoard, line, column);
                break;
        }
        return chessBoard.board[line][column];
    }
}



