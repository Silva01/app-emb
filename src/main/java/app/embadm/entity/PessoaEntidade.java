package app.embadm.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.awt.*;
import java.time.LocalDate;

@Entity
@Table (name = "pessoa")
public class PessoaEntidade {

    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotBlank
    @Size(min = 2, max = 255)
    private String nome;

    @Column(nullable = false)
    @NotBlank
    private String rg;

    @Id
    @Column(nullable = false)
    @NotBlank
    @Size(max = 20)
    private String cpf;

    private String telefone;
    private String endereco;

    @Column(nullable = false)
    @NotBlank
    private String email;

    @Column(nullable = false)
    @NotBlank
    private LocalDate dataNascimento;
    private Boolean ativo;

    @ManyToMany
    @JoinTable(name = "pessoasPerfis",
            joinColumns = { @JoinColumn(name = "idPessoa") },
            inverseJoinColumns = {@JoinColumn(name = "idPerfil") })
    private List<PerfilEntidade> perfis;

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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<PerfilEntidade> getPerfis() {
        return perfis;
    }

    public void setPerfis(List<PerfilEntidade> perfis) {
        this.perfis = perfis;
    }
}
