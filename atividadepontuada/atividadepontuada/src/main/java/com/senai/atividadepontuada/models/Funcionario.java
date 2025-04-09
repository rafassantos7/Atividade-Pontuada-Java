package com.senai.atividadepontuada.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "tab_funcionario")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O cpf é obrigatório")
    private String cpf;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Email invalido")
    private String email;

    private String dataNascimento;
    private Double salario;

    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @Enumerated(EnumType.STRING)
    private Setor setor;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    public Funcionario() {
    }

    public Funcionario(Long id, String nome, String cpf, String email, String dataNascimento, Double salario, EstadoCivil estadoCivil, Setor setor, Sexo sexo, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.salario = salario;
        this.estadoCivil = estadoCivil;
        this.setor = setor;
        this.sexo = sexo;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "O nome é obrigatório") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome é obrigatório") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "O cpf é obrigatório") String getCpf() {
        return cpf;
    }

    public void setCpf(@NotBlank(message = "O cpf é obrigatório") String cpf) {
        this.cpf = cpf;
    }

    public @NotBlank(message = "O email é obrigatório") @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "O email é obrigatório") @Email String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "Id: " + id + '\n' +
                "Nome: " + nome + '\n' +
                "Cpf: " + cpf + '\n' +
                "Email: '" + email + '\n' +
                "Data de Nascimento: " + dataNascimento + '\n' +
                "Salario: " + salario + '\n' +
                "Estado Civil: " + estadoCivil.getTexto() + '\n' +
                "Setor: " + setor.getTexto() + '\n' +
                "Sexo: " + sexo.getTexto() + '\n' + endereco.toString();
    }
}
