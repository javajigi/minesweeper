package Minesweeper;

public class BoardConsolePrinter {

	private static String LINE_SEPERATOR = System.lineSeparator();

	BoardConsolePrinter() {

	}

	public static StringBuilder printBoard(BoardController board) {
		int xNum = board.getXNum();
		int yNum = board.getYNum();

		if (xNum==1&&yNum==1) {
			StringBuilder upperNode = new StringBuilder();
			StringBuilder middleNode = new StringBuilder();
			StringBuilder footerNode = new StringBuilder();

			StringBuilder sb = new StringBuilder();

			upperNode.append(	"┌─┐");

			sb.append(upperNode);
			sb.append(LINE_SEPERATOR);

			middleNode.append(	"│");
			String str;

			if (board.getBlock(1, 1).isMine())
				str = "*";
			else
				str = String.valueOf(board.getNumofNearMines(1, 1));

			middleNode.append(	" "+str);
			middleNode.append(	"│");

			sb.append(middleNode);
			sb.append(LINE_SEPERATOR);

			footerNode.append(	"└─┘");

			sb.append(footerNode);
			sb.append(LINE_SEPERATOR);

			return sb;
		}

		else {
			StringBuilder upperNode = new StringBuilder();
			StringBuilder footerNode = new StringBuilder();

			StringBuilder sb = new StringBuilder();


			upperNode.append("┌");
			for (int i = 0 ; i < xNum ; i++)
				upperNode.append("─┬");
			upperNode.deleteCharAt(upperNode.length()-1);
			upperNode.append("┐");

			sb.append(upperNode);
			sb.append(LINE_SEPERATOR);

			for (int i = 0 ; i < yNum ; i++) {
				StringBuilder middleNode = new StringBuilder();
				middleNode.append("│");
				for (int j = 0 ; j < xNum ; j++) {
					String str;
					if (board.getBlock(i+1, j+1).isMine())
						str = "*";
					else if (board.getNumofNearMines(i+1, j+1)==0)
						str = " ";
					else
						str = String.valueOf(board.getNumofNearMines(i+1, j+1));
					middleNode.append(" "+str);
					middleNode.append("│");
				}

				sb.append(middleNode);
				sb.append(LINE_SEPERATOR);

				if (i!=yNum-1) {
				StringBuilder middleLineNode = new StringBuilder();
				middleLineNode.append("├");
				for (int j = 0 ; j < xNum ; j++) {
					middleLineNode.append("─");
					middleLineNode.append("┼");
				}
				middleLineNode.deleteCharAt(middleLineNode.length()-1);
				middleLineNode.append("┤");
				sb.append(middleLineNode);
				sb.append(LINE_SEPERATOR);
				}
			}

			footerNode.append("└");
			for (int i = 0 ; i < xNum ; i++)
				footerNode.append("─┴");
			footerNode.deleteCharAt(footerNode.length()-1);
			footerNode.append("┘");

			sb.append(footerNode);
			sb.append(LINE_SEPERATOR);

			return sb;
		}
	}
}
