package process.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import process.server.model.Person;
import process.server.service.StartProcessDemoService;

@RestController
@RequestMapping("/start-process")
public class StartProcessDemoController
{

    private final StartProcessDemoService startProcessDemoService;

    @Autowired
    public StartProcessDemoController(StartProcessDemoService startProcessDemoService)
    {
        this.startProcessDemoService = startProcessDemoService;
    }

    @PostMapping
    public void startProcess(@RequestBody Person person)
    {
        startProcessDemoService.startProcess(person);
    }
}
