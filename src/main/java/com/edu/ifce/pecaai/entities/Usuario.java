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

        @Column(nullable = false, unique = true)
        private String email;

        
        public enum TipoUsuario {
            GERENTE,
            USUARIO,
            GARÇOM
        }

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private TipoUsuario tipo;

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

        public TipoUsuario getTipo() {
            return tipo;
        }

        public void setTipo(TipoUsuario tipo) {
            this.tipo = tipo;
        }

        public Usuario(Long id, String email, TipoUsuario tipo) {
            this.id = id;
            this.email = email;
            this.tipo = tipo;
        }

        
        

}
