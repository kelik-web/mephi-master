package edu_mephi.demoexam.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Country {
 RUSSIA,
 USA,
 BRAZIL,
 ARMENIA,
 POLAND;

 @JsonCreator
 public static Country fromString(String value) {
  return Country.valueOf(value.toUpperCase());
 }
}
