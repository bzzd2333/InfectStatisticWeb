<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 

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
        .mtop
        {
            margin-top:10px;
        }
        .mmiddle
        {
            margin-top:2px;
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
            margin-top:15px;
            border: 1px;
            border-style: solid;
         
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
            margin-top: 15px;
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
            height:25px;
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
        .col-sm-6
        {
            width:600px;
        }
        .div_data_main
        {
            background: rgba(242, 242, 242, 1);
        }
        .div_top_r
        {
            border-top-left-radius:15px;
            border-top-right-radius:15px;
        }
        .div_bottom_r
        {
            border-bottom-left-radius:15px;
            border-bottom-right-radius:15px; 
        }
    </style>

    <body>
        <div class="container">
            <div class="row">
                <div class="mycol2 d1 dbold" id="title2">新疆</div>
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
                <div class="row ">
                    <div class="mycol6 d4 div_data_main div_top_r">
                        <div class="datadiv mtop">现有确诊</div>
                        <div class="datadiv mtop">累计确诊</div>
                        <div class="datadiv mtop">累计治愈</div>
                        <div class="datadiv mtop">累计死亡</div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="mycol6 d4 div_data_main ">
                        <div class="datadiv middlefont color1 mmiddle">123</div>
                        <div class="datadiv middlefont color4 mmiddle">123</div>
                        <div class="datadiv middlefont color5 mmiddle">123</div>
                        <div class="datadiv middlefont mmiddle ">123</div>
                    </div>
                </div>
            </div> 
            <div class="container">
                <div class="row">
                    <div class="mycol6 d4 div_data_main div_bottom_r">
                        <div class="datadiv bottomfont color1">昨日:<span>+123</span></div>
                        <div class="datadiv bottomfont color4">昨日:<span>+123</span></div>
                        <div class="datadiv bottomfont color5">昨日:<span>+123</span></div>
                        <div class="datadiv bottomfont ">昨日:<span>+123</span></div>
                    </div>
                </div>
            </div>
        
        
      
        <div class="container">
            <div class="row">
                <div class="mycol6 col-sm-6 d4 divmain" id="div_main">
                   
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
    <script src="js/echarts.min.js"></script>
<script>
  province_name = sessionStorage.getItem('name');
  content = document.getElementById('u39_input');
  content.value = province_name;

</script>

<script type="text/javascript">
  var dom = document.getElementById("div_main");
  var myChart = echarts.init(dom);
  var app = {};
  option = null;
  option = {
    title: {
      text: province_name + "新增确诊趋势图",
      textStyle: {
        fontSize: 13,
      }
    },
    tooltip: {
      formatter: function (params, ticket, callback) {
        return params.name + '<br />' + '新增确诊:' + params.value
      }//数据格式化
    },
    xAxis: {
      name: '日期',
      type: 'category',
      data: ['2-21', '2-22', '2-23', '2-24', '2-25', '2-26', '2-27'],
      axisLabel: {
        textStyle: {
          fontSize: 10,
          color: '#7F7F7F'
        }
      },
      nameTextStyle:{
            color:'#7F7F7F',
        },
     
    },
    yAxis: {
      name: '单位:例',
      type: 'value',
      axisLabel: {
        textStyle: {
          fontSize: 10,
          color: '#7F7F7F'
        }
      },
      nameTextStyle:{
            color:'#7F7F7F',
        },

    },
    series: [{
      data: [1, 2, 1, 3, 4, 1, 3],
      type: 'line',
      smooth: true

    }]
  };
  ;
  if (option && typeof option === "object") {
    myChart.setOption(option, true);
  }
</script>
</html>
    