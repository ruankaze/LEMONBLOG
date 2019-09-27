package top.lemonz.blog.json;

/**
 * Created by IntelliJ IDEA.
 *
 * @author NingZe
 * description: top god info
 * path: LEMONBLOG-top.lemonz.blog.json-TopGodInfo
 * date: 2019/9/27 0027 14:11
 * version: 02.06
 * To change this template use File | Settings | File Templates.
 */
public class TopGodInfo {

    /**
     * 神的命名
     */
    private String godname;

    /**
     * 神的标志
     */
    private String godimg;

    /**
     * 神的领域
     */
    private String godterritory;

    /**
     * 神的象征
     */
    private String godsymbol;

    /**
     * 神的祝福 cn
     */
    private String godwishcn;

    /**
     * 神的祝福 us
     */
    private String godwishus;

    public String getGodname() {
        return godname;
    }

    public void setGodname(String godname) {
        this.godname = godname;
    }

    public String getGodimg() {
        return godimg;
    }

    public void setGodimg(String godimg) {
        this.godimg = godimg;
    }

    public String getGodterritory() {
        return godterritory;
    }

    public void setGodterritory(String godterritory) {
        this.godterritory = godterritory;
    }

    public String getGodsymbol() {
        return godsymbol;
    }

    public void setGodsymbol(String godsymbol) {
        this.godsymbol = godsymbol;
    }

    public String getGodwishcn() {
        return godwishcn;
    }

    public void setGodwishcn(String godwishcn) {
        this.godwishcn = godwishcn;
    }

    public String getGodwishus() {
        return godwishus;
    }

    public void setGodwishus(String godwishus) {
        this.godwishus = godwishus;
    }

    @Override
    public String toString() {
        return "TopGodInfo{" +
                "godname='" + godname + '\'' +
                ", godimg='" + godimg + '\'' +
                ", godterritory='" + godterritory + '\'' +
                ", godsymbol='" + godsymbol + '\'' +
                ", godwishcn='" + godwishcn + '\'' +
                ", godwishus='" + godwishus + '\'' +
                '}';
    }
}
