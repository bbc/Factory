package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class L2vAlduin extends Component {
    public static final String NAME = "L2V Alduin";

    public L2vAlduin(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(L2vSoprendo.NAME);
    }
}
