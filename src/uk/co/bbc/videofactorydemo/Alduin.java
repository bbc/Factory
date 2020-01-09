package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

@Deprecated
public class Alduin extends Component {
    public static final String NAME = "Alduin";
    private static final String DESCRIPTION = "Drm compoment for Axinom and Common Encryption";

    public Alduin(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Soprendo.NAME);
    }
}
