package io.github.luis.store.models;


import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column
    private Long id;


    @NotBlank(message = "O campo email é obrigatório")
    @Email(message = "O email deve ser válido")
    @Column
    private  String email;

    @NotBlank(message = "O campo senha é obrigatório")
    @Size(min = 4, max = 8,  message = "A senha deve ter pelo menos 4 caracteres e no máximo 8")
    @Column
    private String senha;

    @NotBlank(message = "O campo confirmar senha é obrigatório")
    @Size(min = 4, max = 8,  message = "A senha deve ter pelo menos 4 caracteres e no máximo 8")
    @Column
    private String confirmarSenha;


    @NotBlank(message = "O campo nome é obrigatório")
    @Column
    private String name;

    @NotBlank(message = "O campo CPF é obrigatório")
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "O CPF deve estar no formato 000.000.000-00")
    private String cpf;



    @NotNull(message = "A data de nascimento é obrigatória")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column
    private Date dataNascimento;

    @NotBlank(message = "O campo telefone é obrigatório")
    @Pattern(regexp = "\\(\\d{2}\\) \\d{5}-\\d{4}", message = "O telefone deve estar no formato (00) 00000-0000")
    @Column
    private String telefone;


    @Column
    private  Boolean active;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name ="user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id") )
    private Set<Role> roles;


    public User(){

    }
    public  User(String email, String name, String senha , Boolean active){
        this.email = email;
        this.name = name;
        this.senha = senha;
        this.active =active;
    }

    public  User(Long id , String email, String name, String senha , Boolean active){
        this.id= id;
        this.email = email;
        this.name = name;
        this.senha = senha;
        this.active =active;
    }



    @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "A data de nascimento deve estar no formato dd/mm/aaaa")
    public String getDataNascimento() {
        return dataNascimento != null ? new SimpleDateFormat("dd/MM/yyyy").format(dataNascimento) : "";
    }

    public void setDataNascimento(String dataNascimentoString) {
        try {
            this.dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimentoString);
        } catch (ParseException e) {
            // Tratar erro de parsing, se necessário
            e.printStackTrace();
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }


}
