package minesweeper.engine;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GridAcceptanceTest {
	private Grid grid;
	
	@Before
	public void setup() {
		grid = GridTest.createBy(new GridSize(3, 3));
	}
	
	@Test
	public void Grid_최초_생성() {
		assertThat(renderView(grid), is("CCC\nCCC\nCCC\n"));
	}

	@Test
	public void 이웃_마인_수() throws Exception {
		grid.putMine(new Position(1, 1));
		grid.putMine(new Position(1, 1));
		grid.putMine(new Position(1, 3));
		
		grid.openSquare(new Position(1, 2));
		grid.openSquare(new Position(2, 1));
		grid.openSquare(new Position(2, 2));
		assertThat(renderView(grid), is("C2C\n12C\nCCC\n"));
	}

	private String renderView(Grid grid) {
		return render(grid);
	}
	
	@Test
	public void 이웃_마인_수가_0인_스퀘어를_여는_경우() throws Exception {
		grid.openSquare(new Position(1, 1));
		assertThat(renderView(grid), is("000\n000\n000\n"));
	}
	
	@Test
	public void rendering() throws Exception {
		grid = GridTest.createBy(new GridSize(5, 5));
		grid.putMine(new Position(1, 1));
		grid.putMine(new Position(2, 2));
		grid.putMine(new Position(3, 3));
		grid.putMine(new Position(4, 4));
		
		grid.openSquare(new Position(5, 1));
		String result = renderView(grid);
		System.out.println(result);
	}

	private String render(Grid grid) {
		List<Square> squares = grid.getSquares();
		StringBuilder sb = new StringBuilder();
		GridSize gridSize = grid.sizeOfGrid();
		
		for (int i = 1; i <= gridSize.getX(); i++) {
			for (int j = 1; j <= gridSize.getY(); j++) {
				Square square = squares.get(gridSize.indexOfSquare(i, j));
				sb.append(square.getSymbol());
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
