package livegame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapeListener implements ActionListener{
	
	public void actionPerformed(ActionEvent event) {
		try {
			String shape = event.getActionCommand();
			int index=0;
			switch (shape) {
			case "十字":
				index=0;
				break;
			case "矩形":
				index=1;
				break;
			case "随机形状":
				index=2;
				break;
			default:
				break;
			}
			//此处根据index的值用ChessBoard类的对象调用某一个init()方法，初始化棋盘
			InitShape.initShape(index);//InitShape类中的ChessBoard对象调用init()函数初始化形状
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
