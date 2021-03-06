$(function () {



    //后台查询菜单
     var menu = [];
    $.post('menuManagement/allMenu',null,function (data) {
        menu = data.data;
    })

    layui.use('upload', function(){
        var upload = layui.upload;

        //执行上传
        var uploadInst = upload.render({
            elem: '#upload' //绑定元素
            ,url: 'layUiBaseQuery/uploadFile' //上传接口
            ,method: 'POST'
            ,accept: 'file'
            ,size: 50
            ,before: function(obj){
                layer.load();
            }
            ,done: function(res){//上传完毕回调

                // if(data.result){
                    layer.msg(res.message);
                // };
                console.info(res);
                layer.closeAll('loading');
                var result = '';

                for(var i=0; i<res.length; i++){
                    result = result + res[i].nsrsbh+"="+res[i].container+"\n";
                }

                $("#result").html(result);
            }
            ,error: function(){//请求异常回调
                layer.closeAll('loading');
                layer.msg('网络异常，请稍后重试！');
            }
        });
    });



    //JavaScript代码区域
    layui.use(['element','form','laydate','table','layer','code','jquery'], function(){
        //模块初始化
         element = layui.element;
         form = layui.form;
         laydate = layui.laydate;
        table = layui.table;
        layer = layui.layer;
        code = layui.code;

        var $ = layui.$;

        layui.code({
            title: 'NotePad++的风格'
            ,skin: 'notepad' //如果要默认风格，不用设定该key。
        });

        $("#upanddown").click(function () {
            $("#formdiv").slideToggle();
        })

        //视频查询按钮
        $("#vodeoListSearch").click(function () {
            var jsonDate = $("#videoQueryForm").serializeObject(); //输出数组
            //查询面板收起
            $("#formdiv").slideUp();

            //table初始化
            table.render({
                elem: '#tableVideo',               //tableid
                url:'video/layuiVideoQuery',
                where:jsonDate,                   //条件
                skin: 'line', //行边框风格
                even: true ,//开启隔行背景
                size: 'sm', //小尺寸的表格
                cols: [[ //标题栏
                    {type: 'checkbox', fixed: 'left'},
                    {field: 'videoName', title: '视频名字', width: 800,edit: 'text'},
                    //videoFullPathName
                    {field: 'videoFullPathName', title: '视频名字', width: 800,edit: 'text'},
                    //        $("#playVido").click(function () {
                    //
                    //             var loadstr = '<video width="100%" height="100%" ' +
                    //                 ' controls="controls" ' +
                    //                 'autobuffer="autobuffer" ' +
                    //                 ' autoplay="autoplay" loop="loop">' +
                    //                 '<source src="/static/videos/sample1.mp4" type="video/mp4"></source>' +
                    //                 '</video>'
                    //             layer.open({
                    //                 type: 1,
                    //                 title: '播放视频',
                    //                 content: loadstr,
                    //             });
                    //         })
                    {fixed: 'right', title:'点击播放', toolbar: '#playBtn', width:250}
                ]],
                // data: tableDate,
                page:true
                // limit:5
            });

        })
        
        //查询按钮
        $("#userListSearch").click(function () {
            var jsonDate = $("#baseQueryForm").serializeObject(); //输出数组
            console.info(jsonDate);
            //查询面板收起
            $("#formdiv").slideUp();
            //table初始化
            table.render({
                elem: '#tableDemo',               //tableid
                url:'layUiBaseQuery/layuiQuery',
                where:jsonDate,                   //条件
                skin: 'line', //行边框风格
                even: true ,//开启隔行背景
                size: 'sm', //小尺寸的表格
                cols: [[ //标题栏
                    {type: 'checkbox', fixed: 'left'},
                    {field: 'userId', title: 'ID', width: 60, sort: true},
                     {field: 'userName', title: '用户名', width: 120,edit: 'text'},
                     {field: 'passWord', title: '用户密码', width: 120},
                     {field: 'isUse', title: '是否有效', width: 100,
                        templet:function (data) {
                            return isUse(data.isUse);
                        }
                    },
                    {field: 'creatDate', title: '创建时间', width: 180,
                        templet: function(data){
                            return DateTimeFormatter(data.creatDate);
                         }
                    },

                    {fixed: 'right', title:'操作', toolbar: '#barDemo', width:180},
                    {field:'isUse', title:'是否有效', width:105, templet: '#switchTpl', unresize: true}
                    // {field:'lock', title:'是否锁定', width:110, templet: '#checkboxTpl', unresize: true}

                ]],
                // data: tableDate,
                page:true
                // limit:5
            });


        });

        //监听性别操作
        form.on('switch(sexDemo)', function(obj){
            layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
        });




        //日期
        laydate.render({
            elem: '#registerStart'  //必须指定id
        });
        laydate.render({
            elem: '#registerEnd'  //必须指定id
        });


        var ul = $('#mymenu');
        //动态生成菜单

        $.each(menu,function(index,data){




            var li = $("<li></li>");
            li.addClass("layui-nav-item");

            //a标签之中添加内容
            var a1 = $('<a></a>');
            a1.text(data.text);

            //将a标签放到li标签里面
            li.append(a1);

            if(null!= data.children){

                var dl = $('<dl></dl>')
                dl.addClass("layui-nav-child");

                $.each(data.children,function(index,child){
                    var dd = $('<dd></dd>');
                    var a = $("<a href=\"javascript:;\"></a>");


                    //给a标签加id
                    a.attr("id",child.id);
                    //暂时将跳转tab的url放在name中
                    a.attr("name",child.url);


                    a.text(child.text);
                    a.wrap("<a href='www.google.com'>Google Wrap div1</a>");
                    dd.append(a);
                    dl.append(dd);


                })

            }

            li.append(dl);

            ul.append(li);

        })


        //导航更新渲染
        element.render('nav');


        //监听tab
        element.on('tab(demo)', function(data){
            console.log(data);
        });




        //点击垂直导航--监听导航栏
        element.on('nav(test)', function(elem){



            // console.log(elem); //得到当前点击的DOM对象
            console.log(elem[0]);
            var q = $(elem[0]);
            console.log(q );

            // element.tabChange('demo', q.text());

            //获取子标签id和url
            var id = q.attr("id");
            var src = q.attr("name");

            var exist=$("li[lay-id='"+id+"']").length; //判断是否存在tab
            //动态添加url
           var ss = "http://localhost:8081/"+src;


            var ppp = "<iframe src="+ss+ " frameborder='0' scrolling='false' style='width:1450px;height: 600px;'></iframe>";

            //判断是否有子标签，有子标签则不会新增tab
            if (q.html().indexOf("layui-nav-more")>-1) {   //有子标签
                return
            }else{  //没有子标签


                if(exist==0){  //tab 没有打开过
                    element.tabAdd('demo', {
                        title: q.text(),
                        content:ppp, //支持传入html
                        id: id
                    });
                    //切换当前tab
                    element.tabChange('demo', id);
                }else { // tab已经打开
                    element.tabChange('demo', id);
                }


            }
        });



        //行中操作按钮监听
        table.on('tool(tableDemo)',function (obj) {
            //obj.event     del    edit
            //console.info(obj)
            var data = obj.data;
            if('edit'==obj.event){//点击编辑
                layer.prompt({
                    formType:2,
                    value:data.userName
                },function (value, index) {
                    obj.update({
                        userName:value
                    });
                    layer.close(index);
                })
            }

        })

        table.on('tool(tableVideo)',function (obj) {
            //obj.event     del    edit
            //console.info(obj)
            var data = obj.data;
            if('play'==obj.event){//点击编辑

// var location =data.videoFullPathName;
//
//                 var loadstr = '<video width="100%" height="100%" ' +
//                     ' controls="controls" ' +
//                     'autobuffer="autobuffer" ' +
//                     ' autoplay="autoplay" loop="loop">' +
//                     '<source src="http://106.54.46.37/images/44.MP4" type="video/mp4"></source>' +
//                     '</video>' ;
//                 alert(location);
//                 alert(loadstr);
//                 layer.open({
//                     type: 1,
//                     title: '播放视频',
//                     content: loadstr,
//                 });

                window.open("http://106.54.46.37/images/44.MP4");


            }

        })

        //点击删除按钮
        $("#userListDel").click(function () {
            var checkStatus = table.checkStatus('tableDemo'); //idTest 即为基础参数 id 对应的值
            var dataList = checkStatus.data;
            var isAll = checkStatus.isAll;
            
            
            $.requestJson('delete',dataList,function (data) {
                console.info(data);
                if(data.result){
                    layer.msg(data.message);
                };
                //表格重载
                var jsonDate = $("#baseQueryForm").serializeObject(); //输出数组
                table.reload('tableDemo', {
                    where: jsonDate
                    ,page: {
                        curr: 1 //重新从第 1 页开始
                    }
                });
            })

        })
        
        //查看行元素
        $("#layuilook").click(function () {
            var checkStatus = table.checkStatus('tableDemo'); //idTest 即为基础参数 id 对应的值
            console.info(checkStatus);

            var xx=  JSON.stringify(checkStatus);
            var cc  =formatJson(xx);
            layer.prompt({
                formType:2,
                value:cc
            })


        })

        //导出操作
        $('#easyuiUserListExport').click(function () {
            layer.confirm('是否按照条件进行导出操作?',{icon: 3, title:'提示'},function(index){
              var jsonDate = $("#baseQueryForm").serializeObject(); //输出数组
              console.info(jsonDate);
              $('#baseQueryForm').submit();
               layer.close(index);
            });

        })


        
        //保存操作
        $("#userListSave").click(function () {

        })

        //监听单元格编辑
        table.on('edit(tableDemo)', function(obj){ //注：edit是固定事件名，test是table原始容器的属性 lay-filter="对应的值"
            // console.log(obj); //得到修改后的值
            // console.log(obj.value); //得到修改后的值
            // console.log(obj.field); //当前编辑的字段名
            //console.log(obj.data); //所在行的所有相关数据

            var dataa = obj.data;
            //creatDate 在表格中long显示，传到后台是用date接受，会接受不到，故去除
            delete dataa['creatDate'];
            console.info(dataa);


            //修改更新操作
            $.post('layUiBaseQuery/layuiUpdate',dataa,function (data) {
                layer.msg(data.message);
            })

        });

        //监听行单击事件
        table.on('row(tableDemo)', function(obj){
            console.log(obj.tr) //得到当前行元素对象
            console.log(obj.data) //得到当前行数据
            //obj.del(); //删除当前行
            //obj.update(fields) //修改当前行数据
        });

        //下载ftp文件
        $("#download").click(function () {
            $.post('layUiBaseQuery/downLoad',null,function (data) {
                layer.msg(data.message);
            })
           // alert("开始下载")
        })

        //下载ftp文件
        $("#sendMail").click(function () {
            $.post('layUiBaseQuery/sendMail',null,function (data) {
                layer.msg(data.message);
            })
        })



        form.on('select(selectOne)', function(data){
            if(data.value == "001"){
                $("#menuName").show();
                $("#level").hide();
                $("#menuUrl").hide();
                form.render('select');
            }else{
                $("#firstMenu").empty();
                //获取所有一级菜单
                $("#firstMenu").append("<option value=''>"+"请选择二级菜单添加到哪个下面"+"</option>");
                $.each(menu,function(index,data){
                    $("#firstMenu").append("<option value="+data.id+">"+data.text+"</option>");
                });

                $("#level").show();
                $("#menuName").show();
                $("#menuUrl").show();
                form.render('select');//select是固定写法 不是选择器
            }

        })


        $("#getmenu").click(function () {
            //后台查询菜单
            // $.post('menuManagement/allMenu',null,function (data) {
            // })
        })
        $("#playVido").click(function () {

            var loadstr = '<video width="100%" height="100%" ' +
                ' controls="controls" ' +
                'autobuffer="autobuffer" ' +
                ' autoplay="autoplay" loop="loop">' +
                '<source src="/static/videos/sample1.mp4" type="video/mp4"></source>' +
                '</video>'
            layer.open({
                type: 1,
                title: '播放视频',
                content: loadstr,
            });
        })


        form.on('submit(formDemo)', function (data) {
            console.log(data.field);
            $.post('menuManagement/addMenu',data.field,function (data) {
                layer.open({
                    title: '操作提示',
                    content: data.message
                });
            })
        });



    });
})



