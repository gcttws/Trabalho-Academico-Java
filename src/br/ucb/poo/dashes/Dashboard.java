package br.ucb.poo.dashes;

public class Dashboard {
	private String presentationString;
	public String templateString;
	protected int stepAtual = 0;
	
	public String getPresentationString() {
		String stringApresentacao =  "\n==========================================================================\n"
								   + "\n=== Seja bem-vindo à Alpha Motors!                                     ===\n"
								   + "\n=== Primeiro, faça seu login ou cadastre-se!                           ===\n"
								   + "\n==========================================================================\n";
		return stringApresentacao;
	}
	
	public void imprimeTelaAtual() {
		System.out.println(this.getPresentationString());
	}

		
}
