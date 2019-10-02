package com.example.samplewebapp.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.samplewebapp.model.SpeedValueUnit;

@RestController
@RequestMapping("/api/speed")
public class SpeedController {
  @RequestMapping(method = RequestMethod.GET)
  public SpeedValueUnit get() {
    return new SpeedValueUnit();
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<SpeedValueUnit> post(@RequestBody SpeedValueUnit valueUnit) {
    return new ResponseEntity<SpeedValueUnit>(new SpeedValueUnit(valueUnit.getValue(), valueUnit.getUnit()), null, HttpStatus.CREATED);
  }
}