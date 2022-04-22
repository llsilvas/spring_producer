package br.dev.leandro.spring.producer.controller;

import br.dev.leandro.spring.producer.dto.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import javax.jms.Queue;


@RestController
@RequestMapping("/produce")
public class Producer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    @PostMapping("/message")
    public Student sendMessage(@RequestBody Student student){
        try {
            ObjectMapper mapper = new ObjectMapper();
            String studentAsJson = mapper.writeValueAsString(student);
            jmsTemplate.convertAndSend(queue, studentAsJson);
        }catch (Exception e){
            e.printStackTrace();
        }
        return student;
    }

    @PostMapping("/prod/{number}")
    public void criaMessage(@PathVariable Long number){
        try{
            for (int i = 0; i < number; i++) {
                Student student = Student.builder().studentId(String.valueOf(i)).name("Teste" + i).rollNumber("Teste Roll" + i).build();
                ObjectMapper mapper = new ObjectMapper();
                String studentAsJson = mapper.writeValueAsString(student);
                jmsTemplate.convertAndSend(queue, studentAsJson);
            }
        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
