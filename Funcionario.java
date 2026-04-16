import java.math.BigDecimal;
import java.time.LocalDate;

// Classe Funcionario herdando de Pessoa
// Aqui eu reutilizo os dados de Pessoa e adiciono mais informações específicas
public class Funcionario extends Pessoa {

    private BigDecimal salario;
    private String funcao;

    // Construtor chamando o super (Pessoa)
    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }
}
