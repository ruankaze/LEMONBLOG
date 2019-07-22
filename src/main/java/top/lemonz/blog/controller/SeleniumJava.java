package top.lemonz.blog.controller;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by IntelliJ IDEA.
 *
 * @author NingZe
 * description: selenium-java
 * path: LEMONBLOG-top.lemonz.blog.controller-SeleniumJava
 * date: 2019/7/22 0022 11:07
 * version: 02.06
 * To change this template use File | Settings | File Templates.
 */
public class SeleniumJava {

    public static void main(String[] args) throws InterruptedException {

        // 设置系统属性（1. 属性名 2. chrome 驱动路径）
        System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver.exe");
        // 创建浏览器对象
        WebDriver driver= new ChromeDriver();
        // 打开页面
        driver.get("https://www.baidu.cn");
        // 窗口最大化
        driver.manage().window().maximize();
        // 休眠2秒
        Thread.sleep(2000);
        // 打开页面
        driver.get("https://m.baidu.cn");
        // 窗口指定大小
        driver.manage().window().setSize(new Dimension(480, 800));
        // 休眠2秒
        Thread.sleep(2000);
        // 关闭浏览器
        driver.quit();

    }

}