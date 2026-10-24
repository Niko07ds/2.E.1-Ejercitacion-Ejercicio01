package ejercicio01;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class AppConfig {

    // Instancia única del Singleton
    private static AppConfig instance;

    // Almacena las propiedades de configuración
    private final Properties properties;

    // Constructor privado para impedir la creación externa de objetos
    private AppConfig() {
        properties = new Properties();
        loadConfiguration();
    }

    // Devuelve siempre la misma instancia
    public static synchronized AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    // Carga las propiedades desde el archivo de configuración
    private void loadConfiguration() {
        Path path = Path.of("config.properties");

        try (InputStream input = Files.newInputStream(path)) {
            properties.load(input);
            System.out.println("Configuración cargada correctamente.");
        } catch (IOException e) {
            throw new IllegalStateException(
                    "No se pudo cargar config.properties", e
            );
        }
    }

    // Devuelve el valor de una propiedad a partir de su clave
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
