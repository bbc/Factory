package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Mir extends Component {
    public static final String NAME = "Mir";
    private static final String DESCRIPTION = "Media Information Repository.";

    public Mir(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        type = DYNAMO_DB;
    }
}
