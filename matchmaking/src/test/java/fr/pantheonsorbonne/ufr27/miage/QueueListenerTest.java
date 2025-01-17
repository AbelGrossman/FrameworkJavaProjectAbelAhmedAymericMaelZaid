package fr.pantheonsorbonne.ufr27.miage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import fr.pantheonsorbonne.ufr27.miage.dto.User;
import fr.pantheonsorbonne.ufr27.miage.resources.QueueListener;
import fr.pantheonsorbonne.ufr27.miage.service.QueueManager;

import static org.mockito.Mockito.*;

class QueueListenerTest {

    private QueueListener queueListener;
    private QueueManager mockQueueManager;

    @BeforeEach
    void setUp() {
        mockQueueManager = Mockito.mock(QueueManager.class);
        queueListener = new QueueListener(mockQueueManager);
    }

    @Test
    void testOnPlayerAddedToQueue() {
        User user = new User("1", "Geography", 1000);

        queueListener.onPlayerAddedToQueue(user);

        // Verify that addPlayerToQueue was called
        verify(mockQueueManager, times(1)).addPlayerToQueue(user);
    }
}