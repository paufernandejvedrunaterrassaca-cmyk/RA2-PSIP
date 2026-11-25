import java.util.Random;

public class Motor extends Thread {
    private int id;
    private volatile int objectiu = 0;
    private volatile boolean finalitzacioDemanada = false;
    private int actual = 0;
    private Random random = new Random();

    public Motor(int id) {
        this.id = id;
    }

    public void setPotencia(int p) {
        objectiu = p;
        finalitzacioDemanada = p == 0;
    }

    public void run() {
        try {
            while (true) {
                if (actual == objectiu) {
                    if (actual == 0 && finalitzacioDemanada) {
                        return;
                    }
                    Thread.sleep(50);
                } else {
                    Thread.sleep(1000 + random.nextInt(1001));
                    if (actual < objectiu) {
                        actual++;
                        System.out.println("Motor " + id + ": Incre. Objectiu: " + objectiu + " Actual: " + actual);
                    } else if (actual > objectiu) {
                        actual--;
                        System.out.println("Motor " + id + ": Decre. Objectiu: " + objectiu + " Actual: " + actual);
                    }
                    if (actual == objectiu) {
                        System.out.println("Motor " + id + ": FerRes Objectiu: " + objectiu + " Actual: " + actual);
                        if (actual == 0 && finalitzacioDemanada) {
                            return;
                        }
                    }
                }
            }
        } catch (InterruptedException e) {
        }
    }
}