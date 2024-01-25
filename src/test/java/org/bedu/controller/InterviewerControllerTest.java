package org.bedu.controller;

import org.bedu.dto.CreateInterviewerDTO;
import org.bedu.dto.InterviewerDTO;
import org.bedu.service.InterviewerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class InterviewerControllerTest {
    @MockBean
    private InterviewerService interviewerService;
    @Autowired
    private InterviewerController interviewerController ;


    @Test
    @DisplayName("El controlador debría ser injectado por Spring")
    void smokeTest() {
        assertNotNull(interviewerController,"Se injecto");
    }
    @Test
    @DisplayName("El controlador debría regresar una lista de entrevisatadores")
    void finAllTest() {
        //Arrage
        List<InterviewerDTO> fakedata = new LinkedList<>();
        InterviewerDTO fakeInterviwer = new InterviewerDTO();
        fakeInterviwer.setId(100);
        fakeInterviwer.setName("Erick Ríos");
        fakeInterviwer.setEmail("erick@gmail.com");
        fakedata.add(fakeInterviwer);

        //Simulando el resultado de ejecutar el método findAll()
        when(interviewerService.findAll()).thenReturn(fakedata);

        //act
        List<InterviewerDTO> result = interviewerController.findAll()  ;

        //Assert
        assertEquals(fakedata,result);
    }

    @Test
    @DisplayName("El controlador debería guardar un entrevistador")
    public void sveTest(){
        //arrage
        CreateInterviewerDTO dto = new CreateInterviewerDTO();
        dto.setName("ERICK rÍOS");
        dto.setEmail("erick@gmail.com");

        InterviewerDTO saved = new InterviewerDTO();
        saved.setId(200);
        saved.setName("ERICK rÍOS");
        saved.setEmail("erick@gmail.com");

        when(interviewerService.save(any(CreateInterviewerDTO.class))).thenReturn(saved);

        //act
        InterviewerDTO result = interviewerController.save(dto);

        //asserts
        assertNotNull(result);
        assertEquals(dto.getName(),result.getName());
        assertEquals(dto.getEmail(),result.getEmail());

    }
}