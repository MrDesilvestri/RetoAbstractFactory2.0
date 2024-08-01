package org.example.patronabstractfactory;


import java.util.Arrays;

import org.example.abstractfactory.bases.IServiciosBasesGenericos;
import org.example.abstractfactory.bases.ServiciosGenericosAbstractFactory;
import org.example.servicios.IServiciosArticulos;
import org.example.servicios.IServiciosEmpleados;

public class PatronAbstractFactoryMain {

    public static void main(String[] args) {
        IServiciosBasesGenericos factory =
                ServiciosGenericosAbstractFactory.createServiceFactory();
        IServiciosEmpleados employeeService = factory.getEmpleados();
        IServiciosArticulos productService = factory.getArticulos();

        System.out.println("Servicio Empleados class > "
                + employeeService.getClass().getCanonicalName());
        System.out.println("Servicio Articulos class  > "
                + productService.getClass().getCanonicalName());

        System.out.println("getEmployee > "
                + Arrays.toString(employeeService.getEmpleados()));
        System.out.println("getProduct  > "
                + Arrays.toString(productService.getArticulos()));
    }
}
