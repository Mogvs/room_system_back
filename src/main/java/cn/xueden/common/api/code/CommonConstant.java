package cn.xueden.common.api.code;

public interface CommonConstant {

	/**
	 * 正常状态
	 */
    Integer STATUS_NORMAL = 0;

	/**
	 * 禁用状态
	 */
    Integer STATUS_DISABLE = -1;

	/**
	 * 删除标志
	 */
    Integer DEL_FLAG_1 = 1;

	/**
	 * 未删除
	 */
    Integer DEL_FLAG_0 = 0;

	/**
	 * 系统日志类型： 登录
	 */
    int LOG_TYPE_1 = 1;
	
	/**
	 * 系统日志类型： 操作
	 */
    int LOG_TYPE_2 = 2;

	/**
	 * 操作日志类型： 查询
	 */
    int OPERATE_TYPE_1 = 1;
	
	/**
	 * 操作日志类型： 添加
	 */
    int OPERATE_TYPE_2 = 2;
	
	/**
	 * 操作日志类型： 更新
	 */
    int OPERATE_TYPE_3 = 3;
	
	/**
	 * 操作日志类型： 删除
	 */
    int OPERATE_TYPE_4 = 4;
	
	/**
	 * 操作日志类型： 倒入
	 */
    int OPERATE_TYPE_5 = 5;
	
	/**
	 * 操作日志类型： 导出
	 */
    int OPERATE_TYPE_6 = 6;
	
	
	/**
     * {@code 500 Server Error} (HTTP/1.0 - RFC 1945)
     *
     */
    Integer SC_INTERNAL_SERVER_ERROR_500 = 500;
    /**
     * {@code 200 OK} (HTTP/1.0 - RFC 1945)
     */
    Integer SC_OK_200 = 200;


    Integer SC_ERROR_400 = 400;
    /**
     * 访问权限认证未通过 510
     */
    Integer SC_JEECG_NO_AUTHZ=510;
    /**
     * token过期
     */
    Integer SC_JEECG_NO_TOKEN = 530;

    /**
     * 投资限制校验未通过
     */
    Integer SC_INVEST_LIMIT_CHECK_ERROR = 520;

    /**
     * 登录用户Shiro权限缓存KEY前缀
     */
    String PREFIX_USER_SHIRO_CACHE  = "shiro:cache:org.jeecg.modules.shiro.authc.ShiroRealm.authorizationCache:";
    /**
     * 登录用户Token令牌缓存KEY前缀
     */
    String PREFIX_USER_TOKEN  = "prefix_user_token_";
    /**
     * app用户
     */
    String PREFIX_APP_USER_TOKEN  = "prefix_app_user_token_";
    /**
     * Token缓存时间：3600秒即一小时
     */
    int  TOKEN_EXPIRE_TIME  = 3600;

    /**
     * 登录用户信息
     */
    String PREFIX_USER = "prefix_user";
    /**
     *  0：一级菜单
     */
    Integer MENU_TYPE_0  = 0;
   /**
    *  1：子菜单 
    */
   Integer MENU_TYPE_1  = 1;
    /**
     *  2：按钮权限
     */
    Integer MENU_TYPE_2  = 2;

    /**
     * 通告对象类型（USER:指定用户，ALL:全体用户）
     */
    String MSG_TYPE_UESR  = "USER";
    String MSG_TYPE_ALL  = "ALL";

    /**
     * 发布状态（0未发布，1已发布，2已撤销）
     */
    String NO_SEND  = "0";
    String HAS_SEND  = "1";
    String HAS_CANCLE  = "2";

    /**
     * 阅读状态（0未读，1已读）
     */
    String HAS_READ_FLAG  = "1";
    String NO_READ_FLAG  = "0";

    /**
     * 优先级（L低，M中，H高）
     */
    String PRIORITY_L  = "L";
    String PRIORITY_M  = "M";
    String PRIORITY_H  = "H";
    
    /**
     * 短信模板方式  0 .登录模板、1.注册模板、2.忘记密码模板
     */
    String SMS_TPL_TYPE_0  = "0";
    String SMS_TPL_TYPE_1  = "1";
    String SMS_TPL_TYPE_2  = "2";
    
    /**
     * 状态(0无效1有效)
     */
    String STATUS_0 = "0";
    String STATUS_1 = "1";
    
    /**
     * 同步工作流引擎1同步0不同步
     */
    String ACT_SYNC_0 = "0";
    String ACT_SYNC_1 = "1";
    
    /**
     * 消息类型1:通知公告2:系统消息
     */
    String MSG_CATEGORY_1 = "1";
    String MSG_CATEGORY_2 = "2";
    
    /**
     * 是否配置菜单的数据权限 1是0否
     */
    Integer RULE_FLAG_0 = 0;
    Integer RULE_FLAG_1 = 1;

    /**
     * 是否用户已被冻结 1(解冻)正常 2冻结
     */
    Integer USER_UNFREEZE = 1;
    Integer USER_FREEZE = 2;
    
    /**字典翻译文本后缀*/
    String DICT_TEXT_SUFFIX = "_dictText";

    /**
     * 表单设计器主表类型
     */
    Integer DESIGN_FORM_TYPE_MAIN = 1;

    /**
     * 表单设计器子表表类型
     */
    Integer DESIGN_FORM_TYPE_SUB = 2;

    /**
     * 表单设计器URL授权通过
     */
    Integer DESIGN_FORM_URL_STATUS_PASSED = 1;

    /**
     * 表单设计器URL授权未通过
     */
    Integer DESIGN_FORM_URL_STATUS_NOT_PASSED = 2;

    /**
     * 表单设计器新增 Flag
     */
    String DESIGN_FORM_URL_TYPE_ADD = "add";
    /**
     * 表单设计器修改 Flag
     */
    String DESIGN_FORM_URL_TYPE_EDIT = "edit";
    /**
     * 表单设计器详情 Flag
     */
    String DESIGN_FORM_URL_TYPE_DETAIL = "detail";
    /**
     * 表单设计器复用数据 Flag
     */
    String DESIGN_FORM_URL_TYPE_REUSE = "reuse";
    /**
     * 表单设计器编辑 Flag （已弃用）
     */
    String DESIGN_FORM_URL_TYPE_VIEW = "view";

    /**
     * online参数值设置（是：Y, 否：N）
     */
    String ONLINE_PARAM_VAL_IS_TURE = "Y";
    String ONLINE_PARAM_VAL_IS_FALSE = "N";

    /**
     * 文件上传类型（本地：local，Minio：minio，阿里云：alioss）
     */
    String UPLOAD_TYPE_LOCAL = "local";
    String UPLOAD_TYPE_MINIO = "minio";
    String UPLOAD_TYPE_OSS = "alioss";

    /**
     * 员工身份 （1:普通员工  2:上级）
     */
    Integer USER_IDENTITY_1 = 1;
    Integer USER_IDENTITY_2 = 2;

    /**
     * 推荐机构换成前缀
     */
    String CUS_RECOMMEND_ORG_COE = "CUS_RECOMMEND_ORG_";

    /**
     * 最大导出条数
     */
    String EXPORT_MAX_NUMBER = "export_max_number";

    /**
     * 管理员角色role_code值
     */
    String ADMIN = "admin";
}
