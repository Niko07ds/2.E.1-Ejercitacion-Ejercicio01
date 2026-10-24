package ejercicio01;

public class Main {

    public static void main(String[] args) {

        // Obtenemos la instancia única de configuración
        AppConfig config1 = AppConfig.getInstance();

        // Consultamos los parámetros de configuración
        System.out.println("Nombre: " +
                config1.getProperty("aplicacion.nombre"));

        System.out.println("Versión: " +
                config1.getProperty("aplicacion.version"));

        System.out.println("Host: " +
                config1.getProperty("base_datos.host"));

        // Obtenemos nuevamente la instancia
        AppConfig config2 = AppConfig.getInstance();

        // Verificamos si ambas variables apuntan al mismo objeto
        System.out.println("¿Es la misma instancia? " +
                (config1 == config2));
    }
}
