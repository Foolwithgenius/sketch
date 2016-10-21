/*
 * Copyright (C) 2016 Peng fei Pan <sky@xiaopan.me>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.xiaopan.sketch.request;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import me.xiaopan.sketch.drawable.FixedSizeBitmapDrawable;

@SuppressWarnings("unused")
public class DrawableModeImage implements ModeImage {
    private Drawable wrapperDrawable;
    private int resId = -1;

    public DrawableModeImage(Drawable drawable) {
        this.wrapperDrawable = drawable;
    }

    public DrawableModeImage(int resId) {
        this.resId = resId;
    }

    @Override
    public Drawable getDrawable(Context context, FixedSize fixedSize) {
        Drawable finalDrawable = wrapperDrawable;
        if (finalDrawable == null && resId != -1) {
            finalDrawable = context.getResources().getDrawable(resId);
        }

        if (fixedSize != null && finalDrawable != null && finalDrawable instanceof BitmapDrawable) {
            finalDrawable = new FixedSizeBitmapDrawable((BitmapDrawable) finalDrawable, fixedSize);
        }

        return finalDrawable;
    }

    public Drawable getWrapperDrawable() {
        return wrapperDrawable;
    }

    public int getResId() {
        return resId;
    }
}
