import java.util.Scanner;

public class Coet {
    private Motor[] motors = new Motor[4];

    public Coet() {
        for (int i = 0; i < 4; i++) {
            motors[i] = new Motor(i);
        }
    }

    public void passaAPotencia(int p) {
        if (p < 0 || p > 10) {
            throw new IllegalArgumentException("Error de valor: ha de ser entre 0 i 10");
        }
        System.out.println("Passant a potència " + p);
        for (Motor m : motors) {
            m.setPotencia(p);
        }
    }

    public void arrenca() {
        for (Motor m : motors) {
            m.start();
        }
    }

    public static void main(String[] args) {
        Coet coet = new Coet();
        coet.arrenca();
        Scanner scanner = new Scanner(System.in);
        int p = -1;
        while (p != 0) {
            p = scanner.nextInt();
            try {
                coet.passaAPotencia(p);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}