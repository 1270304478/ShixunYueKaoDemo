package che.bwie.com.shixunyuekaodemo.model;


import che.bwie.com.shixunyuekaodemo.bean.ShopBean;
import che.bwie.com.shixunyuekaodemo.okhttp.AbstractUiCallBack;
import che.bwie.com.shixunyuekaodemo.okhttp.OkhttpUtils;

public class MainModel {
    public void getData(final MainModelCallBack callBack){
        OkhttpUtils.getInstance().asy(null, "http://120.27.23.105/product/getCarts?uid=100", new AbstractUiCallBack<ShopBean>() {


            @Override
            public void success(ShopBean bean) {
                callBack.success(bean);
            }

            @Override
            public void failure(Exception e) {
                callBack.failure(e);
            }
        });
    }
}
