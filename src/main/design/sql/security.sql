USE model;

-- 创建用户-角色对应表
DROP TABLE IF EXISTS `mo_userRole`;
CREATE TABLE `mo_userRole`(
	strId							VARCHAR(32)		NOT NULL,											-- 主键Id
	strLoginId						VARCHAR(50)		NOT NULL,											-- 用户id
	strRoleId						VARCHAR(32)		NOT NULL,											-- 角色Id
	PRIMARY KEY(strId),
	UNIQUE(strId)
)
ENGINE=INNODB
DEFAULT CHARACTER SET=utf8;

-- 创建角色表
DROP TABLE IF EXISTS `mo_role`;
CREATE TABLE `mo_role`(
	strId							VARCHAR(32)		NOT NULL,											-- 主键Id
	strName							VARCHAR(32)		NOT NULL,											-- 角色名称
	strDescription					VARCHAR(100)	NOT NULL,											-- 角色描述
	nState							TINYINT			NOT NULL DEFAULT 0,									-- 状态:1-正常,0-禁用
	PRIMARY KEY(strId),
	UNIQUE(strId)
)
ENGINE=INNODB
DEFAULT CHARACTER SET=utf8;

-- 创建权限表
DROP TABLE IF EXISTS `mo_permission`;
CREATE TABLE `mo_permission`(
	strId							VARCHAR(32)		NOT NULL,											-- 主键Id
	strPid							VARCHAR(32)		NOT NULL,											-- 父级id
	strName							VARCHAR(32)		NOT NULL,											-- 权限名称
	strPermission					VARCHAR(100),														-- 权限标识
	strDescription					VARCHAR(200)	NOT NULL,											-- 权限描述
	nType							TINYINT			NOT NULL DEFAULT 0,									-- 类型:0-菜单,1-按钮
	nState							TINYINT			NOT NULL DEFAULT 0,									-- 状态:1-正常,0-禁用
	dtCreateTime					DATETIME		NOT NULL,											-- 创建时间:yyyy-mm-dd HH:mm:ss
	PRIMARY KEY(strId),
	UNIQUE(strId)
)
ENGINE=INNODB
DEFAULT CHARACTER SET=utf8;

-- 创建角色-权限对应表
DROP TABLE IF EXISTS `mo_rolePermission`;
CREATE TABLE `mo_rolePermission`(
	strId							VARCHAR(32)		NOT NULL,											-- 主键Id
	strRoleId						VARCHAR(32)		NOT NULL,											-- 角色Id
	strPermissionId					VARCHAR(32)		NOT NULL,											-- 权限id
	PRIMARY KEY(strId),
	UNIQUE(strId)
)
ENGINE=INNODB
DEFAULT CHARACTER SET=utf8;