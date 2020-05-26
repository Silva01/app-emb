package app.embadm.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "materia")
public class MateriaEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotBlank
    private String nome;

    private String descricao;
    private Boolean ativo;

    @ManyToMany
    @JoinTable(name = "materiasPessoas",
    joinColumns = {@JoinColumn(name = "idMateria")},
    inverseJoinColumns = {@JoinColumn(name = "idPessoa")})
    private List<PessoaEntidade> pessoas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<PessoaEntidade> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<PessoaEntidade> pessoas) {
        this.pessoas = pessoas;
    }
}
