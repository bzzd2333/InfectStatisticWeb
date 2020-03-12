<!DOCTYPE html>
    <!--这个lang="zh-CN"是转化为html5的版本  -->
    <html lang="zh-CN">
    <head>
    <title>学习bootstrap案例</title>
    <!-- 这个是自适应各种分辨率的屏幕 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>   
    <link rel="stylesheet"  href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    </head>
    <style>
        .d1
        {
            margin-left: 300px;
            margin-top: 50px;
            
            text-align: left;
        }
        .d2
        {
            margin-top: 50px;
           
        }
        .d3
        {
            margin-top: 50px;
          
        }
        .d4
        {
            margin-left: 300px;
            text-align: left;
        }
        .d5
        {
            text-align: center;
        }
        .d6
        {
            text-align: right;
        }
        #img1
        {
            width: 13px;
            padding-bottom: 2px;

        }
        .datadiv
        {
            width:25%;
            float: left;
            text-align: center;
        }
        .divmain
        {
            height: 470px;
        }
        .mycol2
        {
            width: 200px;
            float:left;
        }
        .mycol6
        {
            width: 600px;
            float:left;
        }
        .detitle
        {
            margin-top: 10px;
        }
        .dlast
        {
            margin-top:10px;
            text-align: center;
        }
        .dbold
        {
            font-size: 13px;
            font-family: 'Arial Negreta', 'Arial Normal', 'Arial', sans-serif;
            font-weight: 700;
        }
        .draktext
        {
            color:#7F7F7F;
            font-family: 'Arial Normal', 'Arial', sans-serif;
            font-size: 13px;
        }
        .middlefont
        {
            font-family: 'Arial Negreta', 'Arial Normal', 'Arial', sans-serif;
            font-weight: 700;
            font-style: normal;
            font-size: 18px;
        }
        .bottomfont
        {
            font-size: 12px;
        }
        .color1
        {
            color:#FF370A;
        }
        .color2
        {
            color:#F59A23;
        }
        .color3
        {
            color:#015478;
        }
        .color4
        {
            color:#EB001B;
        }
        .color5
        {
            color:#00BFBF;
        }
        .col-sm-2
        {
            width: 200px;
        }
    </style>

    <body>
        <div class="container">
            <div class="row">
                <div class="mycol2 d1 dbold">新疆</div>
                <div class="mycol2 d2"></div>
                <div class="mycol2 d3"></div>
            </div>
        </div>    

        <div class="container">
            <div class="row">
                <div class="mycol2 d4 draktext">更新至 2020.02.26 12:40</div>
                <div class="col-sm-2 d5"></div>
                <div class="mycol2 d6 draktext"><img id="img1" class="draktext" src="image/问号.png">数据说明</div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="mycol6 d4">
                    <div class="datadiv">现有确诊</div>
                    <div class="datadiv">累计确诊</div>
                    <div class="datadiv">累计治愈</div>
                    <div class="datadiv">累计死亡</div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="mycol6 d4">
                    <div class="datadiv middlefont color1">123</div>
                    <div class="datadiv middlefont color4">123</div>
                    <div class="datadiv middlefont color5">123</div>
                    <div class="datadiv middlefont ">123</div>
                </div>
            </div>
        </div> 
        <div class="container">
            <div class="row">
                <div class="mycol6 d4">
                    <div class="datadiv bottomfont color1">昨日:<span>+123</span></div>
                    <div class="datadiv bottomfont color4">昨日:<span>+123</span></div>
                    <div class="datadiv bottomfont color5">昨日:<span>+123</span></div>
                    <div class="datadiv bottomfont ">昨日:<span>+123</span></div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="mycol6 d4 detitle">
                   新疆新增确诊趋势图
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="mycol6 d4 divmain">
                   
                </div>
            </div>
        </div>  
        <div class="container">
            <div class="row">
                <div class="mycol2 d4 dlast"><br>新增<p>确诊趋势</p></div>
                <div class="mycol2 d5 dlast"><br>累计<p>确诊趋势</p></div>
                <div class="mycol2 d6 dlast"><br>累计<p>治愈/死亡</p></div>
            </div>
        </div>  





    </body>
</html>
    