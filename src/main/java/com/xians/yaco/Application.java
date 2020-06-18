package com.xians.yaco;

import com.xians.yaco.repository.base.BaseRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * <pre>
 *     YACO run!
 * </pre>
 *
 * @author : XIANS
 * @date : 2020/04/15
 */
@Slf4j
@SpringBootApplication
@EnableCaching
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "com.xians.yaco.repository", repositoryBaseClass = BaseRepositoryImpl.class)
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(com.xians.yaco.Application.class, args);
        String serverPort = context.getEnvironment().getProperty("server.port");
        //打印前端入口
        log.info("Halo started at http://localhost:" + serverPort);
        //run成功后打印该图案
        System.out.println("               ____               \n" +
                "          .-'\"\"    \"\"`-.          \n" +
                "       .-'              `-.       \n" +
                "     ,'       ____         `.     \n" +
                "   ,'       ,'    `.         `.   \n" +
                "  /         '-')    \\  _       \\  \n" +
                " /         ,'`'      \\( ).--.   \\ \n" +
                ";          \\, / /\\   ||/( ('     :\n" +
                ":            / /  |  |  _) )     :\n" +
                "|           / /___|  \\ )__/      |\n" +
                ":          /  ____    \\          :\n" +
                ":         (  /    |   |          ;\n" +
                " \\        |  |    |    \\_/)     / \n" +
                "  \\     .'   `--)  \\    _/     /  \n" +
                "   `.  /,-'''\"-'    `--'     ,'   \n" +
                "     \\.'                   ,'     \n" +
                "       `-.              ,-'       \n" +
                "          `-.,,____,,.-'        " +
                "");
    }
}
