package che.bwie.com.shixunyuekaodemo.model;

import che.bwie.com.shixunyuekaodemo.bean.MultiBean;
import che.bwie.com.shixunyuekaodemo.okhttp.AbstractUiCallBack;
import che.bwie.com.shixunyuekaodemo.okhttp.OkhttpUtils;

/**
 * 此类的作用：
 *
 * @author: forever
 * @date: 2017/11/23 8:46
 */
public class MuItilActivityModule {
    public void onRefresh(boolean up, final ModuleCallBack callBack) {


        OkhttpUtils.getInstance().asy(null, "http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=1&size=10&offset=0", new AbstractUiCallBack<MultiBean>() {
            @Override
            public void success(MultiBean bean) {

                callBack.success(bean);
            }

            @Override
            public void failure(Exception e) {

                callBack.failure(e);
            }
        });


    }


    public  interface ModuleCallBack {
        public void success(MultiBean bean);
        public void failure(Exception bean);

    }

    }

