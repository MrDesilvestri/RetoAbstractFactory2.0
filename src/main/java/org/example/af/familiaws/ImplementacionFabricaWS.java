package org.example.af.familiaws;



import org.example.abstractfactory.bases.IServiciosBasesGenericos;
import org.example.servicios.IServiciosArticulos;
import org.example.servicios.IServiciosEmpleados;


public class ImplementacionFabricaWS implements IServiciosBasesGenericos {

    @Override
    public IServiciosEmpleados getEmpleados() {
        return new af.familiaws.ImplementacionWSEmpleados();
    }

    @Override
    public IServiciosArticulos getArticulos() {
        return new af.familiaws.ImplementacionWSArticulosConSOAP();
    }
}
