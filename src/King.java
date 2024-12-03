public class King extends ChessPiece{
    public King(String color) {
        super(color);
    }
    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column){
        return false;
    }
    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (toLine >= 0 && toLine < 8 && toColumn >= 0 && toColumn < 8) // movement within the board
        {
            if (
                    ((toColumn == column-1) && ((toLine == line-1) || (toLine == line) || (toLine == line+1)))
                            || ((toColumn == column) && ((toLine == line-1) || (toLine == line+1)))
                            || ((toColumn == column+1) && ((toLine == line-1) || (toLine == line) || (toLine == line+1)))
                            && (!isUnderAttack( chessBoard,  toLine,  toColumn))
                            && chessBoard.board[toLine][toColumn] == null
                    //move within a radius of 1 field and not in the same field
            )
            {
                return true;
            } else {
                if ( chessBoard.board[toLine][toColumn].getColor() != chessBoard.board[line][column].getColor())
                {
                    return true;
                } else
                {
                    return false;
                }
            }
        } else {
            return false;
        }
    }


    @Override
    public String getSymbol() {
        return "K";
    }
}