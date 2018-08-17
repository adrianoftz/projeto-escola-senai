package br.com.effect.teste.service;

import br.com.effect.teste.domain.Turma;
import br.com.effect.teste.repository.TurmaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Service Implementation for managing Turma.
 */
@Service
public class TurmaService {

    private final Logger log = LoggerFactory.getLogger(TurmaService.class);

    private final TurmaRepository turmaRepository;
    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    /**
     * Save a turma.
     *
     * @param turma the entity to save
     * @return the persisted entity
     */
    public Turma save(Turma turma) {
        log.debug("Request to save Turma : {}", turma);
        return turmaRepository.save(turma);
    }

    /**
     *  Get all the turmas.
     *
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<Turma> findAll() {
        log.debug("Request to get all Turmas");
        return turmaRepository.findAll();
    }

    /**
     *  Get one turma by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public Turma findOne(Long id) {
        log.debug("Request to get Turma : {}", id);
        return turmaRepository.findOne(id);
    }

    /**
     *  Delete the  turma by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Turma : {}", id);
        turmaRepository.delete(id);
    }

}
