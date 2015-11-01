package br.com.caelum.estoque.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.ResponseWrapper;

import br.com.caelum.estoque.modelo.item.Filtro;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;

//@WebService(name="UlaUla")
@WebService
public class EstoqueWS {

	private ItemDao dao = new ItemDao();

	/*@WebMethod(operationName="todosOsItens")
	@WebResult(name="Itens")
	public ListaItens getItens() {

        System.out.println("Chamando getItens()");
        List<Item> lista = dao.todosItens();
        return new ListaItens(lista);
        
    }*/

	/*@WebMethod(operationName="todosOsItens")
    @WebResult(name="itens")
    public ListaItens getItens(@WebParam(name="filtros") Filtros filtros) { //cuidado, plural
        System.out.println("Chamando getItens() com filtro");
    
        List<Filtro> lista = filtros.getLista();
        List<Item> itensResultado = dao.todosItens(lista);
        return new ListaItens(itensResultado);
    }*/
	
	//ok
	/*@ResponseWrapper(localName="itens")
	@WebMethod(operationName="todosOsItens")
    @WebResult(name="item")
	@RequestWrapper(localName="listaItens")
	public List<Item> getItens() { 

	    System.out.println("Chamando getItens()");
	    return dao.todosItens();

	}
	*/
		
	@ResponseWrapper(localName="itens")
	@WebMethod(operationName="todosOsItens")
    @WebResult(name="item")
    public List<Item> getItens(@WebParam(name="filtros") Filtros filtros) { //cuidado, plural
        System.out.println("Chamando getItens() com filtro");
    
        List<Filtro> lista = filtros.getLista();
        List<Item> itensResultado = dao.todosItens(lista);
        return itensResultado;
    }
	
	
	@WebMethod(operationName="CadastrarItem") 
	@WebResult(name="item")
	public Item cadstrarItem(@WebParam(name="tokenUsuario", header=true) TokenUsuario token, @WebParam(name="item") Item item) throws AutorizacaoException {

	    System.out.println("Cadastrando " + item + ", " + token);
	    
	    if(!new TokenDao().ehValido(token)) {
	        throw new AutorizacaoException("Autorizacao falhou");
	    }
	    
	    this.dao.cadastrar(item);
	    return item;
	}
}
