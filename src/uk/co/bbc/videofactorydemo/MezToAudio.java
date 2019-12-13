package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;
import me.acdean.factory.Message;

public class MezToAudio extends Component {
    public static final String NAME = "Mez To Audio";

    public MezToAudio(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        type = INPUT;
    }

    // all mez2audio messages go to edc
    @Override
    public void click() {
        factory.addMessage(NAME)
                .property(Message.Property.ENCODER, GtiEdc.NAME);

    }
}
