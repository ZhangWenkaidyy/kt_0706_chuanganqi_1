package com.kevin.zwk.kt_xutils_1;

import org.xutils.http.annotation.HttpResponse;

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
 * 创建时间：2016/7/6 14:57
 * 修改人：Zhang Wenkai
 * 修改时间：
 * 修改备注：
 */
@HttpResponse(parser = NewsResponseparser.class)
public class NewsResponse {
    private NewsInfo newsInfo;

    public NewsInfo getNewsInfo() {
        return newsInfo;
    }

    public void setNewsInfo(NewsInfo newsInfo) {
        this.newsInfo = newsInfo;
    }


}
