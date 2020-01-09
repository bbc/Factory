package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class YellowPages extends Component {
    public static final String NAME = "Yellow Pages";
    private static final String DESCRIPTION = "Converts between names and numbers.";

    public YellowPages(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(VideoFactory.HERALDRY);
    }
}
