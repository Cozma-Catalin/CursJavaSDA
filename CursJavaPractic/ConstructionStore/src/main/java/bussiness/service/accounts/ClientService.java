package bussiness.service.accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistance.dao.accounts.ClientDAO;

@Service
public class ClientService {
    @Autowired
    ClientDAO clientDAO;
}
