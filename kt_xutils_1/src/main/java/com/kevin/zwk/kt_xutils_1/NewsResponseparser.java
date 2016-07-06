package com.kevin.zwk.kt_xutils_1;


import com.alibaba.fastjson.JSONObject;

import org.xutils.http.app.ResponseParser;
import org.xutils.http.request.UriRequest;

import java.lang.reflect.Type;

/**
 * ----------BigGod be here!----------/
 * ***┏┓******┏┓*********
 * *┏━┛┻━━━━━━┛┻━━┓*******
 * *┃             ┃*******
 * *┃     ━━━     ┃*******
 * *┃             ┃*******
 * *┃  ━┳┛   ┗┳━  ┃*******
 * *┃             ┃*******
 * *┃     ━┻━     ┃*******
 * *┃             ┃*******
 * *┗━━━┓     ┏━━━┛*******
 * *****┃     ┃神兽保佑*****
 * *****┃     ┃代码无BUG！***
 * *****┃     ┗━━━━━━━━┓*****
 * *****┃              ┣┓****
 * *****┃              ┏┛****
 * *****┗━┓┓┏━━━━┳┓┏━━━┛*****
 * *******┃┫┫****┃┫┫********
 * *******┗┻┛****┗┻┛*********
 * ━━━━━━神兽出没━━━━━━
 * <p/>
 * 项目名称：kt_0706_chuanganqi_1
 * 包名称：com.kevin.zwk.kt_xutils_1
 * 类描述：
 * 创建人：Zhang Wenkai
 * 创建时间：2016/7/6 14:54
 * 修改人：Zhang Wenkai
 * 修改时间：
 * 修改备注：解析类  解析json
 * parser解析器
 *
 */
public class NewsResponseparser implements ResponseParser {
    @Override
    public void checkResponse(UriRequest request) throws Throwable {

    }

    @Override
    public Object parse(Type resultType, Class<?> resultClass, String result) throws Throwable {
        NewsResponse response = new NewsResponse();
        NewsInfo newsInfo = JSONObject.parseObject(result, NewsInfo.class);
        response.setNewsInfo(newsInfo);
        return response;
    }
}
