package business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.SubscriptionDAO;

@Service
public class SubscriptionService {

    @Autowired
    SubscriptionDAO subscriptionDAO;
}
