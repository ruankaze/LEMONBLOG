<div id="nzraineffects">
    <#--
      Created by IntelliJ IDEA.
      User: NingZe
      Date: 2019/5/28 0028
      Time: 17:21
      To change this template use File | Settings | File Templates.
    -->

    <script src="/backeffect/rain/js/raineffects.js"></script>

    <style>

        .rain {
            position: absolute;
            width: 100%;
            height: 100%;
            z-index: 1;
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

    </style>

    <div class="rain front-row">

        <div class="drop" style="left: 5%; bottom: 95%; animation-delay: 0.21s; animation-duration: 0.521s;">
            <div class="stem" style="animation-delay: 0.21s; animation-duration: 0.521s;"></div>
            <div class="splat" style="animation-delay: 0.21s; animation-duration: 0.521s;"></div>
        </div>
        <div class="drop" style="left: 10%; bottom: 95%; animation-delay: 0.56s; animation-duration: 0.556s;">
            <div class="stem" style="animation-delay: 0.56s; animation-duration: 0.556s;"></div>
            <div class="splat" style="animation-delay: 0.56s; animation-duration: 0.556s;"></div>
        </div>
        <div class="drop" style="left: 14%; bottom: 93%; animation-delay: 0.85s; animation-duration: 0.585s;">
            <div class="stem" style="animation-delay: 0.85s; animation-duration: 0.585s;"></div>
            <div class="splat" style="animation-delay: 0.85s; animation-duration: 0.585s;"></div>
        </div>
        <div class="drop" style="left: 19%; bottom: 95%; animation-delay: 0.31s; animation-duration: 0.531s;">
            <div class="stem" style="animation-delay: 0.31s; animation-duration: 0.531s;"></div>
            <div class="splat" style="animation-delay: 0.31s; animation-duration: 0.531s;"></div>
        </div>
        <div class="drop" style="left: 21%; bottom: 90%; animation-delay: 0.95s; animation-duration: 0.595s;">
            <div class="stem" style="animation-delay: 0.95s; animation-duration: 0.595s;"></div>
            <div class="splat" style="animation-delay: 0.95s; animation-duration: 0.595s;"></div>
        </div>
        <div class="drop" style="left: 25%; bottom: 93%; animation-delay: 0.62s; animation-duration: 0.562s;">
            <div class="stem" style="animation-delay: 0.62s; animation-duration: 0.562s;"></div>
            <div class="splat" style="animation-delay: 0.62s; animation-duration: 0.562s;"></div>
        </div>
        <div class="drop" style="left: 30%; bottom: 95%; animation-delay: 0.30s; animation-duration: 0.530s;">
            <div class="stem" style="animation-delay: 0.30s; animation-duration: 0.530s;"></div>
            <div class="splat" style="animation-delay: 0.30s; animation-duration: 0.530s;"></div>
        </div>
        <div class="drop" style="left: 34%; bottom: 93%; animation-delay: 0.62s; animation-duration: 0.562s;">
            <div class="stem" style="animation-delay: 0.62s; animation-duration: 0.562s;"></div>
            <div class="splat" style="animation-delay: 0.62s; animation-duration: 0.562s;"></div>
        </div>
        <div class="drop" style="left: 39%; bottom: 95%; animation-delay: 0.19s; animation-duration: 0.519s;">
            <div class="stem" style="animation-delay: 0.19s; animation-duration: 0.519s;"></div>
            <div class="splat" style="animation-delay: 0.19s; animation-duration: 0.519s;"></div>
        </div>
        <div class="drop" style="left: 43%; bottom: 93%; animation-delay: 0.96s; animation-duration: 0.596s;">
            <div class="stem" style="animation-delay: 0.96s; animation-duration: 0.596s;"></div>
            <div class="splat" style="animation-delay: 0.96s; animation-duration: 0.596s;"></div>
        </div>
        <div class="drop" style="left: 48%; bottom: 95%; animation-delay: 0.93s; animation-duration: 0.593s;">
            <div class="stem" style="animation-delay: 0.93s; animation-duration: 0.593s;"></div>
            <div class="splat" style="animation-delay: 0.93s; animation-duration: 0.593s;"></div>
        </div>
        <div class="drop" style="left: 50%; bottom: 90%; animation-delay: 0.79s; animation-duration: 0.579s;">
            <div class="stem" style="animation-delay: 0.79s; animation-duration: 0.579s;"></div>
            <div class="splat" style="animation-delay: 0.79s; animation-duration: 0.579s;"></div>
        </div>
        <div class="drop" style="left: 54%; bottom: 93%; animation-delay: 0.67s; animation-duration: 0.567s;">
            <div class="stem" style="animation-delay: 0.67s; animation-duration: 0.567s;"></div>
            <div class="splat" style="animation-delay: 0.67s; animation-duration: 0.567s;"></div>
        </div>
        <div class="drop" style="left: 59%; bottom: 95%; animation-delay: 0.96s; animation-duration: 0.596s;">
            <div class="stem" style="animation-delay: 0.96s; animation-duration: 0.596s;"></div>
            <div class="splat" style="animation-delay: 0.96s; animation-duration: 0.596s;"></div>
        </div>
        <div class="drop" style="left: 64%; bottom: 95%; animation-delay: 0.7s; animation-duration: 0.57s;">
            <div class="stem" style="animation-delay: 0.7s; animation-duration: 0.57s;"></div>
            <div class="splat" style="animation-delay: 0.7s; animation-duration: 0.57s;"></div>
        </div>
        <div class="drop" style="left: 69%; bottom: 95%; animation-delay: 0.69s; animation-duration: 0.569s;">
            <div class="stem" style="animation-delay: 0.69s; animation-duration: 0.569s;"></div>
            <div class="splat" style="animation-delay: 0.69s; animation-duration: 0.569s;"></div>
        </div>
        <div class="drop" style="left: 74%; bottom: 95%; animation-delay: 0.48s; animation-duration: 0.548s;">
            <div class="stem" style="animation-delay: 0.48s; animation-duration: 0.548s;"></div>
            <div class="splat" style="animation-delay: 0.48s; animation-duration: 0.548s;"></div>
        </div>
        <div class="drop" style="left: 79%; bottom: 95%; animation-delay: 0.67s; animation-duration: 0.567s;">
            <div class="stem" style="animation-delay: 0.67s; animation-duration: 0.567s;"></div>
            <div class="splat" style="animation-delay: 0.67s; animation-duration: 0.567s;"></div>
        </div>
        <div class="drop" style="left: 82%; bottom: 92%; animation-delay: 0.2s; animation-duration: 0.52s;">
            <div class="stem" style="animation-delay: 0.2s; animation-duration: 0.52s;"></div>
            <div class="splat" style="animation-delay: 0.2s; animation-duration: 0.52s;"></div>
        </div>
        <div class="drop" style="left: 87%; bottom: 95%; animation-delay: 0.44s; animation-duration: 0.544s;">
            <div class="stem" style="animation-delay: 0.44s; animation-duration: 0.544s;"></div>
            <div class="splat" style="animation-delay: 0.44s; animation-duration: 0.544s;"></div>
        </div>
        <div class="drop" style="left: 90%; bottom: 92%; animation-delay: 0.71s; animation-duration: 0.571s;">
            <div class="stem" style="animation-delay: 0.71s; animation-duration: 0.571s;"></div>
            <div class="splat" style="animation-delay: 0.71s; animation-duration: 0.571s;"></div>
        </div>
        <div class="drop" style="left: 93%; bottom: 92%; animation-delay: 0.72s; animation-duration: 0.572s;">
            <div class="stem" style="animation-delay: 0.72s; animation-duration: 0.572s;"></div>
            <div class="splat" style="animation-delay: 0.72s; animation-duration: 0.572s;"></div>
        </div>
        <div class="drop" style="left: 95%; bottom: 93%; animation-delay: 0.59s; animation-duration: 0.559s;">
            <div class="stem" style="animation-delay: 0.59s; animation-duration: 0.559s;"></div>
            <div class="splat" style="animation-delay: 0.59s; animation-duration: 0.559s;"></div>
        </div>
    </div>

    <div class="rain back-row">

        <div class="drop" style="right: 5%; bottom: 95%; animation-delay: 0.21s; animation-duration: 0.521s;">
            <div class="stem" style="animation-delay: 0.21s; animation-duration: 0.521s;"></div>
            <div class="splat" style="animation-delay: 0.21s; animation-duration: 0.521s;"></div>
        </div>
        <div class="drop" style="right: 10%; bottom: 95%; animation-delay: 0.56s; animation-duration: 0.556s;">
            <div class="stem" style="animation-delay: 0.56s; animation-duration: 0.556s;"></div>
            <div class="splat" style="animation-delay: 0.56s; animation-duration: 0.556s;"></div>
        </div>
        <div class="drop" style="right: 14%; bottom: 93%; animation-delay: 0.85s; animation-duration: 0.585s;">
            <div class="stem" style="animation-delay: 0.85s; animation-duration: 0.585s;"></div>
            <div class="splat" style="animation-delay: 0.85s; animation-duration: 0.585s;"></div>
        </div>
        <div class="drop" style="right: 19%; bottom: 95%; animation-delay: 0.31s; animation-duration: 0.531s;">
            <div class="stem" style="animation-delay: 0.31s; animation-duration: 0.531s;"></div>
            <div class="splat" style="animation-delay: 0.31s; animation-duration: 0.531s;"></div>
        </div>
        <div class="drop" style="right: 21%; bottom: 90%; animation-delay: 0.95s; animation-duration: 0.595s;">
            <div class="stem" style="animation-delay: 0.95s; animation-duration: 0.595s;"></div>
            <div class="splat" style="animation-delay: 0.95s; animation-duration: 0.595s;"></div>
        </div>
        <div class="drop" style="right: 25%; bottom: 93%; animation-delay: 0.62s; animation-duration: 0.562s;">
            <div class="stem" style="animation-delay: 0.62s; animation-duration: 0.562s;"></div>
            <div class="splat" style="animation-delay: 0.62s; animation-duration: 0.562s;"></div>
        </div>
        <div class="drop" style="right: 30%; bottom: 95%; animation-delay: 0.30s; animation-duration: 0.530s;">
            <div class="stem" style="animation-delay: 0.30s; animation-duration: 0.530s;"></div>
            <div class="splat" style="animation-delay: 0.30s; animation-duration: 0.530s;"></div>
        </div>
        <div class="drop" style="right: 34%; bottom: 93%; animation-delay: 0.62s; animation-duration: 0.562s;">
            <div class="stem" style="animation-delay: 0.62s; animation-duration: 0.562s;"></div>
            <div class="splat" style="animation-delay: 0.62s; animation-duration: 0.562s;"></div>
        </div>
        <div class="drop" style="right: 39%; bottom: 95%; animation-delay: 0.19s; animation-duration: 0.519s;">
            <div class="stem" style="animation-delay: 0.19s; animation-duration: 0.519s;"></div>
            <div class="splat" style="animation-delay: 0.19s; animation-duration: 0.519s;"></div>
        </div>
        <div class="drop" style="right: 43%; bottom: 93%; animation-delay: 0.96s; animation-duration: 0.596s;">
            <div class="stem" style="animation-delay: 0.96s; animation-duration: 0.596s;"></div>
            <div class="splat" style="animation-delay: 0.96s; animation-duration: 0.596s;"></div>
        </div>
        <div class="drop" style="right: 48%; bottom: 95%; animation-delay: 0.93s; animation-duration: 0.593s;">
            <div class="stem" style="animation-delay: 0.93s; animation-duration: 0.593s;"></div>
            <div class="splat" style="animation-delay: 0.93s; animation-duration: 0.593s;"></div>
        </div>
        <div class="drop" style="right: 50%; bottom: 90%; animation-delay: 0.79s; animation-duration: 0.579s;">
            <div class="stem" style="animation-delay: 0.79s; animation-duration: 0.579s;"></div>
            <div class="splat" style="animation-delay: 0.79s; animation-duration: 0.579s;"></div>
        </div>
        <div class="drop" style="right: 54%; bottom: 93%; animation-delay: 0.67s; animation-duration: 0.567s;">
            <div class="stem" style="animation-delay: 0.67s; animation-duration: 0.567s;"></div>
            <div class="splat" style="animation-delay: 0.67s; animation-duration: 0.567s;"></div>
        </div>
        <div class="drop" style="right: 59%; bottom: 95%; animation-delay: 0.96s; animation-duration: 0.596s;">
            <div class="stem" style="animation-delay: 0.96s; animation-duration: 0.596s;"></div>
            <div class="splat" style="animation-delay: 0.96s; animation-duration: 0.596s;"></div>
        </div>
        <div class="drop" style="right: 64%; bottom: 95%; animation-delay: 0.7s; animation-duration: 0.57s;">
            <div class="stem" style="animation-delay: 0.7s; animation-duration: 0.57s;"></div>
            <div class="splat" style="animation-delay: 0.7s; animation-duration: 0.57s;"></div>
        </div>
        <div class="drop" style="right: 69%; bottom: 95%; animation-delay: 0.69s; animation-duration: 0.569s;">
            <div class="stem" style="animation-delay: 0.69s; animation-duration: 0.569s;"></div>
            <div class="splat" style="animation-delay: 0.69s; animation-duration: 0.569s;"></div>
        </div>
        <div class="drop" style="right: 74%; bottom: 95%; animation-delay: 0.48s; animation-duration: 0.548s;">
            <div class="stem" style="animation-delay: 0.48s; animation-duration: 0.548s;"></div>
            <div class="splat" style="animation-delay: 0.48s; animation-duration: 0.548s;"></div>
        </div>
        <div class="drop" style="right: 79%; bottom: 95%; animation-delay: 0.67s; animation-duration: 0.567s;">
            <div class="stem" style="animation-delay: 0.67s; animation-duration: 0.567s;"></div>
            <div class="splat" style="animation-delay: 0.67s; animation-duration: 0.567s;"></div>
        </div>
        <div class="drop" style="right: 82%; bottom: 92%; animation-delay: 0.2s; animation-duration: 0.52s;">
            <div class="stem" style="animation-delay: 0.2s; animation-duration: 0.52s;"></div>
            <div class="splat" style="animation-delay: 0.2s; animation-duration: 0.52s;"></div>
        </div>
        <div class="drop" style="right: 87%; bottom: 95%; animation-delay: 0.44s; animation-duration: 0.544s;">
            <div class="stem" style="animation-delay: 0.44s; animation-duration: 0.544s;"></div>
            <div class="splat" style="animation-delay: 0.44s; animation-duration: 0.544s;"></div>
        </div>
        <div class="drop" style="right: 90%; bottom: 92%; animation-delay: 0.71s; animation-duration: 0.571s;">
            <div class="stem" style="animation-delay: 0.71s; animation-duration: 0.571s;"></div>
            <div class="splat" style="animation-delay: 0.71s; animation-duration: 0.571s;"></div>
        </div>
        <div class="drop" style="right: 93%; bottom: 92%; animation-delay: 0.72s; animation-duration: 0.572s;">
            <div class="stem" style="animation-delay: 0.72s; animation-duration: 0.572s;"></div>
            <div class="splat" style="animation-delay: 0.72s; animation-duration: 0.572s;"></div>
        </div>
        <div class="drop" style="right: 95%; bottom: 93%; animation-delay: 0.59s; animation-duration: 0.559s;">
            <div class="stem" style="animation-delay: 0.59s; animation-duration: 0.559s;"></div>
            <div class="splat" style="animation-delay: 0.59s; animation-duration: 0.559s;"></div>
        </div>
    </div>

    <script>
        let makeItRain = function () {
            let increment = 0, randoHundo, randoFiver, drops = "", backDrops = "", $front = $('.rain.front-row'), $back = $('.rain.back-row');
            while (increment < 100) {
                //couple random numbers to use for letious randomizations
                //random number between 98 and 1
                randoHundo = (Math.floor(Math.random() * (95 - 1 + 1) + 1));
                //random number between 5 and 2
                randoFiver = (Math.floor(Math.random() * (5 - 2 + 1) + 2));
                //increment
                increment += randoFiver;
                //size > 95 break
                if (parseInt(increment) >= 95) {
                    break;
                }
                //add in a new raindrop with letious randomizations to certain CSS properties
                drops += '<div class="drop" style="left: ' + increment + '%; bottom: ' + (randoFiver + randoFiver - 1 + 90 - 2) + '%; animation-delay: 0.' + randoHundo + 's; animation-duration: 0.5' + randoHundo + 's;"><div class="stem" style="animation-delay: 0.' + randoHundo + 's; animation-duration: 0.5' + randoHundo + 's;"></div><div class="splat" style="animation-delay: 0.' + randoHundo + 's; animation-duration: 0.5' + randoHundo + 's;"></div></div>';
                backDrops += '<div class="drop" style="right: ' + increment + '%; bottom: ' + (randoFiver + randoFiver - 1 + 90 - 2) + '%; animation-delay: 0.' + randoHundo + 's; animation-duration: 0.5' + randoHundo + 's;"><div class="stem" style="animation-delay: 0.' + randoHundo + 's; animation-duration: 0.5' + randoHundo + 's;"></div><div class="splat" style="animation-delay: 0.' + randoHundo + 's; animation-duration: 0.5' + randoHundo + 's;"></div></div>';
            }
            $front.append(drops);
            $back.append(backDrops);
        }
        makeItRain();
    </script>

    <!--
    <script>
        let makeItRain = function () {
            let drops = "";
            let backDrops = "";
            let n = 0, increment = 0, fornums = 0;
            let num = Math.ceil(Math.random() * 20) + 30;
            console.log(num);
            while (n < num) {
                fornums = Math.ceil(Math.random() * 2);
                for (let i = 0; i < fornums; i++) {
                    // couple random numbers to use for letious randomizations
                    // random number between 98 and 1
                    let randoHundo = (Math.floor(Math.random() * (98 - 1 + 1) + 1));
                    // random number between 5 and 2
                    let randoFiver = (Math.floor(Math.random() * (5 - 2 + 1) + 2));
                    // increment
                    increment += randoFiver;
                    if (parseInt(increment) >= 100) {
                        increment = Math.ceil(Math.random() * 30) + 2;
                    }
                    //add in a new raindrop with letious randomizations to certain CSS properties
                    drops = '<div class="drop" style="left: ' + increment + '%; bottom: ' + (randoFiver + randoFiver - 1 + 100) + '%; animation-delay: 0.' + randoHundo + 's; animation-duration: 0.5' + randoHundo + 's;"><div class="stem" style="animation-delay: 0.' + randoHundo + 's; animation-duration: 0.5' + randoHundo + 's;"></div><div class="splat" style="animation-delay: 0.' + randoHundo + 's; animation-duration: 0.5' + randoHundo + 's;"></div></div>';
                    backDrops = '<div class="drop" style="right: ' + increment + '%; bottom: ' + (randoFiver + randoFiver - 1 + 100) + '%; animation-delay: 0.' + randoHundo + 's; animation-duration: 0.5' + randoHundo + 's;"><div class="stem" style="animation-delay: 0.' + randoHundo + 's; animation-duration: 0.5' + randoHundo + 's;"></div><div class="splat" style="animation-delay: 0.' + randoHundo + 's; animation-duration: 0.5' + randoHundo + 's;"></div></div>';
                    $('.rain.front-row').append(drops);
                    $('.rain.back-row').append(backDrops);
                }
                n++;
            }
        }
        makeItRain();
    </script>
    -->

</div>