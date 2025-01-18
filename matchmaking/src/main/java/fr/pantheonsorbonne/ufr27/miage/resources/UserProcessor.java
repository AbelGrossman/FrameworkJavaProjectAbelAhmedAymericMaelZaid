package fr.pantheonsorbonne.ufr27.miage.resources;

import fr.pantheonsorbonne.ufr27.miage.dto.User;
import fr.pantheonsorbonne.ufr27.miage.service.QueueManager;
import fr.pantheonsorbonne.ufr27.miage.service.UserEmitter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
@Named("UserProcessor")
public class UserProcessor {

    @Inject 
    UserEmitter userEmitter;

    public void processNewUser(User user) {
        // Add the incoming player to the queue
        userEmitter.processRankedUser(user);
    }
}
