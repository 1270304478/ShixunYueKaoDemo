package che.bwie.com.shixunyuekaodemo.view;

import che.bwie.com.shixunyuekaodemo.bean.MultiBean;

/**
 * 此类的作用：
 *
 * @author: forever
 * @date: 2017/11/23 8:41
 */
public interface MultiView {
    public void success(MultiBean bean);
    public void failure(Exception e);

}
