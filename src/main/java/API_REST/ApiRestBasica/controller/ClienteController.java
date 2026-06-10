package API_REST.ApiRestBasica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import API_REST.ApiRestBasica.model.entity.Cliente;
import API_REST.ApiRestBasica.service.ICliente;
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
    public Cliente create( @RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @GetMapping("cliente/{id}")
    public Cliente getById(@PathVariable Long id) {
        return clienteService.findById(id);
    }
    @DeleteMapping("cliente/{id}")
    public void delete( @PathVariable Long id) {
        Cliente cliente = clienteService.findById(id);
        clienteService.delete(cliente);
    }
    @PutMapping("cliente")
    public Cliente update(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }
}
