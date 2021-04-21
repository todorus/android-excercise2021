package com.todorus.exercise2021.analytics

import timber.log.Timber

class AnalyticsFacade {

    fun event(key: String, value: String?) {
        Timber.i("Analytics Event $key $value")
        // TODO send event to actual analytics library
    }

}