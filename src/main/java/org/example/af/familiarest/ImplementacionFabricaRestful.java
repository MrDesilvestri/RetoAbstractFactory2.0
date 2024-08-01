package org.example.af.familiarest;


import org.example.abstractfactory.bases.IServiciosBasesGenericos;
import org.example.servicios.IServiciosArticulos;
import org.example.servicios.IServiciosEmpleados;

public class ImplementacionFabricaRestful implements IServiciosBasesGenericos {

    /**
     * Retorna una implementación del servicio de empleados basada en REST.
     *
     * @return una instancia de ImplementacionRestEmpleados.
     */
    @Override
    public IServiciosEmpleados getEmpleados() {
        return new ImplementacionRestEmpleados();
    }

    /**
     * Retorna una implementación del servicio de artículos basada en REST.
     *
     * @return una instancia de ImplementacionRestArticulos.
     */
    @Override
    public IServiciosArticulos getArticulos() {
        return new ImplementacionRestArticulos();
    }
}
