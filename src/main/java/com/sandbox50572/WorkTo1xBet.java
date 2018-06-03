package com.sandbox50572;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class WorkTo1xBet implements Runnable {

    private static org.openqa.selenium.chrome.ChromeDriver driver;//TODO static?
    private static String url;//url загружаемои страницы
    public int id;
    private String login;
    private String password;
    public int a;

    public String PROXY;

    //конструктор
    public WorkTo1xBet(int id, String proxy, String url) {
        this.id = id;// id потока
        this.url = url;
        this.login = login;
        this.password = password;
        this.PROXY = proxy;//TODO в данном случае socks5
    }
    @Override
    public void run() {

        //TODO Запуск через прокси
        //ChromeOptions option = new ChromeOptions();

        //TODO по протоколу http !!! переделать кидать переменную из coordinator
        //TODO с готовой ссылкой
        //option.addArguments("--proxy-server=http://" + PROXY);

        //TODO подключение прокси socks5
        //option.addArguments("--proxy-server=socks5://" + PROXY);

        System.setProperty("webdriver.chrome.driver","C:/idea/chromedriver.exe");

        //TODO Вариант через proxy
        //driver = new org.openqa.selenium.chrome.ChromeDriver(option);

        //TODO Вариант без прокси
        driver = new org.openqa.selenium.chrome.ChromeDriver();

        //раскрытие браузера на весь экран
        //driver.manage().window().maximize();
        //неявное ожидание действует всякий раз при поиске элемента
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //Заходим на страницу google
        driver.get("https://google.com");
        //находим поисковую строку
        //WebElement searchString = driver.findElementById("lst-ib");
        //вводим поисковый запрос
        //searchString.sendKeys("https://sandbox50572.wordpress.com");
        //жмем Enter
        //searchString.sendKeys(Keys.ENTER);


        //Заходим на страницу
        driver.get("https://sandbox50572.wordpress.com");
        //Находим ссылку
        WebElement link = driver.findElementByLinkText("СМОТРИМ ВНИМАТЕЛЬНО, ВЫИГРЫВАЕМ ОБЯЗАТЕЛЬНО!");
        //жмем enter
        link.sendKeys(Keys.ENTER);

        // АВТОРИЗАЦИЯ
        //Находим элемент ВОЙТИ
        WebElement autorization = driver.findElementByClassName("loginDropTop_con");
        autorization.click();
        //находим поле login
        WebElement loginField = driver.findElementById("userLogin");
        loginField.sendKeys("45949215");
        //Находим поле Password
        WebElement passField = driver.findElementById("userPassword");
        passField.sendKeys("y5uuxkhd");
        //Жмем ВОЙТИ
        WebElement comin = driver.findElementById("userConButton");
        comin.click();

    }
}
