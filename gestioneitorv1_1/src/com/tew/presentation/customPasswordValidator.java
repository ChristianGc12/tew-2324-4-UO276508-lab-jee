package com.tew.presentation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.faces.application.FacesMessage.Severity;
import java.awt.Color;

@FacesValidator("customPasswordValidator")
public class customPasswordValidator implements Validator {
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String password = (String) value;
        String confirmPassword = (String) component.getAttributes().get("password");

        if (password != null && !password.equals(confirmPassword)) {
            // Las contraseñas no coinciden, lanzamos una excepción con un mensaje de error
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Las contraseñas no coinciden.", null);
            context.addMessage(component.getClientId(context), message);
            
            // Establecemos un estilo de borde rojo en el campo
            component.getAttributes().put("style", "border: 1px solid red;");
        }
    }
}
