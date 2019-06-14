package livegame;

import javax.swing.JPanel;

public class Main {

	public static void main(String[] args) {
		UI ui = new UI();
		ui.playUI();//生成UI界面
		
		ChessBoard chessBoard = new ChessBoard();//定义一个棋盘
		InitShape.board=chessBoard;//将棋盘对象传到初始化形状和状态的类
		InitState.ui=ui;
		
		JPanel panels[][]=ui.getJps();//获得UI中每个方格（棋子）
		
		chessBoard.setPanels(panels);//将棋子置于棋盘上
		ui.setChessBord(chessBoard);//UI获得棋盘对象
		chessBoard.play(panels);//画出整个棋盘
	}

}
