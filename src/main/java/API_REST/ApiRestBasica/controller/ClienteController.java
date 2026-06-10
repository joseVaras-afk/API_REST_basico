package API_REST.ApiRestBasica.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import API_REST.ApiRestBasica.model.entity.Cliente;
import API_REST.ApiRestBasica.model.entity.dto.ClienteDto;
import API_REST.ApiRestBasica.service.ICliente;
import API_REST.ApiRestBasica.model.payload.MesajeResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ICliente clienteService;
    
    @PostMapping("cliente")
    public ResponseEntity<?> create( @RequestBody ClienteDto clienteDto) {
        try{
        Cliente clienteSave = clienteService.save(clienteDto);
        return new ResponseEntity<>(MesajeResponse.builder()
                .mensaje("Cliente creado con exito")
                .object(clienteSave)
                .build(), HttpStatus.CREATED);

        }catch(DataAccessException exDt){
            return new ResponseEntity<>(MesajeResponse.builder()
                    .mensaje("Error al crear el cliente: " + exDt.getMessage())
                    .object(null)
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @GetMapping("cliente/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            Cliente cliente = clienteService.findById(id);
            if (cliente==null) {
                return new ResponseEntity<>(MesajeResponse.builder()
                        .mensaje("Cliente no encontrado con id: " + id)
                        .object(null)
                        .build(), HttpStatus.NOT_FOUND);
                
            }
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(MesajeResponse.builder()
                    .mensaje("Error al obtener el cliente: " + exDt.getMessage())
                    .object(null)
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("cliente/{id}")
    public ResponseEntity<?> delete( @PathVariable Long id) {
        try {
            clienteService.delete(clienteService.findById(id));
            return new ResponseEntity<>(MesajeResponse.builder()
                    .mensaje("Cliente eliminado con exito")
                    .object(null)
                    .build(), HttpStatus.NO_CONTENT);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(MesajeResponse.builder()
                    .mensaje("Error al eliminar el cliente: " + exDt.getMessage())
                    .object(null)
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    
    }
    @PutMapping("cliente")
    public ResponseEntity<?> update(@RequestBody ClienteDto clienteDto) {
        try {
        Cliente clienteUpdate = clienteService.save(clienteDto);
        return new ResponseEntity<>(MesajeResponse.builder()
                .mensaje("Cliente actualizado con exito")
                .object(clienteUpdate)
                .build(), HttpStatus.OK);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(MesajeResponse.builder()
                    .mensaje("Error al actualizar el cliente: " + exDt.getMessage())
                    .object(null)
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        
    }
}
