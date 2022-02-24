package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
      
    }
    
    @Override
    public String toString(){
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        //verificando acima
        p.setValues(position.getRow() - 1, position.getColumn());  //subindo uma casa
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){ //enquanto a posição existir e for vaga
            mat[p.getRow()][p.getColumn()] = true; 
            p.setRow(p.getRow() - 1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true; 
        }

        //verificando esquerda
        p.setValues(position.getRow(), position.getColumn() - 1);  //indo para esquerda
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){ //enquanto a posição existir e for vaga
            mat[p.getRow()][p.getColumn()] = true; 
            p.setColumn(p.getColumn() - 1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true; 
        }

        p.setValues(position.getRow(), position.getColumn() + 1);  //indo para direita
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){ //enquanto a posição existir e for vaga
            mat[p.getRow()][p.getColumn()] = true; 
            p.setColumn(p.getColumn() + 1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true; 
        }

        p.setValues(position.getRow() + 1, position.getColumn());  //descendo uma casa
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){ //enquanto a posição existir e for vaga
            mat[p.getRow()][p.getColumn()] = true; 
            p.setRow(p.getRow() + 1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true; 
        }



        return mat;
    }

    
    
}
