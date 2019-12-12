package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Mir extends Component {
    public static final String NAME = "Mir";

    public Mir(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        type = DYNAMO_DB;
    }
}
