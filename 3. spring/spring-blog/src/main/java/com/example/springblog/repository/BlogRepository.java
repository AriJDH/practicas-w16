package com.example.springblog.repository;

import com.example.springblog.model.EntradaBlog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Repository
public class BlogRepository implements IBlogRepository {
    List<EntradaBlog> entradaBlog = new ArrayList<>();

    @Override
    public Integer cargar(EntradaBlog entradaBlog) {
        this.entradaBlog.add(entradaBlog);
        return entradaBlog.getId();
    }

    @Override
    public List<EntradaBlog> getAll() {
        return this.entradaBlog;
    }
}
