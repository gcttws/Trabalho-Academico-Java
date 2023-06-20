package br.ucb.poo.bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Cliente extends Usuario {
	private String telefone;
	private String email;
	private LocalDate dataNascimento;
	
	public Cliente(String nome, String telefone, String email, LocalDate dataNascimento) {
		this.telefone = telefone;
		this.email = email;
		this.dataNascimento = dataNascimento;	
	}
	
	//getters and setters
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
        // Remove caracteres não numéricos do telefone
        String numeroLimpo = telefone.replaceAll("[^0-9]", "");
        // Verifica se o número possui 10 ou 11 dígitos (considerando o DDD)
        if (numeroLimpo.length() == 10 || numeroLimpo.length() == 11) {
            // Formata o número de telefone no padrão (XX) XXXX-XXXX ou (XX) X XXXX-XXXX
            StringBuilder sb = new StringBuilder();
            sb.append("(").append(numeroLimpo.substring(0, 2)).append(") ");
            if (numeroLimpo.length() == 10) {
                sb.append(numeroLimpo.substring(2, 6)).append("-").append(numeroLimpo.substring(6));
            } else {
                sb.append(numeroLimpo.substring(2, 3)).append(" ")
                        .append(numeroLimpo.substring(3, 7)).append("-").append(numeroLimpo.substring(7));
            }
            this.telefone = sb.toString();
        } else {
            System.out.println("Número de telefone inválido. Utilize um formato válido, com 10 ou 11 dígitos.");
        }
    }

    public void setEmail(String email) {
        if (isValidEmail(email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email inválido");
        }
    }

    private boolean isValidEmail(String email) {
        // Implemente a validação do email aqui
        // Você pode usar expressões regulares ou outras lógicas de validação
        // Neste exemplo, verifica-se se o email possui um formato básico válido
        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    }
    
    public String getEmail() {
        return email;
    }
    
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {
			LocalDate data = LocalDate.parse(dataNascimento, formatter);
			this.dataNascimento = data;
		}catch(DateTimeParseException e) {
			System.out.println("Formato de data inválido. Utilize o formato dd/MM/yyyy");
			
		}

	}
	
	//metodo
	
	
}
