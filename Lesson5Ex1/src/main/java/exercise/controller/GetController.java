package exercise.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import exercise.template.GetTemplate;

import javax.servlet.http.HttpServletRequest;


@RestController
public class GetController {
    @GetMapping("/hello")
    public ResponseEntity getHello (HttpServletRequest request){
        String messageR = "";
        GetTemplate objMessage = new GetTemplate();
        messageR = objMessage.getStrJsonHello();

        return new ResponseEntity(messageR, HttpStatus.OK);
    }
}
