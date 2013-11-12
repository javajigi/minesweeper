package Minesweeper;

import java.util.Scanner;

public class BoardUserInterfaceConsole {
	Scanner scanner = new Scanner(System.in);

	private enum DIRECTION
	{
		DIR_UP, DIR_DOWN, DIR_LEFT, DIR_RIGHT, DIR_NONE;
	}

	String getInput(String message) {
		System.out.println(message);
		String input = scanner.next();
		return input;
	}

	DIRECTION controlBoard() {
		String control = getInput("Map Control : ");

		if (control.equals("W") || control.equals("w"))
			return DIRECTION.DIR_UP;
		else if (control.equals("A") || control.equals("a"))
			return DIRECTION.DIR_LEFT;
		else if (control.equals("S") || control.equals("s"))
			return DIRECTION.DIR_DOWN;
		else if (control.equals("D") || control.equals("d"))
			return DIRECTION.DIR_RIGHT;
		else
			return DIRECTION.DIR_NONE;
	}
}
