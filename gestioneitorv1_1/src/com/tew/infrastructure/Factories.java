package com.tew.infrastructure;

import impl.tew.business.SimpleServicesFactory;
import impl.tew.persistence.SimplePersistenceFactory;

import com.tew.persistence.PersistenceFactory;
import com.tew.business.ServicesFactory;
import com.tew.presentation.BeanAlumno;

/**
 * Esta clase es la que realemente relaciona las interfaces de las capas 
 * con sus implementaciones finales. Si se deben hacer cambios de implementaciï¿½ï¿½n
 * en algunas de las capas habrï¿½ï¿½a que retocar esta clase.
 * 
 * En desarrollos mas sofisticados esto se especificarï¿½ï¿½n en ficheros de 
 * configuraciï¿½ï¿½n lo que permitiria al "assembler" y "deployer" ajustar los 
 * ensamblajes entre capas sin necesidad de recompilar.
 * 		Assembler: forma la aplicaciï¿½ï¿½n a base de componentes 
 * 			desarrollados externamente
 * 		Deployer: Adapta la aplicaciï¿½ï¿½n, o reconfigura la aplicaciï¿½ï¿½n en 
 * 			explotaciï¿½ï¿½n a las mï¿½ï¿½quinas/contenedores (tiers/layers)
 * 
 * Hay frameworks especializados en eso precisamente, por ejemplo Spring.
 * 
 * @author Enrique
 *
 */
public class Factories {

	public static ServicesFactory services = new SimpleServicesFactory();
	public static PersistenceFactory persistence = new SimplePersistenceFactory();
	
	 // Agrega la factoría BeanAlumnoFactory
    public static BeanAlumno beanAlumnoFactory = new BeanAlumno();


}
