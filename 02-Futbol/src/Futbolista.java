package src;

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

    public int getNgols() {
        return ngols;
    }

    public int getNtirades() {
        return ntirades;
    }

    public static void main(String[] args) {

        String[] noms = {
            "Piqué", "Vinicius", "Torres", "Ramos",
            "Ronaldo", "Lewan", "Belli", "Arnau",
            "Aspas", "Messi", "Mbapé"
        };

        Futbolista[] jugadors = new Futbolista[NUM_JUGADORES];

        System.out.println("Inici dels xuts ----------------");

        // Crear tots els fils
        for (int i = 0; i < NUM_JUGADORES; i++) {
            jugadors[i] = new Futbolista(noms[i]);
        }

        // Iniciar tots els fils
        for (int i = 0; i < NUM_JUGADORES; i++) {
            jugadors[i].start();
        }

        // Esperar que acabin tots els fils
        for (int i = 0; i < NUM_JUGADORES; i++) {
            try {
                jugadors[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println("Fi dels xuts ----------------");

        // Mostrar estadístiques
        System.out.println("--- Estadistiques ---");

        for (int i = 0; i < NUM_JUGADORES; i++) {
            System.out.println(
                jugadors[i].getName() + " -> "
                + jugadors[i].getNgols() + " gols"
            );
        }
    }
}
