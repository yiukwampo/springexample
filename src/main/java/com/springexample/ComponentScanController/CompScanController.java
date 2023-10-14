package com.springexample.ComponentScanController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CompScanController {

   @GetMapping("/querycontroller") 
   public ResponseEntity<String> calculateSumOfFruit() {
      log.info("querycontroller: ...");
         return ResponseEntity.ok("Test CompScanController");
   }

}
