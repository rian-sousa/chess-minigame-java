package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.Rook;
import chess.pieces.King;

public class ChessMatch {

    private Board board;
    
    public ChessMatch(){
        board = new Board(8,8);
        initialSetup();
        
    }

    public ChessPiece[][] getPieces(){
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for(int i=0;i<board.getRows();i++){
            for(int j=0;j<board.getColumns();j++){
                mat[i][j] = (ChessPiece)board.pieces(i, j);
            }
        }
        return mat;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placePiece(piece, new chessPosition(column, row).toPosition());
    }


    public void initialSetup(){
        placeNewPiece('b', 6, new Rook(board, Color.WHITE));
        placeNewPiece('c', 4, new King(board, Color.BLACK));
    }
    
}
