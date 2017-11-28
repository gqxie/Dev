package com.gqxie.entity;

import com.gqxie.constants.ErrorCode;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 通用结果处理类
 *
 * @param <T>
 * @author xieguoqiang
 */
public class Result<T> implements Serializable
{

    private static final long    serialVersionUID = -5552826115844664550L;
    /**
     * 是否成功，默认成功
     */
    protected            boolean success          = true;

    /**
     * 错误码
     */
    protected String errorCode = "0";

    /**
     * 结果信息
     */
    protected String message = "success";

    private Map<String, Serializable> data = new HashMap<String, Serializable>();

    private transient T target;

    public Result()
    {
    }

    public Result(ErrorCode errorCode)
    {
        Assert.notNull(errorCode);

        setErrorCode(String.valueOf(errorCode.getCode()));
        setMessage(errorCode.getMessage());
    }

    public Result(String code, String message)
    {
        setErrorCode(code);
        setMessage(message);
    }

    public Result(T target)
    {
        Assert.notNull(target);

        setTarget(target);
    }

    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        str.append("dragon.core.lang.Result:").append("\n");
        str.append("success=").append(success).append("\t");
        str.append("errorCode=").append(errorCode).append("\t");
        str.append("message=").append(message).append("\t");
        str.append("data=").append(data).append("\t");
        str.append("target=").append(target).append("\t");
        str.append("\n");
        return str.toString();
    }

    /**
     * 拷贝结果
     *
     * @param result 拷贝目标结果
     * @return 拷贝源结果
     */
    public Result copy(Result result)
    {
        if (result != null)
        {
            this.success = result.success;
            this.errorCode = result.errorCode;
            this.message = result.message;
        }

        return this;
    }

    /**
     * 失败
     */
    public void fail()
    {
        this.success = false;
    }

    /**
     * 失败
     *
     * @param message 结果信息
     */
    public void fail(String message)
    {
        this.success = false;
        this.message = message;
    }

    /**
     * 失败
     *
     * @param errorCode 错误码
     * @param message   结果信息
     */
    public void fail(String errorCode, String message)
    {
        this.success = false;
        this.errorCode = errorCode;
        this.message = message;
    }

    /**
     * 失败 <br>
     * 〈功能详细描述〉
     *
     * @param errorCode 错误码枚举对象
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public void fail(ErrorCode errorCode)
    {
        this.success = false;

        if (errorCode != null)
        {
            this.errorCode = String.valueOf(errorCode.getCode());
            this.message = errorCode.getMessage();
        }
        else
        {
            this.errorCode = "Undefined";
            this.message = "Undefined";
        }
    }

    /**
     * 获取是否成功
     *
     * @return 是否成功
     */
    public boolean isSuccess()
    {
        return success;
    }

    /**
     * 设置是否成功. 该方法已经过时, 使用 {@link #setErrorCode(String)} 设置错误码时默认
     * {@code success} 为 {@code false}.
     *
     * @param success 是否成功
     * @see #setErrorCode(String)
     */
    @Deprecated
    public void setSuccess(boolean success)
    {
        this.success = success;
    }

    /**
     * 获取错误码
     *
     * @return 错误码
     */
    public String getErrorCode()
    {
        return errorCode;
    }

    /**
     * 设置错误码
     *
     * @param errorCode 错误码
     */
    public void setErrorCode(String errorCode)
    {
        Assert.notNull(errorCode);

        this.errorCode = errorCode;

        this.success = false;
    }

    /**
     * 获取结果信息
     *
     * @return 结果信息
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * 设置结果信息
     *
     * @param message 结果信息
     */
    public void setMessage(String message)
    {
        this.message = message;
    }

    @Deprecated
    public void putData(String key, Serializable value)
    {
        this.data.put(key, value);
    }

    @Deprecated
    public Object getData(String key)
    {
        return this.data.get(key);
    }

    @Deprecated
    public <T> T getData(String key, Class<T> requiredType)
    {
        Object obj = this.data.get(key);
        if (obj != null)
        {
            return (T) obj;
        }
        else
        {
            return null;
        }
    }

    @Deprecated
    public Set<Map.Entry<String, Serializable>> entrySet()
    {
        return this.data.entrySet();
    }

    /**
     * @return the data
     */
    @Deprecated
    public Map<String, Serializable> getData()
    {
        return data;
    }

    public T getTarget()
    {
        return target;
    }

    public void setTarget(T target)
    {
        this.target = target;
    }
}
