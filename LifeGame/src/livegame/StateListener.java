package livegame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//状态菜单的监听器
class StateListener implements ActionListener{
	
	public void actionPerformed(ActionEvent event) {
		try {
			String state = event.getActionCommand();
			int index=0;
			switch (state) {
			case "开始":
				index=0;
				break;
			case "暂停":
				index=1;
			default:
				break;
			}
			//此处根据index的值用ChessBoard类的对象调用某一个init()方法，初始化棋盘
			InitState.initState(index);//InitShape类中的ChessBoard对象调用init()函数初始化形状
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
