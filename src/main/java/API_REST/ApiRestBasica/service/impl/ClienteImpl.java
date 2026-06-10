package API_REST.ApiRestBasica.service.impl;
import API_REST.ApiRestBasica.service.ICliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import API_REST.ApiRestBasica.model.entity.Cliente;
import API_REST.ApiRestBasica.model.entity.dao.ClienteDao;

@Service
public class ClienteImpl implements ICliente {

    @Autowired
    private ClienteDao clienteDao;

    @Transactional(readOnly = true)//readonly para indicar que es una consulta, no una modificacion
    @Override
    public Cliente findById(Long id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Transactional //para manejar transacciones, en este caso para guardar un cliente
    @Override
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Transactional
    @Override 
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }
    
}
