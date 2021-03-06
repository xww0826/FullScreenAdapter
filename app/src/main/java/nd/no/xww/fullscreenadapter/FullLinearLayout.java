package nd.no.xww.fullscreenadapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * @author xww
 * @desciption : LinearLayout
 * @date 2020/1/26
 * @time 18:52
 */
public class FullLinearLayout extends LinearLayout {

    private boolean flag = true;
    private float scaleWidth;
    private float scaleHeight;

    public FullLinearLayout(Context context) {
        this(context, null);
    }

    public FullLinearLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FullLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        scaleWidth = ScreenUtils.getInstance(getContext()).getScaleWidth();
        scaleHeight = ScreenUtils.getInstance(getContext()).getScaleHeight();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (flag) {
            int count = getChildCount();
            View child;
            LayoutParams params;
            for (int i = 0; i < count; i++) {
                child = getChildAt(i);
                params = (LayoutParams) child.getLayoutParams();
                if (params instanceof FullLinearLayoutParams) {
                    params.width = (int) (scaleWidth * ((FullLinearLayoutParams) params).getLayout_widthPixel());
                    params.height = (int) (scaleHeight * ((FullLinearLayoutParams) params).getLayout_heightPixel());
                    params.leftMargin = (int) (scaleWidth * ((FullLinearLayoutParams) params).getLayout_leftMarginPixel());
                    params.topMargin = (int) (scaleHeight * ((FullLinearLayoutParams) params).getLayout_topMarginPixel());
                    params.rightMargin = (int) (scaleWidth * ((FullLinearLayoutParams) params).getLayout_rightMarginPixel());
                    params.bottomMargin = (int) (scaleHeight * ((FullLinearLayoutParams) params).getLayout_bottomMarginPixel());
                }
            }
            flag = false;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new FullLinearLayoutParams(getContext(), attrs);
    }

    public class FullLinearLayoutParams extends LayoutParams {
        private int layout_widthPixel;
        private int layout_heightPixel;
        private int layout_leftMarginPixel;
        private int layout_topMarginPixel;
        private int layout_rightMarginPixel;
        private int layout_bottomMarginPixel;

        public FullLinearLayoutParams(Context context, AttributeSet attrs) {
            super(context, attrs);
            @SuppressLint("CustomViewStyleable") TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.FullLinearLayout);
            layout_widthPixel = array.getInt(R.styleable.FullLinearLayout_layout_linear_widthPixel, 0);
            layout_heightPixel = array.getInt(R.styleable.FullLinearLayout_layout_linear_heightPixel, 0);
            layout_leftMarginPixel = array.getInt(R.styleable.FullLinearLayout_layout_linear_leftMarginPixel, 0);
            layout_topMarginPixel = array.getInt(R.styleable.FullLinearLayout_layout_linear_topMarginPixel, 0);
            layout_rightMarginPixel = array.getInt(R.styleable.FullLinearLayout_layout_linear_rightMarginPixel, 0);
            layout_bottomMarginPixel = array.getInt(R.styleable.FullLinearLayout_layout_linear_bottomMarginPixel, 0);
            array.recycle();
        }

        public FullLinearLayoutParams(int width, int height) {
            super(width, height);
        }

        public FullLinearLayoutParams(int width, int height, float weight) {
            super(width, height, weight);
        }

        public FullLinearLayoutParams(ViewGroup.LayoutParams p) {
            super(p);
        }

        public FullLinearLayoutParams(MarginLayoutParams source) {
            super(source);
        }

        public FullLinearLayoutParams(LayoutParams source) {
            super(source);
        }


        public int getLayout_widthPixel() {
            return layout_widthPixel;
        }

        public void setLayout_widthPixel(int layout_widthPixel) {
            this.layout_widthPixel = layout_widthPixel;
        }

        public int getLayout_heightPixel() {
            return layout_heightPixel;
        }

        public void setLayout_heightPixel(int layout_heightPixel) {
            this.layout_heightPixel = layout_heightPixel;
        }

        public int getLayout_leftMarginPixel() {
            return layout_leftMarginPixel;
        }

        public void setLayout_leftMarginPixel(int layout_leftMarginPixel) {
            this.layout_leftMarginPixel = layout_leftMarginPixel;
        }

        public int getLayout_topMarginPixel() {
            return layout_topMarginPixel;
        }

        public void setLayout_topMarginPixel(int layout_topMarginPixel) {
            this.layout_topMarginPixel = layout_topMarginPixel;
        }

        public int getLayout_rightMarginPixel() {
            return layout_rightMarginPixel;
        }

        public void setLayout_rightMarginPixel(int layout_rightMarginPixel) {
            this.layout_rightMarginPixel = layout_rightMarginPixel;
        }

        public int getLayout_bottomMarginPixel() {
            return layout_bottomMarginPixel;
        }

        public void setLayout_bottomMarginPixel(int layout_bottomMarginPixel) {
            this.layout_bottomMarginPixel = layout_bottomMarginPixel;
        }
    }
}
