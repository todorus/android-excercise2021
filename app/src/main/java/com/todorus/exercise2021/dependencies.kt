package com.todorus.exercise2021

import android.content.Context
import com.todorus.logic.api.Api

val Context.api get() = Api(BuildConfig.BASE_URL, BuildConfig.API_KEY)