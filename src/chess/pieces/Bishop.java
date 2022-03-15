package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

    public Bishop(Board board, Color color) {
        super(board, color);
      
    }
    
    @Override
    public String toString(){
        return "B";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        //verificando acima+esquerda
        p.setValues(position.getRow() - 1, position.getColumn() - 1);  //subindo uma casa
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){ //enquanto a posição existir e for vaga
            mat[p.getRow()][p.getColumn()] = true; 
            p.setValues(p.getRow() - 1, p.getColumn() - 1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true; 
        }

        //verificando acima+direita
        p.setValues(position.getRow() - 1, position.getColumn() + 1);  //indo para esquerda
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){ //enquanto a posição existir e for vaga
            mat[p.getRow()][p.getColumn()] = true; 
            p.setValues(p.getRow() - 1, p.getColumn() + 1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true; 
        }
        //verificando baixo+direita
        p.setValues(position.getRow() + 1, position.getColumn() + 1);  //indo para direita
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){ //enquanto a posição existir e for vaga
            mat[p.getRow()][p.getColumn()] = true; 
            p.setValues(p.getRow() + 1, p.getColumn() + 1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true; 
        }

        //verificando baixo+esquerda
        p.setValues(position.getRow() + 1, position.getColumn() - 1);  //descendo uma casa
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){ //enquanto a posição existir e for vaga
            mat[p.getRow()][p.getColumn()] = true; 
            p.setValues(p.getRow() + 1, p.getColumn() - 1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true; 
        }



        return mat;
    }

    
    
}
