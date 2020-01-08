<#--
  Created by IntelliJ IDEA.
  User: NingZe
  Description: acana - 动漫语录
  Date: 2019/6/1 0028
  Time: 9:13
  To change this template use File | Settings | File Templates.
-->

<!-- section start -->
<section id="acana" class="section transprant-bg pclear secPadding acana">
    <div class="container no-view" data-animation-effect="fadeIn">
        <h1 class="title text-center">AC Ana</h1>
        <div class="acmsgs">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <p>あなたは私の唯一、私はあなたの一人です。 [ 終わりのセラフ ]</p>
                        <p>你是我的唯一、我是你的之一。 [ 终结的炽天使 ]</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="space"></div>
        <div class="row acnames">
            <#list [
                    {
                        "name": "终结的炽天使",
                        "intro": "在不知什么时候，整个世界被突如其来的未知病毒攻袭，几乎彻底毁灭。但是只有13岁以下的孩子不被病毒所感染，侥幸活了下来。可是这些孩子们却被从地底出现的吸血鬼所统治，并作为提供血液的家畜饲养。故事的主人公[百夜优一郎]和[百夜米迦尔]就是被抓住的孤儿们之一，而面对不堪的命运，他们没有屈服，开始计划逃亡与复仇……",
                        "url": "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=464159100,1004406335&fm=26&gp=0.jpg"
                    },
                    {
                        "name": "魔道祖师",
                        "intro": "",
                        "url": ""
                    },
                    {
                        "name": "鬼灭之刃",
                        "intro": "",
                        "url": ""
                    },
                    {
                        "name": "少年侦探团",
                        "intro": "",
                        "url": ""
                    },
                    {
                        "name": "刀剑神域",
                        "intro": "",
                        "url": ""
                    },
                    {
                        "name": "东京喰种",
                        "intro": "",
                        "url": ""
                    },
                    {
                        "name": "狐妖小红娘",
                        "intro": "",
                        "url": ""
                    },
                    {
                        "name": "入间同学入魔了",
                        "intro": "",
                        "url": ""
                    },
                    {
                        "name": "伍六七之最强发型师",
                        "intro": "",
                        "url": ""
                    },
                    {
                        "name": "从前有座灵剑山",
                        "intro": "",
                        "url": ""
                    },
                    {
                        "name": "夏目友人帐",
                        "intro": "",
                        "url": ""
                    },
                    {
                        "name": "欢迎来到实力至上主义教室",
                        "intro": "",
                        "url": ""
                    },
                    {
                        "name": "画江湖之不良人",
                        "intro": "",
                        "url": ""
                    },
                    {
                        "name": "我家大师兄脑子有坑",
                        "intro": "",
                        "url": ""
                    },
                    {
                        "name": "全职高手",
                        "intro": "",
                        "url": ""
                    }
            ] as ac >
                <div class="col-md-4">
                    <div class="media block-list">
                        <div class="media-left">
                            <img src="${ac.url}">
                        </div>
                        <div class="media-body">
                            <h3 class="media-heading" style="font-size: 18px;">${ac.name}</h3>
                            <blockquote class="acintros">
                                <p>在不知什么时候，整个世界被突如其来的未知病毒攻袭，几乎彻底毁灭。但是只有13岁以下的孩子不被病毒所感染，侥幸活了下来。可是这些孩子们却被从地底出现的吸血鬼所统治，并作为提供血液的家畜饲养。故事的主人公[百夜优一郎]和[百夜米迦尔]就是被抓住的孤儿们之一，而面对不堪的命运，他们没有屈服，开始计划逃亡与复仇……</p>
                            </blockquote>
                        </div>
                    </div>
                </div>
            </#list>
        </div>
    </div>
</section>
<!-- section end -->

