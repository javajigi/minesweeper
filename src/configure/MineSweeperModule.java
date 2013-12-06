package configure;

import minesweeper.engine.DefaultNeighborSquareFinder;
import minesweeper.engine.GridFactory;
import minesweeper.engine.NeighborSquareFinder;
import minesweeper.engine.RandomGridFactory;

import com.google.inject.AbstractModule;

public class MineSweeperModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(GridFactory.class).to(RandomGridFactory.class);
		bind(NeighborSquareFinder.class).to(DefaultNeighborSquareFinder.class);
	}
}
