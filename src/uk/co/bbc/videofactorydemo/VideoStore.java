package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class VideoStore extends Component {
    public static final String NAME = "Video Store";

    public VideoStore(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(Magnolia.NAME);
        type = BLACK_BOX;
    }
}
