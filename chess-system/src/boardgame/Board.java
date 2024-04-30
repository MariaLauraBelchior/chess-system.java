package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces; //matriz

    public Board(int rows, int columns){
        if (rows < 1 || columns < 1){
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }

        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }
    public int getRows(){
        return rows;
    }

    public int getColumns(){
        return columns;
    }

    public Piece piece(int row, int column){
        if (!positionExists(row, column)){
            throw new BoardException("Position not on the board");
        }
        return pieces[row][column]; //matriz
    }

    public Piece piece(Position position){
        if (!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){
        if (thereIsAPiece(position)) {
            throw new BoardException("There is already a piece on this position" + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;    // posição dada atribui a peça
        piece.position = position;                                 // peça pode ser acessada por conta do protected
    }

    public Piece removePiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		if (piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}


    // isso é para que dentro da classe seja mais facil testar pela linha e coluna
    private boolean positionExists(int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position){
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null; // este piece retorna a peça que está na matriz
    }
}
