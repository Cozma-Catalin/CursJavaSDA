package business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.JanitorDAO;

@Service
public class JanitorService {
    @Autowired
    JanitorDAO janitorDAO;
}
