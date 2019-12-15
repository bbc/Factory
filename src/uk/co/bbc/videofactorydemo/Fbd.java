package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;
import me.acdean.factory.Message;
import me.acdean.factory.Message.Property;

public class Fbd extends Component {
    public static final String NAME = "File Based Delivery";

    public Fbd(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        type = INPUT;
    }

    @Override
    public void click() {
        // some chance that these are subtitles (and go via subherd)
        if (p.random(100) < 30) {
            String handler = Subherd.getRandomhandler();
            factory.addMessage(NAME)
                    .type(Message.SUBTITLE)
                    .property(Property.SUBTITLE_HANDLER, handler);
        } else {
            factory.addMessage(NAME);
        }
    }
}
