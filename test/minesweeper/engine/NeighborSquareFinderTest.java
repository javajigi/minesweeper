package minesweeper.engine;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

public class NeighborSquareFinderTest {
	@Test
	public void findNeighborPositions() throws Exception {
		GridSize gridSize = new GridSize(2, 3);
		DefaultNeighborSquareFinder neighborSquareFinder = new DefaultNeighborSquareFinder();
		List<Position> neighborPositions = neighborSquareFinder.findNeighborPositions(gridSize, new Position(1, 1));
		assertThat(neighborPositions, containsInAnyOrder(new Position(1,  2), new Position(2, 1), new Position(2, 2)));
	}
}
