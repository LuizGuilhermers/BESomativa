package com.AvaliacaoSomativa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "curso")
public class Curso {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column
	private String nome;
	
	
	@Column
	private String conteudoProgramatico;
	

	@Column
	private String professor;
	
	
	@Column
	private double cargaHoraria;
	

	@Column
	private double valor;


	public Curso(Long id, String nome, String conteudoProgramatico, String professor, double cargaHoraria,
			double valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.conteudoProgramatico = conteudoProgramatico;
		this.professor = professor;
		this.cargaHoraria = cargaHoraria;
		this.valor = valor;
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

	public String getConteudoProgramatico() {
		return conteudoProgramatico;
	}

	public void setConteudoProgramatico(String conteudoProgramatico) {
		this.conteudoProgramatico = conteudoProgramatico;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public double getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(double cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
