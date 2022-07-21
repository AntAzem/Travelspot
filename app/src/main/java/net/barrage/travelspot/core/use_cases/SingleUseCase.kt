package net.barrage.travelspot.core.use_cases

import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

abstract class SingleUseCase<Results> {

    abstract fun buildUseCaseSingle(): Single<Results>

    fun execute(observer: SingleObserver<Results>) = buildUseCaseWithSchedulers().subscribe(observer)

    private fun buildUseCaseWithSchedulers(): Single<Results> {
        return buildUseCaseSingle()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}