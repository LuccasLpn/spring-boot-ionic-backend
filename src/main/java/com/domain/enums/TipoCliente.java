package com.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Fisica"), PESSOAJURIDICA(2, "Pessoa Juridica");
	
	private int cod;
	private String description;
	
	private TipoCliente(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(TipoCliente x : TipoCliente.values()){
			if(cod.equals(x.getCod())) {
			 return x;
			}
		}
		throw new IllegalArgumentException("ID invalido: " + cod);
	}

}