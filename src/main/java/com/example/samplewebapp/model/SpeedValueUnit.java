package com.example.samplewebapp.model;

import com.example.samplewebapp.model.unit.SpeedUnit;

public class SpeedValueUnit extends ValueUnit<Double, SpeedUnit> {
  public SpeedValueUnit() {
    super(0.0, SpeedUnit.KIRO_METER);
  }

  public SpeedValueUnit(Double value, SpeedUnit unit) {
    super(value, unit);
  }
}