package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Fred extends Component {
    public static final String NAME = "Fred";
    private static final String DESCRIPTION = "File Replacement Event aDapter";

    public Fred(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Movver.NAME);
    }
}
