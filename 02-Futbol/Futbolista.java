public class Futbolista extends Thread {

    private static final int NUM_JUGADORES = 11;
    private static final int NUM_TIRADES = 20;
    private static final float PROBABILITAT = 0.5f;

    private int ngols;
    private int ntirades;

    public Futbolista(String nom) {
        super(nom);
        ngols = 0;
        ntirades = 0;
    }

    @Override
    public void run() {
        for (int i = 0; i < NUM_TIRADES; i++) {

            ntirades++;

            if (Math.random() < PROBABILITAT) {
                ngols++;
            }
        }
    }
}
