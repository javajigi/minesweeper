package configure;

import minesweeper.View;
import minesweeper.view.ConsoleView;

import com.google.inject.AbstractModule;

public class ViewModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(View.class).to(ConsoleView.class);
	}
}
