package API_REST.ApiRestBasica.service;
import API_REST.ApiRestBasica.model.entity.Cliente;
import API_REST.ApiRestBasica.model.entity.dto.ClienteDto;

public interface ICliente {

    Cliente save(ClienteDto clienteDto);

    Cliente findById(Long id);

    void delete(Cliente cliente);


} 