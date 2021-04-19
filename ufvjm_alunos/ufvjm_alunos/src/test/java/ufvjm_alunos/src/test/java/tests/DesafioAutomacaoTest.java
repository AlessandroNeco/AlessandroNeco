package ufvjm_alunos.src.test.java.tests;


import entities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DesafioCadastroPage;

//@Listeners(TM4JTestNGListener.class)
public class DesafioAutomacaoTest extends BaseTest {

    String nome ="Alessandro";
    String sobrenome = "Moreira";
    String sexo = "Masculino";
    String Comida = "Carne Frango Pizza";
    String sugestoes = "colocar o codigo no git";


    @Test
    public void deveCadastrarPessoaExemplo(){
        DesafioCadastroPage cp = new DesafioCadastroPage(getDriver());
            cp.preencherNome(nome)
                    .preencherSobrenome(sobrenome)
                    .marcarSexo()
                    .selecionarComidaCarne()
                    .selecionarComidaFrango()
                    .selecionarComidaPizza()
                   // .selecionarEscolaridade()
                   // .selecionarEsporte()
                    .preencherSugestoes(sugestoes)
                    .clicarCadastrar();
        //Asserts para verificar os resultados
        /*
        Assert.assertEquals(cp.buscarLabelNome(), "Nome: " + nome);
        Assert.assertEquals(cp.buscarLabelSobrenome(), "Sobrenome: " + sobrenome);
        Assert.assertEquals(cp.buscarLabelSexo(), "Sexo: " + sexo);
        Assert.assertEquals(cp.buscarComida(), "Comida: "+Comida);
        Assert.assertEquals(cp.buscarEsporte(), "Esportes:");
        Assert.assertEquals(cp.buscarLabelSugestoes(), "Sugestoes: " + sugestoes);
        */
    }





}
