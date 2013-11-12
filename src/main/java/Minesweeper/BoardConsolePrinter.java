package Minesweeper;

public class BoardConsolePrinter {
	private static String LINE_SEPERATOR = System.lineSeparator();

	public static StringBuilder printBoard(BoardController board) {
		int xNum = board.getXNum();
		int yNum = board.getYNum();

		if (xNum==1&&yNum==1) {
			StringBuilder upperNode = new StringBuilder();
			StringBuilder middleNode = new StringBuilder();
			StringBuilder footerNode = new StringBuilder();
			StringBuilder fullNode = new StringBuilder();

			upperNode.append(	"┌─┐");

			fullNode.append(upperNode);
			fullNode.append(LINE_SEPERATOR);

			middleNode.append(	"│");
			String str;

			if (board.getBlock(1, 1).isMine())
				str = "*";
			else
				str = String.valueOf(board.getNumofNearMines(1, 1));

			middleNode.append(	" "+str);
			middleNode.append(	"│");

			fullNode.append(middleNode);
			fullNode.append(LINE_SEPERATOR);

			footerNode.append(	"└─┘");

			fullNode.append(footerNode);
			fullNode.append(LINE_SEPERATOR);

			return fullNode;
		}

		else {
			StringBuilder upperNode = new StringBuilder();
			StringBuilder footerNode = new StringBuilder();
			StringBuilder fullNode = new StringBuilder();

			//indexNode
			StringBuilder indexNode = new StringBuilder();
			indexNode.append("    ");
			for (int i = 0 ; i < xNum ; i++) {
				String str = String.format("%2d", i+1);
				indexNode.append(str);
				indexNode.append("  ");
			}
			fullNode.append(indexNode);
			fullNode.append(LINE_SEPERATOR);

			// upperNode
			upperNode.append("  ┌");
			for (int i = 0 ; i < xNum ; i++)
				upperNode.append("─┬");
			upperNode.deleteCharAt(upperNode.length()-1);
			upperNode.append("┐");
			fullNode.append(upperNode);
			fullNode.append(LINE_SEPERATOR);

			// middleNode
			for (int i = 0 ; i < yNum ; i++) {
				StringBuilder middleNode = new StringBuilder();

				middleNode.append((char) (i+65));	// A부터 시작
				middleNode.append(" │");

				// 마인 라인
				for (int j = 0 ; j < xNum ; j++) {
					String str;

						if (board.getBlock(j+1, i+1).isShow()) {
							if (board.getBlock(j+1, i+1).isMine())
								str = " *";
							else if (board.getNumofNearMines(j+1, i+1)==0)
								str = "  ";
							else
								str = " " + String.valueOf(board.getNumofNearMines(j+1, i+1));
						}

						else if (board.getBlock(j+1, i+1).isFlag())
							str = " F";

						else
							str = "::";
					middleNode.append(str);
					middleNode.append("│");
				}
				fullNode.append(middleNode);
				fullNode.append(LINE_SEPERATOR);

				// 중간 구별 해주는 라인 생성
				if (i!=yNum-1) {
					StringBuilder middleLineNode = new StringBuilder();
					middleLineNode.append("  ├");

					for (int j = 0 ; j < xNum ; j++) {
						middleLineNode.append("─");
						middleLineNode.append("┼");
					}

					middleLineNode.deleteCharAt(middleLineNode.length()-1);
					middleLineNode.append("┤");
					fullNode.append(middleLineNode);
					fullNode.append(LINE_SEPERATOR);
				}
			}

			// footerNode
			footerNode.append("  └");
			for (int i = 0 ; i < xNum ; i++)
				footerNode.append("─┴");
			footerNode.deleteCharAt(footerNode.length()-1);
			footerNode.append("┘");
			fullNode.append(footerNode);
			fullNode.append(LINE_SEPERATOR);

			return fullNode;
		}
	}

	public static void printConsoleBoard(BoardController board) {
		System.out.println(printBoard(board));
	}
}
