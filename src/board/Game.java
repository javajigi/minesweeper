package board;

import java.awt.*;

public class Game {

	public static void main(String[] args) {
		Grid game = new Grid(3,3);
		
		Frame f = new Frame("Fream Test");
		f.setSize(100, 100);
		f.setLayout(null);
		
		for (int i = 0; i < game.girdSizeX; i++) {
			for (int j = 0; j < game.girdSizeY; j++) {
				Button b = new Button(" ");
				b.setSize(20, 20);
				b.setLocation(25*(i+1), 25*(j+1));
				b.setName("b"+i+j);
				System.out.println(b.getName());
				
				MyActionListener mal= new MyActionListener();
				//b.addActionListener(mal);
				
				f.add(b);
			}
		}
		
		
		f.setVisible(true);

	}

}
