package com.example.samplewebapp.model;

import javax.validation.constraints.NotNull;

public abstract class ValueUnit<V, U> {
  @NotNull
  private V value;
  @NotNull
  private U unit;
  public ValueUnit(V value, U unit) {
    this.value = value;
    this.unit = unit;
  }

  public V getValue() {
    return this.value;
  }

  public void setValue(V value) {
    this.value = value;
  }

  public U getUnit() {
    return this.unit;
  }

  public void setUnit(U unit) {
    this.unit = unit;
  }
}