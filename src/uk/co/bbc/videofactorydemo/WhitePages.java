package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class WhitePages extends Component {
    public static final String NAME = "White Pages";
    private static final String DESCRIPTION = "Receives 'Rights Changed' messages.";

    public WhitePages(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Rights.NAME);
    }
}
