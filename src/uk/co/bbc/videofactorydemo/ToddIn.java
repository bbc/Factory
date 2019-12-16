package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;
import me.acdean.factory.Message;

public class ToddIn extends Component {

    public static final String NAME = "Todd In";

    public ToddIn(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        type = INPUT;
    }

    @Override
    public void click() {
        switch((int)p.random(3)) {
            case 0:
                factory.addMessage(NAME)
                        .type(Message.VIDEO);
                break;
            case 1:
                factory.addMessage(NAME)
                        .type(Message.AUDIO);
                break;
            case 2:
                // c8390698-fca7-4c21-aa4a-0b8c7d0e7cff
                // gti-bundle h264_video_proxycopy_bundle
                // splits into 3 at cockcroft:
                //      bundle = ttml
                //      bundle = piff_sd -> elemental
                //      bundle = sky - > elemental
                //      
                factory.addMessage(NAME)
                        .type(Message.VIDEO)
                        .property(Message.Property.WORKFLOW_SOURCE, ToddIn.NAME)
                        .property(Message.Property.GTI_BUNDLE, "h264_video_proxycopy");
                break;
        }
    }
}
