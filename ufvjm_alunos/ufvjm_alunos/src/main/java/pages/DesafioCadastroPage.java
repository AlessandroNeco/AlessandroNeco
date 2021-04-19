package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DesafioCadastroPage extends BasePage {


    public DesafioCadastroPage(WebDriver driver) {
        super(driver);
    }

    //mostrar
    @FindBy(id = "elementosForm:nome")
    private WebElement nomeTextField;
    @FindBy(xpath ="//*[@id=\"elementosForm:sexo:0\"]")
    private WebElement sexoWebElement;
    @FindBy(id ="elementosForm:comidaFavorita:0")
    private WebElement carneWebElement;
    @FindBy(id ="elementosForm:comidaFavorita:1")
    private WebElement frangoWebElement;
    @FindBy(id ="elementosForm:comidaFavorita:2")
    private WebElement pizzaWebElement;
    @FindBy(id = "elementosForm:escolaridade")
    private Select listaEscolaridade;
    @FindBy(id = "elementosForm:esportes")
    private Select listaEsportes;
    @FindBy(id ="elementosForm:sugestoes")
    private WebElement sugesWebElement;
    @FindBy(id = "elementosForm:cadastrar")
    private WebElement cadastrarButton;

    //identificacao dos elementos de resultados
    @FindBy(id = "descNome")
    private WebElement nome;
    @FindBy(id = "elementosForm:sobrenome")
    private WebElement sobrenomeTextField;
    @FindBy(id = "descSobrenome")
    private WebElement sobrenome;
    @FindBy(id = "descSexo")
    private WebElement sexo;
    @FindBy(id = "descComida")
    private WebElement comida;
    @FindBy(id = "descEsportes")
    private WebElement esporte;
    @FindBy(id = "descSugestoes")
    private WebElement sugestoes;

    public DesafioCadastroPage preencherNome(String nome) {
        nomeTextField.sendKeys(nome);
        return this;
    }
    public DesafioCadastroPage preencherSobrenome(String sobrenome) {
        sobrenomeTextField.sendKeys(sobrenome);
        return this;
    }
    public DesafioCadastroPage marcarSexo(){
        sexoWebElement.click();
        return  this;
    }
    public DesafioCadastroPage selecionarComidaCarne(){
        carneWebElement.click();
        return  this;
    }
    public DesafioCadastroPage selecionarComidaFrango(){
        frangoWebElement.click();
        return this;
    }
    public DesafioCadastroPage selecionarComidaPizza() {
        pizzaWebElement.click();
        return this;
    }
    public DesafioCadastroPage selecionarEscolaridade(){
        listaEscolaridade.selectByVisibleText("Mestrado");
        return  this;
    }
    public DesafioCadastroPage selecionarEsporte(){
        listaEsportes.selectByVisibleText("futebol");
        return  this;
    }
    public DesafioCadastroPage preencherSugestoes(String sugestoes){
        sugesWebElement.sendKeys(sugestoes);
        return  this;
    }
    public DesafioCadastroPage clicarCadastrar() {
        cadastrarButton.click();
        return this;
    }
    //metodos que capturam os resultados do teste

    public String buscarLabelNome(){
        return nome.getText();
    }
    public String buscarLabelSobrenome(){
        return sobrenome.getText();
    }
    public String buscarLabelSexo(){
        return sexo.getText();
    }
    public String buscarComida(){
        return comida.getText();

    }
    public String buscarEsporte(){
        return esporte.getText();
    }
    public String buscarLabelSugestoes(){
        return sugestoes.getText();
    }



}
