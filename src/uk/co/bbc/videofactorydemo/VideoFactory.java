package uk.co.bbc.videofactorydemo;

import me.acdean.factory.Component;
import me.acdean.factory.Factory;
import me.acdean.factory.Main;
import me.acdean.factory.Message;
import me.acdean.factory.Route;

//  https://daskboard.cloud.bbc.co.uk/workflows/gv/int/d6a3803f-ffd0-4407-8d8d-970e44072cc8
public class VideoFactory extends Factory {

    // generic component names
    public static final String ALDUIN       = "Alduin";
    public static final String BAGPUSS      = "Bagpuss";
    public static final String BARRISTER    = "Barrister";
    public static final String BLEEPER      = "Bleeper";
    public static final String HERALDRY     = "Heraldry";

    public VideoFactory(Main p) {
        super(p);

        int w = Component.WIDTH * 3 / 2;
        int h = Component.HEIGHT * 3 / 2;
        logger.info("W [{}] H [{}]", w, h);

        int y98 = h * -12 / 2;
        int y99 = h * -11 / 2;
        int y00 = h * -10 / 2;
        int y01 = h * -9 / 2;
        int y02 = h * -8 / 2;
        int y03 = h * -7 / 2;
        int y04 = h * -6 / 2;
        int y05 = h * -5 / 2;
        int y06 = h * -4 / 2;
        int y07 = h * -3 / 2;
        int y08 = h * -2 / 2;
        int y09 = h * -1 / 2;
        int y10 = 0;
        int y11 = h * 1 / 2;
        int y12 = h * 2 / 2;
        int y13 = h * 3 / 2;
        int y14 = h * 4 / 2;
        int y15 = h * 5 / 2;
        int y16 = h * 6 / 2;
        int y17 = h * 7 / 2;
        int y18 = h * 8 / 2;
        int y19 = h * 9 / 2;
        int y20 = h * 10 / 2;

        int x = -1000;
        addComponent(new Fbd(this, x, y04));
        addComponent(new Picr(this, x, y08));
        addComponent(new Rorschach(this, x, y10));
        addComponent(new ToddIn(this, x, y12));
        x += w;

        addComponent(new Component(this, x, y04, HERALDRY, "Watches for FBD arrivals.", Fbd.NAME, Component.LAMBDA));
        addComponent(new MezToAudio(this, x, y06));
        addComponent(new Copper(this, x, y08)); // back to bread
        addComponent(new Bread(this, x, y10));
        x += w;

        addComponent(new Rights(this, x, y02));
        addComponent(new YellowPages(this, x, y04));
        addComponent(new Chopper(this, x, y06));
        addComponent(new Lijer(this, x, y10));
        x += w;

        addComponent(new WhitePages(this, x, y02));
        addComponent(new Bifurcate(this, x, y04));
        addComponent(new Movver(this, x, y06));
        addComponent(new Component(this, x, y08, BAGPUSS, "Joins mezzanine chunks together.", Pedant.NAME));
        addComponent(new Pedant(this, x, y10));
        addComponent(new LegacyClips(this, x, y12));
        addComponent(new John(this, x, y16));
        x += w;

        addComponent(new Subherd(this, x, y02));
        addComponent(new Honda(this, x, y04));
        addComponent(new Delilah(this, x, y12));
        addComponent(new Clips(this, x, y14));
        addComponent(new Yoko(this, x, y16));
        x += w;

        addComponent(new Distiller(this, x, y98));
        addComponent(new Sting(this, x, y00));
        addComponent(new Syncopaticaption(this, x, y02));
        addComponent(new Phin(this, x, y04));
        addComponent(new Monk(this, x, y08));
        addComponent(new Lovett(this, x, y10));
        addComponent(new Balham(this, x, y12));
        addComponent(new Ringo(this, x, y16));
        x += w;

        addComponent(new SubtitleOut(this, x, y02));
        addComponent(new Magnolia(this, x, y04));
        addComponent(new Fred(this, x, y06));
        addComponent(new Fenton(this, x, y08));
        addComponent(new Vimes(this, x, y12));
        addComponent(new L2vPumice(this, x, y14));
        addComponent(new L2vMapr(this, x, y18));
        x += w;

        addComponent(new VideoStore(this, x, y04));
        addComponent(new Brucey(this, x, y08));
        addComponent(new Loudnorm(this, x, y12));
        addComponent(new L2vLoofah(this, x, y14));
        addComponent(new L2vSoprendo(this, x, y18));
        x += w;

        addComponent(new Kiosk(this, x, y06));
        addComponent(new Rutherford(this, x, y08));
        addComponent(new Vitruvian(this, x, y12));
        addComponent(new L2vSponge(this, x, y14));
        addComponent(new L2vAlduin(this, x, y18));
        addComponent(new L2vMinion(this, x, y20));
        x += w;

        // gti lambdas
        addComponent(new Cockcroft(this, x, y10));
        addComponent(new Paul(this, x, y16));
        x += w;

        addComponent(new CropConfigurator(this, x, y10));
        addComponent(new PaulOut(this, x, y16));
        x += w;

        addComponent(new GtiRouter2(this, x, y10));
        x += w;

        // encoders
        addComponent(new GtiEdc(this, x, y06));
        addComponent(new GtiBitmovin(this, x, y08));
        addComponent(new GtiElemental(this, x, y10));
        addComponent(new GtiEdwin(this, x, y12));
        addComponent(new GtiEts(this, x, y14));
        x += w;

        // pleasant (same height as bitmovin)
        addComponent(new Pleasant(this, x, y07));
        x += w;

        // endpoints
        addComponent(new Todd(this, x, y08));
        addComponent(new Mattress(this, x, y10));
        x += w;

        addComponent(new Pumice(this, x, y08));
        addComponent(new Component(this, x, y10, BLEEPER, "Add the bleeps to an audio feed.", Mattress.NAME));
        addComponent(new Mapr(this, x, y12));
        x += w;

        addComponent(new Loofah(this, x, y08));
        addComponent(new Soprendo(this, x, y12));
        x += w;

        addComponent(new Sponge(this, x, y08));
        addComponent(new Component(this, x, y12, ALDUIN, "Drm compoment for Axinom and Common Encryption", Soprendo.NAME));
        addComponent(new Minion(this, x, y14));
        x += w;

        addComponent(new Component(this, x, y10, BARRISTER, "Sends jobs to Quality Control.", new String[]{BLEEPER, Sponge.NAME, Minion.NAME, ALDUIN}));
        x += w;

        addComponent(new SubtitlePaulette(this, x, y02));
        addComponent(new Rosetta(this, x, y10));
        x += w;

        //addComponent(new Paul(this, x, y08));
        addComponent(new Paulette(this, x, y10));
        addComponent(new Mdj(this, x, y12)); // goes back to paulette
        addComponent(new PaulMami(this, x, y16));
        x += w;

        addComponent(new Mami(this, x, y10));
        //addComponent(new Pips(this, x, y12));
        x += w;

        addComponent(new MirWriter(this, x, y10));
        //addComponent(new Mir(this, x, y12));
        x += w;
    }

    // fixup the routes. seems a bit hacky.
    @Override
    public void fixupRoutes() {
        logger.info("Fixing up routes");
        updateRoute(Bread.NAME, Copper.NAME, Route.LOOP_BACK);
        updateRoute(Copper.NAME, Bread.NAME, Route.LOOP_FORWARD);

        updateRoute(Pedant.NAME, BAGPUSS, Route.LOOP_BACK);
        updateRoute(BAGPUSS, Pedant.NAME, Route.LOOP_FORWARD);

        updateRoute(Paulette.NAME, Mdj.NAME, Route.LOOP_BACK);
        updateRoute(Mdj.NAME, Paulette.NAME, Route.LOOP_FORWARD);

        for (Route route : routes.values()) {
            logger.info("Fixed Route [{}]", route);
        }
    }

    // a start message
    @Override
    public Message addMessage() {
        return addMessage(Rorschach.NAME)
                .type(Message.VIDEO);
    }
}
