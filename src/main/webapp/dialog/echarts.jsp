<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: 'ECharts 入门示例'
        },
        tooltip: {},
        legend: {
            data:['人员量']
        },
        xAxis: {
            data: ["近一星期","近两个星期","近三个星期"]
        },
        yAxis: {},
        series: [{
            name: '人员量',
            type: 'bar',
        }]
    };

    $.ajax({
        url:"${pageContext.request.contextPath}/user/queryUserByTime",
        dataType:"json",
        success:function (data) {

            myChart.setOption(option);
            myChart.setOption({
                series: [{
                    name: '人员量',
                    type: 'bar',
                    data:data.data
                }]
            });


        }
    })

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
</body>
</html>