package com.produtos.apirest.resources;
 
import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value ="/api" )
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository; 

	 @GetMapping("/produtos")                           // Lista Produto 
	 @ApiOperation(value="Retorna uma lista de produtos")
	 public List<Produto> listaProduto(){
		 return produtoRepository.findAll();
	 } 
	 @GetMapping("/produtos/{id}")                                             // Lista Produto por ID
	 @ApiOperation(value="Retorna um produto unico")
	 public Optional<Produto> listaProdutoUnico(@PathVariable(value="id")Long id){
		 return produtoRepository.findById(id);     
	 } 
	 
	 @PostMapping("/produto/")                                  //salvar Produto por ID
	 @ApiOperation(value="Salvar um produto ")
	 public Produto salvaProduto(@RequestBody Produto produto) {
	 return produtoRepository.save(produto);
	 }
	 
	 @DeleteMapping("/produto/")                                  //Deletar Produto por ID
	 @ApiOperation(value="Deletar um produto")
	 public void deletarProduto(@RequestBody Produto produto) {
		  produtoRepository.delete(produto);
	 }
		                                                           // Atualizar Produto
	@PutMapping("/produto/")	
	 @ApiOperation(value="Atualizar um produto")
	public Produto atualizarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto); 
		  
		  
		  
   }
	 
}
























