package com.example.backend.Controller;

import com.example.backend.CounterRepository;
import com.example.backend.Entities.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CounterController {

    @Autowired
    private CounterRepository counterRepository;

    @GetMapping(path = "/counter/{id}")
    @ResponseBody long getCounter(@PathVariable long id){
        Optional<Counter> optCounter = counterRepository.findById(id);
        if(optCounter.isEmpty()){
            return 0;
        }else{
            return optCounter.get().getCounter();
        }
    }

    @PostMapping(path = "/counter/{id}")
    @ResponseBody long insertCounter(@PathVariable long id){
        long currentCounter = getCounter(id);
        long newCounter = currentCounter + 1;
        if(currentCounter == 0){
            counterRepository.save(new Counter(id, newCounter));
        }else{
            counterRepository.updateCounter(id, newCounter);
        }
        System.out.println(newCounter);
        return newCounter;
    }
}
