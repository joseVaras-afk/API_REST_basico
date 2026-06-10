package API_REST.ApiRestBasica.model.entity.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ClienteDto implements Serializable {

    private Long id;
    private String nombre;
    private String correo;
    private String telefono;
    
}
