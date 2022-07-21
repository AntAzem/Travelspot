package net.barrage.travelspot.core

import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.ViewModel
import io.reactivex.CompletableObserver
import io.reactivex.MaybeObserver
import io.reactivex.Observer
import io.reactivex.SingleObserver
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import net.barrage.travelspot.core.rx.DisposableHelper

open class CoreViewModel : ViewModel(), Observable {

    @Transient
    private var callbacks: PropertyChangeRegistry? = null

    private var compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        DisposableHelper.get().disposeFromUpstream()
        super.onCleared()
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        synchronized(this) {
            if (callbacks == null) {
                callbacks = PropertyChangeRegistry()
            }
        }
        callbacks?.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        synchronized(this) {
            if (callbacks == null) return
        }
        callbacks?.notifyCallbacks(this, 0, null)
    }

    fun notifyPropertyChanged(fieldId: Int) {
        synchronized(this) {
            if (callbacks == null) return
        }
        callbacks?.notifyCallbacks(this, fieldId, null)
    }

    fun Disposable.addSubscription() {
        compositeDisposable.add(this)
    }

    fun addRxSubscription(disposable: Disposable?) {
        disposable?.let {
            compositeDisposable.add(it)
        }
    }

    fun removeRxSubscription(disposable: Disposable?) {
        disposable?.let {
            compositeDisposable.remove(it)
        }
    }

    abstract inner class CoreObserver<T> : Observer<T> {
        override fun onSubscribe(d: Disposable) {
            compositeDisposable.add(d)
        }

        override fun onComplete() {}

        override fun onError(e: Throwable) {
            println("CoreObserver error $e")
        }
    }

    abstract inner class CoreCompletableObserver : CompletableObserver {
        override fun onSubscribe(d: Disposable) {
            compositeDisposable.add(d)
        }

        override fun onComplete() {}

        override fun onError(e: Throwable) {
            println("CoreCompletableObserver error $e")
        }
    }

    abstract inner class OverridenDisposeObserver : CompletableObserver {
        override fun onSubscribe(d: Disposable) {
            DisposableHelper.get().addDisposable(d)
        }

        override fun onComplete() {}

        override fun onError(e: Throwable) {
            println("OverridenDisposeObserver error $e")
        }
    }


    abstract inner class CoreSingleObserver<T> : SingleObserver<T> {
        override fun onSubscribe(d: Disposable) {
            compositeDisposable.add(d)
        }

        override fun onError(e: Throwable) {
            println("CoreSingleObserver error $e")
        }
    }


    abstract inner class CoreMaybeObserver<T> : MaybeObserver<T> {
        override fun onSubscribe(d: Disposable) {
            compositeDisposable.add(d)
        }

        override fun onComplete() {}

        override fun onError(e: Throwable) {
            println("CoreMaybeObserver error $e")
        }
    }
}