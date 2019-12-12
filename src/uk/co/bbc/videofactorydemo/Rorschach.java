package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Rorschach extends Component {
    public static final String NAME = "Rorschach";

    public Rorschach(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        type = INPUT;
    }

    @Override
    public void click() {
        factory.logger.info("Rorschach click");
        factory.addMessage(NAME);
    }
}
