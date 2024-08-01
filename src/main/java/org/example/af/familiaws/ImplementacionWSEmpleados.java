package af.familiaws;


import org.example.servicios.IServiciosEmpleados;

public class ImplementacionWSEmpleados implements IServiciosEmpleados {

    @Override
    public String[] getEmpleados() {
        return new String[]{"Juan", "Pedro", "Luis"};
    }
}
