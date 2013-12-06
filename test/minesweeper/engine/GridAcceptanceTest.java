package minesweeper.engine;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.inject.Inject;

import minesweeper.engine.Grid;
import minesweeper.engine.Position;
import minesweeper.engine.View;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import configure.ViewModule;
import support.GuiceJUnitRunner;
import support.GuiceJUnitRunner.GuiceModules;

@RunWith(GuiceJUnitRunner.class)
@GuiceModules({ ViewModule.class })
public class GridAcceptanceTest {
	@Inject
	private View view;
	
	private Grid grid;
	
	@Before
	public void setup() {
		grid = new Grid(3, 3);
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
		return view.render(grid);
	}
	
	@Test
	public void 이웃_마인_수가_0인_스퀘어를_여는_경우() throws Exception {
		grid.openSquare(new Position(1, 1));
		assertThat(renderView(grid), is("000\n000\n000\n"));
	}
	
	@Test
	public void rendering() throws Exception {
		grid = new Grid(5, 5);
		grid.putMine(new Position(1, 1));
		grid.putMine(new Position(2, 2));
		grid.putMine(new Position(3, 3));
		grid.putMine(new Position(4, 4));
		
		grid.openSquare(new Position(5, 1));
		String result = renderView(grid);
		System.out.println(result);
	}

}
