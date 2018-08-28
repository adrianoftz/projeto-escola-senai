package br.com.effect.teste.domain;


import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "matricula")
    private Integer matricula;

    @Column(name = "data_nascimento")
    private String dataNascimento;

    @ManyToMany
    @JoinTable(name = "aluno_turma",
            joinColumns = @JoinColumn(name="aluno_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="turma_id", referencedColumnName="id"))
    private Set<Turma> turmas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Set<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(Set<Turma> turmas) {
        this.turmas = turmas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Aluno aluno = (Aluno) o;
        if (aluno.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), aluno.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + getId() +
                ", nome='" + getNome() + "'" +
                ", matricula='" + getMatricula() + "'" +
                ", dataNascimento='" + getDataNascimento() + "'" +
                "}";
    }
}
