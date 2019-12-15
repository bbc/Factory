package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;
import me.acdean.factory.Message;

public class Rights extends Component {
    public static final String NAME = "Rights";

    public Rights(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        type = INPUT;
    }

    @Override
    public void click() {
        String handler = Subherd.getRandomhandler();
        factory.addMessage(NAME)
                .property(Message.Property.SUBTITLE_HANDLER, handler);
    }
}
