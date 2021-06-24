package xyz.asitanokibou.demo.models.core;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {
	BUSINESS_EXCEPTION(false, -10000, "业务异常"),

	SUCCESS(true, 20000,"成功"),
	UNKNOWN_REASON(false, 20001, "未知错误"),
	EXCEPTION(false, 20002, "异常"),
	FALLBACK(false, 20003, "跨服务Feign请求异常"),
	SERVICE_NOT_FOUND(false,20004, "未找到服务"),
	BAD_SQL_GRAMMAR(false, 21001, "sql语法错误"),
	JSON_PARSE_ERROR(false, 21002, "json解析异常"),
	PARAM_ERROR(false, 21003, "参数异常"),
	FILE_UPLOAD_ERROR(false, 21004, "文件上传错误"),
	EXCEL_DATA_IMPORT_ERROR(false, 21005, "Excel数据导入错误"),

	VIDEO_UPLOAD_ERROR(false, 22001, "阿里云视频上传错误"),
	VIDEO_DELETE_ALIYUN_ERROR(false, 22002, "阿里云视频删除错误"),
	FETCH_VIDEO_UPLOADAUTH_ERROR(false, 22003, "阿里云获取上传凭证错误"),
	REFRESH_VIDEO_UPLOADAUTH_ERROR(false, 22004, "阿里云刷新传凭证错误"),
	FETCH_VIDEO_PLAYAUTH_ERROR(false, 22005, "阿里云播放凭证获取错误"),

	URL_ENCODE_ERROR(false, 23001, "URL转码错误"),
	ILLEGAL_CALLBACK_REQUEST_ERROR(false, 23002, "非法回调参数错误"),
	FETCH_ACCESS_TOKEN_ERROR(false, 23003, "获取授权码错误"),

	NULL_POINTER_EXCEPTION(false, 50001,"空指针异常"),
	ARITHMETIC_EXCEPTION(false, 50002,"算术运算异常"),
	REQUEST_PARAMETER_EXCEPTION(false, 50003,"请求参数异常"),
	VALIDATION_BIND_EXCEPTION(false, 50004,"参数校验异常"),

	DATABASE_EXCEPTION(false,60000,"数据库异常"),
	REDIS_EXCEPTION(false,60001,"缓存异常"),
	SERVICE_EXCEPTION(false,60002,"微服务异常"),
	ORM_EXCEPTION(false, 60003,"ORM层异常"),

	AUTHENTICATION_EXCEPTION(false,70000,"权限认证异常"),
	AUTHENTICATION_ILLEGALITY_EXCEPTION(false,70001,"权限认证异常，非法请求"),
	AUTHENTICATION_ACCESS_DENIED(false,70001,"拒绝访问");

	private final Boolean success;//响应是否成功
	private final Integer code;//返回码
	private final String message;//返回消息

	ResultCodeEnum(Boolean success, Integer code, String message) {
		this.success = success;
		this.code = code;
		this.message = message;
	}
}