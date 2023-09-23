<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calculadora</title>
</head>
<body>
    <h1>Calculadora</h1>
    <form action="Calculadora.jsp" method="post">
        <label for="numero1">Número 1:</label>
        <input type="text" name="numero1" required><br>
        
        <label for="numero2">Número 2:</label>
        <input type="text" name="numero2" required><br>
        
        <label for="operacion">Operación:</label>
        <select name="operacion">
            <option value="suma">Suma</option>
            <option value="resta">Resta</option>
            <option value="producto">Producto</option>
            <option value="division">División</option>
        </select><br>
        
        <input type="submit" value="Calcular">
    </form>
    
    <%
        String numero1Str = request.getParameter("numero1");
        String numero2Str = request.getParameter("numero2");
        String operacion = request.getParameter("operacion");
        int resultado = 0;
        
        if (numero1Str != null && numero2Str != null && operacion != null) {
            try {
                int numero1 = Integer.parseInt(numero1Str);
                int numero2 = Integer.parseInt(numero2Str);
                
                switch (operacion) {
                    case "suma":
                        resultado = numero1 + numero2;
                        break;
                    case "resta":
                        resultado = numero1 - numero2;
                        break;
                    case "producto":
                        resultado = numero1 * numero2;
                        break;
                    case "division":
                        if (numero2 != 0) {
                            resultado = numero1 / numero2;
                        } else {
                            out.println("Error: División por cero.");
                        }
                        break;
                    default:
                        out.println("Operación no válida.");
                }
            } catch (NumberFormatException e) {
                out.println("Error: Ingresa números enteros válidos.");
            }
        }
    %>
    
    <h2>Resultado:</h2>
    <%= resultado %>
</body>
</html>
