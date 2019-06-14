package livegame;

import java.util.TimerTask;

public class Time extends TimerTask{
	
	private ChessBoard chessBoard;//拥有棋盘对象,可调用play（）方法
	
	void setChessBoard(ChessBoard chessBoard){
		this.chessBoard=chessBoard;
	}
	
	ChessBoard getChessBoard(){
		return this.chessBoard;
	}
	
	//重写run方法，在线程里不断调用run（），达到不断改变chessBoard的目的
	public void run() {
		//棋盘对象调用play（）方法变化棋盘上棋子的状态
		chessBoard.play(chessBoard.getPanels());
	}

}
