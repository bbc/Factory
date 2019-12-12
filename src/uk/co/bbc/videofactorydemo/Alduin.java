package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Alduin extends Component {
    public static final String NAME = "Alduin";

    public Alduin(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(Soprendo.NAME);
    }
}
