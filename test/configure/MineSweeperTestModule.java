package configure;

import minesweeper.engine.DefaultNeighborSquareFinder;
import minesweeper.engine.GridFactory;
import minesweeper.engine.MockGridFactory;
import minesweeper.engine.NeighborSquareFinder;

import com.google.inject.AbstractModule;

public class MineSweeperTestModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(GridFactory.class).to(MockGridFactory.class);
		bind(NeighborSquareFinder.class).to(DefaultNeighborSquareFinder.class);
	}
}
