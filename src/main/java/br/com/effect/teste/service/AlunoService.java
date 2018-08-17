package br.com.effect.teste.service;

import br.com.effect.teste.domain.Aluno;
import br.com.effect.teste.repository.AlunoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Service Implementation for managing Aluno.
 */
@Service
public class AlunoService {

    private final Logger log = LoggerFactory.getLogger(AlunoService.class);

    private final AlunoRepository alunoRepository;
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    /**
     * Save a aluno.
     *
     * @param aluno the entity to save
     * @return the persisted entity
     */
    public Aluno save(Aluno aluno) {
        log.debug("Request to save Aluno : {}", aluno);
        return alunoRepository.save(aluno);
    }

    /**
     *  Get all the alunos.
     *
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<Aluno> findAll() {
        log.debug("Request to get all Alunos");
        return alunoRepository.findAll();
    }

    /**
     *  Get one aluno by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public Aluno findOne(Long id) {
        log.debug("Request to get Aluno : {}", id);
        return alunoRepository.findOne(id);
    }

    /**
     *  Delete the  aluno by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Aluno : {}", id);
        alunoRepository.delete(id);
    }

}
