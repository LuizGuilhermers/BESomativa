package com.AvaliacaoSomativa.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AvaliacaoSomativa.Service.CursoService;
import com.AvaliacaoSomativa.entities.Curso;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Cursos", description = "API REST DE GERENCIAMENTO DE CURSOS")
@RestController
@RequestMapping("/cursos")
@CrossOrigin(origins = "*")
public class CursoController {
	private final CursoService cursoServices;
	 
    @Autowired
    public CursoController (CursoService cursoServices) {
        this.cursoServices = cursoServices;
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Localiza curso por ID")
    public ResponseEntity <Curso> buscaCursoIdControlId(@PathVariable Long id){
        Curso curso = cursoServices.buscarCursoId(id);
        if(curso!= null) {
            return ResponseEntity.ok(curso);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping
    @Operation(summary = "Apresenta todos os produtos")
    public ResponseEntity<List<Curso>> buscaTodosProdutoControl() {
        List<Curso> produto = cursoServices.buscarTodosCursos();
 
        return ResponseEntity.ok(produto);
    }
    
    @PostMapping
    @Operation(summary = "Cadastra um curso")
    public ResponseEntity<Curso> salvaCursoControl(@RequestBody  Curso curso){
        Curso salvaCurso = cursoServices.salvaCurso(curso);
 
        return ResponseEntity.status(HttpStatus.CREATED).body(salvaCurso);
 
    }
    @PutMapping ("/{id}")
    @Operation(summary = "altera as informações do id curso")
    public ResponseEntity<Curso> alterarCurso(@PathVariable Long id, @RequestBody @Valid Curso curso) {
        Curso alterarCurso = cursoServices.alterarCurso(id,curso);
        if (alterarCurso  != null) {
            return ResponseEntity.ok(alterarCurso);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Apagar o id selecionado")
    public ResponseEntity<String> apagaCursoControl(@PathVariable Long id) {
        boolean apagar = cursoServices.apagarProduto(id);
        if(apagar) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
	


}
