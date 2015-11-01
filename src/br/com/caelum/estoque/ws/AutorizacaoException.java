package br.com.caelum.estoque.ws;

import java.util.Date;

import javax.xml.ws.WebFault;

import br.com.caelum.estoque.exceptions.InfoFault;

@WebFault(name="AutorizacaoFault")
public class AutorizacaoException extends Exception {

	private static final long serialVersionUID = 1L;

	public AutorizacaoException(String msg) {
		super(msg);
	}
	
	public InfoFault getFaultInfo(){
		//return "Token Inválido";
		//teste de commit
		return new InfoFault("Token invalido" , new Date());
	}
	

}
