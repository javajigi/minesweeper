package minesweeper.engine;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import minesweeper.engine.GridSize;
import minesweeper.engine.Position;
import minesweeper.engine.RandomPositionGenerator;

import org.junit.Test;

public class RandomPositionGeneratorTest {

	@Test
	public void generate() {
		GridSize gridSize = new GridSize(5, 5);
		int countOfMine = 5;
		RandomPositionGenerator randomGenerator = new RandomPositionGenerator(gridSize, countOfMine);
		List<Position> randomPositions = randomGenerator.generate();
		assertThat(randomPositions.size(), is(countOfMine));
	}

}
