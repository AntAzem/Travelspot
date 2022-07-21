package net.barrage.travelspot.core.rx

import io.reactivex.disposables.Disposable


class DisposableHelper {

    private var upstream: Disposable? = null

    fun addDisposable(disposable: Disposable) {
        upstream?.dispose()
        upstream = disposable
    }

    fun disposeFromUpstream() {
        upstream?.dispose()
        upstream = null
    }

    companion object {
        @Volatile
        private var INSTANCE: DisposableHelper? = null

        fun get(): DisposableHelper {
            return INSTANCE ?: synchronized(this) {
                DisposableHelper().also {
                    INSTANCE = it
                }
            }
        }
    }
}