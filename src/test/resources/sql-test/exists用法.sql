CREATE TABLE `tb_score` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userid` varchar(20) NOT NULL COMMENT '用户id',
  `subject` varchar(20) DEFAULT NULL COMMENT '科目',
  `score` double DEFAULT NULL COMMENT '成绩',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

INSERT INTO `dssp`.`tb_score` (`id`, `userid`, `subject`, `score`) VALUES ('1', '001', '语文', '90');
INSERT INTO `dssp`.`tb_score` (`id`, `userid`, `subject`, `score`) VALUES ('2', '001', '数学', '92');
INSERT INTO `dssp`.`tb_score` (`id`, `userid`, `subject`, `score`) VALUES ('3', '001', '英语', '80');
INSERT INTO `dssp`.`tb_score` (`id`, `userid`, `subject`, `score`) VALUES ('4', '002', '语文', '90');
INSERT INTO `dssp`.`tb_score` (`id`, `userid`, `subject`, `score`) VALUES ('5', '002', '数学', '90');
INSERT INTO `dssp`.`tb_score` (`id`, `userid`, `subject`, `score`) VALUES ('6', '002', '英语', '75.5');
INSERT INTO `dssp`.`tb_score` (`id`, `userid`, `subject`, `score`) VALUES ('7', '003', '语文', '70');
INSERT INTO `dssp`.`tb_score` (`id`, `userid`, `subject`, `score`) VALUES ('8', '003', '数学', '92');
INSERT INTO `dssp`.`tb_score` (`id`, `userid`, `subject`, `score`) VALUES ('9', '003', '英语', '90');
INSERT INTO `dssp`.`tb_score` (`id`, `userid`, `subject`, `score`) VALUES ('10', '003', '政治', '82');


SELECT DISTINCT
	userid
FROM
	tb_score t1
WHERE
	1 = 1
AND EXISTS (
	SELECT
		1
	FROM
		tb_score t2
	WHERE
		t2.`SUBJECT` = '语文' and t2.score = '90'
	AND t2.userid = t1.userid
)
AND EXISTS (
	SELECT
		1
	FROM
		tb_score t2
	WHERE
		t2.`SUBJECT` = '数学' and t2.score = '92'
	AND t2.userid = t1.userid
)