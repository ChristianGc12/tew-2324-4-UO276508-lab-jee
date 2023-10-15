package com.tew.business;

import impl.tew.business.LoginService;

public interface ServicesFactory {
	
	AlumnosService createAlumnosService();

	LoginService createLoginService();

}
