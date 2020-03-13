<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
    <!--这个lang="zh-CN"是转化为html5的版本  -->
    <html lang="zh-CN">
    <head>
    <title>肺炎疫情图</title>
    <!-- 这个是自适应各种分辨率的屏幕 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>   
    <link rel="stylesheet"  href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script language="javascript" type="text/javascript">
        function b1()
        {
            document.getElementById("divl").style.background="white";
            document.getElementById("divr").style.background="#D7D7D7";
            document.getElementById("main_div1").style.visibility="initial";
            document.getElementById("main_div2").style.visibility="hidden";
           
 
        };
        function b2()
        {
            document.getElementById("divl").style.background="#D7D7D7";
            document.getElementById("divr").style.background="white";
            document.getElementById("main_div2").style.visibility="initial";
            document.getElementById("main_div1").style.visibility="hidden";
        };
    </script>
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
            text-align: center;

        }
        .d3
        {
           
            margin-top: 50px;
            text-align: center;
            text-align: right;
            
        }
        #img1
        {
            width: 13px;
            padding-bottom: 2px;

        }
        .d4
        {
            
            margin-left: 300px;
            text-align: center;
      
        }
        .d5
        {
           
            text-align: center;
        }
        .d6
        {
            
            text-align: center;
           
        }
        .d7
        {
           margin-top: 20px;
           

        }
        .d8
        {
            margin-top: 10px;
        }
        .d9
        {
            top: 50%;   
            margin-left: 350px;   
            
        }
        .d10
        {
            width: 50%;
            height:30px;
            float:left;
            margin-top: 5px;
            margin-bottom: 5px;
           
        }
        .d11
        {
            background:blue;
            vertical-align:middle;
        }
        .d12
        {
            margin-top: 5px;
        }
        .dmain1
        {
            margin-top: 10px;
            height:525px;
            background: #F2F2F2;
            margin-left: 300px;
            display: block;
            visibility:initial;
            
        }
        .dmain2
        {
            position: relative;
            top:-535px;
            margin-top: 10px;
            height:525px;
            background: #F2F2F2;
            margin-left: 300px;
            visibility:hidden;
          
        }
        .dbottom
        {
            margin-top: -530px;
            margin-left: 300px;
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
        .divleft
        {
            
            font-family: 'Arial Negreta', 'Arial Normal', 'Arial', sans-serif;
            font-weight: 700;
            font-style: normal;
            font-size: 18px;
            height:49px;
            padding-top: 8px;
            border-top-left-radius:30px;
            border-top-right-radius:30px;
            border-bottom-left-radius:30px;
            border-bottom-right-radius:30px; 
            background: white;
            cursor: pointer;
        }
        .divright
        {
            font-family: 'Arial Negreta', 'Arial Normal', 'Arial', sans-serif;
            font-weight: 700;
            font-style: normal;
            font-size: 18px;
            height:49px;
            padding-top: 8px;
            border-top-left-radius:30px;
            border-top-right-radius:30px;
            border-bottom-left-radius:30px;
            border-bottom-right-radius:30px; 
            background: #D7D7D7;
            cursor: pointer;
        }
        .divoutside
        {
            height:60px;
            border-top-left-radius:30px;
            border-top-right-radius:30px;
            border-bottom-left-radius:30px;
            border-bottom-right-radius:30px; 
            background: #D7D7D7;
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
        .bottomfont
        {
            font-size: 12px;
        }
        .inputbox1
        {
            float:left;
            width:40px;
            height: 15px;
            margin-top: 2px;
        }
        .inputbox2
        {
            float:left;
            width:20px;
            margin-left: 2px;
            height: 15px;
            margin-top: 2px;
        }
        .inputbox3
        {
            float:left;
            width:20px;
            margin-left: 2px;
            height: 15px;
            margin-top: 2px;
        }
        .divfloat
        {
            float:left;
        
        }
        .btn
        {
            height:17px;
            width: 35px;
            padding-top: 0px;
            font-size: 12px;
            padding-left: 5px;
            margin-left: 10px;
            margin-top: -3px;
        }
    </style>
   
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-4 d1 draktext">更新至
                    <form action="1.html">
                        <input class="inputbox1" value="2020">
                        <div class="divfloat">年</div>
                        <input class="inputbox2" value="02">
                        <div class="divfloat">月</div>
                        <input class="inputbox3"value="25">
                        <div class="divfloat">日</div>
                        <button type="submit" class="btn btn-primary ">查看</button>   
                    </form>

                </div>
       
                <div class="col-sm-2 d3 draktext"><img id="img1" class="draktext" src="image/问号.png">数据说明</div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-sm-2 d4 d8">现有确诊</div>
                <div class="col-sm-2 d5 d8">现有疑似</div>
                <div class="col-sm-2 d6 d8" >现有重症</div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-sm-2 d4 middlefont color1">123</div>
                <div class="col-sm-2 d5 middlefont color2">123</div>
                <div class="col-sm-2 d6 middlefont color3">123</div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-sm-2 d4 bottomfont">昨日:<span class="color1">+123</span></div>
                <div class="col-sm-2 d5 bottomfont">昨日:<span class="color2">+123</span></div>
                <div class="col-sm-2 d6 bottomfont">昨日:<span class="color3">+123</span></div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-sm-2 d4 d7">现有确诊</div>
                <div class="col-sm-2 d5 d7">现有疑似</div>
                <div class="col-sm-2 d6 d7">现有重症</div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-sm-2 d4 middlefont color4">123</div>
                <div class="col-sm-2 d5 middlefont color5">123</div>
                <div class="col-sm-2 d6 middlefont ">123</div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-sm-2 d4 bottomfont">昨日:<span class="color4">+123</span></div>
                <div class="col-sm-2 d5 bottomfont">昨日:<span class="color5">+123</span></div>
                <div class="col-sm-2 d6 bottomfont">昨日:<span >+123</span></div>
            </div>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-sm-5 d5 d7 d9 divoutside ">
                        <div class=" d6 d7  d10 divleft" id="divl" onclick=b1()>
                            <p class="d12" >现有确诊</p>
                        </div>
                        <div class=" d6 d7  d10 d11 divright" id="divr" onclick=b2()>
                            <p class="d12" >累计确诊</p>
                        </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-sm-6 dmain1" id="main_div1"></div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-sm-6 dmain2" id="main_div2"></div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-sm-6 dbottom draktext">趋势图与国家卫健委官网发布一致,每日更新一次<img id="img1" src="image/问号.png"></div>
            </div>
        </div>
        
    </body>

    <script src="js/dist/echarts.js"></script>
        <script src="js/map/js/china.js"></script>
        <script type="text/javascript">
            var dataList = [
                { name: "南海诸岛", value: 0 },
                { name: '北京', value: randomValue() },
                { name: '天津', value: randomValue() },
                { name: '上海', value: randomValue() },
                { name: '重庆', value: randomValue() },
                { name: '河北', value: randomValue() },
                { name: '河南', value: randomValue() },
                { name: '云南', value: randomValue() },
                { name: '辽宁', value: randomValue() },
                { name: '黑龙江', value: randomValue() },
                { name: '湖南', value: randomValue() },
                { name: '安徽', value: randomValue() },
                { name: '山东', value: randomValue() },
                { name: '新疆', value: randomValue() },
                { name: '江苏', value: randomValue() },
                { name: '浙江', value: randomValue() },
                { name: '江西', value: randomValue() },
                { name: '湖北', value: randomValue() },
                { name: '广西', value: randomValue() },
                { name: '甘肃', value: randomValue() },
                { name: '山西', value: randomValue() },
                { name: '内蒙古', value: randomValue() },
                { name: '陕西', value: randomValue() },
                { name: '吉林', value: randomValue() },
                { name: '福建', value: randomValue() },
                { name: '贵州', value: randomValue() },
                { name: '广东', value: randomValue() },
                { name: '青海', value: randomValue() },
                { name: '西藏', value: randomValue() },
                { name: '四川', value: randomValue() },
                { name: '宁夏', value: randomValue() },
                { name: '海南', value: randomValue() },
                { name: '台湾', value: randomValue() },
                { name: '香港', value: randomValue() },
                { name: '澳门', value: randomValue() }
            ]
            var myChart = echarts.init(document.getElementById('main_div1'));
            function randomValue() {
                return Math.round(Math.random() * 1000);
            }
            option = {
                tooltip: {
                    formatter: function (params, ticket, callback) {
                        return params.seriesName + '<br />' + params.name + '：' + params.value
                    }//数据格式化
                },
                visualMap: {
                    min: 0,
                    max: 1500,
                    left: 'left',
                    top: 'bottom',
                    text: ['高', '低'],//取值范围的文字
                    inRange: {
                        color: ['#e0ffff', '#006edd']//取值范围的颜色
                    },
                    show: true//图注
                },
                geo: {
                    map: 'china',
                    roam: false,//不开启缩放和平移
                    zoom: 1.23,//视角缩放比例
                    label: {
                        normal: {
                            show: true,
                            fontSize: '10',
                            color: 'rgba(0,0,0,0.7)'
                        }
                    },
                    itemStyle: {
                        normal: {
                            borderColor: 'rgba(0, 0, 0, 0.2)'
                        },
                        emphasis: {
                            areaColor: '#F3B329',//鼠标选择区域颜色
                            shadowOffsetX: 0,
                            shadowOffsetY: 0,
                            shadowBlur: 20,
                            borderWidth: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                },
                series: [
                    {
                        name: "现有确诊",
                        type: 'map',
                        geoIndex: 0,
                        data: dataList
                    }
                ]
            };
            myChart.setOption(option);
            myChart.on('click', function (params) {
                sessionStorage.setItem('name', params.name);
                window.location.href = "2.html";
            });
            var dataList = [
                { name: "南海诸岛", value: 0 },
                { name: '北京', value: randomValue() },
                { name: '天津', value: randomValue() },
                { name: '上海', value: randomValue() },
                { name: '重庆', value: randomValue() },
                { name: '河北', value: randomValue() },
                { name: '河南', value: randomValue() },
                { name: '云南', value: randomValue() },
                { name: '辽宁', value: randomValue() },
                { name: '黑龙江', value: randomValue() },
                { name: '湖南', value: randomValue() },
                { name: '安徽', value: randomValue() },
                { name: '山东', value: randomValue() },
                { name: '新疆', value: randomValue() },
                { name: '江苏', value: randomValue() },
                { name: '浙江', value: randomValue() },
                { name: '江西', value: randomValue() },
                { name: '湖北', value: randomValue() },
                { name: '广西', value: randomValue() },
                { name: '甘肃', value: randomValue() },
                { name: '山西', value: randomValue() },
                { name: '内蒙古', value: randomValue() },
                { name: '陕西', value: randomValue() },
                { name: '吉林', value: randomValue() },
                { name: '福建', value: randomValue() },
                { name: '贵州', value: randomValue() },
                { name: '广东', value: randomValue() },
                { name: '青海', value: randomValue() },
                { name: '西藏', value: randomValue() },
                { name: '四川', value: randomValue() },
                { name: '宁夏', value: randomValue() },
                { name: '海南', value: randomValue() },
                { name: '台湾', value: randomValue() },
                { name: '香港', value: randomValue() },
                { name: '澳门', value: randomValue() }
            ]
            var myChart = echarts.init(document.getElementById('main_div2'));
            function randomValue() {
                return Math.round(Math.random() * 1000);
            }
            option = {
                tooltip: {
                    formatter: function (params, ticket, callback) {
                        return params.seriesName + '<br />' + params.name + '：' + params.value
                    }//数据格式化
                },
                visualMap: {
                    min: 0,
                    max: 1500,
                    left: 'left',
                    top: 'bottom',
                    text: ['高', '低'],//取值范围的文字
                    inRange: {
                        color: ['#e0ffff', '#006edd']//取值范围的颜色
                    },
                    show: true//图注
                },
                geo: {
                    map: 'china',
                    roam: false,//不开启缩放和平移
                    zoom: 1.23,//视角缩放比例
                    label: {
                        normal: {
                            show: true,
                            fontSize: '10',
                            color: 'rgba(0,0,0,0.7)'
                        }
                    },
                    itemStyle: {
                        normal: {
                            borderColor: 'rgba(0, 0, 0, 0.2)'
                        },
                        emphasis: {
                            areaColor: '#F3B329',//鼠标选择区域颜色
                            shadowOffsetX: 0,
                            shadowOffsetY: 0,
                            shadowBlur: 20,
                            borderWidth: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                },
                series: [
                    {
                        name: "累计确诊",
                        type: 'map',
                        geoIndex: 0,
                        data: dataList
                    }
                ]
            };
            myChart.setOption(option);
            myChart.on('click', function (params) {
                sessionStorage.setItem('name', params.name);
                window.location.href = "detail.jsp";
            });
           
        </script>
