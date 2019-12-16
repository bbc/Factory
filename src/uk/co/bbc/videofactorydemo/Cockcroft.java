package uk.co.bbc.videofactorydemo;

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
        String source = currentMessage.property(Message.Property.SOURCE);
        String gtiBundle = currentMessage.property(Message.Property.GTI_BUNDLE);

        // aac audio splits into 6
        if (gtiBundle != null && gtiBundle.equals("aac_audio")) {
            String handler = null;
            if (p.random(100) < 50) {
                handler = GtiEdc.NAME;
            } else {
                handler = GtiEts.NAME;
            }
            currentMessage.route(name, CropConfigurator.NAME)
                    .type(Message.AUDIO)
                    .property(Message.Property.ENCODER, handler)
                    .property(Message.Property.DESTINATION, Mattress.NAME);
            // 5 more
            for (int i = 1 ; i < 6 ; i++) {
                factory.addMessage(
                        new Message(factory, Route.routeName(this.name, CropConfigurator.NAME))
                            .type(Message.AUDIO)
                            .delay(60 * i)
                            .property(Message.Property.ENCODER, handler)
                            .property(Message.Property.DESTINATION, Mattress.NAME)
                );
            }
        }
        // piff hd goes to bitmovin (and gets split into 12 there)
        if (gtiBundle != null && gtiBundle.equals("piff_hd")) {
            currentMessage.route(name, CropConfigurator.NAME)
                    .type(Message.VIDEO)
                    .property(Message.Property.ENCODER, GtiBitmovin.NAME)
                    .property(Message.Property.DESTINATION, Mattress.NAME);
        }
        // h264_video_proxycopy splits into 3
        //      bundle = ttml -> edwin
        //      bundle = piff_sd -> elemental
        //      bundle = sky - > elemental
        // splits into 10 at elemental
        if (gtiBundle != null && gtiBundle.equals("h264_video_proxycopy")) {
            currentMessage.route(name, CropConfigurator.NAME)
                    .type(Message.SUBTITLE)
                    .property(Message.Property.ENCODER, GtiEdwin.NAME)
                    .property(Message.Property.DESTINATION, Mattress.NAME);
            factory.addMessage(
                    new Message(factory, Route.routeName(this.name, CropConfigurator.NAME))
                        .type(Message.VIDEO)
                        .delay(60)
                        .property(Message.Property.ENCODER, GtiElemental.NAME)
                        .property(Message.Property.DESTINATION, Mattress.NAME)
            );
            factory.addMessage(
                    new Message(factory, Route.routeName(this.name, CropConfigurator.NAME))
                        .type(Message.VIDEO)
                        .delay(120)
                        .property(Message.Property.ENCODER, GtiElemental.NAME)
                        .property(Message.Property.DESTINATION, Mattress.NAME)
            );
        }

        // old versions
        if (source != null && source.equals(MezToAudio.NAME)) {
            // split into two, both going go to edc
            currentMessage.route(name, CropConfigurator.NAME)
                    .type(Message.AUDIO)
                    .property(Message.Property.ENCODER, GtiEdc.NAME)
                    .property(Message.Property.DESTINATION, Mattress.NAME);
            factory.addMessage(
                    new Message(factory, Route.routeName(this.name, CropConfigurator.NAME))
                        .type(Message.AUDIO)
                        .delay(60)
                        .property(Message.Property.ENCODER, GtiEdc.NAME)
                        .property(Message.Property.DESTINATION, Mattress.NAME)
            );
        } else {
            // split into n going various places
            // TODO make this accurate...
            currentMessage.route(this.name, CropConfigurator.NAME)
                    .type(Message.PROXY)
                    .property(Message.Property.ENCODER, GtiBitmovin.NAME)
                    .property(Message.Property.DESTINATION, Mattress.NAME);
            factory.addMessage(
                    new Message(factory, Route.routeName(this.name, CropConfigurator.NAME))
                        .type(Message.CLIP)
                        .delay(60)
                        .property(Message.Property.ENCODER, GtiBitmovin.NAME)
                        .property(Message.Property.DESTINATION, Todd.NAME)
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
