import java.time.LocalDate;

// Classe base Pessoa
// Aqui eu criei uma classe simples só para representar dados básicos de qualquer pessoa
public class Pessoa {

    // Atributos básicos
    private String nome;
    private LocalDate dataNascimento;

    // Construtor que vai inicializar os dados
    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    // Getter do nome
    public String getNome() {
        return nome;
    }

    // Getter da data de nascimento
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
