<div class="container-fluid padding-top15" style="width:1200px">
	<div class="row">
		<div class="col-xs-12">
			<ol class="breadcrumb title">
				<li class="title-li">
					<span class="title-text">Account Book</span>
					<span class="userInfo">${sessionUser.userName}</span>
					<a class="logoutLink" href="#" onClick="logout()">注销</a>
				</li>
			</ol>
		</div>
	</div>
	
	<div class="row">
		<div class="col-xs-2">
			<div class="breadcrumb left-column">
				<a href="../incomeController/showIncome">
					<div id="income" class="breadcrumb">
						<div>
							收入
						</div>
					</div>
				</a>
				
				<a href="../expenditureController/showExpenditure">
					<div id="expenditure" class="breadcrumb">
						<div>
							支出
						</div>
					</div>
				</a>
				
				<a href="../historyController/showhistory">
					<div id="history" class="breadcrumb">
						<div>
							往月收支
						</div>
					</div>
				</a>
				<a href="../itemController/showManageItems">
					<div id="itemsManagement" class="breadcrumb">
						<div>
							项目管理
						</div>
					</div>
				</a>
				
				<!-- 说明一些注意事项，不好理解的地方 -->
				<a href="../monthlyStatisticsController/showMonthlyStatistics">
					<div id="about" class="breadcrumb">
						<div>
							关于
						</div>
					</div>
				</a>
				
			</div>
		</div>
		
		<!-- 以下是正文内容-->
		