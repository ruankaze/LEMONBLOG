package top.lemonz.blog.json;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author NingZe
 * description: author info -> links
 * path: LEMONBLOG-top.lemonz.blog.json-AuthorInfo
 * date: 2019/9/24 0024 13:26
 * version: 02.06
 * To change this template use File | Settings | File Templates.
 */
public class AuthorInfo {

    /**
     * 作者名称
     */
    private String authorname;

    /**
     * 作者头像
     */
    private String authorimg;

    /**
     * 作者介绍
     */
    private String description;

    /**
     * 作者外链
     */
    private List<Links> links;

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public String getAuthorimg() {
        return authorimg;
    }

    public void setAuthorimg(String authorimg) {
        this.authorimg = authorimg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Links> getLinks() {
        return links;
    }

    public void setLinks(List<Links> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "AuthorInfo{" +
                "authorname='" + authorname + '\'' +
                ", authorimg='" + authorimg + '\'' +
                ", description='" + description + '\'' +
                ", links=" + links +
                '}';
    }

    public static class Links {

        /**
         * 外链键
         */
        private String key;

        /**
         * 外链标题
         */
        private String title;

        /**
         * 外链样式
         */
        private String lclass;

        /**
         * 外链链接
         */
        private String url;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLclass() {
            return lclass;
        }

        public void setLclass(String lclass) {
            this.lclass = lclass;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "Links{" +
                    "key='" + key + '\'' +
                    ", title='" + title + '\'' +
                    ", lclass='" + lclass + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

}
