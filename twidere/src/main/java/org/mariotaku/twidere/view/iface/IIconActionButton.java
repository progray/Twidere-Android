package org.mariotaku.twidere.view.iface;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;

import org.mariotaku.chameleon.Chameleon;
import org.mariotaku.chameleon.ChameleonView;
import org.mariotaku.chameleon.internal.ChameleonTypedArray;
import org.mariotaku.twidere.R;

/**
 * Created by mariotaku on 16/3/19.
 */
public interface IIconActionButton extends ChameleonView {
    @ColorInt
    int getDefaultColor();

    @ColorInt
    int getActivatedColor();

    @ColorInt
    int getDisabledColor();

    void setDefaultColor(@ColorInt int defaultColor);

    void setActivatedColor(@ColorInt int activatedColor);

    void setDisabledColor(@ColorInt int disabledColor);


    class Appearance implements ChameleonView.Appearance {
        @ColorInt
        private int defaultColor, activatedColor, disabledColor;

        public int getActivatedColor() {
            return activatedColor;
        }

        public void setActivatedColor(int activatedColor) {
            this.activatedColor = activatedColor;
        }

        public int getDefaultColor() {
            return defaultColor;
        }

        public void setDefaultColor(int defaultColor) {
            this.defaultColor = defaultColor;
        }

        public int getDisabledColor() {
            return disabledColor;
        }

        public void setDisabledColor(int disabledColor) {
            this.disabledColor = disabledColor;
        }

        public static Appearance create(Context context, AttributeSet attributeSet, Chameleon.Theme theme) {
            Appearance appearance = new Appearance();
            ChameleonTypedArray a = ChameleonTypedArray.obtain(context, attributeSet, R.styleable.IconActionButton, theme);
            appearance.setDefaultColor(a.getColor(R.styleable.IconActionButton_iabColor, 0, false));
            appearance.setActivatedColor(a.getColor(R.styleable.IconActionButton_iabActivatedColor, 0, false));
            appearance.setDisabledColor(a.getColor(R.styleable.IconActionButton_iabDisabledColor, 0, false));
            a.recycle();
            return appearance;
        }

        public static void apply(IIconActionButton view, Appearance appearance) {
            final int defaultColor = appearance.getDefaultColor();
            if (defaultColor != 0) {
                view.setDefaultColor(defaultColor);
            }
            final int activatedColor = appearance.getActivatedColor();
            if (activatedColor != 0) {
                view.setActivatedColor(activatedColor);
            }
            final int disabledColor = appearance.getDisabledColor();
            if (disabledColor != 0) {
                view.setDisabledColor(disabledColor);
            }
        }
    }
}
