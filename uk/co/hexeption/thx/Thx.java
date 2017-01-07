package uk.co.hexeption.thx;

/**
 * Created by Hexeption on 07/01/2017.
 */
public class Thx {

    public static final Thx INSTANCE = new Thx();

    public final String NAME = "Thx";

    public final String VERSION = "Thx Dev 1";


    public void startClient() {


        //Ends Client
        Runtime.getRuntime().addShutdownHook(new Thread(() -> endClient()));
    }

    public void endClient() {

    }

}
