import br.com.brunnadornelles.command.Deposito;
import br.com.brunnadornelles.command.Processos;
import br.com.brunnadornelles.command.Saque;
import br.com.brunnadornelles.model.Conta;
import br.com.brunnadornelles.service.ServicoBanco;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ServicoBancoTeste {

    private ServicoBanco servicoBanco;
    Conta conta;

    @BeforeEach
    public void ApresentandoUsuario(){
        conta = new Conta("Brunna Dornelles");
        servicoBanco = new ServicoBanco(conta);
    }

    @Test
    public void deposito(){
        Deposito deposito = new Deposito(conta, 1575);
        Assertions.assertTrue(servicoBanco.addOrder(deposito));
    }

    @Test
    public void depositandoValorMenorQueZero(){
        Deposito deposito = new Deposito(conta, -100 );
        Assertions.assertThrows(IllegalArgumentException.class, () -> servicoBanco.addOrder(deposito));

    }

    @Test
    public void saque(){
        Saque saque = new Saque(conta, 0);
        Assertions.assertEquals(true, servicoBanco.addOrder(saque));

    }

    @Test
    public void saqueValorMaiorDoQueSaldoEmConta(){
        Saque saque = new Saque(conta, 1230);
        Assertions.assertThrows(IllegalArgumentException.class, () -> servicoBanco.addOrder(saque));
    }


    @Test
    public void saqueValorMenorQueZero(){
        Saque saque = new Saque(conta, -10);
        Assertions.assertThrows(IllegalArgumentException.class, () -> servicoBanco.addOrder(saque));

    }

    @Test
    public void mostrandoExtrato(){
        List<Processos> mostrandoExtrato = servicoBanco.mostrandoExtrato();
        Assertions.assertEquals(mostrandoExtrato, servicoBanco.mostrandoExtrato());
    }

    @Test
    public void limpandoCache(){
        Assertions.assertTrue(servicoBanco.limpandoCache());
    }

    @Test
    public void saqueContaNull(){
        servicoBanco = new ServicoBanco(null);
        Saque saque = new Saque(null, 10 );
        Assertions.assertThrows(IllegalArgumentException.class, () -> servicoBanco.addOrder(saque));
    }


    @Test
    public void depositoContaNull(){
        servicoBanco = new ServicoBanco(null);
        Deposito deposito = new Deposito(null, 1700 );
        Assertions.assertThrows(IllegalArgumentException.class, () -> servicoBanco.addOrder(deposito));
    }

}