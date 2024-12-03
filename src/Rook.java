public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {


        if (toLine >= 0 && toLine < 8 && toColumn >= 0 && toColumn < 8)
        {

            if (
                    (((toLine != line) && (toColumn == column )) // move not in the same cell (vertically)
                            &&isClearLine(chessBoard,line,column,toLine,toColumn)) // check clearLine and attack
                            || (((toLine == line) && (toColumn != column )) // move mot in the same cell
                            &&isClearColumn(chessBoard,line,column,toLine,toColumn)) // check clearLine and attack
            )
            {
                return true;
            }
            else {
                return false;
            }
        } else {
            return false;
        }

    }
    boolean isClearLine(ChessBoard chessBoard,int line, int column, int toLine, int toColumn){ // check the line
        int n=0;
        boolean isClear = true;
        for (int i = 1; i <= Math.abs(toLine-line); i++){ // check another figures on the way
            if (toLine > line){
                n = line + i;
            } else {
                n = line - i;
            }
            if (chessBoard.board[n][column] == null)
            {
                isClear = true;
            }
            else
            {
                if (n == toLine && chessBoard.board[toLine][toColumn].getColor()!=chessBoard.board[line][column].getColor())
                {
                    isClear = true;
                } else {
                    isClear = false;
                    return isClear;
                } // check enemy on the cell
            }

        }
        return isClear;
    }

    boolean isClearColumn(ChessBoard chessBoard,int line, int column, int toLine, int toColumn){ // check the column
        int n = 0;
        boolean isClear = true;
        for (int i = 1; i <= Math.abs(toColumn-column); i++){ // check another figures on the way
            if (toColumn > column) {
                n = column + i;
            } else {
                n = column - i;
            }
            if (chessBoard.board[line][n] == null)
            {
                isClear = true;
            }
            else {
                if (n == toColumn && chessBoard.board[toLine][toColumn].getColor()!=chessBoard.board[line][column].getColor())
                {
                    isClear = true;
                } else {
                    isClear = false;
                    return isClear;
                } // check enemy n the cell
            }

        }
        return isClear;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
