package org.example.utilidades;


import java.io.InputStream;
import java.util.Properties;

/**
 * Clase de utilidad para cargar archivos de propiedades.
 */
public class UtilidadesAcceso {

    /**
     * Carga un archivo de propiedades desde la ubicación especificada.
     *
     * @param propertiesURL la ubicación del archivo de propiedades.
     * @return un objeto Properties cargado con las propiedades del archivo.
     */
    public static Properties loadProperty(String propertiesURL) {
        try {
            Properties properties = new Properties();
            InputStream inputStream = UtilidadesAcceso.class.getClassLoader().getResourceAsStream(propertiesURL);
            properties.load(inputStream);
            return properties;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

