package br.com.caelum.estoque.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import br.com.caelum.estoque.modelo.item.Filtro;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.item.ListaItens;

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
	
	@ResponseWrapper(localName="itens")
	@WebMethod(operationName="todosOsItens")
    @WebResult(name="item")
	@RequestWrapper(localName="listaItens")
	public List<Item> getItens() { 

	    System.out.println("Chamando getItens()");
	    return dao.todosItens();

	}
	
	/* não funciona ? 
	 * @ResponseWrapper(localName="itens")
	@WebMethod(operationName="todosOsItens")
    @WebResult(name="item")
    public List<Item> getItens(@WebParam(name="filtros") Filtros filtros) { //cuidado, plural
        System.out.println("Chamando getItens() com filtro");
    
        List<Filtro> lista = filtros.getLista();
        List<Item> itensResultado = dao.todosItens(lista);
        return itensResultado;
    }*/
}
