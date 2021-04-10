import org.apache.logging.log4j.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();
    private static final Marker KIJELENTÉS = MarkerManager.getMarker("KIJELENTÉS");
    private static final Marker KÉRDÉS = MarkerManager.getMarker("KÉRDÉS");

    public static void main(String[] args) throws InterruptedException {
        int iterationCount = 2;
        if(args.length == 1){
            iterationCount = Integer.parseInt(args[0]);
        }

        for (int i = 1; i <= iterationCount; i++){
            ThreadContext.put("iterationNumber", String.valueOf(i));

            logger.trace(KIJELENTÉS, "Jöttem végig az utakon.");
            logger.debug(KIJELENTÉS, "Felém hajolt sok-sok virág");
            logger.info(KIJELENTÉS, "Rózsavizük osztogatták.");
            logger.warn(KIJELENTÉS, "Megöntözlek most itt véle");
            logger.error("Piros tojást várok érte!");
            logger.fatal(KÉRDÉS, "Szabad-e locsolni?");

            ThreadContext.clearAll();
            Thread.sleep(1000);
        }
    }
}