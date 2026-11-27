public class Administració {
    
    private int num_poblacio_activa = 50;
    private Treballador[] poblacio_activa = new Treballador[num_poblacio_activa];

    public Administració() {
        for (int i = 0; i < num_poblacio_activa; i++) {
            poblacio_activa[i] = new Treballador("Ciutadà-" + i, 25000, 20, 65);
        }
    }

    public void inicia() {
        for (int i = 0; i < num_poblacio_activa; i++) {
            poblacio_activa[i].start();
        }
        for (int i = 0; i < num_poblacio_activa; i++) {
            try {
                poblacio_activa[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void mostraEstadistiques() {
        for (int i = 0; i < num_poblacio_activa; i++) {
            Treballador t = poblacio_activa[i];
            System.out.printf("%-10s -> edat: %d / total: %.2f%n", t.getName(), t.getEdat(), t.getCobrat());
        }
    }

    public static void main(String[] args) {
        Administració administracio = new Administració();
        administracio.inicia();
        administracio.mostraEstadistiques();
    }
}