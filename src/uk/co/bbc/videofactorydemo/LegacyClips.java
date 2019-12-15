package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;
import me.acdean.factory.Message;

public class LegacyClips extends Component {
    public static final String NAME = "LegacyClips";

    public LegacyClips(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        type = INPUT;
    }

    @Override
    public void click() {
        factory.addMessage(NAME)
                .type(Message.VIDEO);
    }
}
