package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;

public class Paulette extends Component {
    public static final String NAME = "Paulette";

    public Paulette(Factory factory, int x, int y) {
        super(factory, x, y, NAME);
        addInput(Rosetta.NAME);
        addInput(Mdj.NAME); // loop
        addInput(SubtitlePaulette.NAME);
    }

    // this is a loop - paulette -> mdj -> paulette -> mami
    @Override
    public void emit() {
        loop(this.name, Mdj.NAME, Mami.NAME);
//        if (currentMessage.property(Mdj.NAME) == null) {
//            Factory.logger.info("{} -> {}", this.name, Mdj.NAME);
//            currentMessage.property(Mdj.NAME, "done");
//            currentMessage.routeTo(Mdj.NAME);
//        } else {
//            Factory.logger.info("{} -> {}", this.name, Mami.NAME);
//            currentMessage.routeTo(Mami.NAME);
//        }
//        Factory.logger.info("Paulette Current Message [{}]", currentMessage);
    }
}
