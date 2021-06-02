package co.edu.uniandes.carpetaciudadana.operador.controladores;

import co.edu.uniandes.carpetaciudadana.operador.dto.OperadorDto;
import co.edu.uniandes.carpetaciudadana.operador.dto.PeticionLoginDto;
import co.edu.uniandes.carpetaciudadana.operador.dto.RespuestaLoginDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/")
public class ControladorLogin {

    private static final String SEPARADOR =
            "\n===============================================================\n";

    @PostMapping("proveedor-identidad/login")
    public RespuestaLoginDto login(PeticionLoginDto peticion) {
        String token = UUID.randomUUID().toString();
        RespuestaLoginDto respuesta = new RespuestaLoginDto();
        respuesta.setToken(token);
        respuesta.setOperador(getOperador());
        imprimirLogsLogin(peticion, respuesta);
        return respuesta;
    }

    private void imprimirLogsLogin(PeticionLoginDto peticion, RespuestaLoginDto respuesta) {
        System.out.printf("%sOPERACION: Autenticacion y Autorizacion.%s\n",
                SEPARADOR, SEPARADOR);
        System.out.printf("Usuario: [%s]\nToken Generado: [%s]\n", peticion.getUsername(), respuesta.getToken());
        System.out.printf("Operador Autorizado: \n\t- Codigo: [%s]\n\t- Nombre: [%s]",
                respuesta.getOperador().getCodigoOperador(), respuesta.getOperador().getNombreOperador());
        System.out.println(SEPARADOR);
    }

    private static OperadorDto getOperador() {
        OperadorDto operador = new OperadorDto();
        operador.setCodigoOperador("MC_002");
        operador.setNombreOperador("MI CARPETA");
        return operador;
    }
}
