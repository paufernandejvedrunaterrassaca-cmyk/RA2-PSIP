public class Fil extends Thread {
    private String nom;
    private int delay;
    private String fi;
 
    public Fil(String nom, int prioritat, int delay, String fi) {
        this.nom = nom;
        this.delay = delay;
        this.fi = fi;
        setPriority(prioritat);
    }
 
    public void run() {
        try {
            for (int i = 1; i < 10; i++) {
                for (int j = 0; j < 1000; j++);
                if (delay > 0) Thread.sleep(delay);
                System.out.println(nom + " " + i);
            }
        } catch (InterruptedException e) {
        }
        System.out.println(fi + " el fil " + nom);
    }
}