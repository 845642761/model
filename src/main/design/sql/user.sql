USE model;

-- 创建登录用户表
DROP TABLE IF EXISTS `mo_loginUser`;
CREATE TABLE `mo_loginUser`(
	strLoginId						VARCHAR(50)		NOT NULL,											-- 登录id（字母小写）
	strPassword						VARCHAR(32)		NOT NULL,											-- 密码
	nState							TINYINT			NOT NULL DEFAULT 0,									-- 状态,0-待审核,1-正常,2-禁用
	PRIMARY KEY(strLoginId),
	UNIQUE(strLoginId)
)
ENGINE=INNODB
DEFAULT CHARACTER SET=utf8;


-- 创建用户表
DROP TABLE IF EXISTS `mo_user`;
CREATE TABLE `mo_user`(
	strLoginId						VARCHAR(50)		NOT NULL,											-- 登录id（字母小写）
	strName							VARCHAR(30)		NOT NULL,											-- 姓名
	nSex							TINYINT			NOT NULL DEFAULT 0,									-- 性别, 0-未填写,1-男,2-女
	strMobile						VARCHAR(20)		NOT NULL,											-- 手机号
	strPhone						VARCHAR(20),														-- 紧急联系人
	strEmail						VARCHAR(60),														-- 邮箱
	strQQ							VARCHAR(20),														-- QQ
	strWeChar						VARCHAR(20),														-- 微信
	dtBirthday						DATETIME		NOT NULL,											-- 出生日期:yyyy-mm-dd HH:mm:ss
	strProvinceCode					VARCHAR(70),														-- 所属省id
	strProvinceName					VARCHAR(100),														-- 所属省名称
	strCityCode						VARCHAR(70),														-- 所属城市id
	strCityName						VARCHAR(20),														-- 所属城市名称
	strAddress						VARCHAR(100)	NOT NULL,											-- 地址
	strHeadURL						VARCHAR(300),														-- 头像
	dtCreateTime					DATETIME		NOT NULL,											-- 注册时间:yyyy-mm-dd HH:mm:ss
	dtUpdateTime					DATETIME		NOT NULL,											-- 修改时间:yyyy-mm-dd HH:mm:ss
	PRIMARY KEY(strLoginId),
	UNIQUE(strLoginId)
)
ENGINE=INNODB
DEFAULT CHARACTER SET=utf8;