package com.bootcamp.ejerciciocovid19.repositories;

import com.bootcamp.ejerciciocovid19.entities.Symptom;

import java.util.ArrayList;
import java.util.List;

public class SymptomRepository {
   private static List<Symptom> symptoms = new ArrayList<>();

   public static List<Symptom> getAllSymptoms() {
      Symptom symptom1  = new Symptom("sym1",  "Fever", 1);
      Symptom symptom2  = new Symptom("sym2",  "Cough", 1);
      Symptom symptom3  = new Symptom("sym3",  "Fatigue", 1);
      Symptom symptom4  = new Symptom("sym4",  "Loss of taste or smell", 1);
      Symptom symptom5  = new Symptom("sym5",  "Sore throat", 2);
      Symptom symptom6  = new Symptom("sym6",  "Headache", 2);
      Symptom symptom7  = new Symptom("sym7",  "Aches and pains", 2);
      Symptom symptom8  = new Symptom("sym8",  "Diarrhea", 2);
      Symptom symptom9  = new Symptom("sym9",  "Skin rash", 2);
      Symptom symptom10 = new Symptom("sym10", "Irritated eyes", 2);
      Symptom symptom11 = new Symptom("sym11", "Shortness of breath", 3);
      Symptom symptom12 = new Symptom("sym12", "Loss of mobility or speech or feeling confused", 3);
      Symptom symptom13 = new Symptom("sym13", "Chest pain", 3);
      symptoms.add(symptom1);
      symptoms.add(symptom2);
      symptoms.add(symptom3);
      symptoms.add(symptom4);
      symptoms.add(symptom5);
      symptoms.add(symptom6);
      symptoms.add(symptom7);
      symptoms.add(symptom8);
      symptoms.add(symptom9);
      symptoms.add(symptom10);
      symptoms.add(symptom11);
      symptoms.add(symptom12);
      symptoms.add(symptom13);


      return symptoms;
   }
}
