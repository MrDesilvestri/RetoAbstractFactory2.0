package org.example.abstractfactory.bases;

import org.example.utilidades.UtilidadesAcceso;

import java.util.Properties;


public class ServiciosGenericosAbstractFactory {

    public static IServiciosBasesGenericos createServiceFactory() {
        Properties props = UtilidadesAcceso.loadProperty(
                "AbsFactoryPropiedades.properties");
        String factoryClass = props.getProperty("servicioImplementado");
        try {
            return (IServiciosBasesGenericos)
                    Class.forName(factoryClass).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
