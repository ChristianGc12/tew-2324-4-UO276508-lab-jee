import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/gestioneitorv4_0/pisos.json");
		String result = target.request().get().readEntity(String.class);
		System.out.println(result);
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}