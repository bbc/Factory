package me.acdean.factory.example;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class FourB extends Component {
    public static final String NAME = "FourB";
    public static final String DESCRIPTION = "4B";

    public FourB(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        setDescription(DESCRIPTION);
        addInput(Three.NAME);
    }

    // reads from s3, processes, writes to s3, continues
    @Override
    public void processMessage() {
        readWorkWriteEmit();
    }
}
