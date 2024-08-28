import com.opencsv.CSVWriter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;


public class Automacao {

    @Test
    public void pesquisarGoogle() throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/drive/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        LocalDateTime dateNow = LocalDateTime.now();

        CSVWriter csv = new CSVWriter(new FileWriter("ValoresCotacao.csv"));

        /*
        driver.get("https://google.com");
        driver.findElement(By.id("APjFqb")).click();
        driver.findElement(By.id("APjFqb")).sendKeys("Valor do ouro hoje", Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[3]/div/div/div[1]/div/a/h3")).click();
         */

        //Pegar valor do Ouro
        driver.get("https://dolarhoje.com/ouro-hoje/");
        driver.findElement(By.id("nacional")).click();
        WebElement campoNacional =  driver.findElement(By.id("nacional"));
        String valorOuro = campoNacional.getAttribute("value");
        String[] CsvOuro = {"Valor do ouro hoje = ", valorOuro};
        csv.writeNext(CsvOuro);

        /*
        driver.get("https://google.com");
        driver.findElement(By.id("APjFqb")).click();
        driver.findElement(By.id("APjFqb")).sendKeys("Valor do dolar hoje", Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div[6]/div/div/div/div[1]/div/a/h3")).click();
         */

        //Pegar valor do Dolar
        driver.get("https://dolarhoje.com/");
        campoNacional =  driver.findElement(By.id("nacional"));
        String valorDolar = campoNacional.getAttribute("value");
        String[] CsvDolar = {"Valor do dolar hoje = ", valorDolar};
        csv.writeNext(CsvDolar);

        /*
        driver.get("https://google.com");
        driver.findElement(By.id("APjFqb")).click();
        driver.findElement(By.id("APjFqb")).sendKeys("Valor do Euro hoje", Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[11]/div/div/div[1]/div/a/h3")).click();
         */

        //Pegar valor do Euro
        driver.get("https://dolarhoje.com/euro-hoje/");
        driver.findElement(By.id("nacional")).click();
        campoNacional = driver.findElement(By.id("nacional"));
        String valorEuro = campoNacional.getAttribute("value");
        String[] CsvEuro = {"Valor do euro hoje =  ", valorEuro};
        csv.writeNext(CsvEuro);

        //generateLog("Busca realizada em " + dateNow);

        csv.close();
        driver.quit();
    }

    public static void generateLog(String message) throws IOException {

        File log = new File("C:\\Users\\joaov\\Documents\\cursoJavaNelio\\AutomacaoJava\\log.txt");

        if (!log.exists()) {
            log.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(log, true);
        BufferedWriter buffer = new BufferedWriter(fileWriter);

        buffer.write(message);
        buffer.newLine();

        buffer.close();
        fileWriter.close();

    }

}
