package com.bootcamp.ejercicio1.interfaces;

import java.util.concurrent.ThreadLocalRandom;

public interface Ramdon {
  static Integer getRamdon() {
    Integer randomNum = ThreadLocalRandom.current().nextInt(0, 2);
    return randomNum;
  }
}
