package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;
import me.acdean.factory.Message;

public class Clips extends Component {
    public static final String NAME = "Clips";

    public Clips(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        type = INPUT;
    }

    @Override
    public void click() {
        // TODO more
        switch((int)p.random(2)) {
            case 0:
                // based on an example activity 344cb989-12b9-4cba-8be1-e41c8b09bb0e
                // bitmovin splits this into 12 video jobs all go through bitmoving and mattress
                factory.addMessage(NAME)
                        .type(Message.VIDEO)
                        .property(Message.Property.WORKFLOW_SOURCE, Balham.NAME)
                        .property(Message.Property.BALHAM_CUSTOMER, "galileo")
                        .property(Message.Property.GTI_BUNDLE, "piff_hd")
                        .property(Message.Property.ENCODER, GtiBitmovin.NAME)   // for gti router
                        .property(Message.Property.DESTINATION, Mattress.NAME); // for pleasant
                break;
            case 1:
                // based on an example activity 093cf102-5631-447e-872b-0399ad5c790e
                // which splits into 6 audio encodes, all go to ets and mattress
                factory.addMessage(NAME)
                        .type(Message.AUDIO)
                        .property(Message.Property.WORKFLOW_SOURCE, Balham.NAME)
                        .property(Message.Property.BALHAM_CUSTOMER, "galileo")
                        .property(Message.Property.GTI_BUNDLE, "aac_audio")
                        .property(Message.Property.ENCODER, GtiEts.NAME)        // for gti router
                        .property(Message.Property.DESTINATION, Mattress.NAME); // for pleasant
                break;
        }
    }
}
