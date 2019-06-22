package top.lemonz.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by IntelliJ IDEA.
 *
 * @author NingZe
 * @description:
 * @path: blog-top.lemonz.blog-BlogApplication
 * @date: 2019/5/29 0028 13:31
 * @version: 02.06
 * To change this template use File | Settings | File Templates.
 */
@ComponentScan("top.lemonz")
@MapperScan("top.lemonz.blog.dao")
@SpringBootApplication
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

}
