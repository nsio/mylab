CREATE TABLE `tb_area_corpo_selestial` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_corpo_selestial` int(11) DEFAULT NULL,
  `id_um_area` int(11) DEFAULT NULL,
  `area` decimal(30,2) DEFAULT NULL,
  `tp_area` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoy915sth6wqmm9ce0v8kwpofl` (`id_corpo_selestial`),
  KEY `FKbr74rj79reyrfij3lh1fej11f` (`id_um_area`),
  CONSTRAINT `FKbr74rj79reyrfij3lh1fej11f` FOREIGN KEY (`id_um_area`) REFERENCES `tb_unidade_medida` (`id`),
  CONSTRAINT `FKoy915sth6wqmm9ce0v8kwpofl` FOREIGN KEY (`id_corpo_selestial`) REFERENCES `tb_corpo_selestial` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `tb_atmosfera` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_corpo_selestial` int(11) DEFAULT NULL,
  `id_elemento` int(11) DEFAULT NULL,
  `quantidade` decimal(10,2) DEFAULT NULL,
  `id_um_quantidade` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ATM_QTD_UM_idx` (`id_um_quantidade`),
  KEY `FK_ATM_ELEMENTO_idx` (`id_elemento`),
  KEY `FK_ATM_CP_SELES_idx` (`id_corpo_selestial`),
  CONSTRAINT `FK_ATM_CP_SELES` FOREIGN KEY (`id_corpo_selestial`) REFERENCES `tb_corpo_selestial` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ATM_ELEMENTO` FOREIGN KEY (`id_elemento`) REFERENCES `tb_tabela_periodica` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_ATM_QTD_UM` FOREIGN KEY (`id_um_quantidade`) REFERENCES `tb_unidade_medida` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tb_composicao_massa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_corpo_selestial` int(11) DEFAULT NULL,
  `id_elemento` int(11) DEFAULT NULL,
  `composicao_massa` decimal(10,2) DEFAULT NULL,
  `id_um_composicao_massa` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_PLANETA_idx` (`id_corpo_selestial`),
  KEY `FK_UM_idx` (`id_um_composicao_massa`),
  KEY `FKr9mno6n0wk84uhjft694dpaog` (`id_elemento`),
  CONSTRAINT `FK1h02xt620mm0mn5h3o6wv3laf` FOREIGN KEY (`id_um_composicao_massa`) REFERENCES `tb_unidade_medida` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK6ak80krb5c4fn65kpj57dnjxv` FOREIGN KEY (`id_corpo_selestial`) REFERENCES `tb_corpo_selestial` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKr9mno6n0wk84uhjft694dpaog` FOREIGN KEY (`id_elemento`) REFERENCES `tb_tabela_periodica` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

CREATE TABLE `tb_corpo_selestial` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_tipo_corpo_selestial` int(11) DEFAULT NULL,
  `nm_selestial` varchar(200) DEFAULT NULL,
  `diametro_equatorial` decimal(30,2) DEFAULT NULL,
  `id_um_diametro_equatorial` int(11) DEFAULT NULL,
  `inclinacao_axial` decimal(10,2) DEFAULT NULL,
  `id_um_inclinacao_axial` int(11) DEFAULT NULL,
  `area_total` decimal(30,2) DEFAULT NULL,
  `id_um_area_total` int(11) DEFAULT NULL,
  `temperatura_interior` decimal(10,2) DEFAULT NULL,
  `id_um_temperatura_interior` int(11) DEFAULT NULL,
  `velocidade_escape` decimal(10,2) DEFAULT NULL,
  `id_um_velocidade_escape` int(11) DEFAULT NULL,
  `densidade_media` decimal(10,2) DEFAULT NULL,
  `id_um_densidade_media` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1abs0qt0be1krsp1htgdavtmd` (`id_tipo_corpo_selestial`),
  KEY `FKsjhc9obv6lbwumycvokvhnotc` (`id_um_area_total`),
  KEY `FKcd3bv9phul6kc2lqan2ylssn4` (`id_um_densidade_media`),
  KEY `FK2fjd859oefw2cyd2sbbg99g7e` (`id_um_diametro_equatorial`),
  KEY `FKndsu8llmaga3bnburivo0orsn` (`id_um_inclinacao_axial`),
  KEY `FKob212xpifc65i1f9g27c4k520` (`id_um_temperatura_interior`),
  KEY `FKncalap424lgbowe5og77016tl` (`id_um_velocidade_escape`),
  CONSTRAINT `FK1abs0qt0be1krsp1htgdavtmd` FOREIGN KEY (`id_tipo_corpo_selestial`) REFERENCES `tb_tipo_corpo_selestial` (`id`),
  CONSTRAINT `FK2fjd859oefw2cyd2sbbg99g7e` FOREIGN KEY (`id_um_diametro_equatorial`) REFERENCES `tb_unidade_medida` (`id`),
  CONSTRAINT `FKcd3bv9phul6kc2lqan2ylssn4` FOREIGN KEY (`id_um_densidade_media`) REFERENCES `tb_unidade_medida` (`id`),
  CONSTRAINT `FKncalap424lgbowe5og77016tl` FOREIGN KEY (`id_um_velocidade_escape`) REFERENCES `tb_unidade_medida` (`id`),
  CONSTRAINT `FKndsu8llmaga3bnburivo0orsn` FOREIGN KEY (`id_um_inclinacao_axial`) REFERENCES `tb_unidade_medida` (`id`),
  CONSTRAINT `FKob212xpifc65i1f9g27c4k520` FOREIGN KEY (`id_um_temperatura_interior`) REFERENCES `tb_unidade_medida` (`id`),
  CONSTRAINT `FKsjhc9obv6lbwumycvokvhnotc` FOREIGN KEY (`id_um_area_total`) REFERENCES `tb_unidade_medida` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `tb_corpo_selestial` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_tipo_corpo_selestial` int(11) DEFAULT NULL,
  `nm_selestial` varchar(200) DEFAULT NULL,
  `diametro_equatorial` decimal(30,2) DEFAULT NULL,
  `id_um_diametro_equatorial` int(11) DEFAULT NULL,
  `inclinacao_axial` decimal(10,2) DEFAULT NULL,
  `id_um_inclinacao_axial` int(11) DEFAULT NULL,
  `area_total` decimal(30,2) DEFAULT NULL,
  `id_um_area_total` int(11) DEFAULT NULL,
  `temperatura_interior` decimal(10,2) DEFAULT NULL,
  `id_um_temperatura_interior` int(11) DEFAULT NULL,
  `velocidade_escape` decimal(10,2) DEFAULT NULL,
  `id_um_velocidade_escape` int(11) DEFAULT NULL,
  `densidade_media` decimal(10,2) DEFAULT NULL,
  `id_um_densidade_media` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1abs0qt0be1krsp1htgdavtmd` (`id_tipo_corpo_selestial`),
  KEY `FKsjhc9obv6lbwumycvokvhnotc` (`id_um_area_total`),
  KEY `FKcd3bv9phul6kc2lqan2ylssn4` (`id_um_densidade_media`),
  KEY `FK2fjd859oefw2cyd2sbbg99g7e` (`id_um_diametro_equatorial`),
  KEY `FKndsu8llmaga3bnburivo0orsn` (`id_um_inclinacao_axial`),
  KEY `FKob212xpifc65i1f9g27c4k520` (`id_um_temperatura_interior`),
  KEY `FKncalap424lgbowe5og77016tl` (`id_um_velocidade_escape`),
  CONSTRAINT `FK1abs0qt0be1krsp1htgdavtmd` FOREIGN KEY (`id_tipo_corpo_selestial`) REFERENCES `tb_tipo_corpo_selestial` (`id`),
  CONSTRAINT `FK2fjd859oefw2cyd2sbbg99g7e` FOREIGN KEY (`id_um_diametro_equatorial`) REFERENCES `tb_unidade_medida` (`id`),
  CONSTRAINT `FKcd3bv9phul6kc2lqan2ylssn4` FOREIGN KEY (`id_um_densidade_media`) REFERENCES `tb_unidade_medida` (`id`),
  CONSTRAINT `FKncalap424lgbowe5og77016tl` FOREIGN KEY (`id_um_velocidade_escape`) REFERENCES `tb_unidade_medida` (`id`),
  CONSTRAINT `FKndsu8llmaga3bnburivo0orsn` FOREIGN KEY (`id_um_inclinacao_axial`) REFERENCES `tb_unidade_medida` (`id`),
  CONSTRAINT `FKob212xpifc65i1f9g27c4k520` FOREIGN KEY (`id_um_temperatura_interior`) REFERENCES `tb_unidade_medida` (`id`),
  CONSTRAINT `FKsjhc9obv6lbwumycvokvhnotc` FOREIGN KEY (`id_um_area_total`) REFERENCES `tb_unidade_medida` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `tb_periodo_rotacao` (
  `id` int(11) NOT NULL,
  `id_corpo_selestial` int(11) DEFAULT NULL,
  `id_um_periodo` int(11) DEFAULT NULL,
  `periodo` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_UM_idx` (`id_um_periodo`),
  KEY `FK_PER_ROT_PLA_idx` (`id_corpo_selestial`),
  KEY `FK_PER_ROT_UM_idx` (`id_um_periodo`),
  CONSTRAINT `FK_PER_ROT_CP_SELES` FOREIGN KEY (`id_corpo_selestial`) REFERENCES `tb_corpo_selestial` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_PER_ROT_UM` FOREIGN KEY (`id_um_periodo`) REFERENCES `tb_unidade_medida` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tb_tabela_periodica` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nr_atomico` decimal(10,2) DEFAULT NULL,
  `simbolo` varchar(45) DEFAULT NULL,
  `nm_elemento` varchar(250) DEFAULT NULL,
  `massa_atomica` decimal(10,2) DEFAULT NULL,
  `distribuicao` varchar(190) DEFAULT NULL,
  `linha` int(11) DEFAULT NULL,
  `coluna` int(11) DEFAULT NULL,
  `familia` varchar(45) DEFAULT NULL,
  `tp_elemento` varchar(240) DEFAULT NULL,
  `dt_insert` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

CREATE TABLE `tb_temperatura_cp_selestial` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_corpo_selestial` int(11) DEFAULT NULL,
  `temperatura_min` decimal(10,2) DEFAULT NULL,
  `id_um_temperatura_min` int(11) DEFAULT NULL,
  `temperatura_media` decimal(10,2) DEFAULT NULL,
  `id_um_temperatura_media` int(11) DEFAULT NULL,
  `temperatura_max` decimal(10,2) DEFAULT NULL,
  `id_um_temperatura_max` int(11) DEFAULT NULL,
  `anotacoes` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_TEMP_MIM_UM_idx` (`id_um_temperatura_min`),
  KEY `FK_TEMP_MEDIA_UM_idx` (`id_um_temperatura_media`),
  KEY `FK_TEMP_MAX_UM_idx` (`id_um_temperatura_max`),
  KEY `FK_TEMP_CP_SELES_idx` (`id_corpo_selestial`),
  CONSTRAINT `FK_TEMP_CP_SELES` FOREIGN KEY (`id_corpo_selestial`) REFERENCES `tb_corpo_selestial` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_TEMP_MAX_UM` FOREIGN KEY (`id_um_temperatura_max`) REFERENCES `tb_unidade_medida` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_TEMP_MEDIA_UM` FOREIGN KEY (`id_um_temperatura_media`) REFERENCES `tb_unidade_medida` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_TEMP_MIM_UM` FOREIGN KEY (`id_um_temperatura_min`) REFERENCES `tb_unidade_medida` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tb_tipo_corpo_selestial` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

CREATE TABLE `tb_unidade_medida` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `grandeza` varchar(200) DEFAULT NULL,
  `nm_unidade` varchar(200) DEFAULT NULL,
  `simbolo` varchar(10) DEFAULT NULL,
  `regra` varchar(200) DEFAULT NULL,
  `dt_insert` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

CREATE TABLE `tb_usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `dt_insert` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;








