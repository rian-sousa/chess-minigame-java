package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if(rows < 1 || columns <1){  //Criação do tabuleiro + programação defensiva
            throw new BoardException("Erro ao criar tabuleiro: é necessário no mínimo uma linha e uma coluna");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }                                       

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
    
    public Piece pieces(int row, int column){
        if(!positionExists(row, column)){  //programação defensiva
            throw new BoardException("Posição não encontrada no tabuleiro");
        }
        return pieces[row][column];  
    }

    public Piece piece(Position position){
        if(!positionExists(position)){  //programação defensiva
            throw new BoardException("Posição não encontrada no tabuleiro");
        }
        return pieces[position.getRow()][position.getColumn()];
    }  
    
    public void placePiece(Piece piece, Position position){
        if(thereIsAPiece(position)){    //programação defensiva
            throw new BoardException("Já existe uma peça nessa posição" + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;  //colando peça
        piece.position = position;
    }

    private boolean positionExists(int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < columns;  //verificando se a posição existe
    }
                                                                                    // +
    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());  //verificando se a posição existe 
    }

    public boolean thereIsAPiece(Position position){  //verificando se existe uma peça na posição
        if(!positionExists(position)){  //programação defensiva
            throw new BoardException("Posição não encontrada no tabuleiro");
        }
        return piece(position) != null;
    }
    
}
