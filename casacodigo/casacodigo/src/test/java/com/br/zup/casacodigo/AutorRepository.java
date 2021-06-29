package com.br.zup.casacodigo;

import com.br.zup.casacodigo.autor.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository <Autor, Long> {


}
