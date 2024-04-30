package chess;

import boardgame.Piece;
import boardgame.Board;
import boardgame.Position;

public abstract class ChessPiece extends Piece {
    private Colors colors;
    private int moveCount;

    public ChessPiece (Board board, Colors colors){
        super(board);
        this.colors = colors;
    }
    public Colors getColors(){ // apenas acesso
        return colors;
    }
    public int getMoveCount(){
        return moveCount;
    }
    protected void increaseMoveCount(){
        moveCount++;
    }
    protected void decreaseMoveCount(){
        moveCount--;
    }
    public ChessPosition getChessPosition() {
		return ChessPosition.fromPosition(position);
	}
	
	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p.getColors() != colors;
	}
}
