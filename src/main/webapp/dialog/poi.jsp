<%@page contentType="text/html;UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">

    $(function () {
        $('#poi_dg').datagrid({
            url: '${pageContext.request.contextPath}/user/queryAllUser',
            columns: [[
                {field: 'id', title: '编号', width: 100},

                {field: 'name', title: '姓名', width: 100},
                {field: 'DharmaName', 法名: '', width: 100, align: 'right'},
                {field: 'sex', title: '性别', width: 100},
                {field: 'province', title: '省份', width: 100},
                {field: 'city', title: '城市', width: 100},
                {field: 'sign', title: '签名', width: 180},
                {field: 'phoneNum', title: '电话', width: 100},
                {field: 'status', title: '用户状态', width: 100},
                {field: 'regDate', title: '注册时间', width: 100}
            ]],
            fit: true,
            fitColumns: true,

            toolbar: [{
                text: "全部导入",
                iconCls: 'icon-edit',

                handler: function () {
                    $("#addexcel").dialog("open")

                }
            }, '-', {
                text: "全部导出",
                iconCls: 'icon-edit',
                handler: function () {
                    Location.href = "${pageContext.request.contextPath}/poi/export"

                }
            }, '-', {
                text: "自定义导出",
                iconCls: 'icon-edit',
                handler: function () {
                    $("#poi_dd").dialog("open")

                }
            }]

        });


    })
    function submit() {
        $('#add_file').form('submit', {
            url: "${pageContext.request.contextPath}/poi/importExcel",
            success: function (data) {
                if(data=="true"){

                   //alert(data);
                    alert("导入成功");
                }else{

                   //alert(data);
                    alert("导入失败");
                }
                //关闭修改对话框
                $("#addexcel").dialog("close");

                //刷新datagrid
                $("#poi_dg").datagrid("reload");

            }
        });
    }

    $("#custorm_btn").linkbutton({
        onClick: function () {
            var titles = $("#poi_cc").combotree("getText")
            var fileds = $("#poi_cc").combotree("getValues")

            var a="";
            $.each(fileds, function (index, filed) {
                if (index==fileds.length-1){
                    a+=filed;
                }else {
                    a+=filed+",";
                }
            })
            $("#user_ff").form('submit',{
                url:"${pageContext.request.contextPath}/poi/customerExport ",
                queryParams:{
                    titles:titles,
                    fileds:a
                },
                success:function (data) {
                    if (data == "true") {
                        alert(data);
                        alert("到处成功")
                        $("#poi_dd").dialog("close");
                    } else {
                        alert(data);
                        alert("导出失败");
                    }

                }
            })
        }
    })



</script>


<table id="poi_dg"></table>

<div id="poi_dd" class="easyui-dialog" title="自定义导出" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
    <div style="text-align: center">
        <select id="poi_cc" class="easyui-combotree" style="width:200px;" data-options="required:true,checkbox:true,multiple:true,onlyLeafCheck:true,
data:[{
		text: '请选择',
		state: 'closed',
		children: [{
		    id:'id',
			text: '编号'
		},{
		    id:'name',
			text: '名字'
		},{
		    id:'DharmaName',
			text: '法号'
		},{
		    id:'status',
			text: '状态'
		},{
		    id:'sign',
			text: '签名'
		},{
		    id:'sex',
			text: '性别'
		},{
		    id:'province',
			text: '省份'
		},{
		    id:'city',
			text: '城市'
		},{
		    id:'regDate',
			text: '注册时间'
		}]
	}]"></select>
        <form id="user_ff" method="post">
            <a id="custorm_btn" href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-search'">确定</a>

        </form>
    </div>

</div>

<div id="addexcel" class="easyui-dialog" title="全部导入" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){
                   submit()
				}
			},{
				text:'关闭',
				handler:function(){
				 $('#addexcel').dialog('close')
				}
			}]">
    <form id="add_file" method="post" enctype="multipart/form-data">
        <input class="easyui-filebox" name="excel" style="width:300px">
    </form>

</div>

















