package impl.tew.business.resteasy;

import java.util.List;

import javax.ws.rs.NotAuthorizedException;

import com.tew.business.exception.EntityAlreadyExistsException;
import com.tew.business.exception.EntityNotFoundException;
import com.tew.business.resteasy.AlumnosServicesRs;
import com.tew.infrastructure.GestorSesion;
import com.tew.model.Alumno;
import com.tew.model.AlumnoRequestData;

import impl.tew.business.classes.AlumnosAlta;
import impl.tew.business.classes.AlumnosBaja;
import impl.tew.business.classes.AlumnosBuscar;
import impl.tew.business.classes.AlumnosListado;
import impl.tew.business.classes.AlumnosUpdate;

public class AlumnosServicesRsImpl implements AlumnosServicesRs {

	@Override
	public List<Alumno> getAlumnos() {
		try {
			return new AlumnosListado().getAlumnos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


	public void saveAlumno(Alumno alumno) throws EntityAlreadyExistsException {
		new AlumnosAlta().save(alumno);
	}

	@Override
	public void updateAlumno(Alumno alumno) throws EntityNotFoundException {
		new AlumnosUpdate().update(alumno);
	}


	public void deleteAlumno(Long id) throws EntityNotFoundException {
		new AlumnosBaja().delete(id);
	}

	@Override
	public Alumno findById(Long id) throws EntityNotFoundException {
		return new AlumnosBuscar().find(id);
	}

	@Override
	public void deleteAlumno(Long id, String token) throws EntityNotFoundException, NotAuthorizedException {
		if (GestorSesion.getInstance().comprobarToken(token) != null)
			this.deleteAlumno(id);

	}

	@Override
	public void saveAlumno(AlumnoRequestData alumno) throws EntityAlreadyExistsException {
		if (GestorSesion.getInstance().comprobarToken(alumno.getToken()) != null)
			this.saveAlumno(new Alumno(alumno.getId(), alumno.getNombre(),alumno.getApellidos(),
					alumno.getIduser(),alumno.getEmail()));
	}
}
