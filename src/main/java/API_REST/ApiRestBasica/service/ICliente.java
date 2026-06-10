package API_REST.ApiRestBasica.service;
import API_REST.ApiRestBasica.model.entity.Cliente;

public interface ICliente {

    Cliente save(Cliente cliente);

    Cliente findById(Long id);

    void delete(Cliente cliente);

    
} 