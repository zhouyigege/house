<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0044)http://localhost:8080/HouseRent/page/add.jsp -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 -发布房屋信息</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514">
  <script language="JavaScript" type="text/javascript" src="../scripts/jquery-1.8.3.js"></script>
  <script language="JavaScript">
      $(function(){  //加载事件
          //1.发送异步请求获取类型，进行显示
          $.post("getAllType",null,function (data) {
              for(var i=0;i<data.length;i++){
                  //创建节点
                  var node=$("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
                  //追加节点
                  $("#type_id").append(node);
              }

              //设置选中项
              $("#type_id").val(${condition.tid});
          },"json");

          //1.发送异步请求获取区域，进行显示
          $.post("getAllDistrict",null,function (data) {
              for(var i=0;i<data.length;i++){
                  //创建节点
                  var node=$("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
                  //追加节点
                  $("#district_id").append(node);
              }

              //设置选中项
              $("#district_id").val(${condition.did});

              loadStreet();  //加载街道
          },"json");

          //给区域添加改变事件
          $("#district_id").change(loadStreet);

          //加载街道   代码复用
          function loadStreet(){
              //获取区域编号
              var did=$("#district_id").val();
              if(did!="") {
                  //发送异步请求加载街道数据
                  //清空原有数据项
                  $("#street_id>option:gt(0)").remove();
                  $.post("getStreetByDid", {"did": did}, function (data) {

                      for (var i = 0; i < data.length; i++) {
                          //创建节点
                          var node = $("<option value='" + data[i].id + "'>" + data[i].name + "</option>");
                          //追加节点
                          $("#street_id").append(node);
                      }


                      //设置选中项
                      $("#street_id").val(${condition.sid});
                  }, "json");
              }
          }

      });

      //带条件的分页
      function goPage(pageNum){
          //1.将页码设置到表单
          $("#setPage").val(pageNum);
          //2.提交表单
          $("#sform").submit();   //js提交表单，相当于点击了提交按钮
      }
  </script>

</HEAD>
<BODY>

<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV>
<DIV class=search>
<FORM method=get><INPUT class=text type=text name=keywords>
 <LABEL class="ui-green searchs"><a href="list.jsp" target="_blank">搜索房屋</a></LABEL>
</FORM></DIV></DIV>
<DIV id=navbar class=wrap>
<DL class="search clearfix">
  <FORM id=sform method=post action=searchHouse>
    <input  type="hidden" id="setPage" name="page" value="1"/>
    标题：<INPUT class=text type=text name=title value="${condition.title}">
    区域:<select id="district_id"  name="did">
    <option value="">请选择</option>
  </select>
    街道:<select id="street_id" name="sid">
    <option value="">请选择</option>
  </select>
    类型:<select id="type_id" name="tid">
    <option value="">请选择</option>
  </select>
    价格:<input type="tex" name="startPrice" size="8" value="${condition.startPrice}">-<input name="endPrice" type="text" size="8" value="${condition.endPrice}">
    <INPUT  value=搜索房屋 type=submit name=search>

  </FORM></DL></DIV>
<DIV id=position class=wrap>当前位置：青鸟租房网 - 浏览房源</DIV>
<DIV id=view class="main wrap">
<DIV class=intro>
<DIV class=lefter>
<H1>大房子</H1>
<DIV class=subinfo>2013-06-28 14:06:33.0</DIV>
<DIV class=houseinfo>
<P>户　　型：<SPAN>一室一厅</SPAN></P>
<P>面　　积：<SPAN>100m<SUP>2</SUP></SPAN></P>
<P>位　　置：<SPAN>海淀区中关村大街</SPAN></P>
<P>联系方式：<SPAN>123456789</SPAN></P></DIV></DIV>
<DIV class=side>
<P><A class=bold href="http://localhost:8080/House-2/#">北京青鸟房地产经纪公司</A></P>
<P>资质证书：有</P>
<P>内部编号:1000</P>
<P>联 系 人：</P>
<P>联系电话：<SPAN></SPAN></P>
<P>手机号码：<SPAN>暂无</SPAN></P></DIV>
<DIV class=clear></DIV>
<DIV class=introduction>
<H2><SPAN><STRONG>房源详细信息</STRONG></SPAN></H2>
<DIV class=content>
<P>就是好</P></DIV></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV>
</BODY>
</HTML>
