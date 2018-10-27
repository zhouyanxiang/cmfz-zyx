<%@page contentType="text/html;UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
    $(function(){

        //⑤把div标签转换成dialog效果
        $("#addDialog").dialog({
            title:"添加",
            closed:true,
            width:250,
            height:300,
            //resizable:true
            //⑦添加一个底部按钮
            buttons:"#dialogBtn"
            //⑦添加一个底部按钮===END===

        });
        //⑤把div标签转换成dialog效果====END=====

    });

    $(function () {
        $('#dg').edatagrid({
            updateUrl:"${pageContext.request.contextPath}/banner/update.do",
            url:'${pageContext.request.contextPath}/banner/queryAllBanner.do',
            destroyUrl:"${pageContext.request.contextPath}/banner/delete.do",
            columns: [[
                {field: 'name', title: '标题', width: 100},
                {
                    field: 'status', title: '状态', width: 100, editor: {
                    type: "text",
                    options: {
                        required: true
                    }
                }
                },
                {field: 'description', title: '描述', width: 100, align: 'right'},
                {field: 'createDate', title: '时间', width: 100},
            ]],
            fit: true,
            fitColumns: true,
            pagination: true,
            pageSize: 5,
            pageList: [5, 10, 15],
            toolbar: [{
                iconCls: 'icon-add',
                text: "添加",
                handler: function () {
                    $("#banner_dd").dialog("open")
                    //alert('添加按钮')
                }
            }, '-', {
                iconCls: 'icon-edit',
                text: "修改",
                handler: function () {
                    var row = $("#dg").edatagrid("getSelected");
                    if (row == null) {
                        alert("请先选中行")
                    } else {
                        var index = $("#dg").edatagrid("getRowIndex", row);
                        $("#dg").edatagrid("editRow", index);
                    }


                }
            }, '-', {
                iconCls: 'icon-remove',
                text: "删除",
                handler: function () {
                    $('#dg').edatagrid('destroyRow');

                }
            }, '-', {
                iconCls: 'icon-save',
                text: "保存",
                handler: function () {
                   //alert("aaaaaaaaaaaaaaa")
                    $("#dg").edatagrid("saveRow")
                }
            }],
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/img/' + rowData.url + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.desc + '</p>' +
                    '<p>Status: ' + rowData.createDate + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },



        });
    })


    function submit() {
        $('#banner_ff').form('submit',{
            url:"${pageContext.request.contextPath}/banner/add.do",
            success:function(data){
                if(data=="true"){
                    // alert(data);
                    alert("添加成功");
                }else{
                    //alert(data);
                    alert("添加失败");
                }

                //关闭修改对话框
                $("#banner_dd").dialog("close");

                //刷新datagrid
                $("#dg").datagrid("reload")

            }
        } )
    }
</script>


<table id="dg"></table>
<div id="banner_dd" class="easyui-dialog" title="添加轮播图" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){
                   submit()
				}
			},{
				text:'关闭',
				handler:function(){
				 $('#dd').dialog('close')
				}
			}]">
    <form id="banner_ff" method="post" enctype="multipart/form-data">
        <div>
            <label for="name">名字:</label>
            <input id="name" class="easyui-validatebox" type="text" name="name" data-options="required:true" />
        </div>
        <div>
            <label for="desc">描述:</label>
            <input id="desc" class="easyui-validatebox" type="text" name="description" data-options="required:true" />
        </div>
        <div>
            <label for="img">图片:</label>
            <input id="img" class="easyui-filebox" name="photo" style="width:300px">
        </div>

        <select id="status" class="easyui-combobox" name="status" style="width:200px;">
            <option value="Y">展示</option>
            <option value="N">不展示</option>
        </select>
    </form>

</div>

