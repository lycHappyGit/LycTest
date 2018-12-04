<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>余票预警</title>
<style type="text/css">
    span{padding: 5px}
</style>
</head>
<body>
<h5><p>尊敬的<span>${taxpayerCode}</span>用户</p>
	截止<span>${updateTime}</span>
	税盘发票剩余<span style="color: red">${invoiceNumber}</span>张,不足<span style="color: blue">${warningNum}</span>张,请尽快补充发票!</h5>
</body>
</html>
