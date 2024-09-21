package subtes;

/**
 *
 * @author Luciano Peluso
 */
public class Main {

    public static void main(String[] args) {
        Modelo m = new Modelo();
        Vista v = new Vista(m);
        Controlador c = new Controlador(m, v);

        c.ejecutar();
    }

}
