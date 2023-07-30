package com.dev.socialPoll.service.impl;

import com.dev.socialPoll.entity.Topic;
import com.dev.socialPoll.exception.ServiceException;
import com.dev.socialPoll.service.TopicService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TopicServiceTest {

    private static TopicService topicService;

    @BeforeAll
    static void setUp() {
        topicService = new TopicServiceImpl();
    }

    @Test
    void testRetrieveTopics_ShouldReturnListOfTopics() throws ServiceException {
        List<Topic> resultTopics = topicService.retrieveTopics();

        // Verify the result
        assertEquals(4, resultTopics.size());
        assertEquals("Politics", resultTopics.get(0).getTopicName());
        assertEquals("Polls related to political topics and government policies.", resultTopics.get(0).getDescription());
        assertEquals("Environment", resultTopics.get(1).getTopicName());
        assertEquals("Polls related to environmental issues and sustainability.", resultTopics.get(1).getDescription());
    }

    @Test
    void testRetrieveTopicById_ShouldReturnTopic() throws ServiceException {
        // Call the service method with topicId = 1
        int topicId = 1;
        Optional<Topic> resultTopicOptional = topicService.retrieveTopicById(topicId);

        // Verify the result
        assertTrue(resultTopicOptional.isPresent());
        Topic resultTopic = resultTopicOptional.get();
        assertEquals(topicId, resultTopic.getId());
        assertEquals("Family", resultTopic.getTopicName());
        assertEquals("Polls related to family matters and relationships.", resultTopic.getDescription());

        // Call the service method with topicId = 100 (non-existing topic)
        topicId = 100;
        resultTopicOptional = topicService.retrieveTopicById(topicId);

        // Verify the result
        assertFalse(resultTopicOptional.isPresent());
    }

}
