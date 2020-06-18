package com.xians.yaco.web.controller.base;


import com.xians.yaco.model.dto.JsonResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMappingJacksonResponseBodyAdvice;

/**
 * 控制器adivce获取评论结果。
 *
 * @author XIANS
 */
@ControllerAdvice("cc.ryanc.halo.web.controller.api")
public class CommonResultControllerAdvice extends AbstractMappingJacksonResponseBodyAdvice {


    @Override
    protected void beforeBodyWriteInternal(MappingJacksonValue bodyContainer,
                                           MediaType contentType,
                                           MethodParameter returnType,
                                           ServerHttpRequest request,
                                           ServerHttpResponse response) {
        //获取返回的具体内容
        Object returnBody = bodyContainer.getValue();

        if (returnBody instanceof JsonResult) {
            //如果返回体是JsonResult的实例
            JsonResult jsonResult = (JsonResult) returnBody;
            response.setStatusCode(HttpStatus.resolve(jsonResult.getCode()));
            return;
        }

        // 正常的返回
        HttpStatus okStatus = HttpStatus.OK;
        JsonResult jsonResult = new JsonResult(okStatus.value(), okStatus.getReasonPhrase(), returnBody);
        bodyContainer.setValue(jsonResult);
        response.setStatusCode(okStatus);
    }
}
