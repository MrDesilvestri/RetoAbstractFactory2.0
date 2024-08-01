package org.example.abstractfactory.bases;


import org.example.servicios.IServiciosArticulos;
import org.example.servicios.IServiciosEmpleados;

public interface IServiciosBasesGenericos {
    public IServiciosEmpleados getEmpleados();
    public IServiciosArticulos getArticulos();
}
