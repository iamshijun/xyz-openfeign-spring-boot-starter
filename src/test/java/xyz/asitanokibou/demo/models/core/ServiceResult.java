package xyz.asitanokibou.demo.models.core;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

/**
 * 全局统一返回结果
 */
@Data
@NoArgsConstructor
public class ServiceResult<T> {

	/**
	 * 是否成功
	 */
	private Boolean success;

	/**
	 * 返回码
	 */
	private Integer code;

	/**
	 * 返回消息
	 */
	private String message;

	private String msg;

	/**
	 * 返回数据
	 */
	private T data;

	public ServiceResult(ResultCodeEnum resultCodeEnum){
		this.code = resultCodeEnum.getCode();
		this.success = resultCodeEnum.getSuccess();
		this.message = resultCodeEnum.getMessage();
	}

	public ServiceResult(ResultCodeEnum resultCodeEnum, String message){
		this.code = resultCodeEnum.getCode();
		this.success = resultCodeEnum.getSuccess();
		this.message = message;
	}


	public static <E> ServiceResult<E> error(){
		return new ServiceResult<>(ResultCodeEnum.UNKNOWN_REASON);
	}

	public static <E> ServiceResult<E> error(ResultCodeEnum resultCodeEnum){
		return new ServiceResult<>(resultCodeEnum);
	}

	public static <E> ServiceResult<E> error(ResultCodeEnum resultCodeEnum, String message){
		return new ServiceResult<>(resultCodeEnum,message);
	}


	/**
	 * feigh调用失败时回调返回
	 */
	public static <E> ServiceResult<E> fallback(Throwable cause) {
		if(cause != null){
			if(cause instanceof RuntimeException){
//				if(cause.getCause() instanceof com.netflix.client.ClientException){
//					//微服务通信失败
//					return ServiceResult.error(ResultCodeEnum.SERVICE_NOT_FOUND);
//				}
			}
			if(!StringUtils.isEmpty(cause.getMessage())){
				return ServiceResult.error(ResultCodeEnum.FALLBACK,ResultCodeEnum.FALLBACK+":"+cause.getMessage());
			}
		}
		return ServiceResult.error(ResultCodeEnum.FALLBACK);
	}
}
