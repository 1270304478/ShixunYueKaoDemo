package che.bwie.com.shixunyuekaodemo.model;


import che.bwie.com.shixunyuekaodemo.bean.ShopBean;

public interface MainModelCallBack {
   public void success(ShopBean bean);
    public void failure(Exception e);

}
