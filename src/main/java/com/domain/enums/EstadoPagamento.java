package com.domain.enums;

public enum EstadoPagamento {
	
	PENDENTE(1, "Pendente"),QUITADO(2, "Quitado"),CANCELADO(3, "Cancelado");
	
	private int cod;
	private String description;
	
	private EstadoPagamento(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}
	
	public static EstadoPagamento toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(EstadoPagamento x : EstadoPagamento.values()){
			if(cod.equals(x.getCod())) {
			 return x;
			}
		}
		throw new IllegalArgumentException("ID invalido: " + cod);
	}

}
