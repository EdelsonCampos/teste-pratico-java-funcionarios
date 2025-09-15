import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Principal {
    public static void main(String[] args) {

        // 3.1 - Inserindo todos os funcionários
        List<Funcionario> funcionarios = new ArrayList<>();
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

        // 3.2 - Removendo João
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getNome().equals("João")) {
                funcionarios.remove(i);
                break;
            }
        }

        // 3.3 - Imprimindo todos os funcionários
        System.out.println("=== Lista de Funcionários ===");
        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }

        // 3.4 - Aumento de 10%
        for (Funcionario f : funcionarios) {
            BigDecimal novoSalario = f.getSalario().multiply(new BigDecimal("1.10"));
            f.setSalario(novoSalario);
        }

        // 3.5 - Agrupar funcionários por função
        Map<String, List<Funcionario>> mapaPorFuncao = new HashMap<>();
        for (Funcionario f : funcionarios) {
            if (!mapaPorFuncao.containsKey(f.getFuncao())) {
                mapaPorFuncao.put(f.getFuncao(), new ArrayList<>());
            }
            mapaPorFuncao.get(f.getFuncao()).add(f);
        }

        // 3.6 - Imprimir agrupados por função
        System.out.println("\n=== Funcionários Agrupados por Função ===");
        for (String funcao : mapaPorFuncao.keySet()) {
            System.out.println("Função: " + funcao);
            for (Funcionario f : mapaPorFuncao.get(funcao)) {
                System.out.println(f);
            }
        }

        // 3.8 - Funcionários que fazem aniversário em outubro e dezembro
        System.out.println("\n=== Aniversariantes Outubro e Dezembro ===");
        for (Funcionario f : funcionarios) {
            int mes = f.getDataNascimento().getMonthValue();
            if (mes == 10 || mes == 12) {
                System.out.println(f);
            }
        }

        // 3.9 - Funcionário mais velho
        Funcionario maisVelho = funcionarios.get(0);
        for (Funcionario f : funcionarios) {
            if (f.getDataNascimento().isBefore(maisVelho.getDataNascimento())) {
                maisVelho = f;
            }
        }
        int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
        System.out.println("\nMais velho: " + maisVelho.getNome() + " - Idade: " + idade);

        // 3.10 - Funcionários em ordem alfabética
        System.out.println("\n=== Funcionários em Ordem Alfabética ===");
        Collections.sort(funcionarios, Comparator.comparing(Funcionario::getNome));
        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }

        // 3.11 - Total dos salários
        BigDecimal totalSalarios = BigDecimal.ZERO;
        for (Funcionario f : funcionarios) {
            totalSalarios = totalSalarios.add(f.getSalario());
        }
        System.out.println("\nTotal dos salários: R$ " + String.format("%,.2f", totalSalarios).replace(".", "#").replace(",", ".").replace("#", ","));

        // 3.12 - Quantos salários mínimos cada funcionário ganha
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        System.out.println("\n=== Salários Mínimos por Funcionário ===");
        for (Funcionario f : funcionarios) {
            BigDecimal qtd = f.getSalario().divide(salarioMinimo, 2, BigDecimal.ROUND_HALF_UP);
            System.out.println(f.getNome() + " ganha " + qtd + " salários mínimos.");
        }
    }
}