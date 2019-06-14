package livegame;

import java.awt.Color;
import java.util.Random;
import javax.swing.JPanel;

public class ChessBoard {
	
	static  final int SIZE = 50;
	private final Color color = new Color(72,209,204);
	//格子中是否有生命
	private boolean[][] table = new boolean[SIZE][SIZE];
	//各自邻居数目
	private int[][] neighbors = new int[SIZE][SIZE];
	//每个网格
	JPanel panels[][]=new JPanel[SIZE][SIZE];
	
	protected void setPanels(JPanel panels[][]){
		this.panels=panels;
	}
	
	protected boolean[][] getTable() {
		return this.table;
		
	}
	protected JPanel[][] getPanels() {
		return this.panels;
	}
	
	protected void init1() {//初始状态:宽度为6的十字
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if((i>=22&&i<=27)||(j>=22&&j<=27)){
					table[i][j]=true;
					panels[i][j].setBackground(Color.red);
				}
				else{
					table[i][j]=false;
					panels[i][j].setBackground(color);
				}
			}
		}
	}
	
	protected void init2() {//初始状态12x12矩形
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if(i>=19&&i<=30&&j>=19&&j<=30){
					table[i][j]=true;
					panels[i][j].setBackground(Color.red);
				}
				else {
					table[i][j]=false;
					panels[i][j].setBackground(color);
					}
			}
		}
	}
	
	//随机状态
		protected void init3() {
	        Random r=new Random();
	        double n;
	        for(int i = 0;i < SIZE;i++)
				for(int j = 0;j < SIZE;j++) {
					n = r.nextDouble();
					if(n > 0.5){
						table[i][j] = true;
						panels[i][j].setBackground(Color.red);
					}
					else{
						table[i][j] = false;
						panels[i][j].setBackground(color);}
				}
	}
		
//	//初始化状态，前进器,可达到类似向前移动的视觉效果
//	protected void init4() {//目前没有用到，可以再扩展
//		for(int i = 0;i < SIZE;i++)
//			for(int j = 0;j < SIZE;j++)
//				table[i][j] = false;
//		table[44][44] = true;
//		table[45][45] = true;
//		for(int i = 46,j = 43;j <= 45;j++)
//			table[i][j] = true;
//	}
//	
	
	//初始化邻居
	private void initNeighbors() {
		for(int i = 0;i < SIZE;i++)
			for(int j = 0;j < SIZE;j++) {
				neighbors[i][j] = 0;
			}
	}
	//获得邻居个数
	private void getNeighbors() {
		
		for(int r = 0;r < SIZE;r++){
			for(int c = 0;c < SIZE;c++) {
				if(r-1 >= 0 && c-1 >= 0 && table[r-1][c-1] )neighbors[r][c]++;
                if(r-1 >= 0 && table[r-1][c]) neighbors[r][c]++;
                if(r-1 >= 0 && c+1 < SIZE && table[r-1][c+1])neighbors[r][c]++;
                if(c-1 >= 0 && table[r][c-1]) neighbors[r][c]++;
                if(c+1 < SIZE && table[r][c+1]) neighbors[r][c]++;
                if(r+1 < SIZE && table[r+1][c]) neighbors[r][c]++;
                if(r+1 < SIZE && c+1 < SIZE && table[r+1][c+1])  neighbors[r][c]++;
                if(r+1 < SIZE && c-1 >=0 && table[r+1][c-1])  neighbors[r][c]++;               
			}
		}
	}
	
	//获得下一个状态的数组
	private void nextWorld() {
	        for (int r = 0; r < SIZE; r++){//row
	            for (int c = 0; c < SIZE; c++){//column
	                if (neighbors[r][c] == 3){
	                    table[r][c] = true;
	                }//if (neighbors[r][c] == 2) 不改变table[r][c]。
	                if (neighbors[r][c] < 2)
	                    table[r][c] = false; 
	                if (neighbors[r][c] >= 4)
	                    table[r][c] = false;                 
	                neighbors[r][c] = 0;                
	            }           
	        }
	 }
	//状态修改 ,返回修改后的世界数组
	protected boolean[][] next() {
		initNeighbors();
		getNeighbors();
		nextWorld();
		return this.table;
	}

	protected void play(JPanel[][] panels){
		boolean state[][]= next();
		
		for (int i = 0; i < SIZE; i++){
			for (int j = 0; j < SIZE; j++) {
				if(state[i][j]){
					panels[i][j].setBackground(Color.red);
				}else{
					//panels[i][j].setBackground(new Color(72,209,204));
					panels[i][j].setBackground(color);
				}
			}
		}
	}
}
