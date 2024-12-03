public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine!=line && toColumn!=column)  //move not to the same cell
        {
            if (toLine >= 0 && toLine < 8 && toColumn >= 0 && toColumn < 8) {
                if ((((toLine -line) == (toColumn -column )) // move to the diagonal UP
                        ||
                        ((toLine -line) == -1*(toColumn -column )))// move to the diagonal DOWN
                        &&isClearDiagonal(chessBoard,line,column,toLine,toColumn) // clear way or attack
                )
                {
                    return true;}
                else {
                    return false;}

            }else {
                return false;}
        }
        else {
            return false;}

    }

    private boolean isClearDiagonal(ChessBoard chessBoard,  int line, int column, int toLine, int toColumn) {
        int n = 0;
        int m = 0;
        boolean isClear = true;
        for (int i = 1; i <= Math.abs(toLine-line); i++){ //check another figures
            if (toLine > line)
            {
                n = line + i;
                if (toColumn > column)
                {
                    m = column + i;
                } else {
                    m = column - i;
                }
            } else
            {
                n = line - i;
                if ( toColumn > column )
                {
                    m = column + i;
                } else
                {
                    m = column - i;
                }
            }
            if (chessBoard.board[n][m] == null)
            {
                isClear = true;
            }
            else
            {
                if ( n == toLine && m == toColumn
                        && chessBoard.board[toLine][toColumn].getColor() != chessBoard.board[line][column].getColor())
                {
                    isClear = true;
                } else
                {
                    isClear = false;
                    return isClear;
                } //check enemy on the cell
            }

        }
        return isClear;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
