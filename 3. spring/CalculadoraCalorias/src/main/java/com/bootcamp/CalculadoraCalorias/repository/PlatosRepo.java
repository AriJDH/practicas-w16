package com.bootcamp.CalculadoraCalorias.repository;

import com.bootcamp.CalculadoraCalorias.dto.IngredienteDTO;
import com.bootcamp.CalculadoraCalorias.dto.PlatoDTO;
import com.bootcamp.CalculadoraCalorias.entities.Plato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PlatosRepo {
    String[] ingredientesCazuela = {"Papas cocidas", "Pollo", "Porotos verdes", "Arroz blanco"};
    String[] ingredientesArrozConPollo = {"Pollo", "Arroz blanco", "Perejil", "Pimiento", "Huevo duro"};
    String[] ingredientesCarbonada = {"Pollo", "Cebolla", "Zanahoria", "Arroz blanco", "Pimiento", "Ajos", "Perejil"};
    IngredientesRepo ingredientesRepo = new IngredientesRepo();

    List<PlatoDTO> platosDTO = new ArrayList<>(Arrays.asList(
            new PlatoDTO("Cazuela", 300, ingredientesRepo.listaIngredientes(ingredientesCazuela),
                    ingredientesRepo.totalCalorias(ingredientesRepo.listaIngredientes(ingredientesCazuela)),
                    ingredientesRepo.masCalorico(ingredientesRepo.listaIngredientes(ingredientesCazuela))),
            new PlatoDTO("Arroz con pollo", 200, ingredientesRepo.listaIngredientes(ingredientesArrozConPollo),
                    ingredientesRepo.totalCalorias(ingredientesRepo.listaIngredientes(ingredientesArrozConPollo)),
                    ingredientesRepo.masCalorico(ingredientesRepo.listaIngredientes(ingredientesArrozConPollo))),
            new PlatoDTO("Carbonada", 400, ingredientesRepo.listaIngredientes(ingredientesCarbonada),
                    ingredientesRepo.totalCalorias(ingredientesRepo.listaIngredientes(ingredientesCarbonada)),
            ingredientesRepo.masCalorico(ingredientesRepo.listaIngredientes(ingredientesCarbonada)))
    ));

    public PlatoDTO MostrarPlato(String name){
        return platosDTO.stream()
                .filter(platoDTO -> platoDTO.getName().equals(name))
                .findFirst().get();
    }

    public List<PlatoDTO> listarPlatos(String platillo1, String platillo2, String platillo3){
        String[] platillos = {platillo1, platillo2, platillo3};
        List<PlatoDTO> platos = new ArrayList<>();
        for (String dishes: platillos){
            PlatoDTO platoDTO = platosDTO.stream()
                    .filter(value -> value.getName().equalsIgnoreCase(dishes))
                    .findFirst().get();
            platos.add(platoDTO);
        }
        return platos;
    }
}
