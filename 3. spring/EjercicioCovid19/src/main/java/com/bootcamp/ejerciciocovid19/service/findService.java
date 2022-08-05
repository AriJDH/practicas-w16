package com.bootcamp.ejerciciocovid19.service;

import com.bootcamp.ejerciciocovid19.dto.*;
import com.bootcamp.ejerciciocovid19.entities.Person;
import com.bootcamp.ejerciciocovid19.entities.Symphtom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@Setter
@Service
public class findService {

    private List<Person> person;
    private List<Symphtom> symphtom;

    public findService() {
        this.person = loadPersonList();
        this.symphtom = loadSymphotms();
    }

    public List<Person> loadPersonList() {
        List<Person> p = new ArrayList<>();
        p.add(new Person(1, "Luis", "Suarez", 35));
        p.add(new Person(2, "Maria", "Flores", 65));
        p.add(new Person(3, "José", "Benavidez", 90));
        p.add(new Person(4, "Luisina", "Flores", 18));
        return p;
    }

    public List<Symphtom> loadSymphotms() {
        List<Symphtom> s = new ArrayList<>();
        s.add(new Symphtom(121, "Cough", "Middle"));
        s.add(new Symphtom(223, "No taste or smell", "Very High"));
        s.add(new Symphtom(331, "fever", "High"));
        s.add(new Symphtom(211, "fatigue", "middle"));
        s.add(new Symphtom(111, "headache", "low"));
        return s;

    }


    public ResponseEntity<ResponseSymphotmsDto> getSymphtomsDto() {
        List<SymphtomDto> s = this.symphtom.stream()
                .map(symphtom -> new SymphtomDto(symphtom.getName(), symphtom.getDangerLevel()))
                .collect(Collectors.toList());
        if (s.size() > 0) {
            ResponseSymphotmsDto response = new ResponseSymphotmsDto(s,"ok");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            s.add(new SymphtomDto("", ""));
            ResponseSymphotmsDto response = new ResponseSymphotmsDto(s,"No symphotms found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<SymphtomDtoMessage> getSymphtomsByName(String name) {
        Optional<Symphtom> symphtom = this.symphtom.stream()
                .filter(symphtom1 -> symphtom1.getName().equals(name))
                .findFirst();
        if (symphtom.isPresent()) {
            SymphtomDtoMessage dto = new SymphtomDtoMessage(symphtom.get().getName(), symphtom.get().getDangerLevel(), "ok");
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            SymphtomDtoMessage dto = new SymphtomDtoMessage("", "", "No sympthom found with the name '" + name+"'");
            return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity<ResponseRiskPersonDto> getRiskPersons(){
        List<RiskPersonDto> riskPersonDtos = this.person.stream()
                .filter(person1 -> person1.getAge()>60)
                .map(person2-> new RiskPersonDto(person2.getName(), person2.getSubName(),person2.getAge()))
                .collect(Collectors.toList());

if(riskPersonDtos.size()>0){
    ResponseRiskPersonDto response = new ResponseRiskPersonDto(riskPersonDtos,"Ok");
    return new ResponseEntity<>(response,HttpStatus.OK);
}else{
    ResponseRiskPersonDto response = new ResponseRiskPersonDto(riskPersonDtos,"Not found");
    return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
}


    }

}
