import java.util.Random;

public class DormAleatori extends Thread {
    private long creacio;
    private Random random = new Random();

    public DormAleatori(String nom) {
        setName(nom);
        creacio = System.currentTimeMillis();
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            int interval = random.nextInt(1000);
            long total = System.currentTimeMillis() - creacio;
            System.out.println(getName() + "(" + i + ") a dormir " + interval + "ms total " + total + "ms");
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) {
        new DormAleatori("Joan").start();
        new DormAleatori("Pep").start();
        System.out.println("-- Fi de main -----------");
    }
}