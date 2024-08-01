package org.example.af.familiarest;

import org.example.servicios.IServiciosEmpleados;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class ImplementacionRestEmpleados implements IServiciosEmpleados {

    @Override
    public String[] getEmpleados() {
        try {
            // URL del servicio REST que proporciona los empleados
            URL url = new URL("https://jsonplaceholder.typicode.com/users");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Leer la respuesta del servicio REST
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            // Cerrar el stream y desconectar la conexión
            in.close();
            conn.disconnect();

            // En este ejemplo, simplemente devolvemos el contenido como un único elemento en el array
            // En una implementación real, deberías parsear el JSON y extraer los empleados
            return new String[]{content.toString()};
        } catch (Exception e) {
            e.printStackTrace();
            return new String[]{"Error al obtener empleados"};
        }
    }
}
