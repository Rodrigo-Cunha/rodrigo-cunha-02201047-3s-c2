package br.com.bandtec.AC2PWrodrigo_cunha.Repositorio;

import br.com.bandtec.AC2PWrodrigo_cunha.Dominio.Lutador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LutadorRepository extends JpaRepository<Lutador, Integer> {

    List<Lutador> findAllByOrderByForcaGolpeDesc();
    long countAllByVivoTrue();

}
