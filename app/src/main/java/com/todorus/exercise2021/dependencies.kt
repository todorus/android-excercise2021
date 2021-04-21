package com.todorus.exercise2021

import android.content.Context
import com.todorus.exercise2021.analytics.AnalyticsFacade
import com.todorus.logic.api.Api

private val apiInstance = Api(BuildConfig.BASE_URL, BuildConfig.API_KEY)
private val analyticInstance = AnalyticsFacade()

val Context.api get(): Api = apiInstance
val Context.analytics get(): AnalyticsFacade = analyticInstance