package south.repository;

import south.domain.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository {

    private static List<Client> clients;

    public static List<Client> getClients() {
        if (clients == null) {
            clients = new ArrayList<>();
        }
        return clients;
    }

}