package board;

import java.util.Scanner;

public class InputCoordinate {
	
	public Position getCoordinate() {
		Position pos = new Position();
		Scanner keyboard = new Scanner(System.in);
		System.out.print("input coordinate(x y) : ");
		pos.x = keyboard.nextInt();
		pos.y = keyboard.nextInt();
		
		return pos;
	}
	
	
}
