package br.com.dianome.entregadores.repositories;

import br.com.dianome.entregadores.models.EntregadorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregadorRepository extends JpaRepository<EntregadorModel, Integer>{
}
