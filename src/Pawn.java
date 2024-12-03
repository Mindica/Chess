public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine!=line ) //move not to the same cell
        {
            if (toLine >= 0 && toLine < 8 && toColumn==column) // movement within the board
            {

                if (((toLine == line+2)&&(line==1)&& (this.getColor()=="White") // 1st step 2 cell
                        && chessBoard.board[line+2][column]==null && chessBoard.board[line+1][column]==null) // check another figures
                        ||((toLine == line-2)&& (line==6)&& (this.getColor()=="Black") // 1st step 2 cell
                        && chessBoard.board[line-2][column]==null && chessBoard.board[line-1][column]==null // check another figures
                )){
                    return true;} else
                if (((toLine==line+1)&& (this.getColor()=="White")  // 1st step 1 cell
                        && chessBoard.board[line+1][column]==null) // check another figures
                        ||((toLine == line-1)&& (this.getColor()=="Black")  // 1st step 1 cell
                        && chessBoard.board[line-1][column]==null)) // check another figures
                { return true;} else {return false;}

            } else

            if (toLine >= 0 && toLine < 8 && // attack
                    (((toLine==line+1)&& (this.getColor() == "White")
                            && (chessBoard.board[line+1][column+1].getColor() != "White"|| // search enemy right side
                            chessBoard.board[line+1][column-1].getColor() != "White")) // search enemy left side
                            || ((toLine == line-1) && (this.getColor() == "Black")
                            && (chessBoard.board[line-1][column+1].getColor() != "Black"|| // search enemy right side
                            chessBoard.board[line-1][column-1].getColor() != "Black"))  // search enemy left side
                    ))
            {
                return true;
            }
            else
            {
                return false;
            }
        } else {
            return false;
        }

    }


}
