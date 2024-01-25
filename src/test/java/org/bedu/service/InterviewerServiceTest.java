package org.bedu.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class InterviewerServiceTest {
    @Autowired
    InterviewerService interviewerService;
    @Test
    @DisplayName("Service should be injected")
    public void smokeTest(){
        assertNotNull(interviewerService);
    }
}