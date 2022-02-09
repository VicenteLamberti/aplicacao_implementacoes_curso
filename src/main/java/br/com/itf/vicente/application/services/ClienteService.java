package br.com.itf.vicente.application.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.itf.vicente.application.model.Cliente;
import br.com.itf.vicente.application.repositories.ClienteRepository;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;
	
	public ClienteService(ClienteRepository clienteRepository) {
	
		this.clienteRepository = clienteRepository;
	}
	
	public void salvar(Cliente cliente) {
		this.clienteRepository.save(cliente);
		System.out.println("Cliente salvo");
	}
	
	public Cliente buscarPorId(Long id) {
		Optional<Cliente> objCliente = clienteRepository.findById(id);
		return objCliente.orElse(null);
	}
}
