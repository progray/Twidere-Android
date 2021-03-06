package org.mariotaku.twidere.preference

import android.content.Context
import android.support.v7.preference.PreferenceCategory
import android.support.v7.preference.PreferenceViewHolder
import android.util.AttributeSet
import android.widget.TextView
import org.mariotaku.chameleon.Chameleon
import org.mariotaku.chameleon.ChameleonUtils

/**
 * Created by mariotaku on 2017/2/5.
 */

class TintedPreferenceCategory(context: Context, attrs: AttributeSet? = null) : PreferenceCategory(context, attrs) {
    override fun onBindViewHolder(holder: PreferenceViewHolder) {
        super.onBindViewHolder(holder)
        val theme = Chameleon.getOverrideTheme(context, ChameleonUtils.getActivity(context))
        val textView = holder.findViewById(android.R.id.title) as? TextView
        textView?.setTextColor(theme.colorAccent)
    }
}
