package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Pips extends Component {
    public static final String NAME = "Pips";

    public Pips(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        type = MYSQL_DB;
    }
}
