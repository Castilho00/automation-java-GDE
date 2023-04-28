import com.opencsv.CSVWriter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;

public class Automacao {


    @Test
    public void pesquisarGoogle() throws IOException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\joaov\\Documents\\cursoJavaNelio\\AutomacaoJava\\src\\drive\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        CSVWriter csv = new CSVWriter(new FileWriter("ValoresCotacao.csv"));

        driver.get("https://google.com");

        //Pegar valor do Ouro
        driver.findElement(By.id("APjFqb")).click();
        driver.findElement(By.id("APjFqb")).sendKeys("Valor do ouro hoje", Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[3]/div/div/div[1]/div/a/h3")).click();
        driver.manage().addCookie(new Cookie("CONSENT", "YES+pt-BR"));
        driver.findElement(By.id("nacional")).click();
        WebElement campoNacional =  driver.findElement(By.id("nacional"));
        String valorOuro = campoNacional.getAttribute("value");
        String[] CsvOuro = {"Valor do ouro hoje = ", valorOuro};
        csv.writeNext(CsvOuro);

        driver.get("https://google.com");
        //Pegar valor do Dolar
        driver.findElement(By.id("APjFqb")).click();
        driver.findElement(By.id("APjFqb")).sendKeys("Valor do dolar hoje", Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div[4]/div/div/div/div[1]/div/a/h3")).click();
        driver.manage().addCookie(new Cookie("CONSENT", "YES+pt-BR"));
        campoNacional =  driver.findElement(By.id("nacional"));
        String valorDolar = campoNacional.getAttribute("value");
        String[] CsvDolar = {"Valor do dolar hoje = ", valorDolar};
        csv.writeNext(CsvDolar);

        driver.get("https://google.com");
        //Pegar valor do Euro
        driver.findElement(By.id("APjFqb")).click();
        driver.findElement(By.id("APjFqb")).sendKeys("Valor do Euro hoje", Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div[10]/div/div/div/div[1]/div/a/h3")).click();
        driver.manage().addCookie(new Cookie("CONSENT", "YES+pt-BR"));
        driver.findElement(By.id("nacional")).click();
        campoNacional = driver.findElement(By.id("nacional"));
        String valorEuro = campoNacional.getAttribute("value");
        String[] CsvEuro = {"Valor do euro hoje =  ", valorEuro};
        csv.writeNext(CsvEuro);

        csv.close();

        driver.quit();
    }
}
