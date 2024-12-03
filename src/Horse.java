public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getSymbol() {
        return "H";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine!=line && toColumn!=column)  // move not to the same cell
        {
            if (toLine >= 0 && toLine < 8 && toColumn >= 0 && toColumn < 8)  // movement within the board
            {
                if (toLine == (line + 2) && toColumn == (column + 1) // move like horse and check attack or clear cell
                        && isClearCell(chessBoard,line,column,toLine,toColumn)) {
                    return true;
                } else if ((toLine == (line + 2) && toColumn == (column - 1))
                        && isClearCell(chessBoard,line,column,toLine,toColumn)){
                    return true;
                } else if ((toLine == (line + 1) && toColumn == (column + 2))
                        && isClearCell(chessBoard,line,column,toLine,toColumn)){
                    return true;
                } else if ((toLine == (line + 1) && toColumn == (column - 2))
                        && isClearCell(chessBoard,line,column,toLine,toColumn)){
                    return true;
                }else if ((toLine == (line - 2) && toColumn == (column - 1))
                        && isClearCell(chessBoard,line,column,toLine,toColumn)){
                    return true;
                }else if ((toLine == (line - 2) && toColumn == (column + 1))
                        && isClearCell(chessBoard,line,column,toLine,toColumn)){
                    return true;
                } else if ((toLine == (line - 1) && toColumn == (column - 2))
                        && isClearCell(chessBoard,line,column,toLine,toColumn)){
                    return true;
                }else if ((toLine == (line - 1) && toColumn == (column + 2))
                        && isClearCell(chessBoard,line,column,toLine,toColumn)){
                    return true;
                } else {
                    return false;
                }

            } else {
                return false;
            }
        }else {
            return false;
        }

    }

    private boolean isClearCell(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.board[toLine][toColumn]==null ||
                chessBoard.board[toLine][toColumn].getColor() != chessBoard.board[line][column].getColor())
        {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }

}
