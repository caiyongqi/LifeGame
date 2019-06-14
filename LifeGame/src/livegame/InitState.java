package livegame;

import java.util.Timer;

class InitState{
	static UI ui;
	static Timer timer;
	static Time time;
	static protected void initState(int index){
		
		switch (index) {
		case 0:
			//结合Timer使生命游戏开始走动
			//Timer做好后再写
			timer=new Timer();
			time=new Time();
			time.setChessBoard(ui.getChessBoard());
			//timer.scheduleAtFixedRate(time,0,1000);
			timer.schedule(time,0, 1000);
			ui.getM21().setEnabled(false);
			ui.getM22().setEnabled(true);
			break;
		case 1:
			//结合Timer使生命游戏暂停
			//Timer做好后再写
			timer.cancel();
			ui.getM21().setEnabled(true);
			ui.getM22().setEnabled(false);
			break;
		default:
			break;
		}
	}
}