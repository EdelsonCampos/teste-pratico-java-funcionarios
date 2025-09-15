import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

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

    @Override
    public String toString() {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String data = getDataNascimento().format(formatador);

        // Salário com vírgula e ponto
        String salarioFormatado = String.format("%,.2f", salario).replace(".", "#").replace(",", ".").replace("#", ",");

        return "Nome: " + getNome()
                + " | Data Nasc.: " + data
                + " | Salário: " + salarioFormatado
                + " | Função: " + funcao;
    }
}