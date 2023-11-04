import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import javax.ws.rs.client.WebTarget;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import javax.ws.rs.core.MediaType;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/gestioneitorv4_0/pisos.json");
		String result = target.request().get().readEntity(String.class);
		
		// Imprimimos todo el flujo JSON recibido en formato cadena.
        System.out.println("-----------TODOS----------------");
        System.out.println(result);
        
        // Procesamos el texto JSON y lo pasamos a formato SIMPLE-JSON
        Object obj = JSONValue.parse(result);
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray pisos = (JSONArray) jsonObject.get("apartamentos");
        
        // Imprimimos el tercer apartamento.
        System.out.println("----------- PISO ----------------");
        System.out.println(pisos.get(2).toString());
        
        // Accedemos a la "ubicacion" del tercer apartamento.
        JSONObject unPiso = (JSONObject) pisos.get(2);
        String ciudad = (String) unPiso.get("ubicacion");
        System.out.println("----------- CIUDAD DE UN PISO ----------------");
        System.out.println(ciudad);
        // Cerrar el cliente
        client.close();
        
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}