<%@page contentType="text/html;UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">

    $(function () {
        $('#chapter').treegrid({


            onDblClickRow:function (row) {
                $("#audio_dd").dialog("open")
                $("#audio_id").prop("src","${pageContext.request.contextPath}/music/"+row.url);
            },


            url:'${pageContext.request.contextPath}/album/queryAllAlbumAndChapter.do',

            idField:'id',
            treeField:'title',
            columns:[[
                {field:'title',title:'名字',width:100},
                {field:'url',title:'下载路径',width:150,align:'right'},
                {field:'size',title:'章节大小',width:80},
                {field:'duration',title:'章节时长',width:80}
            ]],

            fit:true,
            fitColumns:true,
            pagination: true,
            toolbar: [{
                iconCls: 'icon-redo',
                text: "详情",
                handler: function () {
                    var row = $("#chapter").treegrid("getSelected");
                    if (row != null) {
                        if (row.url == null) {
                            /*选中的是专辑*/

                            $("#chater_dd").dialog("open")
                            $("#chapter_ff").form("load", row);
                            $("#coverImg").prop("src", "${pageContext.request.contextPath}/img/"+row.coverImg)
                        }
                    }



                }
            }, '-', {
                iconCls: 'icon-save',
                text: "添加专辑",
                handler: function () {
                    $("#addAlbum_dd").dialog("open")


                }
            }, '-', {
                iconCls: 'icon-save',
                text: "添加章节",
                handler: function () {
                    var row = $("#chapter").treegrid("getSelected");
                    //console.log("row+++++"+row.id);
                    if (row == null) {
                        alert("请先选中要添加的专辑")

                    } else {
                        if (row.size==null){

                            $("#addChapter_dd").dialog("open");
                            $("#pid").val(row.id);
                        }else {
                            alert("请选中专辑");
                        }

                    }
                }
            }, '-', {
                iconCls: 'icon-print',
                text: "下载音频",
                handler: function () {
                    var row = $("#chapter").treegrid("getSelected");

                    //alert(row.title)
                    //alert(row.url)


                    if (row != null) {
                        if (row.url != null) {
                            alert("下载")
                            location.href="${pageContext.request.contextPath}/chapter/down?title="+row.title+"&url="+row.url;
                        }
                    }

                }
            }],

        });


    })


    function submit() {

        $('#addAlbum_ff').form('submit',{

            url:"${pageContext.request.contextPath}/album/addAlbum.do",
            success:function(data){
                if(data=="true"){
                    // alert(data);
                    alert("添加成功");
                }else{
                    // alert(data);
                    alert("添加失败");
                }

                //关闭修改对话框
                $("#addAlbum_dd").dialog("close");

                //刷新datagrid
                $("#chapter").treegrid("reload")

            }
        } );


        $('#addChapter_ff').form('submit',{
            url:"${pageContext.request.contextPath}/chapter/addChapter.do",
            success:function(data){
                if(data=="true"){

                    // alert(data);
                    alert("添加成功");
                }else{
                    // alert(data);
                    alert("添加失败");
                }
                //关闭修改对话框
                $("#addChapter_dd").dialog("close");

                //刷新datagrid
                $("#chapter").treegrid("reload");



            }
        } );
    }

</script>





<table id="chapter"></table>


<div id="chater_dd" class="easyui-dialog" title="显示详情" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
    <form id="chapter_ff" method="post">
        <div>
            <label for="name">名字:</label>
            <input id="name" class="easyui-validatebox" type="text" name="title" data-options="required:true"/>
        </div>
        <div>
            <label for="count1">数量:</label>
            <input id="count1" class="easyui-validatebox" type="text" name="count" data-options="required:true"/>
        </div>
        <div>
            <label for="createDate">时间:</label>
            <input id="createDate" class="easyui-validatebox" type="text" name="publishDate"
                   data-options="required:true"/>
        </div>
        <div>
            封面：<img id="coverImg" src="" width="60px" height="40px">
        </div>
    </form>
</div>



<div id="addAlbum_dd" class="easyui-dialog" title="添加专辑" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){
                   submit()
				}
			},{
				text:'关闭',
				handler:function(){
				 $('#addAlbum_dd').dialog('close')
				}
			}]">
    <form id="addAlbum_ff" method="post" enctype="multipart/form-data">
        <div>
            <label for="title">名字:</label>
            <input id="title" class="easyui-validatebox" type="text" name="title" data-options="required:true" />
        </div>
        <div>
            <label for="count">章节数量:</label>
            <input id="count" class="easyui-validatebox" type="text" name="count" data-options="required:true" />
        </div>
        <div>
            <label for="img">封面:</label>
            <input id="img" class="easyui-filebox" name="img" style="width:300px">
        </div>
        <div>
            <label for="author">作者:</label>
            <input id="author" class="easyui-validatebox" type="text" name="author" data-options="required:true" />
        </div>
        <div>
            <label for="broadCast">播音:</label>
            <input id="broadCast" class="easyui-validatebox" type="text" name="broadCast" data-options="required:true" />
        </div>
        <div>
            <label for="brief">描述:</label>
            <input id="brief" class="easyui-validatebox" type="text" name="brief" data-options="required:true" />
        </div>
    </form>
</div>


<div id="addChapter_dd" class="easyui-dialog" title="添加章节" style="width:400px;height:200px;"
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
    <form id="addChapter_ff" method="post" enctype="multipart/form-data">
        <div>
            <input id="pid" class="easyui-validatebox" type="hidden" name="pid" data-options="required:true" />
        </div>

        <div>
            <label for="title1">名字:</label>
            <input id="title1" class="easyui-validatebox" type="text" name="title" data-options="required:true" />
        </div>

        <div>
            <label for="music">音频:</label>
            <input id="music" class="easyui-filebox" name="music" style="width:300px">
        </div>

    </form>
</div>

<div id="audio_dd" class="easyui-dialog" title="播放音频" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
    <audio src="" id="audio_id" autoplay="autoplay" controls="controls"></audio>
</div>













