package com.pspot.wicket.filter;


import com.gfs.finger.util.KryoUtils;
import com.pspot.wicket.App;
import com.pspot.wicket.support.ExceptionHandler;
import com.pspot.wicket.internal.ConvertImgServiceImpl;
import com.pspot.wicket.vo.LatentImageBean;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpStatus;
import org.apache.wicket.protocol.http.WicketFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author <a href="yuchen_1997_200486@126.com">yuchen</a>.
 * @since 2019/4/24
 */
public class RequestFilter extends WicketFilter{

    private static final Logger logger = LoggerFactory.getLogger(RequestFilter.class);
    private static final String REQUEST_HEAD_INFO = "X-Requested-With,Content-Type,X-Wicket-Request";

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response,
                         final FilterChain chain) throws IOException, ServletException
    {
        LatentImageBean latentImageBean_result = new LatentImageBean();
        try{
            HttpServletRequest httpServletRequest = (HttpServletRequest)request;
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;

            if(httpServletRequest.getHeader("Access-Control-Allow-Headers") == null
                    || !httpServletRequest.getHeader("Access-Control-Allow-Headers").equals(REQUEST_HEAD_INFO)){
                httpServletResponse.setStatus(HttpStatus.SC_FORBIDDEN);
                httpServletResponse.getWriter();
                throw new Exception("forbidden request:" + new Date());
            }
            byte[] bytes = IOUtils.toByteArray(httpServletRequest.getInputStream());
            ConvertImgServiceImpl service = App.GUICE.get().getInstance(ConvertImgServiceImpl.class);
            LatentImageBean latentImageBean = KryoUtils.deserializer(bytes, new LatentImageBean());
            byte[] convertImg = service.convertImage(latentImageBean.getImg(),false);
            latentImageBean_result.setImg(convertImg);
            latentImageBean_result.setSuccess(true);
        }catch (Exception e){
            latentImageBean_result.setMessage(ExceptionHandler.getErrorInfoFromException(e));
            latentImageBean_result.setSuccess(false);
            logger.error("current error:{}" ,e);
        }
        byte[] result = KryoUtils.registerKryo(latentImageBean_result);
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(result);
    }
}
