var layer = layui.layer
    ,form = layui.form;
var util = layui.util;
var carousel = layui.carousel;
var rate = layui.rate;
var slider = layui.slider;
var colorpicker = layui.colorpicker;
var tree = layui.tree;
var transfer = layui.transfer;

$('#addBtn').click(function () {
    var ss = "http://localhost:8081/layui";
    var ppp = "<iframe src="+ss+ " frameborder='0' scrolling='false' style='width:1450px;height: 600px;'></iframe>";
    layer.open({
        type: 2,
        content: ss //这里content是一个普通的String
    });
})


// 基于准备好的dom，初始化echarts实例
var myChart = echarts.init(document.getElementById('main'));

// 指定图表的配置项和数据
var option = {
    title: {
        text: '第一个 ECharts 实例'
    },
    tooltip: {},
    legend: {
        data:['销量']
    },
    xAxis: {
        data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
    },
    yAxis: {},
    series: [{
        name: '销量',
        type: 'bar',
        data: [5, 20, 36, 10, 10, 20]
    }]
};

// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);
