import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

// Classe principal onde executa tudo
public class Principal {

    public static void main(String[] args) {

        // Lista onde guarda todos os funcionários
        List<Funcionario> funcionarios = new ArrayList<>();

        // Inserindo os dados exatamente como pedido no teste
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        // Removendo João conforme solicitado no teste
        funcionarios.removeIf(f -> f.getNome().equals("João"));

        // Formatadores
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        NumberFormat nf = NumberFormat.getInstance(new Locale("pt", "BR"));

        // Imprimindo lista completa
        System.out.println("=== FUNCIONÁRIOS ===");
        for (Funcionario f : funcionarios) {
            System.out.println(f.getNome() + " | " +
                    f.getDataNascimento().format(formatter) + " | " +
                    nf.format(f.getSalario()) + " | " +
                    f.getFuncao());
        }

        // Aplicando aumento de 10%
        for (Funcionario f : funcionarios) {
            f.setSalario(f.getSalario().multiply(new BigDecimal("1.10")));
        }

        // Agrupando por função usando Map
        Map<String, List<Funcionario>> agrupados =
                funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));

        System.out.println("\n=== AGRUPADOS ===");
        agrupados.forEach((funcao, lista) -> {
            System.out.println("Função: " + funcao);
            lista.forEach(f -> System.out.println(" - " + f.getNome()));
        });

        // Aniversariantes de outubro e dezembro
        System.out.println("\n=== ANIVERSARIANTES ===");
        funcionarios.stream()
                .filter(f -> {
                    int mes = f.getDataNascimento().getMonthValue();
                    return mes == 10 || mes == 12;
                })
                .forEach(f -> System.out.println(f.getNome()));

        // Funcionário mais velho
        Funcionario maisVelho = Collections.min(funcionarios,
                Comparator.comparing(Funcionario::getDataNascimento));

        int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();

        System.out.println("\nMais velho: " + maisVelho.getNome() + " - " + idade + " anos");

        // Ordenação alfabética
        System.out.println("\n=== ORDEM ALFABÉTICA ===");
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(f -> System.out.println(f.getNome()));

        // Soma total dos salários
        BigDecimal total = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("\nTotal salários: " + nf.format(total));

        // Quantos salários mínimos cada um ganha
        BigDecimal salarioMinimo = new BigDecimal("1212.00");

        System.out.println("\n=== SALÁRIOS MÍNIMOS ===");
        funcionarios.forEach(f -> {
            BigDecimal qtd = f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.println(f.getNome() + ": " + qtd);
        });
    }
}
