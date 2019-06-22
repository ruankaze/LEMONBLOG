<#--
  Created by IntelliJ IDEA.
  User: NingZe
  Date: 2019/5/28 0028
  Time: 17:21
  To change this template use File | Settings | File Templates.
-->
<!DOCTYPE html>
<html lang="en" class="ie9" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Test</title>
</head>
<body style="background: url('/images/3.jpg')">

<h1 style="color: white;cursor: progress;">{{ username }}金木 - {{time}}</h1>

</body>

<!-- jquery -->
<script type="text/javascript" src="/js/jquery-3.3.1.js"></script>

<!-- vue -->
<script type="text/javascript" src="/js/vue.js"></script>

<script type="text/javascript">

    new Vue({
        el: 'h1',
        data: {
            username: '${username}',
            time: '${time}'
        }
    });

</script>

</html>