package top.lemonz.blog.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import top.lemonz.blog.json.AuthorInfo;
import top.lemonz.blog.json.JsonFileOption;
import top.lemonz.blog.json.PicRecInfo;
import top.lemonz.blog.json.TopGodInfo;
import top.lemonz.blog.tool.IXlmToolKit;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by IntelliJ IDEA.
 *
 * @author NingZe
 * description: Initialization Config
 * path: LEMONBLOG-top.lemonz.blog.config-InitializationConfig
 * date: 2019/9/26 0026 14:28
 * version: 02.06
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class InitializationConfig implements Serializable {

    private final static Logger log = LoggerFactory.getLogger(InitializationConfig.class);

    /**
     * application
     */
    @Autowired
    private ServletContext sc;

    /**
     * kit
     */
    @Autowired
    private IXlmToolKit kit;

    /**
     * author info
     */
    public static AuthorInfo authorInfo;

    /**
     * pic rec info
     */
    public static PicRecInfo picRecInfo;

    /**
     * top god info
     */
    public static TopGodInfo topGodInfo;

    @PostConstruct
    public void init() {

        log.info("--- 正在初始化数据 ---");
        long l1 = System.currentTimeMillis();

        authorInfo = JsonFileOption.getAuthorInfo();
        sc.setAttribute("authorInfo", authorInfo);

        picRecInfo = JsonFileOption.getPicRecInfo();
        Collections.sort(picRecInfo.getPicrecinfos(), Comparator.comparingInt(PicRecInfo.Info::getKey));
        sc.setAttribute("picrecInfo", picRecInfo);

        topGodInfo = JsonFileOption.getTopGodInfo();
        sc.setAttribute("topGodInfo", topGodInfo);

        long l2 = System.currentTimeMillis();
        log.info("--- 初始化数据完成 --- 耗时：" + (l2 - l1) + " ms");

    }

}
