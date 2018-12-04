<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>余票预警</title>
<style type="text/css">
	span{  color: red; font-weight: bold}
</style>
</head>
<body>

	<h5>以下为发票剩余量不足达到预警值的企业,请尽快督促其补充发票!</h5>

	<table>
		<tr>
	        <th>纳税人识别号</th><th>截止时间</th><th>发票剩余数/张</th><th>预警数/张</th>
		</tr>

		<#list listData as data>
		    <tr>
		        <td>${data.taxpayerCode}</td>
		        <td>${data.updateTime}</td>
		        <td>${data.invoiceNumber}</td>
		        <td>${data.warningNum}</td>
			</tr>
		</#list>
	</table>

</body>
</html>
