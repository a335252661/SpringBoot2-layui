var layer = layui.layer
    ,form = layui.form;
var util = layui.util;
var carousel = layui.carousel;
var rate = layui.rate;
var slider = layui.slider;
var colorpicker = layui.colorpicker;
var tree = layui.tree;
var transfer = layui.transfer;
layer.msg('Hello World');


function previewImg(obj) {
    var img = new Image();
    img.src = obj.src;
    var height = img.height + 50; //获取图片高度
    var width = img.width; //获取图片宽度
    var imgHtml = "<img src='" + obj.src + "' />";
    //弹出层
    layer.open({
        type: 1,
        shade: 0.8,
        offset: 'auto',
        area: [width + 'px',height+'px'],
        shadeClose:true,//点击外围关闭弹窗
        scrollbar: false,//不现实滚动条
        title: "图片预览", //不显示标题
        content: imgHtml, //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
        cancel: function () {
            //layer.msg('捕获就是从页面已经存在的元素上，包裹layer的结构', { time: 5000, icon: 6 });
        }
    });
}


//渲染  穿梭框
transfer.render({
    elem: '#chuansuo'  //绑定元素
    ,data: [
        {"value": "1", "title": "李白", "disabled": "", "checked": ""}
        ,{"value": "2", "title": "杜甫", "disabled": "", "checked": ""}
        ,{"value": "3", "title": "贤心", "disabled": "", "checked": ""}
    ]
    ,id: 'demo1' //定义索引
});

//渲染   树组件
var inst2 = tree.render({
    elem: '#treeTest'  //绑定元素
    ,data: [{
        title: '江西' //一级菜单
        ,children: [{
            title: '南昌' //二级菜单
            ,children: [{
                title: '高新区' //三级菜单
                //…… //以此类推，可无限层级
            }]
        }]
    },{
        title: '陕西' //一级菜单
        ,children: [{
            title: '西安' //二级菜单
        }]
    }]
});

  //颜色选择器
  colorpicker.render({
      elem: '#chosecolour'
      ,predefine: true
      ,colors: ['#F00','#0F0','#00F','rgb(255, 69, 0)','rgba(255, 69, 0, 0.5)']
      ,change: function(color){
          layer.msg(color);
          layer.msg('Hello World');
      }
  });
/*滑块*/
slider.render({
    elem: '#slideTest1'  //绑定元素
    ,setTips: function(value){ //自定义提示文本
        return value + '%';
    }
    ,change: function(value){
        console.log(value); //动态获取滑块数值
        //do something
        layer.msg(value);
    }
});

//渲染
var ins1 = rate.render({
    elem: '#pingfen'  //绑定元素
    ,setText: function(value){
        var arrs = {
            '1': '极差'
            ,'2': '差'
            ,'3': '中等'
            ,'4': '好'
        };
        this.span.text(arrs[value] || ( value + "星"));
    }
    ,choose: function(value){
        if(value > 2) alert( '么么哒' )
    }
});

layer.msg('Hello World');


/*  将dom内容展示出来  */
// layer.open({
//     type: 1,
//     content: $('#shoufengq') //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
// });


// layer.open({
//     type: 2,
//     content: ['http://sentsin.com','no'], //这里content是一个URL，如果你不想让iframe出现滚动条，
//     offset: ['100px', '50px']   //定义弹出位置
//     // 你还可以content: ['http://sentsin.com', 'no']
// });

//eg1
// layer.alert('酷毙了', {icon: 1});
// //eg2
// layer.msg('不开心。。', {icon: 5});
// //eg3
// layer.load(1); //风格1的加载
// layer.open({
//     type: 4,
//     content: ['内容', '#shoufengq'] //数组第二项即吸附元素选择器或者DOM
// });

// layer.open({
//     type: 1,
//     content: '传入任意的文本或html' //这里content是一个普通的String
// });



layui.use('code', function(){ //加载code模块
    layui.code(); //引用code方法
});


var endTime = new Date(2099,1,1).getTime() //假设为结束日期
    ,serverTime = new Date().getTime(); //假设为当前服务器时间，这里采用的是本地时间，实际使用一般是取服务端的

util.countdown(endTime, serverTime, function(date, serverTime, timer){
    var str = date[0] + '天' + date[1] + '时' +  date[2] + '分' + date[3] + '秒';
    layui.$('#time').html('距离2099年1月1日还有：'+ str);
});


//执行
util.fixbar({
    bar1: true
    ,click: function(type){
        console.log(type);
        if(type === 'bar1'){
            alert('点击了bar1')
        }
    }
});

layui.use('flow', function(){
    var flow = layui.flow;

    flow.load({
        elem: '#LAY_demo1' //流加载容器
        ,done: function(page, next){ //执行下一页的回调
            //模拟数据插入
            //每次滑动到了底部度会执行这个函数
            setTimeout(function(){
                var lis = [];
                for(var i = 0; i < 8; i++){
                    lis.push('<li>'+ ( (page-1)*8 + i + 1 ) +'</li>')
                }

                //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                next(lis.join(''), page < 10); //假设总页数为 10
                //最后这个数字，是表示每次加载所用的时间。
            },1500);
        }
    });
});

//建造实例   轮播
carousel.render({
    elem: '#test1'
    ,width: '100%' //设置容器宽度
    ,arrow: 'always' //始终显示箭头
    //,anim: 'updown' //切换动画方式
});

