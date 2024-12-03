public class Queen extends ChessPiece{
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (toLine >= 0 && toLine < 8 && toColumn >= 0 && toColumn < 8) //движение в рамках доски
        {

            if ((((((toLine -line) == (toColumn -column ))||
                    ((toLine -line) == -1*(toColumn -column ))) // движение по диагонали
                    &&isClearDiagonal(chessBoard,line,column,toLine,toColumn) //проверка пути по диагонали и атака как слоном
            )
                    && (toLine!=line && toColumn!=column))  // не в тоже поле
                    ||  ( (((toLine != line) && (toColumn == column )) // движение по горизонтали
                    &&isClearLine(chessBoard,line,column,toLine,toColumn)) //проверка чистого пути и атаки
                    || (((toLine == line) && (toColumn != column )) // движение по вертикали
                    &&isClearColumn(chessBoard,line,column,toLine,toColumn)) //проверка чистого пути и атаки
            ))


            {
                return true;}
            else {
                return false;}


        } else {
            return false;
        }


    }

    private boolean isClearDiagonal(ChessBoard chessBoard, int a1, int b1, int a2, int b2) {
        int n = 0;
        int m = 0;
        boolean isClear = true;
        for (int i = 1; i <= Math.abs(a2-a1); i++){ // check another figures on the way
            if (a2 > a1)
            {
                n = a1 + i;
                if (b2 > b1)
                {
                    m = b1 + i;
                } else {
                    m = b1 - i;
                }
            } else {
                n = a1 - i;
                if (b2 > b1)
                {
                    m = b1 + i;
                } else {
                    m = b1 - i;
                }
            }
            if (chessBoard.board[n][m] == null)
            {
                isClear = true;
            }
            else
            {
                if (n == a2 && m == b2
                        && chessBoard.board[a2][b2].getColor()!=chessBoard.board[a1][b1].getColor())
                {
                    isClear = true;
                } else {
                    isClear = false;
                } // check enemy on cell
            }

        }
        return isClear;
    }
    boolean isClearLine(ChessBoard chessBoard,int a1, int b1, int a2, int b2){ // check the line
        int n=0;
        boolean isClear = true;
        for (int i = 1; i<=Math.abs(a2-a1); i++){ // check another figures on the way
            if (a2 > a1){
                n = a1 + i;
            } else {
                n = a1 - i;
            }
            if (chessBoard.board[n][b1] == null)
            {
                isClear = true;
            }
            else
            {
                if (n == a2 && chessBoard.board[a2][b2].getColor() != chessBoard.board[a1][b1].getColor())
                {
                    isClear = true;
                } else {
                    isClear = false;
                } // check enemy on cell
            }

        }
        return isClear;
    }
    boolean isClearColumn(ChessBoard chessBoard,int a1, int b1, int a2, int b2){ // check the column
        int n=0;
        boolean isClear = true;
        for (int i = 1; i<=Math.abs(b2-b1); i++){ // check another figures on the way
            if (b2 > b1) {
                n = b1 + i;
            } else {
                n = b1 - i;
            }
            if (chessBoard.board[a1][n] == null)
            {
                isClear = true;
            }
            else {
                if (n == b2 && chessBoard.board[a2][b2].getColor() != chessBoard.board[a1][b1].getColor())
                {
                    isClear =true;
                } else {
                    isClear = false;
                } //check enemy on cell
            }

        }
        return isClear;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}