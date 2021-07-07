CREATE TABLE `site` (
  `id` int(11) NOT NULL,
  `site` varchar(255) DEFAULT NULL,
  `up` int(255) DEFAULT NULL,
  `down` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `site` (`id`, `site`, `up`, `down`) VALUES ('1', 'a', '20', '0');
INSERT INTO `site` (`id`, `site`, `up`, `down`) VALUES ('2', 'b', '5', '2');
INSERT INTO `site` (`id`, `site`, `up`, `down`) VALUES ('3', 'c', '2', '6');
INSERT INTO `site` (`id`, `site`, `up`, `down`) VALUES ('4', 'd', '10', '3');
INSERT INTO `site` (`id`, `site`, `up`, `down`) VALUES ('5', 'e', '3', '12');

-- 公交车每站有上车人数和下车人数,求没站车上剩余的人数
SELECT t1.id,t1.site,t1.up,t1.down,(sum(t2.up)-sum(t2.down)) as inc FROM `site` t1 left join site t2 on t1.id >= t2.id group by t1.id
