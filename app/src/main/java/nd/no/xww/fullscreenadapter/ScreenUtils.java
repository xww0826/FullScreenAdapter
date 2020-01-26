package nd.no.xww.fullscreenadapter;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * @author xww
 * @desciption : 采用 px 来适配全屏幕
 * @date 2020/1/18
 * @time 19:10
 */
public class ScreenUtils {

    private static ScreenUtils INSTANCE;
    private Context context;

    private static final float DESIGN_WIDTH = 1080f;
    private static final float DESIGN_HEIGHT = 1857f; // 减去状态栏的高度

    private int screenWidth;
    private int screenHeight;

    private ScreenUtils(Context context) {
        this.context = context;

        final WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);

            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                screenWidth = displayMetrics.heightPixels;
                screenHeight = displayMetrics.widthPixels - getStatusBarHeight();
            } else {
                screenWidth = displayMetrics.widthPixels;
                screenHeight = displayMetrics.heightPixels - getStatusBarHeight();
            }
        }
    }

    public static ScreenUtils getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new ScreenUtils(context.getApplicationContext());
        }
        return INSTANCE;
    }

    public int getStatusBarHeight() {
        Resources resources = context.getResources();
        if (resources != null) {
            int resId = resources.getIdentifier("status_bar_height", "dimen", "android");
            return resources.getDimensionPixelSize(resId);
        }
        return 0;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public float getScaleWidth() {
        return getScreenWidth() / DESIGN_WIDTH;
    }

    public float getScaleHeight() {
        return getScreenHeight() / DESIGN_HEIGHT;
    }
}
