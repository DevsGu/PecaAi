package com.edu.ifce.pecaai.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String nome;

        @Column(nullable = false, unique = true)
        private String email;

        @Column(nullable = false)
        private String senha;

        
        public enum TipoUsuario {
            GERENTE,
            USUARIO,
            GARCOM
        }

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private TipoUsuario tipo;

        

        public Usuario() {
        }

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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getSenha() {
            return senha;
        }

        public void setSenha(String senha) {
            this.senha = senha;
        }

        public TipoUsuario getTipo() {
            return tipo;
        }

        public void setTipo(TipoUsuario tipo) {
            this.tipo = tipo;
        }

        public Usuario(Long id, String nome, String email, String senha, TipoUsuario tipo) {
            this.id = id;
            this.nome = nome;
            this.email = email;
            this.senha = senha;
            this.tipo = tipo;
        }

        
        

}
