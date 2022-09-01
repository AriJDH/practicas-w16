package com.example.testers.service;

import com.example.testers.dao.ITesterDAO;
import com.example.testers.dto.TestCaseDTO;
import com.example.testers.model.TestCase;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TesterService implements ITesterService {

    @Autowired
    ITesterDAO iTesterDAO;

    ModelMapper mapper;

    public TesterService() {
        this.mapper = new ModelMapper();
    }

    @Override
    public TestCaseDTO crearTest(TestCaseDTO testdto){
        TestCase testCase = iTesterDAO.save(mapper.map(testdto, TestCase.class));
        return mapper.map(testCase,TestCaseDTO.class);
    }

    @Override
    public List<TestCaseDTO> recuperarTests() {
        return iTesterDAO.findAll()
                .stream()
                .map(x->mapper.map(x,TestCaseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TestCaseDTO recuperarTestById(Long id) {
        TestCase testCase = iTesterDAO.getReferenceById(id);
        return mapper.map(testCase,TestCaseDTO.class);
    }

    @Override
    public TestCaseDTO actualizarTestById(TestCaseDTO testdto, Long id) {

        TestCase testCase = iTesterDAO.getReferenceById(id);
        testCase.setTested(testdto.getTested());
        testCase.setDescription(testdto.getDescription());
        testCase.setLastUpdate(testdto.getLastUpdate());
        testCase.setPassed(testdto.getPassed());
        testCase.setNumberOfTries(testdto.getNumberOfTries());
        iTesterDAO.save(testCase);

        return mapper.map(testCase, TestCaseDTO.class);
    }

    @Override
    public String eliminatTestById(Long id) {

        iTesterDAO.deleteById(id);
        return "se ha eliminado el caso de uso";
    }

    @Override
    public List<TestCaseDTO> recuperarTestActualizadosPorFecha(LocalDate localDate) {

        //SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        //Date fecha = formato.parse(localDate);

        return iTesterDAO.findAll()
                .stream()
                .filter(x->x.getLastUpdate().isAfter(localDate))
                .map(x->mapper.map(x,TestCaseDTO.class))
                .collect(Collectors.toList());

    }

}
