package nd.no.xww.fullscreenadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * @author xww
 * @desciption : 手动适配
 * @date 2020/1/26
 * @time 18:19
 */
public class UiUtils {

    public static void setSize(View view, int width, int height) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        Context context = view.getContext();
        if (width == LinearLayout.LayoutParams.MATCH_PARENT || width == LinearLayout.LayoutParams.WRAP_CONTENT) {
            params.width = width;
        } else {
            params.width = (int) (width * ScreenUtils.getInstance(context).getScaleWidth());
        }
        if (height == LinearLayout.LayoutParams.MATCH_PARENT || height == LinearLayout.LayoutParams.WRAP_CONTENT) {
            params.height = height;
        } else {
            params.height = (int) (height * ScreenUtils.getInstance(context).getScaleHeight());
        }
        view.setLayoutParams(params);
    }

    public static void setMargin(View view, int top, int left, int right, int bottom) {
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        Context context = view.getContext();
        params.topMargin = (int) (top * ScreenUtils.getInstance(context).getScaleHeight());
        params.leftMargin = (int) (left * ScreenUtils.getInstance(context).getScaleWidth());
        params.rightMargin = (int) (right * ScreenUtils.getInstance(context).getScaleWidth());
        params.bottomMargin = (int) (bottom * ScreenUtils.getInstance(context).getScaleHeight());
        view.setLayoutParams(params);
    }

    public static int dp2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dp(Context context, float pxValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int px2sp(Context context, float pxValue) {
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    public static int sp2px(Context context, float spValue) {
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
}
