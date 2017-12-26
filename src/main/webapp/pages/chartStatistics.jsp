<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Account Book v2 往月收支</title>
<%@ include file="common/common.jsp" %> 
<link href="../res/css/history.css" rel="stylesheet">
<script src="../res/js/history.js"></script>
<script src="../res/js/common/common.js"></script>
<script type="text/javascript" src="../res/echarts/echarts.min.js"></script>
</head>
<body>

<div class="container-fluid padding-top15">
	<div class="row">
		<div class="col-xs-12">
			<ol class="breadcrumb navigation">
				<li class="navi-li">
					<span class="navi-text">收支 > 历史收支 > 图表展示</span>
				</li>
			</ol>
		</div>
		
		<ul id="myTab" class="nav nav-tabs">
			<li class="active"><a href="#tab1" data-toggle="tab">近12月收支</a></li>
			<li><a href="#tab2" data-toggle="tab">收支项目比例</a></li>
		</ul>
		<div id="myTabContent" class="tab-content">
			<div class="tab-pane fade in active" id="tab1">		<!-- 第一个tab -->
				<br>
				<div id="chartmain1" style="width:95%; height: 400px; margin: 0 auto"></div>
			</div>
			<div class="tab-pane fade" id="tab2">	<!-- 第二个tab -->
				<br>
				<div> 
					<label class="label1" style="margin-left:20px">开始日期（含）：</label>
					<input class="Wdate add-data" type="text" onClick="WdatePicker()" id="startdate"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					
					<label class="label1">结束日期（含）：</label>
					<input class="Wdate add-data" type="text" onClick="WdatePicker()" id="enddate"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				
					<button onclick="searchHistoryGroupByName()">确定</button>
				</div>
				<br>
				<div id="chartmain2" style="width:600px; height: 400px; float:left"></div>
				<div id="chartmainPlaceholder" style="width:600px; height: 400px; float:left; margin-left: 200px;"></div>
				<div id="chartmain3" style="width:600px; height: 400px; float:left"></div>
                <div id="chartmain4" style="width:600px; height: 400px; float:left; margin-left: 200px;"></div>
			</div>
		</div>
	</div>
</div>

<!-- 近12月收支折线图  -->
<script type="text/javascript">
	var monthArr = new Array();  
	var incomeArr = new Array(); 
	<c:forEach items="${last12Income}" var="t">  
		monthArr.push("${t.month}"); //js中可以使用此标签，将EL表达式中的值push到数组中  
		incomeArr.push("${t.sumMoney}"); 
	</c:forEach> 
	
	var expenditureArr = new Array(); 
	<c:forEach items="${last12Expenditure}" var="t">  
		expenditureArr.push("${t.sumMoney}"); 
	</c:forEach> 
	
	option = {
	    title: {
	        text: '近12月收支图',
	    },
	    tooltip: {
	        trigger: 'axis'
	    },
	    legend: {
	        data:['收入','实际支出']  // 这里是折线图的图例，需要与下面的series中的name对应
	    },
	    toolbox: {
	        show: true,
	        feature: {
	            dataZoom: {
	                yAxisIndex: 'none'
	            },
	            dataView: {readOnly: false},
	            magicType: {type: ['line', 'bar']},
	            restore: {},
	            saveAsImage: {}
	        }
	    },
	    xAxis:  {
	        type: 'category',
	        boundaryGap: false,
	        data: monthArr	// 月份
	    },
	    yAxis: {
	        type: 'value',
	        axisLabel: {
	            formatter: '{value}'
	        }
	    },
	    series: [
	        {
	            name:'收入',
	            type:'line',
	            data: incomeArr, // 收入
	            markPoint: {
	                data: [
	                    {type: 'max', name: '最大值'},
	                    {type: 'min', name: '最小值'}
	                ]
	            },
	            markLine: {
	                data: [
	                    {type: 'average', name: '平均值'}
	                ]
	            }
	        },
	        {
	            name:'实际支出',
	            type:'line',
	            data: expenditureArr,  // 支出
	            markPoint: {
	                data: [
	                    {type: 'max', name: '最大值'},
	                    {type: 'min', name: '最小值'}
	                ]
	            },
	            markLine: {
	                data: [
	                    {type: 'average', name: '平均值'}
	                ]
	            }
	        }
	    ]
	};

    var myChart = echarts.init(document.getElementById('chartmain1')); //初始化echarts实例
    myChart.setOption(option); //使用制定的配置项和数据显示图表
</script>

<!-- 收支项目比例 -->
<script type="text/javascript">
	var inDataArr = new Array();
	<c:forEach items="${inGroupByItemName}" var="t">  
		inDataArr.push({
			name: "${t.name}"+":"+"${t.sumMoney}",
		    value: "${t.sumMoney}"
		})
	</c:forEach> 
		
    var option2 = {
        title:{
            text:'收入项目比例'
        },            
        series:[{
            name:'比例图',
            type:'pie',    
            radius:'60%', 
            data: inDataArr
        }]
    };
    
    var myChart2 = echarts.init(document.getElementById('chartmain2'));
    myChart2.setOption(option2);
    
    // 实际支出项目比例
    var exDataArr = new Array();
    <c:forEach items="${exGroupByItemName}" var="t">  
        exDataArr.push({
            name: "${t.name}"+" : "+"${t.sumMoney}",
            value: "${t.sumMoney}"
        })
    </c:forEach>
    var option3 = {
        title:{
            text:'实际支出项目比例',
            subtext:'花呗等支出算入下月的消费',
        }, 
        series:[{
            name:'访问量',
            type:'pie',    
            radius:'60%', 
            data:exDataArr
        }]
    };
    var myChart3 = echarts.init(document.getElementById('chartmain3'));
    myChart3.setOption(option3);
    
    // 实际支出项目比例
    var allExDataArr = new Array();
    <c:forEach items="${allExGroupByItemName}" var="t">  
        allExDataArr.push({
            name: "${t.name}"+" : "+"${t.sumMoney}",
            value: "${t.sumMoney}"
        })
    </c:forEach>
    var option4 = {
        title:{
            text:'支出项目比例',
            subtext:'上月花呗算入本月还款，本月花呗也计入本月支出(实际上花呗支出被计算了2次)',
        }, 
        series:[{
            name:'访问量',
            type:'pie',    
            radius:'60%', 
            data:allExDataArr
        }]
    };
    var myChart4 = echarts.init(document.getElementById('chartmain4'));
    myChart4.setOption(option4);
</script>

<script type="text/javascript">
// 搜索
function searchHistoryGroupByName(){
	var startdate = $("#startdate").val();
	var enddate = $("#enddate").val();	
	
	$.ajax({
		type: "POST",
		url: "searchChartStatistics",
		data: {
			"startdate":startdate,
			"enddate":enddate
		},
		success: function(data1){
			var inDataArr_new = new Array();
			for(var i=0;i<data1.inGroupByItemName.length;i++){
				t=data1.inGroupByItemName[i];
				inDataArr_new.push({
					name: t.name+":"+t.sumMoney,
				    value: t.sumMoney
				})
			}
			var exDataArr_new = new Array();
			for(var i=0;i<data1.exGroupByItemName.length;i++){
				t=data1.exGroupByItemName[i];
				exDataArr_new.push({
					name: t.name+" : "+t.sumMoney,
				    value: t.sumMoney
				})
			}
			//更新数据
			var option2_new = myChart2.getOption();
		    option2_new.series[0].data = inDataArr_new;   
		    myChart2.setOption(option2_new); 
		    
		    var option3_new = myChart3.getOption();
		    option3_new.series[0].data = exDataArr_new;   
		    myChart3.setOption(option3_new);    
			
		},
		error: function (msg) {
			alert("请求失败");
		} 
	});
}

</script>
</body>
</html>