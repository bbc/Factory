package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class SubtitlePaulette extends Component {
    public static final String NAME = "SubtitlePaulette";

    public SubtitlePaulette(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        type = CONNECTOR;
        addInput(SubtitleOut.NAME);
    }
}
