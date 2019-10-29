<#--
  Created by IntelliJ IDEA.
  User: NingZe
  Date: 2019/10/22 0022
  Time: 17:28
  To change this template use File | Settings | File Templates.
-->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="/guestbook/valine.min.css">
</head>
<body>
<div id="vcomments" class="v">
    <div class="vwrap">
        <div class="vedit">
            <textarea id="veditor" class="veditor vinput" placeholder="Friends, please speak up, I am a fool."></textarea>
            <div class="vinput vpreview" style="display:none;"></div>
        </div>
        <div class="vcontrol">
            <div class="col col-20" title="Markdown is supported"></div>
            <div class="col col-80 text-right">
                <button type="button" title="Cmd|Ctrl+Enter" class="vsubmit vbtn" disabled="true">回复</button>
            </div>
        </div>
        <div style="display:none;" class="vmark"></div>
    </div>
    <div class="vinfo" style="display:block;">
        <div class="vcount col"><span class="vnum">206</span> 评论</div>
    </div>
    <div class="vlist">
        <div class="vcard" id="5daebdf1ba39c80071abdf31">
            <img class="vimg" src="/guestbook/head.png">
            <div class="vh" rootid="5daebdf1ba39c80071abdf31">
                <div class="vhead">
                    <span class="vnick">Anonymous</span>
                    <span class="vsys">Chrome 75.0.3770.8</span>
                    <span class="vsys">Windows 7</span>
                </div>
                <div class="vmeta">
                    <span class="vtime">2019-10-12</span>
                    <#--<span class="vat">回复</span>-->
                </div>
                <div class="vcontent">
                    <p>是</p>
                </div>
            </div>
        </div>
    </div>
    <div class="vpage txt-center">
        <button type="button" class="vmore vbtn">查看更多...</button>
    </div>
</div>
</div>
</body>
</html>