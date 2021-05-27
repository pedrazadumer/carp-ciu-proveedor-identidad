package co.edu.uniandes.carpetaciudadana.operador.controladores;

import co.edu.uniandes.carpetaciudadana.operador.dto.PeticionLoginDto;
import co.edu.uniandes.carpetaciudadana.operador.dto.RespuestaLoginDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/")
public class ControladorLogin {

    public static final String SEPARADOR =
            "\n===============================================================\n";

    @PostMapping("proveedor-identidad/login")
    public RespuestaLoginDto login(PeticionLoginDto peticion) {
        String token = UUID.randomUUID().toString();
        RespuestaLoginDto respuesta = new RespuestaLoginDto();
        System.out.printf("%sSe ha generado un nuevo token.\nUsuario: [%s]\nToken: [%s]%s",
                SEPARADOR, peticion.getUsername(), token, SEPARADOR);
        System.out.println();
        respuesta.setToken(token);
        return respuesta;
    }
}
