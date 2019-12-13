package uk.co.bbc.videofactorydemo;

import com.sun.xml.internal.ws.api.message.saaj.SAAJFactory;
import me.acdean.factory.Component;
import me.acdean.factory.Factory;
import me.acdean.factory.Message;
import me.acdean.factory.Route;

public class Cockcroft extends Component {
    public static final String NAME = "Cockcroft";
    public static final String DESCRIPTION = "Splits the request up into similar jobs.";

    public Cockcroft(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        type = LAMBDA;
        setDescription(DESCRIPTION);
        addInput(Rutherford.NAME);
        addInput(Lovett.NAME);
        addInput(Vitruvian.NAME);
        addInput(Kiosk.NAME);
    }

    // messages are split into various types, encoders and final destinations
    @Override
    public void emit() {
        if (currentMessage.property(Message.Property.SOURCE).equals(MezToAudio.NAME)) {
            // two of these go to edc
            factory.addMessage(
                    new Message(factory, Route.routeName(this.name, CropConfigurator.NAME))
                        .type(Message.AUDIO)
                        .property(Message.Property.ENCODER, GtiEdc.NAME)
                        .property(Message.Property.DESTINATION, Mattress.NAME)
            );
            factory.addMessage(
                    new Message(factory, Route.routeName(this.name, CropConfigurator.NAME))
                        .type(Message.AUDIO)
                        .delay(60)
                        .property(Message.Property.ENCODER, GtiEdc.NAME)
                        .property(Message.Property.DESTINATION, Mattress.NAME)
            );
        } else {
            factory.addMessage(
                    new Message(factory, Route.routeName(this.name, CropConfigurator.NAME))
                        .type(Message.CLIP)
                        .property(Message.Property.ENCODER, GtiBitmovin.NAME)
                        .property(Message.Property.DESTINATION, Todd.NAME)
            );
            factory.addMessage(
                    new Message(factory, Route.routeName(this.name, CropConfigurator.NAME))
                        .type(Message.PROXY)
                        .delay(60)
                        .property(Message.Property.ENCODER, GtiBitmovin.NAME)
                        .property(Message.Property.DESTINATION, Mattress.NAME)
            );
            factory.addMessage(
                    new Message(factory, Route.routeName(this.name, CropConfigurator.NAME))
                        .type(Message.VIDEO)
                        .delay(120)
                        .property(Message.Property.ENCODER, GtiBitmovin.NAME)
                        .property(Message.Property.DESTINATION, Todd.NAME)
            );
            factory.addMessage(
                    new Message(factory, Route.routeName(this.name, CropConfigurator.NAME))
                        .type(Message.VIDEO)
                        .delay(180)
                        .property(Message.Property.ENCODER, GtiElemental.NAME)
                        .property(Message.Property.DESTINATION, Mattress.NAME)
            );
            factory.addMessage(
                    new Message(factory, Route.routeName(this.name, CropConfigurator.NAME))
                        .type(Message.AUDIO)
                        .delay(240)
                        .property(Message.Property.ENCODER, GtiEts.NAME)
                        .property(Message.Property.DESTINATION, Todd.NAME)
            );
            factory.addMessage(
                    new Message(factory, Route.routeName(this.name, CropConfigurator.NAME))
                        .type(Message.SUBTITLE)
                        .delay(300)
                        .property(Message.Property.ENCODER, GtiEdwin.NAME)
                        .property(Message.Property.DESTINATION, Mattress.NAME)
            );
            factory.addMessage(
                    new Message(factory, Route.routeName(this.name, CropConfigurator.NAME))
                        .type(Message.AUDIO)
                        .delay(360)
                        .property(Message.Property.ENCODER, GtiEdc.NAME)
                        .property(Message.Property.DESTINATION, Mattress.NAME)
            );
        }
    }
}
