package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rabbitmq")
public class RabbitController {

    @Autowired
    RabbitMQService rabbitMQService;

    @Autowired
    MessageSource messageSource;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("empName") String empName,
                           @RequestParam("empId") String empId) {

        Employee emp=new Employee();
        emp.setEmpId(empId);
        emp.setEmpName(empName);
        rabbitMQService.send(emp);

        return "Producer has send messenger successfully";
    }

    @RequestMapping(value = "/get-greeting", method = RequestMethod.GET)
    public String greeting() {
        return messageSource.getMessage("good.morning", null, LocaleContextHolder.getLocale());
    }

    @RequestMapping(value = "/get-greeting-name", method = RequestMethod.GET)
    public String greetingWithName() {
        String[] params = new String[]{"Hiep ", " today"};
        return messageSource.getMessage("good.morning.name", params, LocaleContextHolder.getLocale());
    }

}