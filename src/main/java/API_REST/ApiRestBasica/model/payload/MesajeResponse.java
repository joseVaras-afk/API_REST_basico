package API_REST.ApiRestBasica.model.payload;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString 
@Builder
public class MesajeResponse implements Serializable {

    private String mensaje;
    private Object object;
}
