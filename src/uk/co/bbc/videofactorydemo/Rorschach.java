package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Rorschach extends Component {
    public static final String NAME = "Rorschach";
    private static final String DESCRIPTION = "Video Factory data.";

    public Rorschach(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        type = INPUT;
    }

    @Override
    public void click() {
        factory.logger.info("Rorschach click");
        factory.addMessage(NAME);
    }
}
