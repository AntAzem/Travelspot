package net.barrage.travelspot.core.rx

import com.akaita.java.rxjava2debug.RxJava2Debug
import io.reactivex.exceptions.CompositeException
import retrofit2.HttpException
import io.reactivex.*
import io.reactivex.schedulers.Schedulers


object ApiRxUtil {

    private const val LOG_TAG = "ApiRxUtil"

    fun <T> rxObservableScheduler(): ObservableTransformer<T, T> {
        return ObservableTransformer { observable ->
            observable.subscribeOn(Schedulers.io())
                .onErrorResumeNext { e: Throwable? ->
                    rxJavaDebugStackTrace(LOG_TAG, e)
                    if (e is HttpException) {
                        throw CompositeException(e)
                    }
                    Observable.error(e)
                }
            //.observeOn(AndroidSchedulers.mainThread())
        }
    }

    fun <T> rxMaybeScheduler(): MaybeTransformer<T, T> {
        return MaybeTransformer { observable ->
            observable.subscribeOn(Schedulers.io())
                .onErrorResumeNext { e: Throwable? ->
                    rxJavaDebugStackTrace(LOG_TAG, e)
                    if (e is HttpException) {
                        throw CompositeException(e)
                    }
                    Maybe.error(e)
                }
                //.observeOn(AndroidSchedulers.mainThread())
        }
    }

    fun rxJavaDebugStackTrace(logTag: String, throwable: Throwable?) {
        throwable ?: return
        val enchancedStackTrace = RxJava2Debug.getEnhancedStackTrace(throwable)
        println("$logTag $enchancedStackTrace")
    }
}