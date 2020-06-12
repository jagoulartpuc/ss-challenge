package south.service;

import south.repository.ClientRepository;

public class ClientService {

    private ClientRepository clientRepository = new ClientRepository();

    public int getTotalClients() {
        return ClientRepository.getClients().size();
    }
}
