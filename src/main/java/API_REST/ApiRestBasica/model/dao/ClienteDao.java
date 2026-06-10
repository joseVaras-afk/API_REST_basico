package API_REST.ApiRestBasica.model.dao;

import org.springframework.data.repository.CrudRepository;

import API_REST.ApiRestBasica.model.entity.Cliente;

public interface ClienteDao extends CrudRepository<Cliente, Long> {

    
} 