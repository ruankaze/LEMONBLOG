package top.lemonz.blog.json;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 *
 * @author NingZe
 * description: json file path
 * path: LEMONBLOG-top.lemonz.blog.json-JsonFileOption
 * date: 2019/9/27 0027 12:47
 * version: 02.06
 * To change this template use File | Settings | File Templates.
 */
public class JsonFileOption {

    public static final String AuthorInfoPath = "/static/json/author.json";

    public static final String PicRecInfoPath = "/static/json/picturerec.json";

    public static final String TopGodInfoPath = "/static/json/topgod.json";

    /**
     * get json file author info
     *
     * @return
     */
    public static AuthorInfo getAuthorInfo() {
        return readFileParse(JsonFileOption.AuthorInfoPath, AuthorInfo.class);
    }

    /**
     * get json file pic rec info
     *
     * @return
     */
    public static PicRecInfo getPicRecInfo() {
        return readFileParse(JsonFileOption.PicRecInfoPath, PicRecInfo.class);
    }

    /**
     * get json file top god info
     *
     * @return
     */
    public static TopGodInfo getTopGodInfo() {
        return readFileParse(JsonFileOption.TopGodInfoPath, TopGodInfo.class);
    }

    /**
     * read file parse to class
     *
     * @param path
     * @return
     */
    private static <T> T readFileParse(String path, Class<T> calzz) {
        ClassPathResource resource = new ClassPathResource(path);
        try {
            String input = FileUtils.readFileToString(resource.getFile(), "UTF-8");
            return JSON.parseObject(input, calzz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
