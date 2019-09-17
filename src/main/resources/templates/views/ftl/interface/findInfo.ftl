<#--
  Created by IntelliJ IDEA.
  User: NingZe
  Date: 2019/9/16 0016
  Time: 14:03
  To change this template use File | Settings | File Templates.
-->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>信息查询</title>
</head>
<body>

<div id="identityCard">
    <input type="text"/>
    <button v-on:click="find">查询身份证信息</button>
</div>

</body>
</html>

<!-- jquery -->
<script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
<!-- vue -->
<script type="text/javascript" src="/js/vue.js"></script>

<script type="text/javascript">

    new Vue({
        el: '#identityCard button',
        methods: {
            find: function (event) {
                execresult('http://www.dffyw.com/sfzcx/query.php', 'id=' + $("#identityCard input").val().trim());
            }
        }
    });

    function execresult(url, maps) {
        let $result = null;
        $.ajax({
            url: url,
            data: maps,
            type: 'post',
            dataType: 'json',
            headers: {
                'Content-Type': 'application/json;charset=utf8',
                'organId': '1333333333'
            },
            async: false,
            success: function (result) {
                $result = result;
            }
        });
        return $result;
    }

</script>