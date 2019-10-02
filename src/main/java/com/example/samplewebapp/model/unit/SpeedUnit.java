package com.example.samplewebapp.model.unit;

import java.util.stream.Stream;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SpeedUnit {
  KIRO_METER("km"),
  FEET("ft");

  private final String text;

  private SpeedUnit(final String text) {
    this.text = text;
  }

  @JsonValue
  public String getString() {
      return this.text;
  }

  @JsonCreator
  public static SpeedUnit create(String value) {
      if (value == null) {
          return null;
      }
      return Stream.of(values())
              .filter(v -> value.equals(v.getString()))
              .findFirst()
              .orElseThrow(() -> new IllegalArgumentException());
  }
}