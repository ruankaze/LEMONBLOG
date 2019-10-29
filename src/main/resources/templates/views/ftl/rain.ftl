<#--
  Created by IntelliJ IDEA.
  User: NingZe
  Date: 2019/10/28 0028
  Time: 15:31
  To change this template use File | Settings | File Templates.
-->
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>雨</title>
    <style>
        html {
            height: 100%;
        }

        body {
            height: 100%;
            margin: 0;
            overflow: hidden;
            /*background: linear-gradient(to bottom, #202020, #111119);*/
            background: url('${Application.topGodInfo.godterritory}') no-repeat center;background-size: cover;
        }

        body:after {
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background-color: rgba(0, 0, 0, 0.52);
            content: "";
        }

        .rain {
            position: absolute;
            left: 0;
            width: 100%;
            height: 100%;
            z-index: 2;
        }

        .rain.back-row {
            display: none;
            z-index: 1;
            bottom: 60px;
            opacity: 0.5;
        }

        body.back-row-toggle .rain.back-row {
            display: block;
        }

        .drop {
            position: absolute;
            bottom: 100%;
            width: 15px;
            height: 120px;
            pointer-events: none;
            animation: drop 0.5s linear infinite;
        }

        @keyframes drop {
            0% {
                transform: translateY(0vh);
            }
            75% {
                transform: translateY(90vh);
            }
            100% {
                transform: translateY(90vh);
            }
        }

        .stem {
            width: 1px;
            height: 60%;
            margin-left: 7px;
            background: linear-gradient(to bottom, rgba(255, 255, 255, 0), rgba(255, 255, 255, 0.25));
            animation: stem 0.5s linear infinite;
        }

        @keyframes stem {
            0% {
                opacity: 1;
            }
            65% {
                opacity: 1;
            }
            75% {
                opacity: 0;
            }
            100% {
                opacity: 0;
            }
        }

        .splat {
            width: 15px;
            height: 10px;
            border-top: 2px dotted rgba(255, 255, 255, 0.5);
            border-radius: 50%;
            opacity: 1;
            transform: scale(0);
            animation: splat 0.5s linear infinite;
            display: none;
        }

        body.splat-toggle .splat {
            display: block;
        }

        @keyframes splat {
            0% {
                opacity: 1;
                transform: scale(0);
            }
            80% {
                opacity: 1;
                transform: scale(0);
            }
            90% {
                opacity: 0.5;
                transform: scale(1);
            }
            100% {
                opacity: 0;
                transform: scale(1.5);
            }
        }

        .toggles {
            position: absolute;
            top: 0;
            left: 0;
            z-index: 3;
        }

        .toggle {
            position: absolute;
            left: 20px;
            width: 50px;
            height: 50px;
            line-height: 51px;
            box-sizing: border-box;
            text-align: center;
            font-family: sans-serif;
            font-size: 10px;
            font-weight: bold;
            background-color: rgba(255, 255, 255, 0.2);
            color: rgba(0, 0, 0, 0.5);
            border-radius: 50%;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .toggle:hover {
            background-color: rgba(255, 255, 255, 0.25);
        }

        .toggle:active {
            background-color: rgba(255, 255, 255, 0.3);
        }

        .toggle.active {
            background-color: rgba(255, 255, 255, 0.4);
        }

        .splat-toggle {
            top: 20px;
        }

        .back-row-toggle {
            top: 90px;
            line-height: 12px;
            padding-top: 14px;
        }

        .single-toggle {
            top: 160px;
        }

        body.single-toggle .drop {
            display: none;
        }

        body.single-toggle .drop:nth-child(10) {
            display: block;
        }
    </style>
</head>
<body class="back-row-toggle splat-toggle">

<div class="rain front-row">
    <div class="drop" style="left: 5%; bottom: 109%; animation-delay: 0.93s; animation-duration: 0.593s;">
        <div class="stem" style="animation-delay: 0.93s; animation-duration: 0.593s;"></div>
        <div class="splat" style="animation-delay: 0.93s; animation-duration: 0.593s;"></div>
    </div>
    <div class="drop" style="left: 7%; bottom: 103%; animation-delay: 0.93s; animation-duration: 0.593s;">
        <div class="stem" style="animation-delay: 0.93s; animation-duration: 0.593s;"></div>
        <div class="splat" style="animation-delay: 0.93s; animation-duration: 0.593s;"></div>
    </div>
    <div class="drop" style="left: 12%; bottom: 109%; animation-delay: 0.42s; animation-duration: 0.542s;">
        <div class="stem" style="animation-delay: 0.42s; animation-duration: 0.542s;"></div>
        <div class="splat" style="animation-delay: 0.42s; animation-duration: 0.542s;"></div>
    </div>
    <div class="drop" style="left: 17%; bottom: 109%; animation-delay: 0.91s; animation-duration: 0.591s;">
        <div class="stem" style="animation-delay: 0.91s; animation-duration: 0.591s;"></div>
        <div class="splat" style="animation-delay: 0.91s; animation-duration: 0.591s;"></div>
    </div>
    <div class="drop" style="left: 21%; bottom: 107%; animation-delay: 0.83s; animation-duration: 0.583s;">
        <div class="stem" style="animation-delay: 0.83s; animation-duration: 0.583s;"></div>
        <div class="splat" style="animation-delay: 0.83s; animation-duration: 0.583s;"></div>
    </div>
    <div class="drop" style="left: 23%; bottom: 103%; animation-delay: 0.64s; animation-duration: 0.564s;">
        <div class="stem" style="animation-delay: 0.64s; animation-duration: 0.564s;"></div>
        <div class="splat" style="animation-delay: 0.64s; animation-duration: 0.564s;"></div>
    </div>
    <div class="drop" style="left: 26%; bottom: 105%; animation-delay: 0.59s; animation-duration: 0.559s;">
        <div class="stem" style="animation-delay: 0.59s; animation-duration: 0.559s;"></div>
        <div class="splat" style="animation-delay: 0.59s; animation-duration: 0.559s;"></div>
    </div>
    <div class="drop" style="left: 30%; bottom: 107%; animation-delay: 0.39s; animation-duration: 0.539s;">
        <div class="stem" style="animation-delay: 0.39s; animation-duration: 0.539s;"></div>
        <div class="splat" style="animation-delay: 0.39s; animation-duration: 0.539s;"></div>
    </div>
    <div class="drop" style="left: 34%; bottom: 107%; animation-delay: 0.29s; animation-duration: 0.529s;">
        <div class="stem" style="animation-delay: 0.29s; animation-duration: 0.529s;"></div>
        <div class="splat" style="animation-delay: 0.29s; animation-duration: 0.529s;"></div>
    </div>
    <div class="drop" style="left: 36%; bottom: 103%; animation-delay: 0.67s; animation-duration: 0.567s;">
        <div class="stem" style="animation-delay: 0.67s; animation-duration: 0.567s;"></div>
        <div class="splat" style="animation-delay: 0.67s; animation-duration: 0.567s;"></div>
    </div>
    <div class="drop" style="left: 40%; bottom: 107%; animation-delay: 0.81s; animation-duration: 0.581s;">
        <div class="stem" style="animation-delay: 0.81s; animation-duration: 0.581s;"></div>
        <div class="splat" style="animation-delay: 0.81s; animation-duration: 0.581s;"></div>
    </div>
    <div class="drop" style="left: 42%; bottom: 103%; animation-delay: 0.89s; animation-duration: 0.589s;">
        <div class="stem" style="animation-delay: 0.89s; animation-duration: 0.589s;"></div>
        <div class="splat" style="animation-delay: 0.89s; animation-duration: 0.589s;"></div>
    </div>
    <div class="drop" style="left: 44%; bottom: 103%; animation-delay: 0.27s; animation-duration: 0.527s;">
        <div class="stem" style="animation-delay: 0.27s; animation-duration: 0.527s;"></div>
        <div class="splat" style="animation-delay: 0.27s; animation-duration: 0.527s;"></div>
    </div>
    <div class="drop" style="left: 49%; bottom: 109%; animation-delay: 0.78s; animation-duration: 0.578s;">
        <div class="stem" style="animation-delay: 0.78s; animation-duration: 0.578s;"></div>
        <div class="splat" style="animation-delay: 0.78s; animation-duration: 0.578s;"></div>
    </div>
    <div class="drop" style="left: 52%; bottom: 105%; animation-delay: 0.68s; animation-duration: 0.568s;">
        <div class="stem" style="animation-delay: 0.68s; animation-duration: 0.568s;"></div>
        <div class="splat" style="animation-delay: 0.68s; animation-duration: 0.568s;"></div>
    </div>
    <div class="drop" style="left: 55%; bottom: 105%; animation-delay: 0.98s; animation-duration: 0.598s;">
        <div class="stem" style="animation-delay: 0.98s; animation-duration: 0.598s;"></div>
        <div class="splat" style="animation-delay: 0.98s; animation-duration: 0.598s;"></div>
    </div>
    <div class="drop" style="left: 58%; bottom: 105%; animation-delay: 0.8s; animation-duration: 0.58s;">
        <div class="stem" style="animation-delay: 0.8s; animation-duration: 0.58s;"></div>
        <div class="splat" style="animation-delay: 0.8s; animation-duration: 0.58s;"></div>
    </div>
    <div class="drop" style="left: 62%; bottom: 107%; animation-delay: 0.40s; animation-duration: 0.540s;">
        <div class="stem" style="animation-delay: 0.40s; animation-duration: 0.540s;"></div>
        <div class="splat" style="animation-delay: 0.40s; animation-duration: 0.540s;"></div>
    </div>
    <div class="drop" style="left: 64%; bottom: 103%; animation-delay: 0.22s; animation-duration: 0.522s;">
        <div class="stem" style="animation-delay: 0.22s; animation-duration: 0.522s;"></div>
        <div class="splat" style="animation-delay: 0.22s; animation-duration: 0.522s;"></div>
    </div>
    <div class="drop" style="left: 69%; bottom: 109%; animation-delay: 0.39s; animation-duration: 0.539s;">
        <div class="stem" style="animation-delay: 0.39s; animation-duration: 0.539s;"></div>
        <div class="splat" style="animation-delay: 0.39s; animation-duration: 0.539s;"></div>
    </div>
    <div class="drop" style="left: 74%; bottom: 109%; animation-delay: 0.24s; animation-duration: 0.524s;">
        <div class="stem" style="animation-delay: 0.24s; animation-duration: 0.524s;"></div>
        <div class="splat" style="animation-delay: 0.24s; animation-duration: 0.524s;"></div>
    </div>
    <div class="drop" style="left: 77%; bottom: 105%; animation-delay: 0.45s; animation-duration: 0.545s;">
        <div class="stem" style="animation-delay: 0.45s; animation-duration: 0.545s;"></div>
        <div class="splat" style="animation-delay: 0.45s; animation-duration: 0.545s;"></div>
    </div>
    <div class="drop" style="left: 79%; bottom: 103%; animation-delay: 0.3s; animation-duration: 0.53s;">
        <div class="stem" style="animation-delay: 0.3s; animation-duration: 0.53s;"></div>
        <div class="splat" style="animation-delay: 0.3s; animation-duration: 0.53s;"></div>
    </div>
    <div class="drop" style="left: 81%; bottom: 103%; animation-delay: 0.51s; animation-duration: 0.551s;">
        <div class="stem" style="animation-delay: 0.51s; animation-duration: 0.551s;"></div>
        <div class="splat" style="animation-delay: 0.51s; animation-duration: 0.551s;"></div>
    </div>
    <div class="drop" style="left: 86%; bottom: 109%; animation-delay: 0.23s; animation-duration: 0.523s;">
        <div class="stem" style="animation-delay: 0.23s; animation-duration: 0.523s;"></div>
        <div class="splat" style="animation-delay: 0.23s; animation-duration: 0.523s;"></div>
    </div>
    <div class="drop" style="left: 91%; bottom: 109%; animation-delay: 0.78s; animation-duration: 0.578s;">
        <div class="stem" style="animation-delay: 0.78s; animation-duration: 0.578s;"></div>
        <div class="splat" style="animation-delay: 0.78s; animation-duration: 0.578s;"></div>
    </div>
    <div class="drop" style="left: 96%; bottom: 109%; animation-delay: 0.19s; animation-duration: 0.519s;">
        <div class="stem" style="animation-delay: 0.19s; animation-duration: 0.519s;"></div>
        <div class="splat" style="animation-delay: 0.19s; animation-duration: 0.519s;"></div>
    </div>
    <div class="drop" style="left: 101%; bottom: 109%; animation-delay: 0.24s; animation-duration: 0.524s;">
        <div class="stem" style="animation-delay: 0.24s; animation-duration: 0.524s;"></div>
        <div class="splat" style="animation-delay: 0.24s; animation-duration: 0.524s;"></div>
    </div>
</div>
<div class="rain back-row">
    <div class="drop" style="right: 5%; bottom: 109%; animation-delay: 0.93s; animation-duration: 0.593s;">
        <div class="stem" style="animation-delay: 0.93s; animation-duration: 0.593s;"></div>
        <div class="splat" style="animation-delay: 0.93s; animation-duration: 0.593s;"></div>
    </div>
    <div class="drop" style="right: 7%; bottom: 103%; animation-delay: 0.93s; animation-duration: 0.593s;">
        <div class="stem" style="animation-delay: 0.93s; animation-duration: 0.593s;"></div>
        <div class="splat" style="animation-delay: 0.93s; animation-duration: 0.593s;"></div>
    </div>
    <div class="drop" style="right: 12%; bottom: 109%; animation-delay: 0.42s; animation-duration: 0.542s;">
        <div class="stem" style="animation-delay: 0.42s; animation-duration: 0.542s;"></div>
        <div class="splat" style="animation-delay: 0.42s; animation-duration: 0.542s;"></div>
    </div>
    <div class="drop" style="right: 17%; bottom: 109%; animation-delay: 0.91s; animation-duration: 0.591s;">
        <div class="stem" style="animation-delay: 0.91s; animation-duration: 0.591s;"></div>
        <div class="splat" style="animation-delay: 0.91s; animation-duration: 0.591s;"></div>
    </div>
    <div class="drop" style="right: 21%; bottom: 107%; animation-delay: 0.83s; animation-duration: 0.583s;">
        <div class="stem" style="animation-delay: 0.83s; animation-duration: 0.583s;"></div>
        <div class="splat" style="animation-delay: 0.83s; animation-duration: 0.583s;"></div>
    </div>
    <div class="drop" style="right: 23%; bottom: 103%; animation-delay: 0.64s; animation-duration: 0.564s;">
        <div class="stem" style="animation-delay: 0.64s; animation-duration: 0.564s;"></div>
        <div class="splat" style="animation-delay: 0.64s; animation-duration: 0.564s;"></div>
    </div>
    <div class="drop" style="right: 26%; bottom: 105%; animation-delay: 0.59s; animation-duration: 0.559s;">
        <div class="stem" style="animation-delay: 0.59s; animation-duration: 0.559s;"></div>
        <div class="splat" style="animation-delay: 0.59s; animation-duration: 0.559s;"></div>
    </div>
    <div class="drop" style="right: 30%; bottom: 107%; animation-delay: 0.39s; animation-duration: 0.539s;">
        <div class="stem" style="animation-delay: 0.39s; animation-duration: 0.539s;"></div>
        <div class="splat" style="animation-delay: 0.39s; animation-duration: 0.539s;"></div>
    </div>
    <div class="drop" style="right: 34%; bottom: 107%; animation-delay: 0.29s; animation-duration: 0.529s;">
        <div class="stem" style="animation-delay: 0.29s; animation-duration: 0.529s;"></div>
        <div class="splat" style="animation-delay: 0.29s; animation-duration: 0.529s;"></div>
    </div>
    <div class="drop" style="right: 36%; bottom: 103%; animation-delay: 0.67s; animation-duration: 0.567s;">
        <div class="stem" style="animation-delay: 0.67s; animation-duration: 0.567s;"></div>
        <div class="splat" style="animation-delay: 0.67s; animation-duration: 0.567s;"></div>
    </div>
    <div class="drop" style="right: 40%; bottom: 107%; animation-delay: 0.81s; animation-duration: 0.581s;">
        <div class="stem" style="animation-delay: 0.81s; animation-duration: 0.581s;"></div>
        <div class="splat" style="animation-delay: 0.81s; animation-duration: 0.581s;"></div>
    </div>
    <div class="drop" style="right: 42%; bottom: 103%; animation-delay: 0.89s; animation-duration: 0.589s;">
        <div class="stem" style="animation-delay: 0.89s; animation-duration: 0.589s;"></div>
        <div class="splat" style="animation-delay: 0.89s; animation-duration: 0.589s;"></div>
    </div>
    <div class="drop" style="right: 44%; bottom: 103%; animation-delay: 0.27s; animation-duration: 0.527s;">
        <div class="stem" style="animation-delay: 0.27s; animation-duration: 0.527s;"></div>
        <div class="splat" style="animation-delay: 0.27s; animation-duration: 0.527s;"></div>
    </div>
    <div class="drop" style="right: 49%; bottom: 109%; animation-delay: 0.78s; animation-duration: 0.578s;">
        <div class="stem" style="animation-delay: 0.78s; animation-duration: 0.578s;"></div>
        <div class="splat" style="animation-delay: 0.78s; animation-duration: 0.578s;"></div>
    </div>
    <div class="drop" style="right: 52%; bottom: 105%; animation-delay: 0.68s; animation-duration: 0.568s;">
        <div class="stem" style="animation-delay: 0.68s; animation-duration: 0.568s;"></div>
        <div class="splat" style="animation-delay: 0.68s; animation-duration: 0.568s;"></div>
    </div>
    <div class="drop" style="right: 55%; bottom: 105%; animation-delay: 0.98s; animation-duration: 0.598s;">
        <div class="stem" style="animation-delay: 0.98s; animation-duration: 0.598s;"></div>
        <div class="splat" style="animation-delay: 0.98s; animation-duration: 0.598s;"></div>
    </div>
    <div class="drop" style="right: 58%; bottom: 105%; animation-delay: 0.8s; animation-duration: 0.58s;">
        <div class="stem" style="animation-delay: 0.8s; animation-duration: 0.58s;"></div>
        <div class="splat" style="animation-delay: 0.8s; animation-duration: 0.58s;"></div>
    </div>
    <div class="drop" style="right: 62%; bottom: 107%; animation-delay: 0.40s; animation-duration: 0.540s;">
        <div class="stem" style="animation-delay: 0.40s; animation-duration: 0.540s;"></div>
        <div class="splat" style="animation-delay: 0.40s; animation-duration: 0.540s;"></div>
    </div>
    <div class="drop" style="right: 64%; bottom: 103%; animation-delay: 0.22s; animation-duration: 0.522s;">
        <div class="stem" style="animation-delay: 0.22s; animation-duration: 0.522s;"></div>
        <div class="splat" style="animation-delay: 0.22s; animation-duration: 0.522s;"></div>
    </div>
    <div class="drop" style="right: 69%; bottom: 109%; animation-delay: 0.39s; animation-duration: 0.539s;">
        <div class="stem" style="animation-delay: 0.39s; animation-duration: 0.539s;"></div>
        <div class="splat" style="animation-delay: 0.39s; animation-duration: 0.539s;"></div>
    </div>
    <div class="drop" style="right: 74%; bottom: 109%; animation-delay: 0.24s; animation-duration: 0.524s;">
        <div class="stem" style="animation-delay: 0.24s; animation-duration: 0.524s;"></div>
        <div class="splat" style="animation-delay: 0.24s; animation-duration: 0.524s;"></div>
    </div>
    <div class="drop" style="right: 77%; bottom: 105%; animation-delay: 0.45s; animation-duration: 0.545s;">
        <div class="stem" style="animation-delay: 0.45s; animation-duration: 0.545s;"></div>
        <div class="splat" style="animation-delay: 0.45s; animation-duration: 0.545s;"></div>
    </div>
    <div class="drop" style="right: 79%; bottom: 103%; animation-delay: 0.3s; animation-duration: 0.53s;">
        <div class="stem" style="animation-delay: 0.3s; animation-duration: 0.53s;"></div>
        <div class="splat" style="animation-delay: 0.3s; animation-duration: 0.53s;"></div>
    </div>
    <div class="drop" style="right: 81%; bottom: 103%; animation-delay: 0.51s; animation-duration: 0.551s;">
        <div class="stem" style="animation-delay: 0.51s; animation-duration: 0.551s;"></div>
        <div class="splat" style="animation-delay: 0.51s; animation-duration: 0.551s;"></div>
    </div>
    <div class="drop" style="right: 86%; bottom: 109%; animation-delay: 0.23s; animation-duration: 0.523s;">
        <div class="stem" style="animation-delay: 0.23s; animation-duration: 0.523s;"></div>
        <div class="splat" style="animation-delay: 0.23s; animation-duration: 0.523s;"></div>
    </div>
    <div class="drop" style="right: 91%; bottom: 109%; animation-delay: 0.78s; animation-duration: 0.578s;">
        <div class="stem" style="animation-delay: 0.78s; animation-duration: 0.578s;"></div>
        <div class="splat" style="animation-delay: 0.78s; animation-duration: 0.578s;"></div>
    </div>
    <div class="drop" style="right: 96%; bottom: 109%; animation-delay: 0.19s; animation-duration: 0.519s;">
        <div class="stem" style="animation-delay: 0.19s; animation-duration: 0.519s;"></div>
        <div class="splat" style="animation-delay: 0.19s; animation-duration: 0.519s;"></div>
    </div>
    <div class="drop" style="right: 101%; bottom: 109%; animation-delay: 0.24s; animation-duration: 0.524s;">
        <div class="stem" style="animation-delay: 0.24s; animation-duration: 0.524s;"></div>
        <div class="splat" style="animation-delay: 0.24s; animation-duration: 0.524s;"></div>
    </div>
</div>

<div class="toggles">
    <div class="splat-toggle toggle active">SPLAT</div>
    <div class="back-row-toggle toggle active">BACK<br>ROW</div>
    <div class="single-toggle toggle">SINGLE</div>
</div>

<script type="text/javascript" src="/js/jquery-3.3.1.js"></script>

<script>
    let makeItRain = function () {
        //clear out everything
        $('.rain').empty();

        let increment = 0;
        let drops = "";
        let backDrops = "";

        while (increment < 100) {
            //couple random numbers to use for various randomizations
            //random number between 98 and 1
            let randoHundo = (Math.floor(Math.random() * (98 - 1 + 1) + 1));
            //random number between 5 and 2
            let randoFiver = (Math.floor(Math.random() * (5 - 2 + 1) + 2));
            //increment
            increment += randoFiver;
            //add in a new raindrop with various randomizations to certain CSS properties
            drops += '<div class="drop" style="left: ' + increment + '%; bottom: ' + (randoFiver + randoFiver - 1 + 100) + '%; animation-delay: 0.' + randoHundo + 's; animation-duration: 0.5' + randoHundo + 's;"><div class="stem" style="animation-delay: 0.' + randoHundo + 's; animation-duration: 0.5' + randoHundo + 's;"></div><div class="splat" style="animation-delay: 0.' + randoHundo + 's; animation-duration: 0.5' + randoHundo + 's;"></div></div>';
            backDrops += '<div class="drop" style="right: ' + increment + '%; bottom: ' + (randoFiver + randoFiver - 1 + 100) + '%; animation-delay: 0.' + randoHundo + 's; animation-duration: 0.5' + randoHundo + 's;"><div class="stem" style="animation-delay: 0.' + randoHundo + 's; animation-duration: 0.5' + randoHundo + 's;"></div><div class="splat" style="animation-delay: 0.' + randoHundo + 's; animation-duration: 0.5' + randoHundo + 's;"></div></div>';
        }

        $('.rain.front-row').append(drops);
        $('.rain.back-row').append(backDrops);
    }

    $('.splat-toggle.toggle').on('click', function () {
        $('body').toggleClass('splat-toggle');
        $('.splat-toggle.toggle').toggleClass('active');
        makeItRain();
    });

    $('.back-row-toggle.toggle').on('click', function () {
        $('body').toggleClass('back-row-toggle');
        $('.back-row-toggle.toggle').toggleClass('active');
        makeItRain();
    });

    $('.single-toggle.toggle').on('click', function () {
        $('body').toggleClass('single-toggle');
        $('.single-toggle.toggle').toggleClass('active');
        makeItRain();
    });

    makeItRain();

</script>

</body>
</html>