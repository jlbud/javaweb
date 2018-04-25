2.反馈表
    CREATE TABLE `t_feedback` (
            `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '反馈ID',
            `email` varchar(255) DEFAULT NULL COMMENT '邮箱地址',
            `content` varchar(255) DEFAULT NULL COMMENT '反馈内容',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

1.用户表    
CREATE TABLE `t_user` (
              `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
              `email` varchar(255) NOT NULL COMMENT '用户邮箱',
              `password` varchar(255) NOT NULL COMMENT '用户密码',
              `username` varchar(255) NOT NULL COMMENT '用户昵称',
              `phone` varchar(255) NOT NULL COMMENT '用户昵称',
              `sex` varchar(255) NOT NULL COMMENT '用户昵称',
              `sfz` varchar(255) NOT NULL COMMENT '用户昵称',
              `truename` varchar(255) NOT NULL COMMENT '用户昵称',
      PRIMARY KEY (`id`),
      UNIQUE KEY `email` (`email`) USING BTREE
  ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
      INSERT INTO `t_user` VALUES ('1', '11111111111@outlook.com', '123456', 'kevin', '1111111111', '0', 'shen me gui', 'kevin');
      SET FOREIGN_KEY_CHECKS=1;
