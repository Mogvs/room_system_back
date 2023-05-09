package cn.xueden.common.api;

import cn.xueden.common.api.code.CommonConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *   接口返回数据格式
 * @author scott
 * @email jeecgos@163.com
 * @date  2019年1月19日
 */
@Data
@ApiModel(value="接口返回对象", description="接口返回对象")
public class Result<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String DEFAULT_SUCCESS_MSG = "成功";

	/**
	 * 成功标志
	 */
	@ApiModelProperty(value = "成功标志")
	private boolean success = true;

	/**
	 * 返回处理消息
	 */
	@ApiModelProperty(value = "返回处理消息")
	private String message = "操作成功！";

	@ApiModelProperty(value = "返回处理代码")
	private String bizCode = "";

	private String readFlag ;

	/**
	 * 返回代码
	 */
	@ApiModelProperty(value = "返回代码")
	private Integer code = 0;

	/**
	 * 返回数据对象 data
	 */
	@ApiModelProperty(value = "返回数据对象")
	private T result;

	/**
	 * 时间戳
	 */
	@ApiModelProperty(value = "时间戳")
	private long timestamp = System.currentTimeMillis();

	public Result() {

	}

	public Result<T> success(String message) {
		this.message = message;
		this.code = CommonConstant.SC_OK_200;
		this.success = true;
		return this;
	}


	public static Result<Object> ok() {
		Result<Object> r = new Result<Object>();
		r.setSuccess(true);
		r.setCode(CommonConstant.SC_OK_200);
		r.setMessage(DEFAULT_SUCCESS_MSG);
		return r;
	}

	public static Result<Object> ok(String msg) {
		Result<Object> r = new Result<Object>();
		r.setSuccess(true);
		r.setCode(CommonConstant.SC_OK_200);
		r.setMessage(msg);
		return r;
	}

	public static Result<Object> ok(Object data) {
		Result<Object> r = new Result<Object>();
		r.setSuccess(true);
		r.setCode(CommonConstant.SC_OK_200);
		r.setResult(data);
		return r;
	}

	public static <T> Result<List<T>> ok(List<T> data) {
		Result<List<T>> r = new Result<>();
		r.setSuccess(true);
		r.setCode(CommonConstant.SC_OK_200);
		r.setResult(data);
		return r;
	}

	public static <T> Result<T> okd(T data) {
		Result<T> r = new Result<>();
		r.setSuccess(true);
		r.setCode(CommonConstant.SC_OK_200);
		r.setResult(data);
		return r;
	}

	public static Result<Object> ok(String msg,Object data) {
		Result<Object> r = new Result<Object>();
		r.setSuccess(true);
		r.setCode(CommonConstant.SC_OK_200);
		r.setResult(data);
		r.setMessage(msg);
		return r;
	}

	public static Result<Object> error(String msg) {
		return error(CommonConstant.SC_INTERNAL_SERVER_ERROR_500, msg);
	}

	public static Result<Object> error(int code, String msg) {
		Result<Object> r = new Result<Object>();
		r.setCode(code);
		r.setMessage(msg);
		r.setSuccess(false);
		return r;
	}

	public static <T> Result<T> err(String msg) {
		Result<T> result = new Result<>();
		result.setCode(CommonConstant.SC_INTERNAL_SERVER_ERROR_500);
		result.setMessage(msg);

		return result;
	}

	public static Result<Object> error(int code, String bizCode, String msg) {
		Result<Object> r = new Result<Object>();
		r.setCode(code);
		r.setMessage(msg);
		r.setSuccess(false);
		r.setBizCode(bizCode);
		return r;
	}

	public static Result<Object> error(String bizCode,String msg) {
		Result<Object> r = new Result<Object>();
		r.setCode(CommonConstant.SC_INTERNAL_SERVER_ERROR_500);
		r.setMessage(msg);
		r.setSuccess(false);
		r.setBizCode(bizCode);
		return r;
	}

	public static Result<Object> error(Object data) {
		Result<Object> r = new Result<Object>();
		r.setSuccess(false);
		r.setMessage("操作失败");
		r.setCode(CommonConstant.SC_ERROR_400);
		r.setResult(data);
		return r;
	}

	public static Result<Object> error(String msg,Object data) {
		Result<Object> r = new Result<Object>();
		r.setSuccess(false);
		r.setCode(CommonConstant.SC_ERROR_400);
		r.setMessage(msg);
		r.setResult(data);
		return r;
	}

	public static Result<Object> error(int code, Object data) {
		Result<Object> r = new Result<Object>();
		r.setSuccess(false);
		r.setCode(code);
		r.setResult(data);
		return r;
	}

	public Result<T> error500(String message) {
		this.message = message;
		this.code = CommonConstant.SC_INTERNAL_SERVER_ERROR_500;
		this.success = false;
		return this;
	}
	/**
	 * 无权限访问返回结果
	 */
	public static Result<Object> noauth(String msg) {
		return error(CommonConstant.SC_JEECG_NO_AUTHZ, msg);
	}
	/**
	 * token过期或未登陆
	 */
	public static Result<Object> noToken(String code,String message) {
		return error(CommonConstant.SC_JEECG_NO_TOKEN, code, message);
	}
}