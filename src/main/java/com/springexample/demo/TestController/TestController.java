package com.springexample.demo.TestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springexample.demo.Dto.TestDto;
import com.springexample.demo.Service.CalculateSumOfFruitReentrantLock;
import com.springexample.demo.Service.CounterServiceSynchronized;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class TestController {

    @Autowired
    CalculateSumOfFruitReentrantLock calculateSumOfFruitReentrantLock;

    @Autowired
    CounterServiceSynchronized counterServiceSynchronized;

    @PostMapping("/calculateSumOfFruitLock")
    public ResponseEntity<Integer> calculateSumOfFruit(
      @RequestBody final TestDto testDto) {

         log.info("calculateSumOfFruitLock: ...");
         if (testDto != null) {
               switch(testDto.getFruitType()){
                  case "1" : // apple
                     calculateSumOfFruitReentrantLock.add(10);
                     break;
                  case "2" : // banana
                     calculateSumOfFruitReentrantLock.add(20);
                     break;
                  case "3" : // orange
                     calculateSumOfFruitReentrantLock.add(30);
                     break;
                  default:
                     break;
               }
               return ResponseEntity.ok(calculateSumOfFruitReentrantLock.getCount());
         }
         return null;

      }

   @PostMapping("/calculateSumOfFruitSynchronized")
    public ResponseEntity<Integer> calculateSumOfFruitSynchronized(
      @RequestBody final TestDto testDto) {

         if (testDto != null) {
               switch(testDto.getFruitType()){
                  case "1" : // apple
                     counterServiceSynchronized.add(10);
                     break;
                  case "2" : // banana
                     counterServiceSynchronized.add(20);
                     break;
                  case "3" : // orange
                     counterServiceSynchronized.add(30);
                     break;
                  default:
                     break;
               }
               return ResponseEntity.ok(counterServiceSynchronized.getCount());
         }
         return null;

      }

}
