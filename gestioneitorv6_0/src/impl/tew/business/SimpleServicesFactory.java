package impl.tew.business;


import com.tew.business.AlumnosServices;
import com.tew.business.LoginService;
import com.tew.business.ServicesFactory;

public class SimpleServicesFactory implements ServicesFactory {

	@Override
	public AlumnosServices createAlumnosService() {
		return new SimpleAlumnosService();
	}

	@Override
	public LoginService createLoginService() {
		// TODO Auto-generated method stub
		
		return new SimpleLoginService();	
	}

}
