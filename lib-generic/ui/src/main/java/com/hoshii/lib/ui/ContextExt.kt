package com.hoshii.lib.ui

import android.content.Context

fun Context.isRunningOnTablet(): Boolean =
    resources.getBoolean(R.bool.isTablet)