package com.example.produtos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.produtos.model.ProdutoModelo;
import com.example.produtos.model.RespostaModelo;
import com.example.produtos.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository pr;

    @Autowired
    private RespostaModelo rm;

    public Iterable<ProdutoModelo> listar(){
        return pr.findAll();
    }

    public ResponseEntity<?> cadastrar(ProdutoModelo pm){
        if(pm.getNome().equals("")){
            rm.setMensagem("O nome do produto é obrigatório");
            return new ResponseEntity<RespostaModelo>(rm,HttpStatus.BAD_REQUEST);
        }else if(pm.getMarca().equals("")){
            rm.setMensagem("O nome da marca é obrigatório");
            return new ResponseEntity<RespostaModelo>(rm,HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<ProdutoModelo>(pr.save(pm),HttpStatus.CREATED);
        }
    }

    public ResponseEntity<?> cadastrarAlterar(ProdutoModelo pm, String acao){
        if(pm.getNome().equals("")){
            rm.setMensagem("O nome do produto é obrigatório");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else if(pm.getMarca().equals("")){
            rm.setMensagem("O nome da marca é obrigatório");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else{
            if (acao.equals("cadastrar")) {
                return new ResponseEntity<ProdutoModelo>(pr.save(pm),HttpStatus.CREATED);
            }else{
                return new ResponseEntity<ProdutoModelo>(pr.save(pm),HttpStatus.OK);
            }
        }
    }

    public ResponseEntity<RespostaModelo> remover(long id){
        pr.deleteById(id);

        rm.setMensagem("O produto foi removido com sucessso");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);

    }

   
    

}
