package top.lemonz.blog.json;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author NingZe
 * description: pic rec info
 * path: LEMONBLOG-top.lemonz.blog.json-PicrecInfo
 * date: 2019/9/26 0026 18:02
 * version: 02.06
 * To change this template use File | Settings | File Templates.
 */
public class PicRecInfo {

    /**
     * pic head
     */
    public List<Head> picrecheads;

    /**
     * pic info
     */
    public List<Info> picrecinfos;

    public List<Head> getPicrecheads() {
        return picrecheads;
    }

    public void setPicrecheads(List<Head> picrecheads) {
        this.picrecheads = picrecheads;
    }

    public List<Info> getPicrecinfos() {
        return picrecinfos;
    }

    public void setPicrecinfos(List<Info> picrecinfos) {
        this.picrecinfos = picrecinfos;
    }

    @Override
    public String toString() {
        return "PicrecInfo{" +
                "picrecheads=" + picrecheads +
                ", picrecinfos=" + picrecinfos +
                '}';
    }

    public static class Head {

        /**
         * 文本名称
         */
        private String text;

        /**
         * 过滤名
         */
        private String filter;

        /**
         * 链接
         */
        private String href;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getFilter() {
            return filter;
        }

        public void setFilter(String filter) {
            this.filter = filter;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        @Override
        public String toString() {
            return "Head{" +
                    "text='" + text + '\'' +
                    ", filter='" + filter + '\'' +
                    ", href='" + href + '\'' +
                    '}';
        }
    }

    public static class Info {

        /**
         * 图片键
         */
        private Integer key;

        /**
         * 图片地址
         */
        private String img;

        /**
         * 图片编号
         */
        private String code;

        /**
         * 图片名称
         */
        private String name;

        /**
         * 图片标题
         */
        private String title;

        /**
         * 弹层标题
         */
        private String modeltitle;

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getModeltitle() {
            return modeltitle;
        }

        public void setModeltitle(String modeltitle) {
            this.modeltitle = modeltitle;
        }

        @Override
        public String toString() {
            return "Picrecinfo{" +
                    "key='" + key + '\'' +
                    ", img='" + img + '\'' +
                    ", code='" + code + '\'' +
                    ", name='" + name + '\'' +
                    ", title='" + title + '\'' +
                    ", modeltitle='" + modeltitle + '\'' +
                    '}';
        }
    }

}
